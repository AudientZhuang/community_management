package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.BuildingService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    /**
     * 添加楼栋信息
     * @param building
     * @return
     */
    @PostMapping("/building")
    public Result addBuilding(Building building) throws Exception {
        //对前端信息进行校验

        //添加楼栋信息到数据库
        return buildingService.addBuilding(building);
    }

    /**
     * 更新楼栋信息
     * @param building
     * @return
     */
    @PutMapping("/building")
    public Result updateBuilding(Building building) throws Exception {
        //对前端信息进行校验

        //更新楼栋信息到数据库
        return buildingService.updateBuilding(building);
    }

    /**
     * 删除楼栋信息
     * @param id
     * @return
     */
    @DeleteMapping("/building/{id}")
    public Result deleteBuilding(@PathVariable("id") Integer id) throws Exception {
        return buildingService.deleteBuilding(id);
    }

    /**
     * 查询指定id的楼栋信息
     * @param id
     * @return
     */
    @GetMapping("/building/{id}")
    public Result findBuildingById(@PathVariable("id") Integer id) throws Exception {
        return buildingService.findBuildingById(id);
    }

    /**
     * 根据条件查询楼栋信息
     * @param request
     * @return
     */
    @GetMapping("/building")
    public Result findBuilding(HttpServletRequest request) throws Exception {
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
            result = buildingService.findBuildingPage(pageRequest,conditionMap);
        }else{
            // 不需要分页
            result = buildingService.findBuilding(conditionMap);
        }
        // 返回结果
        return result;
    }



}
