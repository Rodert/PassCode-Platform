package com.javapub.passcode.passcodeuser.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapub.passcode.passcodeuser.entity.MembersEntity;
import com.javapub.passcode.passcodeuser.service.MembersService;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.common.utils.R;



/**
 * 
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
@RestController
@RequestMapping("passcodeuser/members")
public class MembersController {
    @Autowired
    private MembersService membersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = membersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MembersEntity members = membersService.getById(id);

        return R.ok().put("members", members);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MembersEntity members){
		membersService.save(members);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MembersEntity members){
		membersService.updateById(members);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		membersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
