# PassCode-Platform
PassCode-Platform项目是PassCode的服务平台。PassCode是一款商城类的开源系统。PassCode 项目教会你如何搭建SpringBoot 项目，SpringCloud 项目。采用流行的技术，如 SpringBoot、MyBatis、Redis、MySql、Elasticsearch、采用Docker 容器化部署。带你掌握整个系统架构部署，适合初学者。

[toc]

# 前言

【猿来是你】

# 数据库

## 用户库

1. 会员
2. 管理员
3. 讲师lecturer


## 商品库

1. 商品基础信息表
2. 商品重要信息表（源码）

## 订单库
order
1. 商品会员关系表
2. 

# 支付模块

1. 

## 统计库

1. 点击表
2. 浏览表
3. 

# PassCode架构篇

## 创建项目和添加模块

| 序号 | 服务描述     | 服务名 |
|:----:|-------------:| -----: |
| 1 | 商品微服务  | passcode-product |
| 2 | 订单微服务  | passcode-order |  
| 3 | 用户微服务  | passcode-user |


## 数据库及数据库表
### 数据库设计记录

支付中心是重点

### 数据库SQL语句

SQL文件目录：[sql](SQL.md)

### 搭建管理后台

使用renren 开源后台框架

### 自动生成前后端代码



# 参考

完整搭建（使用了renren开源代码）：https://www.cnblogs.com/jackson0714/p/12717818.html

推荐参考：https://github.com/mtcarpenter/mall-cloud-alibaba 
