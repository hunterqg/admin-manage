package org.bumishi.admin.interfaces.system.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by qingao on 2017/11/14.
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    private static Logger logger = LoggerFactory.getLogger(ApiController.class);
    @RequestMapping(value = "/test",method= RequestMethod.POST)
    @ResponseBody
    public Map test(@RequestBody Map map) {
        logger.debug(map.toString());
        return map;
    }


}
