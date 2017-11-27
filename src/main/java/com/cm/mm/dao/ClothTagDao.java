package com.cm.mm.dao;

import com.cm.mm.dao.mapper.ClothTagMapper;
import com.cm.mm.model.ClothTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingao on 2017/11/23.
 */
@Component
public class ClothTagDao {
    @Autowired
    ClothTagMapper mapper;

    public List<ClothTag> getClothTags(Integer [] tags) {
        return mapper.getClothTags(tags);
    }
}
