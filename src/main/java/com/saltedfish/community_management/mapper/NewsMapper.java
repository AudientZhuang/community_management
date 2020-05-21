package com.saltedfish.community_management.mapper;

import com.saltedfish.community_management.bean.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 新闻信息
 */
@Mapper
public interface NewsMapper {

    /**
     * 添加新闻信息
     * @param news
     * @return
     */
    public Integer insertNews(News news);

    /**
     * 更新新闻信息
     * @param news
     * @return
     */
    public Integer updateNews(News news);

    /**
     * 删除新闻信息
     * @param id
     * @return
     */
    public Integer deleteNews(@Param("id") Integer id);

    /**
     * 查询指定id的新闻信息
     * @param id
     * @return
     */
    public News findNewsById(@Param("id") Integer id);

    /**
     * 根据条件查询新闻信息
     * @param conditionMap
     * @return
     */
    public List<News> findNews(@Param("conditionMap") Map<String,String> conditionMap);
}
