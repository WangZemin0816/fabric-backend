package com.wumu.fabric.controller;

import com.alibaba.fastjson.JSONObject;
import com.wumu.fabric.model.TDesign;
import com.wumu.fabric.service.ITDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TDesignController {


    @Autowired
    private ITDesignService tdesignService;

    @Value("${image.tdesign}")
    private String uploadPath;

    @RequestMapping("tdesign/getAll")
    public Page<TDesign> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return tdesignService.findAll(pageable);
    }

    @RequestMapping("tdesign/upload")
    public String upload (@RequestParam("file") MultipartFile multipartFile,
                          @RequestParam("efile")String spdesign) throws IOException {
        TDesign tDesign = (TDesign) JSONObject.parseObject(spdesign,TDesign.class);
        tdesignService.upload(multipartFile,tDesign,uploadPath);
        return "Upload Image Success!";
    }
}
