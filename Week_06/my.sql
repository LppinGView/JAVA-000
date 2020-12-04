-- ----------------------------
-- 用户表
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uuid` bigint(20) NOT NULL COMMENT 'uuid后续用于分表',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `nickname` varchar(100) NOT NULL COMMENT '昵称',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- 订单表
-- Table structure for t_trade
-- ----------------------------
CREATE TABLE `t_trade_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交易序号',
  `trade_no` bigint(20) NOT NULL COMMENT '交易单号',
  `user_uuid` bigint(20) NOT NULL COMMENT '用户uuid',
  `payment` varchar(255) NOT NULL COMMENT '交易事件',
  `payment_type` varchar(255) NOT NULL COMMENT '交易类型',
  `status` tinyint(4) NOT NULL COMMENT '交易状态',
  `payment_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `close_time` timestamp NULL DEFAULT NULL COMMENT '订单关闭时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
   PRIMARY KEY (`id`),
   UNIQUE KEY (`trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- 订单明细表
-- Table structure for t_trade_item
-- ----------------------------
CREATE TABLE `t_trade_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_uuid` bigint(20) NOT NULL,
  `trade_no` bigint(20) NOT NULL COMMENT '订单号',
  `sku_id` bigint(20) NOT NULL,
  `sku_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `current_price` decimal(10,2) NOT NULL COMMENT '单价',
  `quantity` bigint(20) NOT NULL COMMENT '数量',
  `total_price` decimal(10,2) NOT NULL COMMENT '总价',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- 购物车表
-- Table structure for t_shop_cart
-- ----------------------------
CREATE TABLE `t_shop_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_uuid` bigint(20) NOT NULL COMMENT '用户uuid',
  `sku_id` int(11) NOT NULL COMMENT 'skuID',
  `sku_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku名称',
  `current_price` decimal(10,2) NOT NULL COMMENT '单价',
  `quantity` bigint(20) NOT NULL COMMENT '数量',
  `total_price` decimal(10,2) NOT NULL COMMENT '总价',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 库存表
-- Table structure for t_store
-- ----------------------------
CREATE TABLE `t_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `sku_id` int(11) NOT NULL COMMENT 'skuID',
  `quantity` bigint(20) NOT NULL COMMENT '数量',
  `unit` tinyint(4) NOT NULL DEFAULT 0 COMMENT '计量单位',
  `status` tinyint(4) NOT NULL COMMENT '交易状态',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 分类表
-- Table structure for t_category
-- ----------------------------
CREATE TABLE `t_category` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '分类序号',
  `parent_id` int(100) NOT NULL COMMENT '父分类序号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `status` int(1) NOT NULL COMMENT '状态',
  `sort_order` int(100) NOT NULL COMMENT '序列',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- 产品spu表
-- Table structure for t_product
-- ----------------------------
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `spu_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `status` int(1) NOT NULL COMMENT '状态',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 属性表
-- Table structure for t_property
-- ----------------------------
CREATE TABLE `t_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `property_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 属性值表
-- Table structure for t_property_option
-- ----------------------------
CREATE TABLE `t_property_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性值id',
  `property_id` int(11) NOT NULL COMMENT '属性id',
  `option_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性详细值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 最小库存单位sku表
-- Table structure for t_sku
-- ----------------------------
CREATE TABLE `t_sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skuID',
  `spu_id` int(11) NOT NULL COMMENT 'spuID',
  `sku_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku名称',
  `sku_price` decimal(10,2) NOT NULL COMMENT 'sku价格',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片',
  `enable_flag` int(11) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


-- ----------------------------
-- sku属性值表
-- Table structure for t_sku_property_option
-- ----------------------------
CREATE TABLE `t_sku_property_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'sku参数ID',
  `sku_id` int(11) NOT NULL COMMENT 'skuID',
  `property_id` int(11) NOT NULL COMMENT '属性ID',
  `property_option_id` int(11) NOT NULL COMMENT '属性值ID',
  `enable_flag` int(11) NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 品牌表
-- Table structure for t_brand
-- ----------------------------
CREATE TABLE `t_brand` (
  `id` int(80) NOT NULL AUTO_INCREMENT COMMENT '品牌序号',
  `brand_name` varchar(20) NOT NULL COMMENT '品牌名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;