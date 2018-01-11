package com.cm.mm.controller;

import com.cm.mm.model.SmallProgramBanner;
import com.cm.mm.service.SmallProgramBannerService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by qingao on 18-1-11.
 */
@RestController
@RequestMapping("/api/v1/spbanner")
public class SmallProgramBannerController {
    @Autowired
    private SmallProgramBannerService service;


    @RequestMapping(value = "",method = RequestMethod.GET)
    public Map<String,Object> listBanners() {
        Map<String,Object> retMap = new HashedMap();
        retMap.put("code",0);
        retMap.put("msg","ok");

        List<SmallProgramBanner> list = service.listAllSpBanners();

        if(list == null || list.size() == 0) {
            retMap.put("code",-1);
            retMap.put("msg","No banner found!");
        }else {
            retMap.put("data", list);
        }

        return retMap;
    }

}
