package com.cm.mm.model;

/**
 * Created by qingao on 2017/11/16.
 */
public class Cloth extends Base {
    private String name;
    private String model;
    private String picUrl;
    private String description;
    private String userId;
    private Integer type;

    public Cloth() {

    }
    public Cloth( String name,String model,String userId,String picUrl,Integer type) {
        this.name = name;
        this.type = type;
        this.userId = userId;
        this.picUrl = picUrl;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
