package com.wumu.fabric.controller;

import com.alibaba.fastjson.JSONObject;
import com.wumu.fabric.model.PDesign;

import com.wumu.fabric.service.IPDesignService;
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
public class PDesignController {

    @Autowired
    private IPDesignService pdesignService;

    @Value("${image.pdesign}")
    private String uploadPath;

    @RequestMapping("pdesign/getAll")
    public Page<PDesign> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return pdesignService.findAll(pageable);
    }

    @RequestMapping("pdesign/upload")
    public String upload (@RequestParam("file") MultipartFile multipartFile,
                          @RequestParam("efile")String spdesign) throws IOException {
        PDesign pDesign = (PDesign) JSONObject.parseObject(spdesign,PDesign.class);
        pdesignService.upload(multipartFile,pDesign,uploadPath);
        return "Upload Image Success!";
    }

}
