package com.javapub.passcode.passcodeproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品重要信息表
 * 
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 15:25:32
 */
@Data
@TableName("product_detail")
public class DetailEntity implements Serializable {
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
	 * 视频封面图
	 */
	private String videocoverimg;
	/**
	 * 工具
	 */
	private String tool;
	/**
	 * 源码
	 */
	private String code;
	/**
	 * 视频
	 */
	private String video;
	/**
	 * 状态，1=启用；2=禁用；0=删除；
	 */
	private Integer status;
	/**
	 * 排序
	 */
	private Integer sort;
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
