package edu;

import edu.ctrl.UserController;
import edu.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class TestUserControl {

    private MockMvc mockMvc;

    //this is an instance of certain class that will be injected into the testing class, but nothing left.
    @Mock
    private UserService userService;
    //this is an instance of the being tested class
    @InjectMocks
    private UserController user;

    @Before
    public void Setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(user).build();
    }

    @Test
    public void testLogin() throws Exception
    {
        mockMvc.perform(post("/user/loginrespond").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username","sel.f")
        .param("password","self").param("hidden","true")
        ).andExpect(status().isOk()).andDo(print());
    }
}
