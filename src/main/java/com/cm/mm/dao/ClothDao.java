package com.cm.mm.dao;

import com.cm.mm.dao.mapper.ClothMapper;
import com.cm.mm.model.Cloth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingao on 2017/11/16.
 */
@Component
public class ClothDao {

    private Logger logger = LoggerFactory.getLogger(ClothDao.class);

    @Autowired
    ClothMapper mapper;

    public Cloth getClothByid(Integer id) {
        return mapper.getClothById(id);
    }
}
