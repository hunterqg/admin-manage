package com.cm.mm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by qingao on 2018/1/9.
 */

@JsonIgnoreProperties({"id","createAt","updateAt"})
public class SmallProgramUser extends Base{
    private String wechatId;
    private Integer gender;
    private Integer age;
    private Float height;
    private Float weight;
    private Integer skinColor;
    private Integer style;

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(Integer skinColor) {
        this.skinColor = skinColor;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }
}
