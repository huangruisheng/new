package com.trusthiker.core.user.service.impl;

import com.trusthiker.core.user.service.UserService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by rui on 16/10/22.
 */
@MotanService(export = "demoMotan:8002")
public class UserServiceImpl implements UserService {

    @PostConstruct
    public void init(){
        System.out.println("==============================");
    }

    public String hello(String name) {
        System.out.println(name);
        return "Hello " + name + "!";
    }

}
