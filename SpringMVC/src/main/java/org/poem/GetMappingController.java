package org.poem;


import org.poem.json.JsonBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMappingController {

    @GetMapping("/user/all/*.json")
    public JsonBean allUser() {

    }
}
