package org.poem.user;

import org.poem.json.JsonBean;
import org.poem.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/api/v1.0/user/{id}")
    public JsonBean getUser(@PathVariable String id){
        return new JsonBean(new UserVo(id, "name"));
    }
}
