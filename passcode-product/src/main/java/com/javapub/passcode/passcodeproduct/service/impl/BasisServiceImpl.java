package com.javapub.passcode.passcodeproduct.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.passcodeproduct.common.utils.PageUtils;
import com.javapub.passcode.passcodeproduct.common.utils.Query;

import com.javapub.passcode.passcodeproduct.dao.BasisDao;
import com.javapub.passcode.passcodeproduct.entity.BasisEntity;
import com.javapub.passcode.passcodeproduct.service.BasisService;


@Service("basisService")
public class BasisServiceImpl extends ServiceImpl<BasisDao, BasisEntity> implements BasisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<BasisEntity> page = this.page(
//                new Query<BasisEntity>().getPage(params),
//                new QueryWrapper<BasisEntity>()
//        );
//
//        return new PageUtils(page);
        return null;
    }

}