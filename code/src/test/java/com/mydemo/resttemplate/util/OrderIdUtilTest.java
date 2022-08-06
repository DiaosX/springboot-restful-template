package com.mydemo.resttemplate.util;

import com.mydemo.resttemplate.common.util.OrderIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @Author yst
 * @Date 2022/8/6 22:01
 * @Version 1.0
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
public class OrderIdUtilTest {

    @Test
    public void test() {
        for (int i = 0; i < 100000; i++) {
            log.info(OrderIdUtil.nextStr());
        }

    }
}
