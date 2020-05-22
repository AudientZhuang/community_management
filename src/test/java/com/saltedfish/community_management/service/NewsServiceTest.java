package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.News;
import com.saltedfish.community_management.common.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void addNews(){
        //添加的新闻信息
        News news = new News();
        news.setTitle("新闻标题1");
        news.setContent("新闻内容1111");
        news.setImage("D:/ssda");
        news.setAuthor("作者11111");
        news.setDate(new Date(Date.valueOf("2020-1-1").getTime()));

        try {
            Result result = newsService.addNews(news);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateNews(){
        //添加的新闻信息
        News news = new News();
        news.setId(1);
        news.setTitle("新闻标题1111111");
        news.setContent("新闻内容1111修改");
        news.setImage("D:/ssda");
        news.setAuthor("作者11111");
        news.setDate(new Date(Date.valueOf("2020-1-1").getTime()));

        try {
            Result result = newsService.updateNews(news);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNews(){
        try {
            Result result = newsService.deleteNews(2);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findNewsById(){
        try{
            Result result = newsService.findNewsById(1);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findNews(){
        try {
            Map<String,String> conditionMap = new HashMap<>();
            conditionMap.put("title","新闻标题1111111");
            Result result = newsService.findNews(conditionMap);
            System.out.println(result);
            Assert.assertThat(result.getStatus(),is(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
