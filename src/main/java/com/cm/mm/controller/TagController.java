package com.cm.mm.controller;

import com.cm.mm.model.Tag;
import com.cm.mm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qingao on 2017/11/16.
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    private int offset = 0;
    private int limit = 0;
    @Autowired
    private TagService tagService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list",tagService.getTags(offset,limit));
        return "tag/list";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(@RequestParam(value="id",required = false) Integer id,Model model) {
        String api = "/tag/add";
        if(id != null){
            model.addAttribute("tag",tagService.getTagById(id));
            api="/tag/"+id+"/modify";
        }
        model.addAttribute("api",api);
        return "tag/form";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String create( Tag tag){
        tagService.addTag(tag);
        return "redirect:/tag";
    }
    @RequestMapping(value = "/{id}/modify",method = RequestMethod.POST)
    public String modify(@PathVariable("id")Integer id, Tag tag) {
        tag.setId(id);
        tagService.modifyTag(tag);
        return "redirect:/tag";
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")Integer id){
        tagService.removeTagById(id);
    }
}
