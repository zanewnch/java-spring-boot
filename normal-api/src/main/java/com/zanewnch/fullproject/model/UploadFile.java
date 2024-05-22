package com.zanewnch.fullproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/*
Using entity class to parse the json file
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFile {
    private String username;
    private Integer age;
    private MultipartFile image;
}
