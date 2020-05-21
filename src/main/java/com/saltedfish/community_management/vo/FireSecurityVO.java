package com.saltedfish.community_management.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author Audient
 * @date 2020/5/21
 */
@Data
public class FireSecurityVO {

    private Integer id;         //自增ID
    private Integer buildId;    //外键绑定楼栋ID
    private String buildingName;//楼栋名称
    private Date createDate;    //记录创建日期
    private String checkContent;//检查内容
    private Integer level;      //消防状态等级(0差,需要更新,1良好,2优秀)
    private Date checkDate;     //检查日期
    private Date updateDate;    //更新日期
}
