package com.cm.mm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by qingao on 18-1-12.
 */

@JsonIgnoreProperties({"createAt","updateAt"})
public class ClothBrand extends Base {
    private String name;
    private String code;

    private String logoUrl;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
