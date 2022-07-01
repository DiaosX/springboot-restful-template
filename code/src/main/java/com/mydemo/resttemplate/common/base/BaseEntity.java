package com.mydemo.resttemplate.common.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author yst
 * @Description 持久层基础实体类
 * @Date 2022/6/1 23:25
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {
    @TableId(
            value = "id",
            type = IdType.AUTO
    )
    protected Long id;

    @TableField(value = "create_by")
    protected String createBy;

    @TableField(
            value = "create_at",
            fill = FieldFill.INSERT
    )
    protected Date createAt;

    @TableField(value = "update_by")
    protected String updateBy;

    @TableField(
            value = "update_at",
            fill = FieldFill.UPDATE
    )
    protected Date updateAt;

    @TableField(value = "deleted")
    @TableLogic
    protected Long deleted;
    @TableField(value = "remark")
    protected String remark;
}
