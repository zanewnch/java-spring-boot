package com.zanewnch.fullproject.service.impl;

import com.zanewnch.fullproject.mapper.UploadMapper;
import com.zanewnch.fullproject.model.UploadFile;
import com.zanewnch.fullproject.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public void upload(UploadFile uploadFile) throws IOException {

        MultipartFile file = uploadFile.getImage();

        /*
        Get the original file name
         */
        String fileName = file.getOriginalFilename();

        /*
        Get the index of the last dot
         */
        int index = fileName.lastIndexOf(".");

        /*
        Get the extension name,
        for example: .jpg, .png, .gif
         */
        String extensionName = fileName.substring(index);

        /*
        Create the complete file name;
        UUID: is the abbreviation of "Universally Unique Identifier,
        which is an identification number that is unique in space and time.
         */
        String completedFileName = UUID.randomUUID().toString() + extensionName;
        /*
        Store file to the specific path
         */
        file.transferTo(new File("/static/" + completedFileName));

        //        UploadMapper.upload();
    }
}
