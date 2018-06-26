package org.poem.json;

import java.io.Serializable;

public class JsonBean implements Serializable {

    private String message;

    private Object result;

    private int status = 0;

    public JsonBean() {
        this.status = 0;
        this.message = null;
        this.result = null;
    }

    public JsonBean(Object result) {
        this.result = result;
        this.message = "";
        this.status = 0;
    }

    public JsonBean(int status, String message) {
        this.message = message;
        this.status = status;
        this.result = null;
    }

    public JsonBean(int status, String message, Object result) {
        this.message = message;
        this.result = result;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }

    public int getStatus() {
        return status;
    }

     private static void test(){

     }
}
