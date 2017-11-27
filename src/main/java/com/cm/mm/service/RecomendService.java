package com.cm.mm.service;

import com.cm.mm.dao.ClothDao;
import com.cm.mm.dao.ClothTagDao;
import com.cm.mm.model.Cloth;
import com.cm.mm.model.ClothTag;
import com.cm.mm.rules.RulesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by qingao on 2017/11/23.
 */

@Service
public class RecomendService {
    @Autowired
    private ClothTagDao clothTagDao;

    @Autowired
    private ClothDao clothDao;
    /**
     * 获取符合条件的衣服信息
     * @param tagKey 传入的条件
     * @return
     */
    public List<Cloth> getRecommendClothes(String tagKey) {
        List<Integer> rules = RulesFactory.getRules(tagKey);
        List<ClothTag> clothTags = clothTagDao.getClothTags(rules.toArray(new Integer[0]));
        Set<Integer> idSet = new HashSet<>();
        for (ClothTag ct : clothTags) {
            idSet.add(ct.getClothId());
        }
        List<Cloth> recommendList = new ArrayList<>();
        if(idSet.size()>0) {
            recommendList = clothDao.listClothes(idSet.toArray(new Integer[0]));
        }
        return recommendList;
    }
}
