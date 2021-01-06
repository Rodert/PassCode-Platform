package com.javapub.passcode.passcodeuser.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapub.passcode.passcodeuser.entity.SysAdminEntity;
import com.javapub.passcode.passcodeuser.service.SysAdminService;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.common.utils.R;



/**
 * 系统管理
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
@RestController
@RequestMapping("passcodeuser/sysadmin")
public class SysAdminController {
    @Autowired
    private SysAdminService sysAdminService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAdminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SysAdminEntity sysAdmin = sysAdminService.getById(id);

        return R.ok().put("sysAdmin", sysAdmin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysAdminEntity sysAdmin){
		sysAdminService.save(sysAdmin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysAdminEntity sysAdmin){
		sysAdminService.updateById(sysAdmin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		sysAdminService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
