package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 设施维护信息
 */
@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 添加维护信息
     * @param maintenance
     * @return
     */
    @PostMapping("/maintenance")
    public Result addMaintenance(Maintenance maintenance){
        try{

        }catch (Exception e){

        }
        return null;
    }

    /**
     * 修改维护信息
     * @param maintenance
     * @return
     */
    @PutMapping("/maintenance")
    public Result updateMaintenance(Maintenance maintenance){
        try {

        }catch (Exception e){

        }
        return null;
    }

    /**
     * 删除维护信息
     * @param id
     * @return
     */
    @DeleteMapping("/maintenance/{id}")
    public Result deleteMaintenance(@PathVariable("id") Integer id){
        try {

        }catch (Exception e){

        }
        return null;
    }

    /**
     * 查询指定id的维护信息
     * @param id
     * @return
     */
    @GetMapping("/maintenance/{id}")
    public Result findMaintenanceById(@PathVariable("id") Integer id){
        try{

        }catch (Exception e){

        }
        return null;
    }

    /**
     * 根据条件查询维护信息
     * @param request
     * @return
     */
    @GetMapping("/maintenance")
    public Result findMaintenance(HttpServletRequest request){
        try{

        }catch (Exception e){

        }
        return null;
    }



}
