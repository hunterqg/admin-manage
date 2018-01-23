package com.cm.mm.model;

/**
 * Created by qingao on 18-1-23.
 */
public class SmallProgramFavorite extends Base {
    String wechatId;
    Integer clothId;

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Integer getClothId() {
        return clothId;
    }

    public void setClothId(Integer clothId) {
        this.clothId = clothId;
    }
}
