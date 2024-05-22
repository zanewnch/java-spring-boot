package com.zanewnch.fullproject.service;

import com.zanewnch.fullproject.model.UploadFile;

import java.io.IOException;


public interface UploadService {

    void upload(UploadFile uploadFile) throws IOException;
}
