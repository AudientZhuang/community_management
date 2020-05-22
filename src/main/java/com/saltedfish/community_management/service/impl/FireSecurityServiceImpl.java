package com.saltedfish.community_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saltedfish.community_management.bean.Building;
import com.saltedfish.community_management.bean.FireSecurity;
import com.saltedfish.community_management.common.PageRequest;
import com.saltedfish.community_management.common.PageResult;
import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import com.saltedfish.community_management.mapper.BuildingMapper;
import com.saltedfish.community_management.mapper.FireSecurityMapper;
import com.saltedfish.community_management.service.FireSecurityService;
import com.saltedfish.community_management.util.PageUtil;
import com.saltedfish.community_management.util.VOUtil;
import com.saltedfish.community_management.vo.FireSecurityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sun.font.CreatedFontTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FireSecurityServiceImpl implements FireSecurityService {

    @Autowired
    private FireSecurityMapper fireSecurityMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Result addFireSecurity(FireSecurity fireSecurity) throws Exception {
        Integer effort = fireSecurityMapper.insertFireSecurity(fireSecurity);
        if (effort != 0){
            //添加消防检查情况成功
            return new Result(HttpStatus.OK.value(),"添加消防检查情况成功",null);
        }else{
            //添加消防检查情况失败
            throw new Exception("添加消防检查情况失败");
        }
    }

    @Override
    public Result updateFireSecurity(FireSecurity fireSecurity) throws Exception {
        Integer effort = fireSecurityMapper.updateFireSecurity(fireSecurity);
        if (effort != 0){
            //更新消防检查情况成功
            return new Result(HttpStatus.OK.value(),"更新消防检查情况成功",null);
        }else{
            //更新消防检查情况失败
            throw new Exception("更新消防检查情况失败");
        }
    }

    @Override
    public Result deleteFireSecurity(Integer id) throws Exception {
        Integer effort = fireSecurityMapper.deleteFireSecurity(id);
        if (effort != 0){
            //删除消防检查情况成功
            return new Result(HttpStatus.OK.value(),"删除消防检查情况成功",null);
        }else {
            //删除消防检查情况失败
            throw new Exception("删除消防检查情况失败");
        }
    }

    @Override
    public Result findFireSecurityById(Integer id) {
        FireSecurity fireSecurity = fireSecurityMapper.findFireSecurityById(id);
        if (fireSecurity != null){
            //查询指定id的消防检查情况成功
            return new Result(HttpStatus.OK.value(),"查询指定id的消防检查情况成功",fireSecurity);
        }else{
            //查询指定id的消防检查情况失败
            return new Result(HttpStatus.UNAUTHORIZED.value(),"没有找到消防检查情况",null);
        }
    }

    @Override
    public Result findFireSecurityPage(PageRequest pageRequest, Map<String, String> conditionMap) throws Exception {
        // 分页
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<FireSecurity> fireSecurityList = fireSecurityMapper.findFireSecurity(conditionMap);
        if (fireSecurityList == null){
            //根据条件查询消防检查情况失败
            throw new Exception("根据条件查询消防检查情况失败");
        }
        // 根据条件查询消防检查情况成功
        // 封装返回结果，需要楼栋名称
        List<FireSecurityVO> fireSecurityVOList = new ArrayList<>();
        for (FireSecurity fireSecurity : fireSecurityList) {
            //对消防检查情况进行完善
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(fireSecurity.getBuildId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            FireSecurityVO fireSecurityVO = VOUtil.toFireSecurityVO(fireSecurity);
            fireSecurityVO.setBuildingName(building.getBuildName());
            fireSecurityVOList.add(fireSecurityVO);
        }
        PageResult pageResult = PageUtil.getPageResult(pageRequest, new PageInfo<>(fireSecurityVOList));
        return new Result(HttpStatus.OK.value(),"根据条件查询消防检查情况成功",pageResult);
    }

    @Override
    public Result findFireSecurity(Map<String, String> conditionMap) throws Exception {
        List<FireSecurity> fireSecurityList = fireSecurityMapper.findFireSecurity(conditionMap);
        if (fireSecurityList == null){
            //根据条件查询消防检查情况失败
            throw new Exception("根据条件查询消防检查情况失败");
        }
        //根据条件查询消防检查情况成功
        // 封装返回结果，需要楼栋名称
        List<FireSecurityVO> fireSecurityVOList = new ArrayList<>();
        for (FireSecurity fireSecurity : fireSecurityList) {
            //对消防检查情况进行完善
            //根据id获取楼栋信息
            Building building = buildingMapper.findBuildingById(fireSecurity.getBuildId());
            //获取不到楼栋信息，跳过
            if (building == null){
                continue;
            }
            FireSecurityVO fireSecurityVO = VOUtil.toFireSecurityVO(fireSecurity);
            fireSecurityVO.setBuildingName(building.getBuildName());
            fireSecurityVOList.add(fireSecurityVO);
        }
        return new Result(HttpStatus.OK.value(),"根据条件查询消防检查情况成功",fireSecurityVOList);
    }
}
