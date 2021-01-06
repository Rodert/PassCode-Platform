package com.javapub.passcode.passcodeproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品基础信息
 * 
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:25:32
 */
@Data
@TableName("product_basis")
public class BasisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 讲师id
	 */
	private Long lecturerid;
	/**
	 * 商品标题
	 */
	private String producttitle;
	/**
	 * 封面图
	 */
	private String coverimg;
	/**
	 * 状态，1=启用；2=禁用；0=删除；
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 价格
	 */
	private Double productprice;
	/**
	 * 折扣
	 */
	private Double productdiscount;
	/**
	 * 
	 */
	private Date modifiedtime;
	/**
	 * 
	 */
	private Date createtime;
	/**
	 * 讲义
	 */
	private String producthandout;

}
