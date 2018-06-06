package org.poem.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.poem.user.UserController;
import org.poem.user.UserService;
import org.poem.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMVC() throws  Exception{
        String userId = "10";
        String expectedCredit = "100";
        BDDMockito.given(this.userService.getById(userId)).willReturn(new UserVo(expectedCredit,"BDDMockito"));
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1.0/user/{id}",userId)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(reseult));
    }
}
