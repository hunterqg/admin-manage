package com.cm.mm.service;

import com.cm.mm.model.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cm.mm.dao.ClothDao;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Service
public class ClothService {

    @Autowired
    private ClothDao clothDao;

    public Cloth getClothById(Integer id) {
        return clothDao.getClothById(id);
    }

    public List<Cloth> listClothes(Cloth cloth) {
        return clothDao.listClothes(cloth);
    }
    public int addCloth(Cloth cloth) {
        return clothDao.insertCloth(cloth);
    }
    public int modifyCloth(Cloth cloth) {
        return clothDao.updateCloth(cloth);
    }
    public int removeClothById(Integer id) {
        return clothDao.deleteClothById(id);
    }
}
