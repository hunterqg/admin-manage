package com.cm.mm.dto;

import com.cm.mm.model.Cloth;

/**
 * Created by qingao on 2017/12/5.
 */
public class RankedCloth extends Cloth {
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public RankedCloth(int rank,Cloth cloth) {
        this.setId(cloth.getId());
        this.setUserId(cloth.getUserId());
        this.setType(cloth.getType());
        this.setModel(cloth.getModel());
        this.setName(cloth.getName());
        this.setPicUrl(cloth.getPicUrl());
        this.setDescription(cloth.getDescription());
        this.setCreateAt(cloth.getCreateAt());
        this.setUpdateAt(cloth.getUpdateAt());
        this.setRank(rank);
        this.setUrlType(cloth.getUrlType());
    }
}
