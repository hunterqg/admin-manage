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
    private Float price;
    private ClothBrand brand;
    private Integer urlType;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ClothBrand getBrand() {
        return brand;
    }

    public void setBrand(ClothBrand brand) {
        this.brand = brand;
    }


    public Cloth() {

    }
    public Cloth( String name,String model,String userId,String picUrl,Integer type,Float price,ClothBrand brand) {
        this.name = name;
        this.type = type;
        this.userId = userId;
        this.picUrl = picUrl;
        this.model = model;
        this.brand = brand;
        this.price = price;
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

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

}
