package com.saltedfish.community_management.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author Audient
 * @date 2020/6/1
 */
public class SHA256Util {

    /**
     * 私有化构造器
     */
    private SHA256Util(){}

    /**
     * 加密算法
     */
    public static final String HASH_ALGORITHM_NAME = "SHA-256";

    /**
     * 循环次数
     */
    public final static int HASH_ITERATIONS = 15;

    /**
     * 执行加密-采用SHA256和盐加密
     * @param password
     * @param salt
     * @return
     */
    public static String sha256(String password,String salt){
        return new SimpleHash(HASH_ALGORITHM_NAME,password,salt,HASH_ITERATIONS).toString();
    }
}
