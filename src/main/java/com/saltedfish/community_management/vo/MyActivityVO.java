package com.saltedfish.community_management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Audient
 * @date 2020/5/22
 */
@Data
public class MyActivityVO {
    private Integer id;         //活动报名ID
    private Integer act_id;     //活动id
    private String title;       //活动标题
    private Integer num;        //报名人数
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;     //活动开始日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;       //活动结束日期
    private Integer cancel;     //活动是否取消,0表示不取消,1表示取消,默认为0
}
