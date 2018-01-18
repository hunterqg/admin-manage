package com.cm.mm.dto;

import com.cm.mm.model.Cloth;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by qingao on 2017/12/5.
 */
public class RankedCloth extends Cloth {
    static private Logger logger = LoggerFactory.getLogger(RankedCloth.class);
    private int rank;
    private float displayWeight;

    private static int MAX_TRY_TIMES = 100;
    private static int MAX_SHOW_TIMES = 100;

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
        this.setBrand(cloth.getBrand());
        this.setPrice(cloth.getPrice());
    }

    /*
    考量维度和其对应权重为试穿次数（20%）、展示次数（10%）、库存情况（50%）、商家推荐指数（20%）
    目前可以随机生成一个数值，加权得出排序数值
    具体操作为：
    试穿次数：最高次数为30次，对应值为1；试穿次数为15次的值为0.5
    展示次数：雷同试穿次数
    库存情况：库存有则为以，库存没有则为0
    商家推荐指数：指的是该商品是否为商家精品搭配的30套，是则为1，不是则为0
    例如：一件衣服的各个数据为试穿次数50次（已知最大试穿次数为100次），
    展示次数为90次（已知最大次数150次），库存有，是商家推荐的套装，
    它对应的加权应该为50/100*0.2+90/150*0.1+1*0.5+1*0.2=0.1+0.06+0.5+0.2=0.86
     */
    public float calcDisplayWeight() {
        logger.debug("calcDisplayWeight for mirror");
        if (displayWeight > 0f) {
            return displayWeight;
        }
        float retVal = 0f;
        Random random = new Random();
        int randomTryCount = random.nextInt(101);
        int randomShowCount = random.nextInt(101);

        int randomRecommend = random.nextInt(2);
        int randomRepository = random.nextInt(2);
        retVal = ((float)randomTryCount/MAX_TRY_TIMES) * 0.2f +((float)randomShowCount/MAX_SHOW_TIMES) * 0.1f + randomRecommend*0.5f + randomRepository*0.2f;
        displayWeight = retVal;
        return retVal;
    }

    public float calcSpDisplayWeight() {
        logger.debug("calcSpDisplayWeight for small program");
        if (displayWeight > 0f) {
            return displayWeight;
        }
        float retVal = 0f;
        //mock the feedback data by random
        Random random = new Random();
        boolean isBrandFan = random.nextBoolean();
        int clothClickCount = random.nextInt(20000);
        boolean isRecommendByDesigner = random.nextBoolean();
        boolean isRecommendByShop = random.nextBoolean();
        int clothShareCount = random.nextInt(60000);


        retVal = 0.2f * (isBrandFan?1:0)
                + 0.2f*getClothClickCountWeight(clothClickCount)
                + 0.2f * (isRecommendByDesigner?1:0)
        + 0.2f *(isRecommendByShop?1:0)
        + 0.2f * getClothShareWeight(clothShareCount);

        return retVal;
    }

    private float getClothShareWeight(int clothSharedCount) {
        float retVal = 0f;
        if(clothSharedCount<10) {
            retVal = 0.1f;
        }else if(clothSharedCount>=10 && clothSharedCount<50) {
            retVal = 0.2f;
        }else if(clothSharedCount>=50 && clothSharedCount<150) {
            retVal = 0.3f;
        }else if(clothSharedCount>=150 && clothSharedCount<300) {
            retVal = 0.4f;
        }else if(clothSharedCount>=300 && clothSharedCount<500) {
            retVal = 0.5f;
        }else if(clothSharedCount>=500 && clothSharedCount<1000) {
            retVal = 0.6f;
        }else if(clothSharedCount>=1000 && clothSharedCount<2000) {
            retVal = 0.7f;
        }else if(clothSharedCount>=2000 && clothSharedCount<5000) {
            retVal = 0.8f;
        }else if(clothSharedCount>=5000 && clothSharedCount<10000) {
            retVal = 0.9f;
        }else if(clothSharedCount>=10000) {
            retVal = 1f;
        }

        return retVal;
    }
    private float getClothClickCountWeight(int clothClickedCount) {
        float retVal = 0f;
        if(clothClickedCount<100) {
            retVal = 0.1f;
        }else if(clothClickedCount>=100 && clothClickedCount<500) {
            retVal = 0.2f;
        }else if(clothClickedCount>=500 && clothClickedCount<1500) {
            retVal = 0.3f;
        }else if(clothClickedCount>=1500 && clothClickedCount<3000) {
            retVal = 0.4f;
        }else if(clothClickedCount>=3000 && clothClickedCount<5000) {
            retVal = 0.5f;
        }else if(clothClickedCount>=5000 && clothClickedCount<10000) {
            retVal = 0.6f;
        }else if(clothClickedCount>=10000 && clothClickedCount<20000) {
            retVal = 0.7f;
        }else if(clothClickedCount>=20000&& clothClickedCount<50000) {
            retVal = 0.8f;
        }else if(clothClickedCount>=50000 && clothClickedCount<100000) {
            retVal = 0.9f;
        }else if(clothClickedCount>=100000) {
            retVal = 1f;
        }

        return retVal;
    }
}
