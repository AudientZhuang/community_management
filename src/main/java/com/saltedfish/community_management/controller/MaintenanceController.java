package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.MaintenanceService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 设施维护信息
 */
@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 添加设施维护信息
     * @param maintenance
     * @return
     */
    @PostMapping("/maintenance")
    public Result addMaintenance(Maintenance maintenance) throws Exception {
        //对前端信息进行校验

        //添加设施维护信息到数据库
        return maintenanceService.addMaintenance(maintenance);
    }

    /**
     * 修改设施维护信息
     * @param maintenance
     * @return
     */
    @PutMapping("/maintenance")
    public Result updateMaintenance(Maintenance maintenance) throws Exception {
        //对前端信息进行校验

        //更新设施维护信息到数据库
        return maintenanceService.updateMaintenance(maintenance);

    }

    /**
     * 删除设施维护信息
     * @param id
     * @return
     */
    @DeleteMapping("/maintenance/{id}")
    public Result deleteMaintenance(@PathVariable("id") Integer id) throws Exception {
        //在数据库中删除设施维护信息
        return maintenanceService.deleteMaintenance(id);
    }

    /**
     * 查询指定id的设施维护信息
     * @param id
     * @return
     */
    @GetMapping("/maintenance/{id}")
    @ResponseBody
    public Result findMaintenanceById(@PathVariable("id") Integer id){
        return maintenanceService.findMaintenanceById(id);
    }

    /**
     * 根据条件查询设施维护信息
     * @param request
     * @return
     */
    @GetMapping("/maintenance")
    public Result findMaintenance(HttpServletRequest request) throws Exception {
        // 分页请求封装类
        PageRequest pageRequest = new PageRequest();
        // 设置一个分页变量，判断是否需要分页，默认为不需要分页
        Boolean isPage = false;
        Result result = new Result();
        // 获取前端请求的条件参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 条件参数Map
        Map<String,String> conditionMap = new HashMap<>();
        if (parameterMap == null) {
            // 无法获取参数，连接出现异常
            throw new Exception();
        }
        //参数为空也可以正常运行
        for (String key: parameterMap.keySet()) {
            //请求参数中含有分页参数pageNum或pageSize
            if ("pageNum".equals(key) || "pageSize".equals(key)){
                // 将分页变量设置为true
                isPage = true;
                // 将分页参数设置给pageRequest
                pageRequest = PageUtil.addPageRequestParam(key,parameterMap.get(key)[0],pageRequest);
                // 跳过，不将分页请求参数添加到条件参数Map中
                continue;
            }
            //条件请求参数，添加到条件Map中
            conditionMap.put(key,parameterMap.get(key)[0]);
        }
        // 根据是否需要分页调用不同的服务方法
        if (isPage == true){
            // 需要分页
            result = maintenanceService.findMaintenancePage(pageRequest,conditionMap);
        }else{
            // 不需要分页
            result = maintenanceService.findMaintenance(conditionMap);
        }
        // 返回结果
        return result;
    }



}
