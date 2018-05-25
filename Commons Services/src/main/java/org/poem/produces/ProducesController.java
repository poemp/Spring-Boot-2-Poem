package org.poem.produces;

import org.poem.json.JsonBean;
import org.poem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducesController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/produces/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonBean getUser(@PathVariable String id, Model model) {
        return new JsonBean(this.userService.getById(id));
    }
}
