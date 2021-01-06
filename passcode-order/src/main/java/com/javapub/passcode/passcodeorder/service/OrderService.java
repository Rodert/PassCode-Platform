package com.javapub.passcode.passcodeorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javapub.passcode.passcodeorder.common.utils.PageUtils;
import com.javapub.passcode.passcodeorder.entity.OrderEntity;

import java.util.Map;

/**
 * 订单表
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:46:33
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

