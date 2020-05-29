package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.Activity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.ActivityService;
import com.saltedfish.community_management.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 活动信息
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 添加活动信息
     * @param activity
     * @return
     */
    @PostMapping("/activity")
    public Result addActivity(Activity activity) throws Exception {
        //对前端信息进行校验

        //添加活动信息到数据库
        return activityService.addActivity(activity);
    }

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    @PutMapping("/activity")
    public Result updateActivity(Activity activity) throws Exception {
        //对前端信息进行校验

        //更新活动信息到数据库
        return activityService.updateActivity(activity);
    }

    /**
     * 取消活动
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/activity/cancel")
    public Result cancelActivity(Integer id) throws Exception {
        return activityService.cancelActivity(id);
    }

    /**
     * 删除活动信息
     * @param id
     * @return
     */
    @DeleteMapping("/activity/{id}")
    public Result deleteActivity(@PathVariable("id") Integer id) throws Exception {
        //在数据库中删除活动信息
        Result result = activityService.deleteActivity(id);
        return result;
    }

    /**
     * 查询指定id的活动信息
     * @param id
     * @return
     */
    @GetMapping("/activity/{id}")
    public Result findActivityById(@PathVariable("id") Integer id) throws Exception {
        return activityService.findActivityById(id);
    }

    /**
     * 根据条件查询活动信息
     * @return
     */
    @GetMapping("/activity")
    public Result findActivity(HttpServletRequest request) throws Exception {

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
            result = activityService.findActivityPage(pageRequest,conditionMap);
        }else{
            // 不需要分页
            result = activityService.findActivity(conditionMap);
        }
        // 返回结果
        return result;
    }


    /**
     * 获取指定id的用户的正在进行的活动
     * @param hh_id
     * @return
     */
    @GetMapping("/household/activity/underway")
    public Result findMyUnderwayActivity(Integer hh_id){
        return activityService.findMyUnderwayActivity(hh_id, new Date(System.currentTimeMillis()));
    }


    /**
     * 获取指定id的用户的正在进行的活动
     * @param hh_id
     * @return
     */
    @GetMapping("/household/activity/overdue")
    public Result findMyOverdueActivity(Integer hh_id){
        return activityService.findMyOverdueActivity(hh_id, new Date(System.currentTimeMillis()));
    }

    @GetMapping("/household/activity/{id}")
    public Result findActivityByIdAndHouseholdId(@PathVariable("id") Integer id,
                                                 @RequestParam("hh_id") Integer hh_id) throws Exception {
        return activityService.findActivityByIdAndHouseholdId(id, hh_id);
    }
}
