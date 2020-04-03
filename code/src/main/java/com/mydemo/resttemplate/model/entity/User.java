package com.mydemo.resttemplate.model.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}