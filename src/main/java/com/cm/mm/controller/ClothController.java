package com.cm.mm.controller;

import com.cm.mm.model.Cloth;
import com.cm.mm.service.ClothService;
import com.cm.mm.service.TypeService;
import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.bumishi.admin.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by qingao on 2017/11/15.
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
    private Logger logger = LoggerFactory.getLogger(ClothController.class);

    @Value("${admin.cloth.upload.path}")
    private String imgUploadPath;
    @Autowired
    private ClothService service;

    @Autowired
    private TypeService typeService;

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
            model.addAttribute("cloth",service.getClothById(id));
            api="/cloth/"+id+"/modify";
        }
        model.addAttribute("types",typeService.getTypes(0,1000));
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

    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map  upload(@RequestParam("avatar_data") String data,
                       @RequestParam("avatar_src") String src,
                       @RequestParam("avatar_file") MultipartFile file) {
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("state",200);
        String orgFileName = file.getOriginalFilename();
        String fileExtName = FilenameUtils.getExtension(orgFileName);
        if(!fileExtNameList.contains(fileExtName.toLowerCase())) {
            retMap.put("message","Invalid input file type,(png,jpg,gif) only");
            logger.debug("Invalid input file type!");
            return retMap;
        }
        try {
            String fileSavePath = imgUploadPath;
            String monthStr = DateFormatUtils.format(new Date(),"yyyy-MM");
            fileSavePath += monthStr + File.separator;
            File filePath = new File(fileSavePath);
            if(!filePath.exists()) {
                filePath.mkdirs();
            }
            String fileName =  System.currentTimeMillis()+"."+fileExtName;
            File f = new File(fileSavePath + fileName);
            logger.debug(f.getAbsolutePath());
            file.transferTo(f);
            retMap.put("result","/upload_img/"+fileName);
            logger.debug("upload file saved to:" + f.getAbsolutePath());
        } catch (IOException e) {
            retMap.put("message","Save file failed! == " + e.getMessage());
            e.printStackTrace();
        }

        return retMap;
    }
    public static List<String> fileExtNameList = new ArrayList<>();
    static {
        fileExtNameList.add("png");
        fileExtNameList.add("jpg");
        fileExtNameList.add("gif");
    }
}
