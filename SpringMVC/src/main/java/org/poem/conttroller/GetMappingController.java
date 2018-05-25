package org.poem.conttroller;


import org.poem.json.JsonBean;
import org.poem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMappingController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/all/*.json")
    public JsonBean allUser() {
        return  new JsonBean(this.userService.getById("NO 1"));
    }

    @GetMapping("/user/{id}.json")
    public JsonBean getById(@PathVariable(value = "id") String id){
        return new JsonBean(this.userService.getById(id));
    }
}
