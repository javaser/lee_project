package com.github.xianzhan.dubbo.service.impl;

import com.github.xianzhan.dubbo.service.ClientService;

public class ClientServiceImpl implements ClientService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String like(String name) {
        return "I like " + name;
    }
}
