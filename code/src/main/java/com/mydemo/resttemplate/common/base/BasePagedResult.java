package com.mydemo.resttemplate.common.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasePagedResult<T> {
    protected Integer pageIndex;
    protected Integer pageSize;
    protected Integer totalCount;
    protected List<T> items;

    public static <T> BasePagedResult set(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> items) {
        BasePagedResult<T> result = new BasePagedResult<>();
        result.setItems(items);
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);
        result.setTotalCount(totalCount);
        return result;
    }
}
