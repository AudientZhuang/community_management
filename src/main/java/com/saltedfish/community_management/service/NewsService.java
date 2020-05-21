package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.News;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;

import java.util.Map;

public interface NewsService {

    /**
     * 添加新闻信息
     * @param news
     * @return
     */
    Result addNews(News news) throws Exception;

    /**
     * 更新新闻信息
     * @param news
     * @return
     */
    Result updateNews(News news) throws Exception;

    /**
     * 删除新闻信息
     * @param id
     * @return
     */
    Result deleteNews(Integer id) throws Exception;

    /**
     * 查询指定id的新闻信息
     * @param id
     * @return
     */
    Result findNewsById(Integer id);

    /**
     * 根据条件查询新闻信息，需要分页
     * @param conditionMap
     * @return
     */
    Result findNewsPage(PageRequest pageRequest, Map<String,String> conditionMap) throws Exception;

    /**
     * 根据条件查询新闻信息，不需要分页
     * @param conditionMap
     * @return
     */
    Result findNews(Map<String,String> conditionMap) throws Exception;

}
