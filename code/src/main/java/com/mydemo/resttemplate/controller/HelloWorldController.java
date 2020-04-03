package com.mydemo.resttemplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController extends BaseController {

    @RequestMapping(value = "forList", method = RequestMethod.GET)
    public List<String> forList() {
        List<String> bucket = new ArrayList<>();
        bucket.add("Hello");
        bucket.add("world");
        return bucket;
    }

    @RequestMapping("forString")
    public String forString() {
        String message = "Hello world";
        return message;
    }

    @RequestMapping("forException")
    public String forException() {
        throw new RuntimeException("发生异常了.");
    }

    @RequestMapping("forObject")
    public Object forObject() {
        String obj = "cccc";
        return obj;
    }
}
