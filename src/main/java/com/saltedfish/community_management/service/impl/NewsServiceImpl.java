package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.News;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.NewsMapper;
import com.saltedfish.community_management.service.NewsService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Result addNews(News news) throws Exception {
        Integer effort = newsMapper.insertNews(news);
        if (effort != 0){
            //添加新闻信息成功
            return new Result(HttpStatus.OK.value(),"添加新闻信息成功",null);
        }else{
            //添加新闻信息失败
            throw new Exception("添加新闻信息失败");
        }
    }

    @Override
    public Result updateNews(News news) throws Exception {
        Integer effort = newsMapper.updateNews(news);
        if (effort != 0){
            //更新新闻信息成功
            return new Result(HttpStatus.OK.value(),"更新新闻信息成功",null);
        }else{
            //更新新闻信息失败
            throw new Exception("更新新闻信息失败");
        }
    }

    @Override
    public Result deleteNews(Integer id) throws Exception {
        Integer effort = newsMapper.deleteNews(id);
        if (effort != 0){
            //删除新闻信息成功
            return new Result(HttpStatus.OK.value(),"删除新闻信息成功",null);
        }else{
            //删除新闻信息失败
            throw new Exception("删除新闻信息失败");
        }
    }

    @Override
    public Result findNewsById(Integer id) {
        News news = newsMapper.findNewsById(id);
        if (news != null){
            // 查询指定id的新闻信息成功
            return new Result(HttpStatus.OK.value(),"查询指定id的新闻信息成功",news);
        }else{
            // 查询指定id的新闻信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到新闻信息",null);
        }
    }

    @Override
    public Result findNewsPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<News> newsList = newsMapper.findNews(conditionMap);
        if (newsList != null){
            // 根据条件查询新闻信息成功
            PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(newsList));
            return new Result(HttpStatus.OK.value(),"根据条件查询新闻信息成功",pageResult);
        }else{
            // 根据条件查询新闻信息失败
            throw new Exception("根据条件查询新闻信息失败");
        }
    }

    @Override
    public Result findNews(Map<String, String> conditionMap) throws Exception {
        List<News> newsList = newsMapper.findNews(conditionMap);
        if (newsList != null){
            // 根据条件查询新闻信息成功
            return new Result(HttpStatus.OK.value(),"根据条件查询新闻信息成功",newsList);
        }else{
            // 根据条件查询新闻信息失败
            throw new Exception("根据条件查询新闻信息失败");
        }
    }
}
