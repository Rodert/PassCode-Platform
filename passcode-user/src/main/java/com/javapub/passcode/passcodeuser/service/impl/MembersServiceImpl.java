package com.javapub.passcode.passcodeuser.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.common.utils.Query;

import com.javapub.passcode.passcodeuser.dao.MembersDao;
import com.javapub.passcode.passcodeuser.entity.MembersEntity;
import com.javapub.passcode.passcodeuser.service.MembersService;


@Service("membersService")
public class MembersServiceImpl extends ServiceImpl<MembersDao, MembersEntity> implements MembersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
//        IPage<MembersEntity> page = this.page(
//                new Query<MembersEntity>().getPage(params),
//                new QueryWrapper<MembersEntity>()
//        );
//
//        return new PageUtils(page);
    }

}