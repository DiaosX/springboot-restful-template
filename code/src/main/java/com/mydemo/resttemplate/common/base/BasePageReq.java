package com.mydemo.resttemplate.common.base;

import java.io.Serializable;

/**
 * @Author yst
 * @Date 2021/10/27 10:11 上午
 * @Version 1.0
 */
public class BasePageReq extends BaseReq implements Serializable {
    protected int pageIndex;
    protected int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
