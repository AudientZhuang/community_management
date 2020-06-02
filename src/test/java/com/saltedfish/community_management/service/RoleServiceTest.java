package com.saltedfish.community_management.service;

import com.saltedfish.community_management.bean.Role;
import com.saltedfish.community_management.common.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Audient
 * @date 2020/6/2
 */
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRolesByUserId(){

        try {
            Result result = roleService.getRolesByUserId(1);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUserRoles() throws Exception {
        List<Integer> roleIdList = new ArrayList<>();

        roleService.updateUserRoles(1,roleIdList);


    }


}
