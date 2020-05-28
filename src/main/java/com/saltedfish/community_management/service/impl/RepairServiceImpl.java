package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Household;
import com.saltedfish.community_management.bean.Repair;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.HouseholdMapper;
import com.saltedfish.community_management.mapper.RepairMapper;
import com.saltedfish.community_management.service.RepairService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.RepairVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private HouseholdMapper householdMapper;

    @Override
    public Result addRepair(Repair repair) throws Exception {
        // 检查住户信息是否存在
        Household household = householdMapper.findHouseholdById(repair.getHouseholdId());
        // 住户信息不存在
        if (household == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"住户信息不存在",null);
        }

        // 添加住户申报维修信息
        Integer effort = repairMapper.insertRepair(repair);
        if (effort != 0){
            //添加住户申报维修信息成功
            return new Result(HttpStatus.OK.value(),"添加住户申报维修信息成功",null);
        }else{
            //添加住户申报维修信息失败
            throw new Exception("添加住户申报维修信息失败");
        }
    }

    @Override
    public Result updateRepair(Repair repair) throws Exception {
        Integer effort = repairMapper.updateRepair(repair);
        if(effort != 0){
            //更新住户申报维修信息成功
            return new Result(HttpStatus.OK.value(),"更新住户申报维修信息成功",null);
        }else{
            //更新住户申报维修信息失败
            throw new Exception("更新住户申报维修信息失败");
        }
    }

    @Override
    public Result deleteRepair(Integer id) throws Exception {
        Integer effort = repairMapper.deleteRepair(id);
        if (effort != 0){
            //删除住户申报维修信息成功
            return new Result(HttpStatus.OK.value(),"删除住户申报维修信息成功",null);
        }else{
            //删除住户申报维修信息失败
            throw new Exception("删除住户申报维修信息失败");
        }
    }

    @Override
    public Result findRepairById(Integer id) throws Exception {
        Repair repair = repairMapper.findRepairById(id);
        if (repair == null){
            //查询指定id的住户申报维修信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到住户申报维修信息",null);
        }
        //查询指定id的住户申报维修信息成功
        //对住户申报维修信息进行完善
        //根据id获取住户信息
        Household household = householdMapper.findHouseholdById(repair.getHouseholdId());
        //获取不到住户信息，跳过
        if (household == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"住户信息不存在",null);
        }
        RepairVO repairVO = VOUtil.toRepairVO(repair);
        repairVO.setHouseholdName(household.getName());
        return new Result(HttpStatus.OK.value(),"查询指定id的住户申报维修信息成功",repairVO);
    }

    @Override
    public Result findRepairPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Repair> repairList = repairMapper.findRepair(conditionMap);
        if (repairList == null){
            // 根据条件查询住户申报维修信息失败
            throw new Exception("根据条件查询住户申报维修信息失败");
        }
        // 根据条件查询住户申报维修信息成功
        //封装返回结果，需要住户名称
        List<RepairVO> repairVOList = new ArrayList<>();
        for (Repair repair : repairList) {
            //对住户申报维修信息进行完善
            //根据id获取住户信息
            Household household = householdMapper.findHouseholdById(repair.getHouseholdId());
            //获取不到住户信息，跳过
            if (household == null) {
                continue;
            }
            RepairVO repairVO = VOUtil.toRepairVO(repair);
            repairVO.setHouseholdName(household.getName());
            repairVOList.add(repairVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(repairList));
        pageResult.setItems(repairVOList);
        return new Result(HttpStatus.OK.value(),"根据条件查询住户申报维修信息成功",pageResult);
    }

    @Override
    public Result findRepair(Map<String, String> conditionMap) throws Exception {
        List<Repair> repairList = repairMapper.findRepair(conditionMap);
        if (repairList == null){
            // 根据条件查询住户申报维修信息失败
            throw new Exception("根据条件查询住户申报维修信息失败");
        }
        // 根据条件查询住户申报维修信息成功
        //封装返回结果，需要住户名称
        List<RepairVO> repairVOList = new ArrayList<>();
        for (Repair repair : repairList) {
            //对住户申报维修信息进行完善
            //根据id获取住户信息
            Household household = householdMapper.findHouseholdById(repair.getHouseholdId());
            //获取不到住户信息，跳过
            if (household == null) {
                continue;
            }
            RepairVO repairVO = VOUtil.toRepairVO(repair);
            repairVO.setHouseholdName(household.getName());
            repairVOList.add(repairVO);

        }
        return new Result(HttpStatus.OK.value(),"根据条件查询住户申报维修信息成功",repairVOList);
    }
}
