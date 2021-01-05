订单库、商品库、统计库、用户库、
![数据库](https://img-blog.csdnimg.cn/20210105214324933.png)

```sql
CREATE TABLE `product_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) DEFAULT NULL COMMENT '商品id',
  `membersId` bigint(20) DEFAULT NULL COMMENT '会员id',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，0=删除；1=待支付；2=已支付；',
  `paymentPrice` double(6,2) DEFAULT NULL COMMENT '付款价格',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
```

```sql
CREATE TABLE `product_basis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lecturerId` bigint(20) NOT NULL DEFAULT '0' COMMENT '讲师id',
  `productTitle` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `coverImg` varchar(255) DEFAULT NULL COMMENT '封面图',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，1=启用；2=禁用；0=删除；',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `productPrice` double(6,2) DEFAULT NULL COMMENT '价格',
  `productDiscount` double(6,2) DEFAULT NULL COMMENT '折扣',
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  `productHandout` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '讲义',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品基础信息';
```

```sql
CREATE TABLE `product_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) DEFAULT NULL COMMENT '商品id',
  `videoCoverImg` varchar(255) DEFAULT NULL COMMENT '视频封面图',
  `tool` varchar(255) DEFAULT NULL COMMENT '工具',
  `code` varchar(255) DEFAULT NULL COMMENT '源码',
  `video` varchar(255) DEFAULT NULL COMMENT '视频',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，1=启用；2=禁用；0=删除；',
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品重要信息表';
```

```sql
CREATE TABLE `lecturer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '',
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adminHead` varchar(255) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，1=启用；2=禁用；0=删除；',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `lastLoginTime` timestamp NULL DEFAULT NULL,
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师';
```

```sql
CREATE TABLE `members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '',
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adminHead` varchar(255) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，1=启用；2=禁用；0=删除；',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `lastLoginTime` timestamp NULL DEFAULT NULL,
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```sql
CREATE TABLE `sys_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '',
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adminHead` varchar(255) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态，1=启用；2=禁用；0=删除；',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `lastLoginTime` timestamp NULL DEFAULT NULL,
  `modifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统管理';
```
