package com.wumu.fabric.service;

import com.wumu.fabric.controller.validated.UploadForm;
import com.wumu.fabric.model.EFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IEFileService<T extends EFile> extends IBaseService<T>{

    T upload(MultipartFile uploadFile,T eFile, String path) throws IOException;

}
