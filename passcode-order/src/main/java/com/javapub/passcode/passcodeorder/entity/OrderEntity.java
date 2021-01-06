package com.javapub.passcode.passcodeorder.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * 
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:46:33
 */
@Data
@TableName("product_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 商品id
	 */
	private Long productid;
	/**
	 * 会员id
	 */
	private Long membersid;
	/**
	 * 状态，0=删除；1=待支付；2=已支付；
	 */
	private Integer status;
	/**
	 * 付款价格
	 */
	private Double paymentprice;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 
	 */
	private Date modifiedtime;
	/**
	 * 
	 */
	private Date createtime;

}
