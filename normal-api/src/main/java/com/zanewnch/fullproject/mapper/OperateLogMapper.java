package com.zanewnch.fullproject.mapper;

import com.zanewnch.fullproject.model.OperateLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    void insertOperateLog(OperateLog operateLog);
}
