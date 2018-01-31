package com.cm.mm.service;

import com.cm.mm.dao.SmallProgramFavoriteDao;
import com.cm.mm.model.Cloth;
import com.cm.mm.model.SmallProgramFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingao on 18-1-23.
 */
@Service
public class SmallProgramFavoriteService {
    @Autowired
    private SmallProgramFavoriteDao dao;

    public List<Cloth> listFavorites(String wechatId) {
        return dao.getSpFavorites(wechatId);
    }

    public int addAllFaviatories(String wechatId,List<Integer> clothIds) {
        return dao.insertFavorites(wechatId,clothIds);
    }

    public int removeAllFavorites(String wechatId,List<Integer> clothIds) {
        return dao.deleteFavorites(wechatId,clothIds);
    }
}
