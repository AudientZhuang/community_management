package com.saltedfish.community_management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Audient
 * @date 2020/5/28
 */
@Data
public class ActivityVO {
    private Integer id;         //自增ID
    private String image;       //活动图片路径
    private String title;       //活动标题
    private String content;     //活动内容
    private String address;     //活动地址
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;          //活动开始日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;          //活动结束日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date deadline;          //活动截止日期
    private String publisher;   //活动发布者
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishDate;   //活动发布日期
    private Integer cancel;     //活动是否取消,0表示不取消,1表示取消,默认为0

    private Integer register;   //用户是否已经报名活动,0表示未报名,1表示已报名
}
