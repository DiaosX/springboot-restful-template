package com.mydemo.resttemplate.common.enums;

/**
 * @Author yst
 * @Date 2021/10/28 10:13 上午
 * @Version 1.0
 */
public enum DbOrderTypeEnum {
    asc,
    ASC,
    ascending,
    desc,
    DESC,
    descending;

    public static boolean isAsc(DbOrderTypeEnum type) {
        return isAsc(type.name());
    }

    public static boolean isAsc(String type) {
        return type == null
                || ASC.name().equalsIgnoreCase(type)
                || ascending.name().equalsIgnoreCase(type);
    }
}
