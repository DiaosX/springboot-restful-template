package com.mydemo.resttemplate.common.cache;

import com.mydemo.resttemplate.model.vo.UserVO;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author yst
 * @Description 本地缓存配置
 * @Date 2022/7/18 22:43
 * @Version 1.0
 */
public class LocalCacheConfig {
    @Bean
    public LocalCache<String, List<UserVO>> userLocalCache() {
        return new LocalCache<>(30, TimeUnit.MINUTES);
    }

}
