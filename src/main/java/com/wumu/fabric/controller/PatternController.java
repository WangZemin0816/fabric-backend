package com.wumu.fabric.controller;

import com.alibaba.fastjson.JSONObject;
import com.wumu.fabric.model.Pattern;
import com.wumu.fabric.service.IPatternService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@CrossOrigin
@RestController
public class PatternController {

    @Autowired
    private IPatternService patternService;

    @Value("${image.pattern}")
    private String uploadPath;

    @RequestMapping("pattern/getAll")
    public Page<Pattern> getAll(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return patternService.findAll(pageable);
    }

    @RequestMapping("pattern/upload")
    public String upload (@RequestParam("file") MultipartFile multipartFile,
                @RequestParam("efile")String spattern) throws IOException{
        Pattern pattern = (Pattern) JSONObject.parseObject(spattern,Pattern.class);
        patternService.upload(multipartFile,pattern,uploadPath);
        return "Upload Image Success!";
    }
}
