package com.javapub.passcode.passcodeuser.feign;

import com.javapub.passcode.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wangshiyu javapub rodert
 * @Date: 2021/2/19 14:47
 */
@FeignClient("passcode-order")
public interface UserFeignService {

//    public R list();

    @RequestMapping("passcodeorder/order/list/test/{id}")
    public R getOrderListTest(@PathVariable("id") Long id);

}
