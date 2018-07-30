package com.obelisk.controller;

import com.alibaba.fastjson.JSONObject;
import com.obelisk.dao.UserDao;
import com.obelisk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by duguangquan on 2018/7/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @PostMapping("/insert")
    public User insertUser(@RequestParam("name") String name) {

        User user = new User();
        user.setName(name);

        userDao.save(user);

        System.err.println(JSONObject.toJSON(user));
        return user;

    }

}
