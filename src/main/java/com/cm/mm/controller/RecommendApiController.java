package com.cm.mm.controller;

import com.cm.mm.dto.RankedCloth;
import com.cm.mm.model.Cloth;
import com.cm.mm.rules.RulesFactory;
import com.cm.mm.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by qingao on 2017/11/22.
 */

@Controller
@RequestMapping("/api/v1")
public class RecommendApiController {
    Logger logger = LoggerFactory.getLogger(RecommendApiController.class);

    @Autowired
    private RecommendService recomendService;

    @RequestMapping(value = "/recommend",method= RequestMethod.POST)
    @ResponseBody
    public Map test(@RequestBody Map map) {
        logger.debug("Recevied  map:" + map);

//        int baseHeight = 140;
        Random random = new Random();
//        int randomInt = random.nextInt(60);
//        int height = baseHeight + randomInt;
        double height = (double)map.get("height");
        double shape = (double)map.get("shape");
        logger.debug(String.format("get body height %.2f,shape=%.2f:" , height,shape ));

        String key = getBodyShapeKey((int)height,shape);
        int faceColor = 1+random.nextInt(3);
        String faceColorKey = "FC"+faceColor;

        int faceShape = 1+random.nextInt(7);
        String faceShapeKey = "FS"+faceShape;

        logger.debug(String.format("get bodyShape:%s,faceColor:%s,faceShape:%s",key,faceColorKey,faceShapeKey));

        List<RankedCloth> recommendList1 = recomendService.getRecommendClothes(key,faceColorKey,faceShapeKey,1,"1");
        List<RankedCloth> recommendList2 = recomendService.getRecommendClothes(key,faceColorKey,faceShapeKey,2,"1");
        map.clear();
        map.put("code",0);
        map.put("msg","ok");
        Map<String,Object> data = new HashMap<>();

        String [] reason = {
                RulesFactory.getInstance().getRecommendReason(key),
                RulesFactory.getInstance().getRecommendReason(faceColorKey),
                RulesFactory.getInstance().getRecommendReason(faceShapeKey)
        };
        data.put("reason",reason);
/*

        recommendList1.addAll(recommendList2);
        Cloth cloth = recommendList1.get(0);
        cloth.setUrlType(2);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://10.60.210.215:10000/upload_img/1.jpg");

        cloth = recommendList1.get(1);
        cloth.setUrlType(3);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://10.60.210.215:10000/upload_img/1.mp4");
*/

        data.put("clothes",recommendList1);
        map.put("data",data);

        return map;
    }

    private String getBodyShapeKey(int height,double shape) {
        int offset;
        int bodyOffset = getOffset(shape);

        if (height<160) {//A
            offset = 0;
        }else if(height>=160 && height<=168) {//B
            offset = 3;
        }else{ //C
            offset = 6;
        }
        int index = offset + bodyOffset;
        return RulesFactory.BODY_SHAPES[index];
    }

    private int getOffset(double shape) {
        int retVal;
        if(shape<0.4) {
            retVal = 0;
        }else if (shape>=0.4 && shape <0.8) {
            retVal = 1;
        }else{
            retVal = 2;
        }
        return retVal;
    }
}
