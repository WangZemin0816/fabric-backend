package com.wumu.fabric.controller.validated;

import com.wumu.fabric.model.EFile;
import com.wumu.fabric.model.Pattern;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class UploadForm<T extends EFile>{

    @NotNull
    private MultipartFile file;

    @NotNull
    private T eFile;
}
