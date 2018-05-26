package org.poem.params;

import org.poem.json.JsonBean;
import org.poem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/params/update.json", params = "action=save")
    public JsonBean saveUser(){
        System.out.println("save Data.");
        return new JsonBean();
    }
}
