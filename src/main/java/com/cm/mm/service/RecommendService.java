package com.cm.mm.service;

import com.cm.mm.dao.ClothDao;
import com.cm.mm.dao.ClothTagDao;
import com.cm.mm.dto.RankedCloth;
import com.cm.mm.model.Cloth;
import com.cm.mm.model.ClothTag;
import com.cm.mm.rules.RulesFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by qingao on 2017/11/23.
 */

@Service
public class RecommendService {
    private static final int MAX_RECOMMEND_NUMBER = 20;

    private Logger logger = LoggerFactory.getLogger(RecommendService.class);
    @Autowired
    private ClothTagDao clothTagDao;

    @Autowired
    private ClothDao clothDao;
    /**
     * 获取符合条件的衣服信息
     * @param tagKey 传入的条件
     * @param  type 衣服的类型
     * @param userId
     * @return
     */
//    @Cacheable(value="RecommendClothList",
//            key="{#tagKey,#type,#userId}")
    public List<RankedCloth> getRecommendClothes(String tagKey, String faceColorKey,String faceShapeKey ,Integer type, String userId) {
        List<RankedCloth> recommendList = new ArrayList<>();
        Cloth conditionCloth = new Cloth();
        conditionCloth.setType(type);
        conditionCloth.setUserId(userId);
        List<Cloth> typedClothList = clothDao.listClothes(conditionCloth);

        for (Cloth cloth : typedClothList) {
            int rank = rankCloth(cloth,tagKey,type);
            String descriptions = cloth.getDescription();
            String [] descAry = descriptions.split("\r\n");
            if(descAry.length>0) {
                cloth.setDescription(descAry[0]);
            }
            if(rank >0) {

                if(faceColorKey != null && !faceColorKey.equals(RulesFactory.KEY_FACE_COLOR_1)) {//处理匹配肤色的规则
                    if(descAry.length>1) {
                        cloth.setDescription(descAry[1]);
                        rank = rank + 2;
                    }
                }
                if(faceShapeKey != null) {//处理脸型的推荐规则

                }

                recommendList.add(new RankedCloth(rank,cloth));
            }
        }
        recommendList.sort(new Comparator<RankedCloth>() {
            @Override
            public int compare(RankedCloth o1, RankedCloth o2) {
                return o2.getRank()-o1.getRank();
            }
        });
        if (recommendList.size() > MAX_RECOMMEND_NUMBER) {
           recommendList = recommendList.subList(0,MAX_RECOMMEND_NUMBER);
        }
        return recommendList;
    }

    private List<Integer> getAllTags(String tagKey,Integer type) {
        Map<String,List<Integer>> tagRules = RulesFactory.getInstance().getRules(tagKey);
        if (tagRules == null) {
            return null;
        }

        List<Integer> allMatchTags = new ArrayList<>();
        for (String key:tagRules.keySet()) {
            allMatchTags.addAll(tagRules.get(key));
        }
        if(type == 1) {//如果是上装，移除下装的tag
            List<Integer> downTag = tagRules.get(RulesFactory.KEY_DOWN_VALUES);
            if (downTag != null) {
                allMatchTags.removeAll(downTag);
            }
        }else if(type == 2) {//如果是下装，移除上装的tag
            List<Integer> upTag = tagRules.get(RulesFactory.KEY_UP_VALUES);
            if(upTag!= null) {
                allMatchTags.removeAll(upTag);
            }
        }
        return  allMatchTags;
    }

    private int rankCloth(Cloth cloth,String tagKey,Integer type) {
        int rank = 0;
        //获取衣服的所有标签
        List<ClothTag> clothTagList = clothTagDao.getClothTagsByClothId(cloth.getId());
        List<Integer> tagList = new ArrayList<>();
        for(ClothTag cTag: clothTagList) {
            tagList.add(cTag.getTagId());
        }
        List<Integer> allTags = getAllTags(tagKey,type);
        if (allTags != null) {
            logger.debug("Cloth tags: " + tagList);
            logger.debug(tagKey + " needed tags " + allTags);
            allTags.retainAll(tagList);//交集
            logger.debug("matched tags " + allTags);
            rank = allTags.size();
        }

        //剔除避免属性的
        List<Integer> allForbidTags = getAllTags(tagKey+"_FORBID",type);
        if(allForbidTags != null) {
            logger.debug("Forbid tags: " + allForbidTags);
            allForbidTags.retainAll(tagList);
            logger.debug("matched forbid tags " + allForbidTags);
            if (allForbidTags.size() > 0) {
                rank = 0;
            }
        }


        return rank;
    }
}
