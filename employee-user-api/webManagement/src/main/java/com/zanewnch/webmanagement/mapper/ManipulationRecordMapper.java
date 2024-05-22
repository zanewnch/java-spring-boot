//package org.zanewnch;
//
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
////import org.zanewnch.ManipulationRecord;
///*
//這一段我改了很久
//兩個module之間不能相互dependency
//然後一開始我是讓webManagement depend on aspect
//因為想說springboot module 需要depend on aspect module 這樣才會生效
//但因為所有的module 都extends structuredWeb pom.xml 裡面有stringboot and aop dependency
//所以總結來說 我不需要讓webManagement module depend on aspect module,
//所以我就可以讓aspect module depend on webManagement,
//就解決在aspect module 需要 @autowired ManipulationRecordMapper(this file) 的問題
//
//上面是bullshit, 你webManagement 不depend on aspect那根本就沒有調用aspect
// */
//
//@Mapper
//public interface ManipulationRecordMapper {
//    @Insert("insert into manipulationLog (manipulationUser, manipulationTime, className, methodName, methodParams, returnValue, runTime) values (#{manipulationUser},#{manipulationTime},#{className},#{methodName},#{methodParams},#{returnValue},#{runTime})")
//    void insertManipulationRecord(ManipulationRecord manipulationRecord);
//}
