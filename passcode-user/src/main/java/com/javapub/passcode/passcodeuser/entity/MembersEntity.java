package com.javapub.passcode.passcodeuser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author javapub wangshiyu rodert
 * @email 731444260@qq.com
 * @date 2021-01-06 16:01:28
 */
@Data
@TableName("members")
public class MembersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String sex;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private String email;
	/**
	 * 头像
	 */
	private String adminhead;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 状态，1=启用；2=禁用；0=删除；
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 
	 */
	private Date lastlogintime;
	/**
	 * 
	 */
	private Date modifiedtime;
	/**
	 * 
	 */
	private Date createtime;

}
