package com.javapub.passcode.passcodeuser.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.common.utils.PageUtils;

import com.javapub.passcode.passcodeuser.dao.SysAdminDao;
import com.javapub.passcode.passcodeuser.entity.SysAdminEntity;
import com.javapub.passcode.passcodeuser.service.SysAdminService;


@Service("sysAdminService")
public class SysAdminServiceImpl extends ServiceImpl<SysAdminDao, SysAdminEntity> implements SysAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
//        IPage<SysAdminEntity> page = this.page(
//                new Query<SysAdminEntity>().getPage(params),
//                new QueryWrapper<SysAdminEntity>()
//        );
//
//        return new PageUtils(page);
    }

}