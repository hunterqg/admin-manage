package com.cm.mm.controller;

import com.cm.mm.dto.RankedCloth;
import com.cm.mm.model.Cloth;
import com.cm.mm.rules.RulesFactory;
import com.cm.mm.service.ClothService;
import com.cm.mm.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by qingao on 2017/11/22.
 */

@Controller
@RequestMapping("/api/v1")
public class RecommendApiController {
    Logger logger = LoggerFactory.getLogger(RecommendApiController.class);

    @Autowired
    private RecommendService recomendService;

    @Autowired
    private ClothService clothService;

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

        Collections.sort(recommendList1,
                (RankedCloth o1,RankedCloth o2) ->(int)(o2.getDisplayWeight()*100) - (int)(o1.getDisplayWeight()*100));

        recommendList1.addAll(recommendList2);
        Cloth cloth = recommendList1.get(0);
        cloth.setUrlType(2);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://211.159.176.204:8080/upload_img/1.jpg");

        cloth = recommendList1.get(1);
        cloth.setUrlType(3);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://211.159.176.204:8080/upload_img/1.mp4");

        cloth = recommendList1.get(2);
        cloth.setUrlType(3);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://211.159.176.204:8080/upload_img/2.mp4");

        cloth = recommendList1.get(3);
        cloth.setUrlType(3);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://211.159.176.204:8080/upload_img/3.mp4");

        cloth = recommendList1.get(4);
        cloth.setUrlType(3);
        cloth.setPicUrl(cloth.getPicUrl()+";"+"http://211.159.176.204:8080/upload_img/4.mp4");

        data.put("clothes", recommendList1);
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

    @RequestMapping(value = "/cloth/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCloth(@PathVariable("id")int id) {
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("code",0);
        retMap.put("msg","ok");
        Cloth cloth = clothService.getClothById(id);
        if(cloth != null) {
            retMap.put("data",cloth);
        }else{
            retMap.put("code",-1);
            retMap.put("msg","Cloth not found with ID:" +id);
        }
        return retMap;
    }
}
