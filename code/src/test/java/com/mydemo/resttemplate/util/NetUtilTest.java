package com.mydemo.resttemplate.util;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @Author yst
 * @Description 网络工具类单元测试
 * @Date 2022/7/16 23:18
 * @Version 1.0
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
class NetUtilTest {

    @Test
    public void success_to_get_local_ip_address() {
        log.info(NetUtil.getLocalhostStr());
        log.info(NetUtil.getLocalHostName());
    }

}
