package com.javapub.passcode.passcodeuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.entity.LecturerEntity;

import java.util.Map;

/**
 * 讲师
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
public interface LecturerService extends IService<LecturerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

