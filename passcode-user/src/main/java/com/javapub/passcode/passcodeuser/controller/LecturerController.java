package com.javapub.passcode.passcodeuser.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javapub.passcode.passcodeuser.entity.LecturerEntity;
import com.javapub.passcode.passcodeuser.service.LecturerService;
import com.javapub.passcode.passcodeuser.common.utils.PageUtils;
import com.javapub.passcode.passcodeuser.common.utils.R;



/**
 * 讲师
 *
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
@RestController
@RequestMapping("passcodeuser/lecturer")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lecturerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		LecturerEntity lecturer = lecturerService.getById(id);

        return R.ok().put("lecturer", lecturer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LecturerEntity lecturer){
		lecturerService.save(lecturer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LecturerEntity lecturer){
		lecturerService.updateById(lecturer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		lecturerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
