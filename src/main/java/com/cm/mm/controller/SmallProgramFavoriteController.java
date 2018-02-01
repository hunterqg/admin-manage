package com.cm.mm.controller;

import com.cm.mm.service.SmallProgramFavoriteService;
import com.cm.mm.service.SmallProgramUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingao on 18-1-23.
 */
@RestController
@RequestMapping("/api/v1")
public class SmallProgramFavoriteController {

    @Autowired
    private SmallProgramFavoriteService service;
    @Autowired
    private SmallProgramUserService userService;

    @RequestMapping(value = "/spfavorite/{wechatId}",method = RequestMethod.GET)
    public Map listFavorites(@PathVariable("wechatId") String wechatId) {
        Map<String,Object> retMap = new HashedMap();
        retMap.put("code",0);
        retMap.put("msg","ok");
        if(wechatId == null) {
            retMap.put("code",-1);
            retMap.put("msg","wechat id can not be null!");
        }else {
            if(userService.getSpUser(wechatId) == null) {
                retMap.put("code",-2);
                retMap.put("msg","wechat id can not be found!");
            }else {
                retMap.put("wechatId", wechatId);
                retMap.put("data", service.listFavorites(wechatId));
            }
        }

        return retMap;
    }
    @RequestMapping(value = "/spfavorite/{wechatId}",method = RequestMethod.DELETE)
    public Map removeFavorites(@PathVariable("wechatId") String wechatId, @RequestBody Map map) {
        Map<String,Object> retMap = new HashedMap();
        retMap.put("code",0);
        retMap.put("msg","ok");
        if(wechatId == null) {
            retMap.put("code",-1);
            retMap.put("msg","wechat id can not be null!");
        }else {
            if(userService.getSpUser(wechatId) == null) {
                retMap.put("code",-2);
                retMap.put("msg","wechat id can not be found!");
            }else {
                List<Integer> ids = (List<Integer>)map.get("ids");
                if(ids == null) {
                    retMap.put("code",-3);
                    retMap.put("msg","invalid input ids!");
                }else {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("wechatId", wechatId);
                    dataMap.put("counts", service.removeAllFavorites(wechatId, ids));
                    retMap.put("data",dataMap);
                }
            }
        }

        return retMap;
    }

    @RequestMapping(value = "/spfavorite/{wechatId}",method = RequestMethod.POST)
    public Map addFavorites(@PathVariable("wechatId") String wechatId, @RequestBody Map map) {
        Map<String,Object> retMap = new HashedMap();
        retMap.put("code",0);
        retMap.put("msg","ok");
        if(wechatId == null) {
            retMap.put("code",-1);
            retMap.put("msg","wechat id can not be null!");
        }else {
            if(userService.getSpUser(wechatId) == null) {
                retMap.put("code",-2);
                retMap.put("msg","wechat id can not be found!");
            }else {
                List<Integer> ids = (List<Integer>)map.get("ids");
                if(ids == null) {
                    retMap.put("code",-3);
                    retMap.put("msg","invalid input ids!");
                }else {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("wechatId", wechatId);
                    dataMap.put("counts", service.addAllFaviatories(wechatId, ids));
                    retMap.put("data",dataMap);
                }
            }
        }

        return retMap;
    }
}
