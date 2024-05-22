package org.zane.server.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
@Slf4j
public class SimpleExampleTask {

    /*
    當開啟spring boot server就會自動開始執行
    不需要config file
     */
    /*
    定時任務
    每5秒執行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        log.info("spring task testing... : "+new Date());
    }
}
