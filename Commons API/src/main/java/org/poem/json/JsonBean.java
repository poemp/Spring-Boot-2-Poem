package org.poem.json;

import java.io.Serializable;

public class JsonBean implements Serializable {

    private final String message;

    private final Object result;

    private final int status;


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
}
