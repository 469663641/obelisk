package com.obelisk.dao;

import com.obelisk.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by duguangquan on 2018/7/29.
 */
@Repository
public class UserDao {


    private final ConcurrentHashMap<Integer,User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();


    public Boolean save(User user){

        int id = idGenerator.incrementAndGet();
        user.setId(id);
        repository.put(id, user);
        return true;
    }
}
