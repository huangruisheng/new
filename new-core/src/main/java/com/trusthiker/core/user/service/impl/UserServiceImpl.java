package com.trusthiker.core.user.service.impl;

import com.trusthiker.core.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rui on 16/10/22.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    public String hello(String name) {
        System.out.println(name);
        return "Hello " + name + "!";
    }

}
