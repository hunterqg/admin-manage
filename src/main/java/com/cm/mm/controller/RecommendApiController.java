package com.cm.mm.controller;

import com.cm.mm.dto.RankedCloth;
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

        int baseHeight = 140;
        Random random = new Random();
        int randomInt = random.nextInt(60);
        int height = baseHeight + randomInt;
        logger.debug("get body height :" + height);
        String key = getBodyShapeKey(height,0);

        logger.debug("get body shape :" + key);
        List<RankedCloth> recommendList1 = recomendService.getRecommendClothes(key,1, "1");
        List<RankedCloth> recommendList2 = recomendService.getRecommendClothes(key,2, "1");
        map.clear();
        map.put("code",0);
        map.put("msg","ok");
        Map<String,Object> data = new HashMap<>();
        data.put("reason",RulesFactory.getInstance().getRecommendReason(key));
//        List<Cloth> clothList = new ArrayList<>();
//        clothList.add(new Cloth("recommend1","model1","user1","https://gd3.alicdn.com/imgextra/i4/40842616/TB2rzrTgC_I8KJjy0FoXXaFnVXa_!!40842616.jpg",1));
//        clothList.add(new Cloth("recommend2","model2","user2","https://gd3.alicdn.com/imgextra/i3/40842616/TB2A25FaxPI8KJjSspoXXX6MFXa_!!40842616.jpg",2));
        recommendList1.addAll(recommendList2);
        data.put("clothes",recommendList1);
        map.put("data",data);

        return map;
    }

    private String getBodyShapeKey(int height,int width) {
        int offset = 0;
        Random random = new Random();
        int index = 0;
        int randomInt = random.nextInt(3);
        if (height<160) {//A
            offset = 0;

        }else if(height>=160 && height<=168) {//B
            offset = 3;
        }else{ //C
            offset = 6;

        }
        index = offset + randomInt;
        return RulesFactory.BODY_SHAPES[index];
    }
}
