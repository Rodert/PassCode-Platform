package com.javapub.passcode.passcodeorder.service;

import com.javapub.passcode.passcodeorder.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: wangshiyu javapub rodert
 * @Date: 2021/1/6 22:19
 */
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    void saveOne() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setProductid(1L);
        boolean save = orderService.save(orderEntity);
        System.out.println(save);
    }

    @Test
    void update() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setProductid(2L);
        boolean b = orderService.updateById(orderEntity);
        System.out.println("更新：" + b);
    }
}