package com.cm.mm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by qingao on 2018/1/9.
 */

@JsonIgnoreProperties({"id","createAt","updateAt"})
public class SmallProgramMaLong extends Base{
    private String md5;
    private String url;
    private String prop1;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }
}
