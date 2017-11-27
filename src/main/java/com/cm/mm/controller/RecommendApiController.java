package com.cm.mm.controller;

import com.cm.mm.model.Cloth;
import com.cm.mm.rules.RulesFactory;
import com.cm.mm.service.RecomendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by qingao on 2017/11/22.
 */

@Controller
@RequestMapping("/api/v1")
public class RecommendApiController {
    Logger logger = LoggerFactory.getLogger(RecommendApiController.class);

    @Autowired
    private RecomendService recomendService;

    @RequestMapping(value = "/recommend",method= RequestMethod.POST)
    @ResponseBody
    public Map test(@RequestBody Map map) {
        logger.debug("Recevied  map:" + map);
        List<Cloth> recommednList = recomendService.getRecommendClothes(RulesFactory.KEY_BODY_SHAPE_A1);
        map.clear();
        map.put("data",recommednList);
        return map;
    }
}
