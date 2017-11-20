package com.cm.mm.controller;

import com.cm.mm.model.Cloth;
import com.cm.mm.model.Tag;
import com.cm.mm.service.ClothService;
import org.bumishi.admin.security.SecurityUser;
import org.bumishi.admin.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qingao on 2017/11/15.
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {

    @Autowired
    private ClothService service;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(Model model) {
        Cloth cloth = new Cloth();
        if (!SecurityUtil.isRoot()) {
            cloth.setUserId(SecurityUtil.getUid());
        }
        model.addAttribute("list",service.listClothes(cloth));
        return "cloth/list";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(@RequestParam(value="id",required = false) Integer id, Model model) {
        String api = "/cloth/add";
        if(id != null){
            model.addAttribute("tag",service.getClothById(id));
            api="/cloth/"+id+"/modify";
        }
        model.addAttribute("api",api);
        return "cloth/form";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String create( Cloth cloth){
        service.addCloth(cloth);
        return "redirect:/cloth";
    }
    @RequestMapping(value = "/{id}/modify",method = RequestMethod.POST)
    public String modify(@PathVariable("id")Integer id, Cloth cloth) {
        cloth.setId(id);
        service.modifyCloth(cloth);
        return "redirect:/cloth";
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")Integer id){
        service.removeClothById(id);
    }
}
