package com.javapub.passcode.passcodeorder.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.passcodeorder.common.utils.PageUtils;
import com.javapub.passcode.passcodeorder.common.utils.Query;

import com.javapub.passcode.passcodeorder.dao.OrderDao;
import com.javapub.passcode.passcodeorder.entity.OrderEntity;
import com.javapub.passcode.passcodeorder.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<OrderEntity> page = this.page(
//                new Query<OrderEntity>().getPage(params),
//                new QueryWrapper<OrderEntity>()
//        );
//
//        return new PageUtils(page);
        return null;
    }

}