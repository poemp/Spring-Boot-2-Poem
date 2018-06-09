package org.poem.sql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.poem.user.UserService;
import org.poem.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserDBTest {

    @Autowired
    private UserService userService;

    @Value(value = "${user.id}")
    @NotNull
    private String userId;

    @Test
    @Sql("user.sql")
    public void test(){
        UserVo user  = userService.getById(userId);
        System.err.println(user);
    }
}
