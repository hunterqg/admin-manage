package com.cm.mm.dao;

import com.cm.mm.dao.mapper.SmallProgramFavoriteMapper;
import com.cm.mm.model.SmallProgramFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingao on 18-1-23.
 */
@Component
public class SmallProgramFavoriteDao extends BaseDao {

    @Autowired
    private SmallProgramFavoriteMapper mapper;

    public List<Integer> getSpFavorites(String wechatId) {
        return mapper.getSpFavorites(wechatId);
    }

    public int insertFavorites(String wechatId,List<Integer> clothIds) {
        return mapper.insertSpFavorites(wechatId,clothIds);
    }

    public int deleteFavorites(String wechatId,List<Integer> clothIds) {
        return mapper.deleteSpFavorites(wechatId,clothIds);
    }
}
