package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Facility;
import com.saltedfish.community_management.bean.Maintenance;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.FacilityMapper;
import com.saltedfish.community_management.mapper.MaintenanceMapper;
import com.saltedfish.community_management.service.MaintenanceService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.MaintenanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MaintenanceSerivceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceMapper maintenanceMapper;

    @Autowired
    private FacilityMapper facilityMapper;

    @Override
    public Result addMaintenance(Maintenance maintenance) throws Exception {
        Integer effort = maintenanceMapper.insertMaintenance(maintenance);
        if (effort != 0){
            //添加设施维护信息成功
            return new Result(HttpStatus.OK.value(),"添加设施维护信息成功",null);
        }else{
            //添加设施维护信息失败
            throw new Exception("添加设施维护信息失败");
        }
    }

    @Override
    public Result updateMaintenance(Maintenance maintenance) throws Exception {
        Integer effort = maintenanceMapper.updateMaintenance(maintenance);
        if (effort != 0){
            //更新设施维护信息成功
            return new Result(HttpStatus.OK.value(),"更新设施维护信息成功",null);
        }else{
            //更新设施维护信息失败
            throw new Exception("更新设施维护信息失败");
        }
    }

    @Override
    public Result deleteMaintenance(Integer id) throws Exception {
        Integer effort = maintenanceMapper.deleteMaintenance(id);
        if (effort != 0){
            //删除设施维护信息成功
            return new Result(HttpStatus.OK.value(),"删除设施维护信息成功",null);
        }else{
            //删除设施维护信息失败
            throw new Exception("删除设施维护信息失败");
        }
    }

    @Override
    public Result findMaintenanceById(Integer id) {
        Maintenance maintenance = maintenanceMapper.findMaintenanceById(id);
        if (maintenance == null){
            //查询指定id的设施维护信息失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到设施维护信息",null);
        }
        //查询指定id的设施维护信息成功
        //对维修信息进行完善
        //根据id获取设施信息
        Facility facility = facilityMapper.findFacilityById(maintenance.getFacilityId());
        //获取不到设施信息，跳过
        if (facility == null){
            return new Result(HttpStatus.UNAUTHORIZED.value(),"设施信息不存在",null);
        }
        MaintenanceVO maintenanceVO = VOUtil.toMaintenanceVO(maintenance);
        maintenanceVO.setFacilityName(facility.getName());
        return new Result(HttpStatus.OK.value(),"查询指定id的设施维护信息成功",maintenanceVO);
    }

    @Override
    public Result findMaintenancePage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Maintenance> maintenanceList = maintenanceMapper.findMaintenance(conditionMap);
        if (maintenanceList == null){
            // 根据条件查询设施维护信息失败
            throw new Exception("根据条件查询设施维护信息失败");
        }
        // 根据条件查询设施维护信息成功
        //封装返回结果，需要设施名称
        List<MaintenanceVO> maintenanceVOList = new ArrayList<>();
        for (Maintenance maintenance : maintenanceList) {
            //对维修信息进行完善
            //根据id获取设施信息
            Facility facility = facilityMapper.findFacilityById(maintenance.getFacilityId());
            //获取不到设施信息，跳过
            if (facility == null){
                continue;
            }
            MaintenanceVO maintenanceVO = VOUtil.toMaintenanceVO(maintenance);
            maintenanceVO.setFacilityName(facility.getName());
            maintenanceVOList.add(maintenanceVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(maintenanceVOList));
        return new Result(HttpStatus.OK.value(),"根据条件查询设施维护信息成功",pageResult);
    }

    @Override
    public Result findMaintenance(Map<String, String> conditionMap) throws Exception {
        List<Maintenance> maintenanceList = maintenanceMapper.findMaintenance(conditionMap);
        if (maintenanceList == null){
            //根据条件查询设施维护信息失败
            throw new Exception("根据条件查询设施维护信息失败");
        }
        //根据条件查询设施维护信息成功
        List<MaintenanceVO> maintenanceVOList = new ArrayList<>();
        for (Maintenance maintenance : maintenanceList) {
            //对维修信息进行完善
            //根据id获取设施信息
            Facility facility = facilityMapper.findFacilityById(maintenance.getFacilityId());
            //获取不到设施信息，跳过
            if (facility == null){
                continue;
            }
            MaintenanceVO maintenanceVO = VOUtil.toMaintenanceVO(maintenance);
            maintenanceVO.setFacilityName(facility.getName());
            maintenanceVOList.add(maintenanceVO);
        }
        return new Result(HttpStatus.OK.value(),"根据条件查询设施维护信息成功",maintenanceVOList);
    }
}
