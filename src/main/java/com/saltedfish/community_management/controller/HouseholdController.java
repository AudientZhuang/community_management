package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.service.HouseholdService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.vo.HouseholdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 住户信息
 */
@RestController
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    /**
     * 添加住户信息
     * @param householdVO
     * @return
     */
    @PostMapping("/household")
    public Result addHousehold(HouseholdVO householdVO) throws Exception {
        //对前端信息进行校验

        //添加住户信息到数据库
        return householdService.addHousehold(householdVO);
    }

    /**
     * 更新住户信息
     * @param household
     * @return
     */
    @PutMapping("/household")
    public Result updateHousehold(Household household) throws Exception {
        //对前端信息进行校验

        //更新住户信息到数据库
        return householdService.updateHousehold(household);
    }

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    @DeleteMapping("/household/{id}")
    public Result deleteHousehold(@PathVariable("id") Integer id) throws Exception {
        //在数据库中删除住户信息
        return householdService.deleteHousehold(id);
    }


    /**
     * 查询指定id的住户信息
     * @param id
     * @return
     */
    @GetMapping("/household/{id}")
    public Result findHousehold(@PathVariable("id") Integer id){
        //在数据库中查询指定id的住户信息
        return householdService.findHouseholdById(id);
    }

    /**
     * 根据条件查询住户信息
     * @return
     */
    @GetMapping("/household")
    public Result findHousehold(HttpServletRequest request) throws Exception {
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
            result = householdService.findHouseholdPage(pageRequest,conditionMap);
        }else{
            // 不需要分页
            result = householdService.findHousehold(conditionMap);
        }
        // 返回结果
        return result;
    }
}
