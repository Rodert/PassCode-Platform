package com.javapub.passcode.passcodeproduct.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javapub.passcode.passcodeproduct.common.utils.PageUtils;
import com.javapub.passcode.passcodeproduct.common.utils.Query;

import com.javapub.passcode.passcodeproduct.dao.DetailDao;
import com.javapub.passcode.passcodeproduct.entity.DetailEntity;
import com.javapub.passcode.passcodeproduct.service.DetailService;


@Service("detailService")
public class DetailServiceImpl extends ServiceImpl<DetailDao, DetailEntity> implements DetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<DetailEntity> page = this.page(
//                new Query<DetailEntity>().getPage(params),
//                new QueryWrapper<DetailEntity>()
//        );
//
//        return new PageUtils(page);
        return null;
    }

}