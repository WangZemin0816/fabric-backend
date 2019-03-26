package com.wumu.fabric.service.impl;

import com.wumu.fabric.controller.validated.UploadForm;
import com.wumu.fabric.model.EFile;
import com.wumu.fabric.model.User;
import com.wumu.fabric.service.IEFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


public abstract class EFileService<T extends EFile>
        extends BaseService<T> implements IEFileService<T> {

    /* 静态资源相对项目根目录的路径 */
    @Value("${static.root}")
    private String staticRoot;

    public T upload(MultipartFile uploadFile, T eFile, String path) throws IOException {
        String relaPath = path+"/"+getRandomName(uploadFile);
        save2Disk(uploadFile,relaPath);
        return save2Database(eFile,relaPath);
    }
    private void save2Disk(MultipartFile uploadFile,String relaPath)throws IOException{
        String abspath = new File("").getAbsolutePath()+staticRoot+relaPath;
        File file = new File(abspath);
        uploadFile.transferTo(file);
    }

    private T save2Database(T eFile,String relaPath){
        eFile.setUrl(relaPath);
        return this.save(eFile);
    }

    private String getRandomName(MultipartFile uploadFile){
        String uuid = UUID.randomUUID().toString();
        String filename = uploadFile.getOriginalFilename();
        String suffix=filename.substring(filename.lastIndexOf("."));
        return uuid+suffix;
    }
}
