package com.cm.mm.controller;

import com.cm.mm.model.SmallProgramUser;
import com.cm.mm.service.SmallProgramUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 2018/1/9.
 */
@RestController
@RequestMapping("/api/v1/spuser")
public class SmallProgramUserController {
    private Logger logger = LoggerFactory.getLogger(SmallProgramUserController.class);
    @Autowired
    private SmallProgramUserService service;

    @RequestMapping(value = "/{wechatid}",method = RequestMethod.GET)
    public Map getSpUserInfo(@PathVariable("wechatid") String weichatId) {
        logger.debug("wechatId =" +weichatId);
        Map<String,Object> map = new HashMap<>();
        SmallProgramUser user = service.getSpUser(weichatId);

        if(user != null) {
            map.put("code",0);
            map.put("data",user);
            map.put("msg","success");
        }else{
            map.put("code","-1");
            map.put("msg","No record found.");
        }
        return map;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map saveSpUser(@RequestBody SmallProgramUser user) {
        logger.debug("input:" + user.toString());
        Map retMap = new HashMap();
        retMap.put("code",0);
        retMap.put("msg","ok");
        int result = service.saveSpUser(user);
        if(result != 1) {
            retMap.put("code",-1);
            retMap.put("msg","Save user failed.");
        }
        return retMap;
    }

}
