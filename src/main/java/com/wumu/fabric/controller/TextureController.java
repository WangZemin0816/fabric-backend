package com.wumu.fabric.controller;

import com.alibaba.fastjson.JSONObject;
import com.wumu.fabric.dao.ITDivisionDao;
import com.wumu.fabric.model.TDesign;
import com.wumu.fabric.model.TDivision;
import com.wumu.fabric.model.TOrigin;
import com.wumu.fabric.service.ITDivisionService;
import com.wumu.fabric.service.ITOriginService;
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
public class TextureController {

    @Autowired
    private ITOriginService tOriginService;

    @Autowired
    private ITDivisionService tDivisionService;

    @Value("${image.texture.origin}")
    private String uploadOriginPath;

    @Value("${image.texture.division}")
    private String uploadDivisionPath;

    @RequestMapping("texture/getAll")
    public Page<TOrigin> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return tOriginService.findAll(pageable);
    }

    @RequestMapping("texture/upload")
    public String upload (@RequestParam("origin") MultipartFile multipartFile,
                          @RequestParam("division") MultipartFile multipartFile1,
                          @RequestParam("efile") String efile) throws IOException {
        TDivision tDivision = new TDivision();
        tDivision = tDivisionService.upload(multipartFile1,tDivision,uploadDivisionPath);
        TOrigin tOrigin = (TOrigin) JSONObject.parseObject(efile,TOrigin.class);
        tOrigin.setTDivision(tDivision);
        tOriginService.upload(multipartFile,tOrigin,uploadOriginPath);

        return "Success!";
    }
}
