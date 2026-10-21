package com.wander;

import com.wander.service.SysPermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysPermissionTest {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Test
    public void listPermissionsByUserId() {
        List<String> strings = sysPermissionService.listPermissionByUserId(1L);
        System.out.println(strings);
    }
}
