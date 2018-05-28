package org.poem.pathVariable;

import org.poem.json.JsonBean;
import org.poem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariable {

    @Autowired
    private UserService userService;

    /**
     *
     * @param name
     * @param id
     * @return
     */
    @GetMapping(value = "/getUserPath/{name}/{id}")
    public JsonBean pathVariable(@org.springframework.web.bind.annotation.PathVariable(name = "name") String name,
                                 @org.springframework.web.bind.annotation.PathVariable(name = "id") String id){
        return  new JsonBean(this.userService.getUserAndName(id, name));
    }
}
