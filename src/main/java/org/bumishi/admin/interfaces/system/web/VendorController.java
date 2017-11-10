package org.bumishi.admin.interfaces.system.web;

import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qingao on 2017/11/10.
 */
@Controller("/vendor")
public class VendorController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message","Hello Vendor");
        return "vendor/welcome";
    }
}
