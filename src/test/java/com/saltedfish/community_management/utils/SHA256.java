package com.saltedfish.community_management.utils;

import com.saltedfish.community_management.util.SHA256Util;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author Audient
 * @date 2020/6/2
 */
@SpringBootTest
public class SHA256 {

    @Test
    public void testSHA256(){
        String salt = UUID.randomUUID().toString();
        String password = SHA256Util.sha256("123456", salt);
        System.out.println("盐值: " + salt);
        System.out.println("加密之后的密码: " + password);
    }
}
