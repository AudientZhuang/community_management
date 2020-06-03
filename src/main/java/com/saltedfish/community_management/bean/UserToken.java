package com.saltedfish.community_management.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Audient
 * @date 2020/6/3
 */
@Data
public class UserToken {

    private Integer id;
    private Serializable token;

}
