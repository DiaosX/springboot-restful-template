package com.mydemo.resttemplate.common.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @Author yst
 * @Date 2021/10/28 10:20 上午
 * @Version 1.0
 */
public class DbFieldNameUtil {
    public static String fmt(String propName) {
        return StringUtils.camelToUnderline(propName);
    }

    public static String fmt(String propName, Class<?> clazz) {
        Field field = ReflectionUtils.findField(clazz, propName);
        if (field != null) {
            if (field.isAnnotationPresent(TableField.class)) {
                TableField tableField = field.getAnnotation(TableField.class);
                return tableField.value();
            }
        }
        return DbFieldNameUtil.fmt(propName);
    }
}
