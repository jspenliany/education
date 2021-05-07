package edu.filter;

import edu.util.BufferedServletRequestWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

/**
 * created infos 2021/4/6---tomcat
 */
@Component
public class WorkFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {
        try
        {
            HttpServletRequest hreq=(HttpServletRequest)request;
            StringBuilder UrlString=new StringBuilder(hreq.getRequestURL());

            if (UrlString.toString().contains("/css") ||
                    UrlString.toString().contains("/js") ||
                    UrlString.toString().contains("/img"))
            {
                System.out.println(UrlString);
            }
            else {
                String contentType  = request.getContentType();
                System.out.println("请求数据类型："+contentType + " data " + request.getParameter("username") +" "+ UrlString);

            }

            HttpServletResponse hres=(HttpServletResponse)response;
        }catch (ClassCastException e)
        {
            e.printStackTrace();
        }
        //将request 传到下一个Filter
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy()
    {

    }

}
