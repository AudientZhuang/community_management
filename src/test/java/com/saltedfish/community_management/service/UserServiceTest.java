package com.saltedfish.community_management.service;

import com.saltedfish.community_management.common.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void cmLogin(){
        try {
            Result result = userService.cmLogin("lzy", "lzy");
            System.out.println("result=" +result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
