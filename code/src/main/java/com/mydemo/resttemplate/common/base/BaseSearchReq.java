package com.mydemo.resttemplate.common.base;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mydemo.resttemplate.common.enums.DbOrderTypeEnum;
import com.mydemo.resttemplate.common.util.DbFieldNameUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yst
 * @Description 基础搜索请求数据
 * @Date 2022/6/1 22:42
 * @Version 1.0
 */
public class BaseSearchReq extends BasePageReq {
    /**
     * 检索关键字
     */
    protected String keywords;
    /**
     * 排序集合,多列排序
     */
    protected List<BaseOrderInfo> orderItems;


    public <T> Page<T> ofPageable() {
        Page<T> pageable = new Page<>(this.getPageIndex(), this.getPageSize());
        List<OrderItem> orderItems = this.getDbOrderItems();
        if (!CollectionUtils.isEmpty(orderItems)) {
            pageable.setOrders(orderItems);
        }
        return pageable;
    }

    public List<OrderItem> getDbOrderItems() {
        if (CollectionUtil.isNotEmpty(this.getOrderItems())) {
            List<OrderItem> dbOrderItems = new ArrayList<>();
            for (BaseOrderInfo orderItem : this.getOrderItems()) {
                String columnName = DbFieldNameUtil.fmt(orderItem.getOrderFieldName());
                OrderItem dbOrderItem = OrderItem.asc(columnName);
                if (!DbOrderTypeEnum.isAsc(orderItem.getOrderType())) {
                    dbOrderItem = OrderItem.desc(columnName);
                }
                dbOrderItems.add(dbOrderItem);
            }
            return dbOrderItems;
        }
        return null;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<BaseOrderInfo> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<BaseOrderInfo> orderItems) {
        this.orderItems = orderItems;
    }
}
