package com.cm.mm.controller;

import com.cm.mm.model.Type;
import com.cm.mm.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qingao on 2017/11/16.
 */
@Controller
@RequestMapping("/type")
public class TypeController {
    private int offset = 0;
    private int limit = 0;
    @Autowired
    private TypeService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", service.getTypes(offset,limit));
        return "type/list";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(@RequestParam(value="id",required = false) Integer id,Model model) {
        String api = "/type/add";
        if(id != null){
            model.addAttribute("type", service.getTypeById(id));
            api="/type/"+id+"/modify";
        }
        model.addAttribute("api",api);
        return "type/form";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String create( Type type){
        service.addType(type);
        return "redirect:/type";
    }
    @RequestMapping(value = "/{id}/modify",method = RequestMethod.POST)
    public String modify(@PathVariable("id")Integer id,Type type) {
        type.setId(id);
        service.modifyType(type);
        return "redirect:/type";
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")Integer id){
        service.removeTypeById(id);
    }
}
