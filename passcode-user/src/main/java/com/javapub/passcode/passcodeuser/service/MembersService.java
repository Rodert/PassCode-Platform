package com.javapub.passcode.passcodeuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.entity.MembersEntity;

import java.util.Map;

/**
 * 
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
public interface MembersService extends IService<MembersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

