package com.cm.mm.service;

import com.cm.mm.model.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cm.mm.dao.ClothDao;

/**
 * Created by qingao on 2017/11/16.
 */
@Service
public class ClothService {

    @Autowired
    private ClothDao clothDao;

    public Cloth getClothById(Integer id) {
        return clothDao.getClothByid(id);
    }
}
