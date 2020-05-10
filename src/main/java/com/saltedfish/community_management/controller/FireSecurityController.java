package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.bean.FireSecurity;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.service.FireSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


/**
 * 消防检查情况
 */
@RestController
public class FireSecurityController {

    @Autowired
    private FireSecurityService fireSecurityService;

    /**
     * 添加消防检查情况
     * @param fireSecurity
     * @return
     */
    @PostMapping("/fireSecurity")
    public Result addFireSecurity(FireSecurity fireSecurity){
        try {
            //对前端信息进行校验

            //添加消防检查情况到数据库
            Result result = fireSecurityService.addFireSecurity(fireSecurity);
            if (result.getStatus() != ResultCode.INSERT_FIRE_SECURITY_EXCEPTION.getStatus()){
                //添加消防检查情况没有异常
                return result;
            }else{
                //添加消防检查情况出现异常
                throw new Exception(ResultCode.INSERT_FIRE_SECURITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 更新消防检查情况
     * @param fireSecurity
     * @return
     */
    @PutMapping("/fireSecurity")
    public Result updateFireSecurity(FireSecurity fireSecurity){
        try {
            //对前端信息进行校验

            //更新消防检查情况到数据库
            Result result = fireSecurityService.updateFireSecurity(fireSecurity);
            if (result.getStatus() != ResultCode.UPDATE_FIRE_SECURITY_EXCEPTION.getStatus()){
                //更新消防检查情况没有异常
                return result;
            }else{
                //更新消防检查情况出现异常
                throw new Exception(ResultCode.UPDATE_FIRE_SECURITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 删除消防检查情况
     * @param id
     * @return
     */
    @DeleteMapping("/fireSecurity/{id}")
    public Result deleteFireSecurity(@PathVariable("id") Integer id){
        try {
            Result result = fireSecurityService.deleteFireSecurity(id);
            if (result.getStatus() != ResultCode.DELETE_FIRE_SECURITY_EXCEPTION.getStatus()){
                //删除消防检查情况没有异常
                return result;
            }else{
                //删除消防检查情况出现异常
                throw new Exception(ResultCode.DELETE_FIRE_SECURITY_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 查询指定id的消防检查情况
     * @param id
     * @return
     */
    @GetMapping("/fireSecurity/{id}")
    public Result findFireSecurityById(@PathVariable("id") Integer id){
        try {
            Result result = fireSecurityService.findFireSecurityById(id);
            if (result.getStatus() != ResultCode.FIND_FIRE_SECURITY_BY_ID_EXCEPTION.getStatus()){
                //查询指定id的消防检查情况没有异常
                return result;
            }else{
                throw new Exception(ResultCode.FIND_FIRE_SECURITY_BY_ID_EXCEPTION.getMessage());
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }

    /**
     * 根据条件查询消防检查情况
     * @param request
     * @return
     */
    @GetMapping("/fireSecurity")
    public Result findFireSecurity(HttpServletRequest request){
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,String> conditionMap = new HashMap<>();
            if (parameterMap.size() >= 0){
                //参数为空时也可以正常运行
                for (String key: parameterMap.keySet()) {
                    conditionMap.put(key,parameterMap.get(key)[0]);
                }
                Result result = fireSecurityService.findFireSecurity(conditionMap);
                if (result.getStatus() != ResultCode.FIND_FIRE_SECURITY_EXCEPTION.getStatus()){
                    //根据条件查询消防检查情况没有异常
                    return result;
                }else{
                    //根据条件查询消防检查情况出现异常
                    throw new Exception(ResultCode.FIND_FIRE_SECURITY_EXCEPTION.getMessage());
                }
            }else{
                //获取不到参数
                throw new Exception();
            }
        }catch (Exception e){
            //捕获异常
            return new Result(ResultCode.SYSTEM_BUSY.getStatus(),ResultCode.SYSTEM_BUSY.getMessage(),null);
        }
    }


}
