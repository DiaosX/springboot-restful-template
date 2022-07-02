package com.mydemo.resttemplate.common.startup;

import com.mydemo.resttemplate.common.util.I18nUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author yst
 * @Description Spring事件监听器
 * @Date 2022/7/2 21:31
 * @Version 1.0
 */
@Slf4j
@Component
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    private MessageSource messageSource;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        I18nUtil.setMessageSource(messageSource);
    }
}
