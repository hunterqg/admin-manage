package com.cm.mm.controller;

import com.cm.mm.model.SmallProgramMaLong;
import com.cm.mm.model.SmallProgramUser;
import com.cm.mm.service.SmallProgramMaLongService;
import com.cm.mm.service.SmallProgramUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 2018/1/9.
 */
@RestController
@RequestMapping("/api/v1/malong")
public class SmallProgramMaLongController {
    private Logger logger = LoggerFactory.getLogger(SmallProgramMaLongController.class);
    @Autowired
    private SmallProgramMaLongService service;



    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map queryMalong(@RequestBody Map<String,String> map) {
        logger.debug("input:" + map.toString());
        Map retMap = new HashMap();
        retMap.put("code",0);
        retMap.put("msg","ok");
        String url = map.get("url");
        if(url == null) {
            retMap.put("code",-2);
            retMap.put("msg","Can't find url in parameters");
        }else {
            SmallProgramMaLong maLong = service.getMaLong(url);
            if (maLong == null || maLong.getProp1() == null || StringUtils.isEmpty(maLong.getProp1())) {
                retMap.put("code", -1);
                retMap.put("msg", "Can't get info from malong");
            } else {
                retMap.put("data", maLong);
            }
        }
        return retMap;
    }

}
