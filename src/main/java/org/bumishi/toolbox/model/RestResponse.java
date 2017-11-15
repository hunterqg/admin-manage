package org.bumishi.toolbox.model;

import java.io.Serializable;

/**
 * Created by qingao on 2017/11/15.
 */
public class RestResponse<T> implements Serializable {
    private boolean success;
    private String code;
    private String msg;
    private T data;

    public RestResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static org.bumishi.toolbox.model.RestResponse ok() {
        org.bumishi.toolbox.model.RestResponse rep = new org.bumishi.toolbox.model.RestResponse();
        rep.setSuccess(true);
        return rep;
    }

    public static org.bumishi.toolbox.model.RestResponse ok(Object data) {
        org.bumishi.toolbox.model.RestResponse rep = new org.bumishi.toolbox.model.RestResponse();
        rep.setSuccess(true);
        rep.setData(data);
        return rep;
    }

    public static org.bumishi.toolbox.model.RestResponse fail() {
        org.bumishi.toolbox.model.RestResponse rep = new org.bumishi.toolbox.model.RestResponse();
        rep.setSuccess(true);
        return rep;
    }

    public static org.bumishi.toolbox.model.RestResponse fail(String msg) {
        org.bumishi.toolbox.model.RestResponse rep = new org.bumishi.toolbox.model.RestResponse();
        rep.setSuccess(false);
        rep.setMsg(msg);
        return rep;
    }

    public static org.bumishi.toolbox.model.RestResponse fail(String code, String msg) {
        org.bumishi.toolbox.model.RestResponse rep = new org.bumishi.toolbox.model.RestResponse();
        rep.setSuccess(false);
        rep.setMsg(msg);
        rep.setCode(code);
        return rep;
    }
}

