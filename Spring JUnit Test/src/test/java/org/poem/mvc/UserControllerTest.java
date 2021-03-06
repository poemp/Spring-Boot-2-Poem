package org.poem.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.poem.json.JsonBean;
import org.poem.user.UserController;
import org.poem.user.UserService;
import org.poem.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        String reseult = new JsonBean(new UserVo(expectedCredit, "name")).toString();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1.0/user/{id}",userId)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //200
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(model().attributeExists("name"))
                .andExpect(model().attribute("name","name"))
                .andExpect(content().string(reseult));
    }
}
