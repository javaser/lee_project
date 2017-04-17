package com.github.xianzhan.service.impl;

import com.github.xianzhan.service.TimeService;

import java.util.Date;

public class TimeServiceImpl implements TimeService {

    @Override
    public void sayTime() {
        System.out.println(new Date());
    }
}
