package com.mydemo.resttemplate.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @Author yst
 * @Description 国际化帮助类
 * @Date 2022/7/1 23:57
 * @Version 1.0
 */
public class I18nUtil extends ResourceBundleMessageSource {

    private static MessageSource messageSource;

    public static void setMessageSource(MessageSource messageSource) {
        I18nUtil.messageSource = messageSource;

    }

    public I18nUtil() {
        super();
    }

    public static String get(String key) {
        return get(key, (Object) null);
    }

    public static String get(String key, Object... params) {
        try {
            return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        } catch (Exception ex) {
            return key;
        }
    }
}
