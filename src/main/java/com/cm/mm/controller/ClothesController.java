package com.cm.mm.controller;

import org.bumishi.admin.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qingao on 2017/11/15.
 */
@Controller
@RequestMapping("/clothes")
public class ClothesController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("message","Clothes Page");
        SecurityUtil.getUser();
        return "clothes/clothes";
    }
}
