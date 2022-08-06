package com.mydemo.resttemplate.common.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yst
 * @Description
 * @Date 2022/8/6 21:21
 * @Version 1.0
 */
@Slf4j
@Configuration
public class OtherConfig {

    @Bean
    public Snowflake snowflake() {
        String ipv4 = NetUtil.getLocalhostStr();
        long ipLong = Ipv4Util.ipv4ToLong(ipv4);
        long workId = ipLong % 32;
        long threadId = Thread.currentThread().getId();
        long dataCenterId = threadId % 32;

        log.info("local ipv4 address={},ip long value={},thread id={},work id={},data center id={}",
                ipv4, ipLong, threadId, workId, dataCenterId);

        return new Snowflake(workId, dataCenterId, true);
    }
}
