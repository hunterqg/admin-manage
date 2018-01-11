package com.cm.mm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by qingao on 2018/1/9.
 */

@JsonIgnoreProperties({"id","createAt","updateAt"})
public class SmallProgramBanner extends Base{
    private String title;
    private String bgColor;
    private String bgImage;
    private String url;
    private Integer order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
