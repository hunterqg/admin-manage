package com.cm.mm.model;

import java.util.Date;

/**
 * Created by qingao on 2017/11/16.
 */
public abstract  class Base {
    protected Integer Id;
    protected Date createAt;
    protected Date updateAt;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }


}
