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

    public static <T> BasePagedResult toResult(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> items) {
        BasePagedResult<T> result = new BasePagedResult<>();
        result.setItems(items);
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);
        result.setTotalCount(totalCount);
        return result;
    }

    public static <E> BasePagedResult<E> toResult(Integer totalRow, List<E> items) {
        BasePagedResult<E> pageResult = new BasePagedResult<>();
        pageResult.setTotalCount(totalRow);
        pageResult.setItems(items);
        return pageResult;
    }

    /**
     * 包装列表结果为分页结果数据
     *
     * @param items
     * @param <E>
     * @return
     */
    public static <E> BasePagedResult<E> toResult(List<E> items) {
        return BasePagedResult.toResult(items.size(), items);
    }
}
