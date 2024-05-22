package com.zanewnch.fullproject.mapper;

import com.zanewnch.fullproject.model.UploadFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadMapper {
    void upload(UploadFile uploadFile);
}
