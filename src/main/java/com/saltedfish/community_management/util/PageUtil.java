package com.saltedfish.community_management.util;

import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;

import java.util.function.LongBinaryOperator;

public class PageUtil {

    /**
     * 将分页信息封装到统一的PageResult中
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getSize());
        pageResult.setItems(pageInfo.getList());
        return pageResult;
    }

    /**
     * 将分页请求参数设置到分页请求封装类中
     * @param key
     * @param value
     * @param pageRequest
     * @return
     */
    public static PageRequest addPageRequestParam(String key, String value, PageRequest pageRequest){
        if ("pageNum".equals(key)){
            //key为分页参数 pageNum
            pageRequest.setPageNum(Integer.parseInt(value));
        }
        if ("pageSize".equals(key)){
            //请求参数中含有分页参数 pageNum
            pageRequest.setPageSize(Integer.parseInt(value));
        }
        return pageRequest;
    }

}
