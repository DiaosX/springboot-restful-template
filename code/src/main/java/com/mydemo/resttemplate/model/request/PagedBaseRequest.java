package com.mydemo.resttemplate.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagedBaseRequest {
    private Integer pageIndex = 1;
    private Integer pageSize = 20;
}
