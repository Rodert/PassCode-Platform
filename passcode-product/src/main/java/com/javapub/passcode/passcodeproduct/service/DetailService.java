package com.javapub.passcode.passcodeproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javapub.passcode.passcodeproduct.common.utils.PageUtils;
import com.javapub.passcode.passcodeproduct.entity.DetailEntity;

import java.util.Map;

/**
 * 商品重要信息表
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:25:32
 */
public interface DetailService extends IService<DetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

