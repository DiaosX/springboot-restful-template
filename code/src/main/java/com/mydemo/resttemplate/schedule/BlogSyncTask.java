package com.mydemo.resttemplate.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @Author yst
 * @Description 同步任务
 * @Date 2022/6/8 21:33
 * @Version 1.0
 */
@Slf4j
@Component
public class BlogSyncTask {

    @Scheduled(initialDelay = 60 * 100, fixedDelay = 60 * 1000)
    public void execute() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("BlogSyncTask");
        log.info("BlogSyncTask:任务开始........");
        try {
            doExecute();
        } catch (Exception e) {
            log.error("BlogSyncTask:任务发生错误", e);
        }
        stopWatch.stop();
        log.info("BlogSyncTask:任务结束");
        log.info(stopWatch.prettyPrint());
    }

    private void doExecute() {
        log.info("do something...");
    }
}
