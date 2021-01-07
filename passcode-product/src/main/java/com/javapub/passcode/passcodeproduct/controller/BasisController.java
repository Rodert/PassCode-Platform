package com.javapub.passcode.passcodeproduct.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapub.passcode.passcodeproduct.entity.BasisEntity;
import com.javapub.passcode.passcodeproduct.service.BasisService;
import com.javapub.passcode.common.utils.PageUtils;
import com.javapub.passcode.common.utils.R;



/**
 * 商品基础信息
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:25:32
 */
@RestController
@RequestMapping("passcodeproduct/basis")
public class BasisController {
    @Autowired
    private BasisService basisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = basisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		BasisEntity basis = basisService.getById(id);

        return R.ok().put("basis", basis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BasisEntity basis){
		basisService.save(basis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BasisEntity basis){
		basisService.updateById(basis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		basisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
