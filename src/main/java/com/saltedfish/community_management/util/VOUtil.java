package com.saltedfish.community_management.util;

/**
 * @author Audient
 * @date 2020/5/21
 */

import com.saltedfish.community_management.bean.*;
import com.saltedfish.community_management.vo.*;

/**
 * VO工具类
 * 将原始的bean封装为前端需要的数据对象
 */
public class VOUtil {

    /**
     * 将Household对象转换为HouseholdVO对象
     * @param household
     * @return
     */
    public static HouseholdVO toHouseholdVO(Household household){
        HouseholdVO householdVO = new HouseholdVO();
        householdVO.setId(household.getId());
        householdVO.setName(household.getName());
        householdVO.setGender(household.getGender());
        householdVO.setAge(household.getAge());
        householdVO.setTelephone(household.getTelephone());
        householdVO.setIDcard(household.getIDcard());
        householdVO.setArrivalDate(household.getArrivalDate());
        householdVO.setIsOwner(household.getIsOwner());
        householdVO.setBuildingId(household.getBuildingId());
        householdVO.setRoomId(household.getRoomId());
        return householdVO;
    }

    /**
     * 将ActivityRegister对象转换为ActivityRegisterVO对象
     * @param activityRegister
     * @return
     */
    public static ActivityRegisterVO toActivityRegisterVO(ActivityRegister activityRegister){
        ActivityRegisterVO activityRegisterVO = new ActivityRegisterVO();
        activityRegisterVO.setId(activityRegister.getId());
        activityRegisterVO.setAct_id(activityRegister.getAct_id());
        activityRegisterVO.setHh_id(activityRegister.getHh_id());
        activityRegisterVO.setTelephone(activityRegister.getTelephone());
        activityRegisterVO.setNum(activityRegister.getNum());
        return activityRegisterVO;
    }

    /**
     * 将Maintenance对象转换为MaintenanceVO
     * @param maintenance
     * @return
     */
    public static MaintenanceVO toMaintenanceVO(Maintenance maintenance){
        MaintenanceVO maintenanceVO = new MaintenanceVO();
        maintenanceVO.setId(maintenance.getId());
        maintenanceVO.setFacilityId(maintenance.getFacilityId());
        maintenanceVO.setContent(maintenance.getContent());
        maintenanceVO.setStatus(maintenance.getStatus());
        maintenanceVO.setCost(maintenance.getCost());
        maintenanceVO.setCreateDate(maintenance.getCreateDate());
        maintenanceVO.setDate(maintenance.getDate());
        maintenanceVO.setNote(maintenance.getNote());
        return maintenanceVO;
    }

    /**
     * 将Payment对象转换为PaymentVO对象
     * @param payment
     * @return
     */
    public static PaymentVO toPaymentVO(Payment payment){
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setId(payment.getId());
        paymentVO.setHouseholdId(payment.getHouseholdId());
        paymentVO.setCharId(payment.getCharId());
        paymentVO.setCharStandard(payment.getCharStandard());
        paymentVO.setPayReal(payment.getPayReal());
        paymentVO.setPayStatus(payment.getPayStatus());
        paymentVO.setPayDate(payment.getPayDate());
        return paymentVO;
    }

    /**
     * 将Repair对象转换为RepairVO对象
     * @param repair
     * @return
     */
    public static RepairVO toRepairVO(Repair repair){
        RepairVO repairVO = new RepairVO();
        repairVO.setId(repair.getId());
        repairVO.setHouseholdId(repair.getHouseholdId());
        repairVO.setName(repair.getName());
        repairVO.setTelephone(repair.getTelephone());
        repairVO.setContent(repair.getContent());
        repairVO.setDate(repair.getDate());
        repairVO.setStatus(repair.getStatus());
        repairVO.setReply(repair.getReply());
        return repairVO;
    }

    /**
     * 将Room对象转换为RoomVO对象
     * @param room
     * @return
     */
    public static RoomVO toRoomVO(Room room){
        RoomVO roomVO = new RoomVO();
        roomVO.setId(room.getId());
        roomVO.setBuildingId(room.getBuildingId());
        roomVO.setRoomNum(room.getRoomNum());
        return roomVO;
    }

    /**
     * 将Facility对象转换为FacilityVO对象
     * @param facility
     * @return
     */
    public static FacilityVO toFacilityVO(Facility facility){
        FacilityVO facilityVO = new FacilityVO();
        facilityVO.setId(facility.getId());
        facilityVO.setName(facility.getName());
        facilityVO.setCateId(facility.getCateId());
        facilityVO.setNum(facility.getNum());
        facilityVO.setPrice(facility.getPrice());
        facilityVO.setPurchaseDate(facility.getPurchaseDate());
        return facilityVO;
    }

    /**
     * 将FireSecurity对象转换为FireSecurityVO对象
     * @param fireSecurity
     * @return
     */
    public static FireSecurityVO toFireSecurityVO(FireSecurity fireSecurity){
        FireSecurityVO fireSecurityVO = new FireSecurityVO();
        fireSecurityVO.setId(fireSecurity.getId());
        fireSecurityVO.setBuildId(fireSecurity.getBuildId());
        fireSecurityVO.setCreateDate(fireSecurity.getCreateDate());
        fireSecurityVO.setCheckContent(fireSecurity.getCheckContent());
        fireSecurityVO.setLevel(fireSecurity.getLevel());
        fireSecurityVO.setCheckDate(fireSecurity.getCheckDate());
        fireSecurityVO.setUpdateDate(fireSecurity.getUpdateDate());
        return fireSecurityVO;
    }

    /**
     * 将Activity对象转换为ActivityVO对象
     * @param activity
     * @return
     */
    public static ActivityVO toActivityVO(Activity activity){
        ActivityVO activityVO = new ActivityVO();
        activityVO.setId(activity.getId());
        activityVO.setImage(activity.getImage());
        activityVO.setTitle(activity.getTitle());
        activityVO.setContent(activity.getContent());
        activityVO.setAddress(activity.getAddress());
        activityVO.setStartDate(activity.getStartDate());
        activityVO.setEndDate(activity.getEndDate());
        activityVO.setDeadline(activity.getDeadline());
        activityVO.setPublisher(activity.getPublisher());
        activityVO.setPublishDate(activity.getPublishDate());
        activityVO.setCancel(activity.getCancel());
        return activityVO;
    }

}
