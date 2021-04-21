package edu;

import edu.ctrl.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@WebAppConfiguration
public class JUserControlTest {
    @Autowired
    private WebApplicationContext wbc;

    private MockMvc mockMvc;

    @Before
    public void Setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wbc).build();
    }

    @Test
    public void TestExample() throws Exception
    {
/*        if(wbc.containsBean("UserController"))
            System.out.println(" well, good");
        else
            System.out.println(" emm, bad");
        UserController u = (UserController) wbc.getBean(UserController.class);
        if(u == null)
            System.out.println(" emm, bad");
        else
            System.out.println(" well, good " + u.toString());*/
        mockMvc.perform(MockMvcRequestBuilders.post("/user/loginrespond")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","self")
                        .param("password","self")
                        .param("hidden","true")
                    )
                .andDo(print()).andExpect(status().isOk());
    }
}
