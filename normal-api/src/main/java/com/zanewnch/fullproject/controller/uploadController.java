package com.zanewnch.fullproject.controller;

import com.zanewnch.fullproject.model.UploadFile;
import com.zanewnch.fullproject.service.UploadService;
import com.zanewnch.fullproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class uploadController {
    @Autowired
    private UploadService uploadService;


    /*
    POST for adding data
    and suppose that the pass method of frontend is using request body
     */
    @PostMapping
    public Result upload(
            @RequestBody UploadFile uploadFile
    ) throws IOException {
        uploadService.upload(uploadFile);
        return Result.success();
    }
}
