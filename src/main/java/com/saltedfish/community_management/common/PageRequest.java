package com.saltedfish.community_management.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询请求封装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest<T> {

    private Integer pageNum;    //当前页码
    private Integer pageSize;   //每页数量
    //private T obj;

}
