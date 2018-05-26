package org.poem.consumes;

import org.poem.json.JsonBean;
import org.poem.user.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumesController {

    /**
     * this for  Content-Type
     * @return
     */
    @GetMapping(value = "/consumes/forJson.json", consumes = "application/json")
    public JsonBean forJson(){
        return  new JsonBean(new UserVo());
    }
}
