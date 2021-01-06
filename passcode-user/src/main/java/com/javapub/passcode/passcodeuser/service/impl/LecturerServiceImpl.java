package com.javapub.passcode.passcodeuser.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.common.utils.Query;

import com.javapub.passcode.passcodeuser.dao.LecturerDao;
import com.javapub.passcode.passcodeuser.entity.LecturerEntity;
import com.javapub.passcode.passcodeuser.service.LecturerService;


@Service("lecturerService")
public class LecturerServiceImpl extends ServiceImpl<LecturerDao, LecturerEntity> implements LecturerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
//        IPage<LecturerEntity> page = this.page(
//                new Query<LecturerEntity>().getPage(params),
//                new QueryWrapper<LecturerEntity>()
//        );
//
//        return new PageUtils(page);
    }

}