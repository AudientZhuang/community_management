package com.saltedfish.community_management.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果封装类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    private Integer pageNum;    //当前页码
    private Integer pageSize;   //每页数量
    private Integer totalPages; //页面总数
    private Long totalSize;  //记录总数
    private List<?> items;      //数据
}
