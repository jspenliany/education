package edu.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            HttpServletResponse hres=(HttpServletResponse)response;
        }catch (ClassCastException e)
        {
            e.printStackTrace();
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy()
    {

    }

}
