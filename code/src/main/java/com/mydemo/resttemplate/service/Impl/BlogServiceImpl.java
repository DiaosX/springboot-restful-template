package com.mydemo.resttemplate.service.Impl;

import com.mydemo.resttemplate.model.entity.Blog;
import com.mydemo.resttemplate.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    private static Map<Integer, Blog> BLOG_STORE = new HashMap<>();


}
