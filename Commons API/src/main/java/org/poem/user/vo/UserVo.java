package org.poem.user.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class UserVo implements Serializable {
    private String id;

    private String name;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserVo() {
    }

    public UserVo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserVo(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
