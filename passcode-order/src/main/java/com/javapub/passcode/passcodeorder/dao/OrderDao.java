package com.javapub.passcode.passcodeorder.dao;

import com.javapub.passcode.passcodeorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:46:33
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
