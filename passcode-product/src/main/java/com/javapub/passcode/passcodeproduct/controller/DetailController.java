package com.javapub.passcode.passcodeproduct.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapub.passcode.passcodeproduct.entity.DetailEntity;
import com.javapub.passcode.passcodeproduct.service.DetailService;
import com.javapub.passcode.passcodeproduct.common.utils.PageUtils;
import com.javapub.passcode.passcodeproduct.common.utils.R;



/**
 * 商品重要信息表
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:25:32
 */
@RestController
@RequestMapping("passcodeproduct/detail")
public class DetailController {
    @Autowired
    private DetailService detailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = detailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DetailEntity detail = detailService.getById(id);

        return R.ok().put("detail", detail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DetailEntity detail){
		detailService.save(detail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DetailEntity detail){
		detailService.updateById(detail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		detailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
