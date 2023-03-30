CREATE database if NOT EXISTS `novel-cloud` default character set utf8mb4 collate utf8mb4_unicode_ci;
use `novel-cloud`;

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for author_code
-- ----------------------------
DROP TABLE IF EXISTS `author_code`;
CREATE TABLE `author_code`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `invite_code`   varchar(100) NOT NULL COMMENT '邀请码',
    `validity_time` datetime     NOT NULL COMMENT '有效时间',
    `is_used`       tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否使用过;0-未使用 1-使用过',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_code` (`invite_code`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='作家邀请码';

-- ----------------------------
-- Table structure for author_income
-- ----------------------------
DROP TABLE IF EXISTS `author_income`;
CREATE TABLE `author_income`
(
    `id`               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `author_id`        bigint(20) unsigned NOT NULL COMMENT '作家ID',
    `book_id`          bigint(20) unsigned NOT NULL COMMENT '小说ID',
    `income_month`     date NOT NULL COMMENT '收入月份',
    `pre_tax_income`   int(10) unsigned NOT NULL DEFAULT '0' COMMENT '税前收入;单位：分',
    `after_tax_income` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '税后收入;单位：分',
    `pay_status`       tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '支付状态;0-待支付 1-已支付',
    `confirm_status`   tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '稿费确认状态;0-待确认 1-已确认',
    `detail`           varchar(255) DEFAULT NULL COMMENT '详情',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`      datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='稿费收入统计';

-- ----------------------------
-- Table structure for author_income_detail
-- ----------------------------
DROP TABLE IF EXISTS `author_income_detail`;
CREATE TABLE `author_income_detail`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `author_id`      bigint(20) unsigned NOT NULL COMMENT '作家ID',
    `book_id`        bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '小说ID;0表示全部作品',
    `income_date`    date NOT NULL COMMENT '收入日期',
    `income_account` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订阅总额',
    `income_count`   int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订阅次数',
    `income_number`  int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订阅人数',
    `create_time`    datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='稿费收入明细统计';

-- ----------------------------
-- Table structure for author_info
-- ----------------------------
DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`        bigint(20) unsigned NOT NULL COMMENT '用户ID',
    `invite_code`    varchar(20) NOT NULL COMMENT '邀请码',
    `pen_name`       varchar(20) NOT NULL COMMENT '笔名',
    `tel_phone`      varchar(20) DEFAULT NULL COMMENT '手机号码',
    `chat_account`   varchar(50) DEFAULT NULL COMMENT 'QQ或微信账号',
    `email`          varchar(50) DEFAULT NULL COMMENT '电子邮箱',
    `work_direction` tinyint(3) unsigned DEFAULT NULL COMMENT '作品方向;0-男频 1-女频',
    `status`         tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0：正常;1-封禁',
    `create_time`    datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_userId` (`user_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='作者信息';

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `work_direction` tinyint(3) unsigned NOT NULL COMMENT '作品方向;0-男频 1-女频',
    `name`           varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名',
    `sort`           tinyint(3) unsigned NOT NULL DEFAULT '10' COMMENT '排序',
    `create_time`    datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `pk_id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说类别';

-- ----------------------------
-- Table structure for book_chapter
-- ----------------------------
DROP TABLE IF EXISTS `book_chapter`;
CREATE TABLE `book_chapter`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `book_id`      bigint(20) unsigned NOT NULL COMMENT '小说ID',
    `chapter_num`  smallint(5) unsigned NOT NULL COMMENT '章节号',
    `chapter_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节名',
    `word_count`   int(10) unsigned NOT NULL COMMENT '章节字数',
    `is_vip`       tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否收费;1-收费 0-免费',
    `create_time`  datetime DEFAULT NULL,
    `update_time`  datetime DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_bookId_chapterNum` (`book_id`,`chapter_num`) USING BTREE,
    UNIQUE KEY `pk_id` (`id`) USING BTREE,
    KEY            `idx_bookId` (`book_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1445988184596992001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说章节';

-- ----------------------------
-- Table structure for book_comment
-- ----------------------------
DROP TABLE IF EXISTS `book_comment`;
CREATE TABLE `book_comment`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `book_id`         bigint(20) unsigned NOT NULL COMMENT '评论小说ID',
    `user_id`         bigint(20) unsigned NOT NULL COMMENT '评论用户ID',
    `comment_content` varchar(512) NOT NULL COMMENT '评价内容',
    `reply_count`     int(10) unsigned NOT NULL DEFAULT '0' COMMENT '回复数量',
    `audit_status`    tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核状态;0-待审核 1-审核通过 2-审核不通过',
    `create_time`     datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_bookId_userId` (`book_id`,`user_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说评论';

-- ----------------------------
-- Table structure for book_comment_copy1
-- ----------------------------
DROP TABLE IF EXISTS `book_comment_copy1`;
CREATE TABLE `book_comment_copy1`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `book_id`         bigint(20) unsigned NOT NULL COMMENT '评论小说ID',
    `user_id`         bigint(20) unsigned NOT NULL COMMENT '评论用户ID',
    `comment_content` varchar(512) NOT NULL COMMENT '评价内容',
    `reply_count`     int(10) unsigned NOT NULL DEFAULT '0' COMMENT '回复数量',
    `audit_status`    tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核状态;0-待审核 1-审核通过 2-审核不通过',
    `create_time`     datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_bookId_userId` (`book_id`,`user_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说评论';

-- ----------------------------
-- Table structure for book_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `book_comment_reply`;
CREATE TABLE `book_comment_reply`
(
    `id`            bigint(20) unsigned NOT NULL COMMENT '主键',
    `comment_id`    bigint(20) unsigned NOT NULL COMMENT '评论ID',
    `user_id`       bigint(20) unsigned NOT NULL COMMENT '回复用户ID',
    `reply_content` varchar(512) NOT NULL COMMENT '回复内容',
    `audit_status`  tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核状态;0-待审核 1-审核通过 2-审核不通过',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说评论回复';

-- ----------------------------
-- Table structure for book_content
-- ----------------------------
DROP TABLE IF EXISTS `book_content`;
CREATE TABLE `book_content`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `chapter_id`  bigint(20) unsigned NOT NULL COMMENT '章节ID',
    `content`     mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '小说章节内容',
    `create_time` datetime DEFAULT NULL,
    `update_time` datetime DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_chapterId` (`chapter_id`) USING BTREE,
    UNIQUE KEY `pk_id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4256332 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说内容';

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`
(
    `id`                       bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `work_direction`           tinyint(3) unsigned DEFAULT NULL COMMENT '作品方向;0-男频 1-女频',
    `category_id`              bigint(20) unsigned DEFAULT NULL COMMENT '类别ID',
    `category_name`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类别名',
    `pic_url`                  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '小说封面地址',
    `book_name`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '小说名',
    `author_id`                bigint(20) unsigned NOT NULL COMMENT '作家id',
    `author_name`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL COMMENT '作家名',
    `book_desc`                varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍描述',
    `score`                    tinyint(3) unsigned NOT NULL COMMENT '评分;总分:10 ，真实评分 = score/10',
    `book_status`              tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '书籍状态;0-连载中 1-已完结',
    `visit_count`              bigint(20) unsigned NOT NULL DEFAULT '103' COMMENT '点击量',
    `word_count`               int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总字数',
    `comment_count`            int(10) unsigned NOT NULL DEFAULT '0' COMMENT '评论数',
    `last_chapter_id`          bigint(20) unsigned DEFAULT NULL COMMENT '最新章节ID',
    `last_chapter_name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最新章节名',
    `last_chapter_update_time` datetime                                                     DEFAULT NULL COMMENT '最新章节更新时间',
    `is_vip`                   tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否收费;1-收费 0-免费',
    `create_time`              datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`              datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_bookName_authorName` (`book_name`,`author_name`) USING BTREE,
    UNIQUE KEY `pk_id` (`id`) USING BTREE,
    KEY                        `idx_createTime` (`create_time`) USING BTREE,
    KEY                        `idx_lastChapterUpdateTime` (`last_chapter_update_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1431630596354977793 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说信息';

-- ----------------------------
-- Table structure for home_book
-- ----------------------------
DROP TABLE IF EXISTS `home_book`;
CREATE TABLE `home_book`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `type`        tinyint(3) unsigned NOT NULL COMMENT '推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐',
    `sort`        tinyint(3) unsigned NOT NULL COMMENT '推荐排序',
    `book_id`     bigint(20) unsigned NOT NULL COMMENT '推荐小说ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='小说推荐';

-- ----------------------------
-- Table structure for home_friend_link
-- ----------------------------
DROP TABLE IF EXISTS `home_friend_link`;
CREATE TABLE `home_friend_link`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `link_name`   varchar(50)  NOT NULL COMMENT '链接名',
    `link_url`    varchar(100) NOT NULL COMMENT '链接url',
    `sort`        tinyint(3) unsigned NOT NULL DEFAULT '11' COMMENT '排序号',
    `is_open`     tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否开启;0-不开启 1-开启',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='友情链接';

-- ----------------------------
-- Table structure for news_category
-- ----------------------------
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE `news_category`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) NOT NULL COMMENT '类别名',
    `sort`        tinyint(3) unsigned NOT NULL DEFAULT '10' COMMENT '排序',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='新闻类别';

-- ----------------------------
-- Table structure for news_content
-- ----------------------------
DROP TABLE IF EXISTS `news_content`;
CREATE TABLE `news_content`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `news_id`     bigint(20) unsigned NOT NULL COMMENT '新闻ID',
    `content`     mediumtext NOT NULL COMMENT '新闻内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_newsId` (`news_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='新闻内容';

-- ----------------------------
-- Table structure for news_info
-- ----------------------------
DROP TABLE IF EXISTS `news_info`;
CREATE TABLE `news_info`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `category_id`   bigint(20) unsigned NOT NULL COMMENT '类别ID',
    `category_name` varchar(50)  NOT NULL COMMENT '类别名',
    `source_name`   varchar(50)  NOT NULL COMMENT '新闻来源',
    `title`         varchar(100) NOT NULL COMMENT '新闻标题',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='新闻信息';

-- ----------------------------
-- Table structure for pay_alipay
-- ----------------------------
DROP TABLE IF EXISTS `pay_alipay`;
CREATE TABLE `pay_alipay`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `out_trade_no`   varchar(64) NOT NULL COMMENT '商户订单号',
    `trade_no`       varchar(64) NOT NULL COMMENT '支付宝交易号',
    `buyer_id`       varchar(16) DEFAULT NULL COMMENT '买家支付宝账号 ID',
    `trade_status`   varchar(32) DEFAULT NULL COMMENT '交易状态;TRADE_SUCCESS-交易成功',
    `total_amount`   int(10) unsigned NOT NULL COMMENT '订单金额;单位：分',
    `receipt_amount` int(10) unsigned DEFAULT NULL COMMENT '实收金额;单位：分',
    `invoice_amount` int(10) unsigned DEFAULT NULL COMMENT '开票金额',
    `gmt_create`     datetime    DEFAULT NULL COMMENT '交易创建时间',
    `gmt_payment`    datetime    DEFAULT NULL COMMENT '交易付款时间',
    `create_time`    datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`),
    KEY              `uk_outTradeNo` (`out_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支付宝支付';

-- ----------------------------
-- Table structure for pay_wechat
-- ----------------------------
DROP TABLE IF EXISTS `pay_wechat`;
CREATE TABLE `pay_wechat`
(
    `id`               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `out_trade_no`     varchar(32) NOT NULL COMMENT '商户订单号',
    `transaction_id`   varchar(32) NOT NULL COMMENT '微信支付订单号',
    `trade_type`       varchar(16)  DEFAULT NULL COMMENT '交易类型;JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付',
    `trade_state`      varchar(32)  DEFAULT NULL COMMENT '交易状态;SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)',
    `trade_state_desc` varchar(255) DEFAULT NULL COMMENT '交易状态描述',
    `amount`           int(10) unsigned NOT NULL COMMENT '订单总金额;单位：分',
    `payer_total`      int(10) unsigned DEFAULT NULL COMMENT '用户支付金额;单位：分',
    `success_time`     datetime     DEFAULT NULL COMMENT '支付完成时间',
    `payer_openid`     varchar(128) DEFAULT NULL COMMENT '支付者用户标识;用户在直连商户appid下的唯一标识',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`      datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`),
    KEY                `uk_outTradeNo` (`out_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='微信支付';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
    `username`    varchar(50)   DEFAULT NULL COMMENT '用户名',
    `operation`   varchar(50)   DEFAULT NULL COMMENT '用户操作',
    `time`        int(10) unsigned DEFAULT NULL COMMENT '响应时间',
    `method`      varchar(200)  DEFAULT NULL COMMENT '请求方法',
    `params`      varchar(5000) DEFAULT NULL COMMENT '请求参数',
    `ip`          varchar(64)   DEFAULT NULL COMMENT 'IP地址',
    `create_time` datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统日志';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父菜单ID;一级菜单为0',
    `name`        varchar(50) NOT NULL COMMENT '菜单名称',
    `url`         varchar(200) DEFAULT NULL COMMENT '菜单URL',
    `type`        tinyint(3) unsigned NOT NULL COMMENT '类型;0-目录   1-菜单',
    `icon`        varchar(50)  DEFAULT NULL COMMENT '菜单图标',
    `sort`        tinyint(3) unsigned DEFAULT NULL COMMENT '排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统菜单';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `role_name`   varchar(100) NOT NULL COMMENT '角色名称',
    `role_sign`   varchar(100) DEFAULT NULL COMMENT '角色标识',
    `remark`      varchar(100) DEFAULT NULL COMMENT '备注',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `role_id`     bigint(20) unsigned NOT NULL COMMENT '角色ID',
    `menu_id`     bigint(20) unsigned NOT NULL COMMENT '菜单ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `username`    varchar(50) NOT NULL COMMENT '用户名',
    `password`    varchar(50) NOT NULL COMMENT '密码',
    `name`        varchar(100) DEFAULT NULL COMMENT '真实姓名',
    `sex`         tinyint(3) unsigned DEFAULT NULL COMMENT '性别;0-男 1-女',
    `birth`       datetime     DEFAULT NULL COMMENT '出身日期',
    `email`       varchar(100) DEFAULT NULL COMMENT '邮箱',
    `mobile`      varchar(100) DEFAULT NULL COMMENT '手机号',
    `status`      tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态;0-禁用 1-正常',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) unsigned NOT NULL COMMENT '用户ID',
    `role_id`     bigint(20) unsigned NOT NULL COMMENT '角色ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色对应关系';

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`
(
    `id`    int(11) NOT NULL,
    `test`  tinyint(1) unsigned zerofill DEFAULT NULL,
    `test2` tinyint(4) unsigned zerofill DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `user_bookshelf`;
CREATE TABLE `user_bookshelf`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`        bigint(20) unsigned NOT NULL COMMENT '用户ID',
    `book_id`        bigint(20) unsigned NOT NULL COMMENT '小说ID',
    `pre_content_id` bigint(20) unsigned DEFAULT NULL COMMENT '上一次阅读的章节内容表ID',
    `create_time`    datetime DEFAULT NULL COMMENT '创建时间;',
    `update_time`    datetime DEFAULT NULL COMMENT '更新时间;',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_userId_bookId` (`user_id`,`book_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户书架';

-- ----------------------------
-- Table structure for user_comment
-- ----------------------------
DROP TABLE IF EXISTS `user_comment`;
CREATE TABLE `user_comment`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`         bigint(20) unsigned NOT NULL COMMENT '评论用户ID',
    `book_id`         bigint(20) unsigned NOT NULL COMMENT '评论小说ID',
    `comment_content` varchar(512) NOT NULL COMMENT '评价内容',
    `reply_count`     int(10) unsigned NOT NULL DEFAULT '0' COMMENT '回复数量',
    `audit_status`    tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核状态;0-待审核 1-审核通过 2-审核不通过',
    `create_time`     datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_bookId_userId` (`book_id`,`user_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户评论';

-- ----------------------------
-- Table structure for user_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `user_comment_reply`;
CREATE TABLE `user_comment_reply`
(
    `id`            bigint(20) unsigned NOT NULL COMMENT '主键',
    `comment_id`    bigint(20) unsigned NOT NULL COMMENT '评论ID',
    `user_id`       bigint(20) unsigned NOT NULL COMMENT '回复用户ID',
    `reply_content` varchar(512) NOT NULL COMMENT '回复内容',
    `audit_status`  tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核状态;0-待审核 1-审核通过 2-审核不通过',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户评论回复';

-- ----------------------------
-- Table structure for user_consume_log
-- ----------------------------
DROP TABLE IF EXISTS `user_consume_log`;
CREATE TABLE `user_consume_log`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`      bigint(20) unsigned NOT NULL COMMENT '消费用户ID',
    `amount`       int(10) unsigned NOT NULL COMMENT '消费使用的金额;单位：屋币',
    `product_type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '消费商品类型;0-小说VIP章节',
    `product_id`   bigint(20) unsigned DEFAULT NULL COMMENT '消费的的商品ID;例如：章节ID',
    `produc_name`  varchar(50) DEFAULT NULL COMMENT '消费的的商品名;例如：章节名',
    `produc_value` int(10) unsigned DEFAULT NULL COMMENT '消费的的商品值;例如：1',
    `create_time`  datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户消费记录';

-- ----------------------------
-- Table structure for user_feedback
-- ----------------------------
DROP TABLE IF EXISTS `user_feedback`;
CREATE TABLE `user_feedback`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) unsigned NOT NULL COMMENT '反馈用户id',
    `content`     varchar(512) NOT NULL COMMENT '反馈内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户反馈';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `username`        varchar(50)  NOT NULL COMMENT '登录名',
    `password`        varchar(100) NOT NULL COMMENT '登录密码-加密',
    `salt`            varchar(8)   NOT NULL COMMENT '加密盐值',
    `nick_name`       varchar(50)  DEFAULT NULL COMMENT '昵称',
    `user_photo`      varchar(100) DEFAULT NULL COMMENT '用户头像',
    `user_sex`        tinyint(3) unsigned DEFAULT NULL COMMENT '用户性别;0-男 1-女',
    `account_balance` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '账户余额',
    `status`          tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态;0-正常',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息';

-- ----------------------------
-- Table structure for user_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `user_pay_log`;
CREATE TABLE `user_pay_log`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`       bigint(20) unsigned NOT NULL COMMENT '充值用户ID',
    `pay_channel`   tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '充值方式;0-支付宝 1-微信',
    `out_trade_no`  varchar(64)  NOT NULL COMMENT '商户订单号',
    `amount`        int(10) unsigned NOT NULL COMMENT '充值金额;单位：分',
    `product_type`  tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '充值商品类型;0-屋币 1-包年VIP',
    `product_id`    bigint(20) unsigned DEFAULT NULL COMMENT '充值商品ID',
    `product_name`  varchar(255) NOT NULL COMMENT '充值商品名;示例值：屋币',
    `product_value` int(10) unsigned DEFAULT NULL COMMENT '充值商品值;示例值：255',
    `pay_time`      datetime     NOT NULL COMMENT '充值时间',
    `create_time`   datetime DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户充值记录';

-- ----------------------------
-- Table structure for user_read_history
-- ----------------------------
DROP TABLE IF EXISTS `user_read_history`;
CREATE TABLE `user_read_history`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`        bigint(20) unsigned NOT NULL COMMENT '用户ID',
    `book_id`        bigint(20) unsigned NOT NULL COMMENT '小说ID',
    `pre_content_id` bigint(20) unsigned NOT NULL COMMENT '上一次阅读的章节内容表ID',
    `create_time`    datetime DEFAULT NULL COMMENT '创建时间;',
    `update_time`    datetime DEFAULT NULL COMMENT '更新时间;',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_userId_bookId` (`user_id`,`book_id`),
    UNIQUE KEY `pk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户阅读历史';

SET
FOREIGN_KEY_CHECKS = 1;


CREATE database if NOT EXISTS `nacos` default character set utf8mb4 collate utf8mb4_unicode_ci;
use `nacos`;

SET NAMES utf8mb4;

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info   */
/******************************************/
CREATE TABLE `config_info`
(
    `id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`            varchar(255) NOT NULL COMMENT 'data_id',
    `group_id`           varchar(128)          DEFAULT NULL,
    `content`            longtext     NOT NULL COMMENT 'content',
    `md5`                varchar(32)           DEFAULT NULL COMMENT 'md5',
    `gmt_create`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`           text COMMENT 'source user',
    `src_ip`             varchar(50)           DEFAULT NULL COMMENT 'source ip',
    `app_name`           varchar(128)          DEFAULT NULL,
    `tenant_id`          varchar(128)          DEFAULT '' COMMENT '租户字段',
    `c_desc`             varchar(256)          DEFAULT NULL,
    `c_use`              varchar(64)           DEFAULT NULL,
    `effect`             varchar(64)           DEFAULT NULL,
    `type`               varchar(64)           DEFAULT NULL,
    `c_schema`           text,
    `encrypted_data_key` text         NOT NULL COMMENT '秘钥',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_aggr   */
/******************************************/
CREATE TABLE `config_info_aggr`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) NOT NULL COMMENT 'data_id',
    `group_id`     varchar(128) NOT NULL COMMENT 'group_id',
    `datum_id`     varchar(255) NOT NULL COMMENT 'datum_id',
    `content`      longtext     NOT NULL COMMENT '内容',
    `gmt_modified` datetime     NOT NULL COMMENT '修改时间',
    `app_name`     varchar(128) DEFAULT NULL,
    `tenant_id`    varchar(128) DEFAULT '' COMMENT '租户字段',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='增加租户字段';


/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_beta   */
/******************************************/
CREATE TABLE `config_info_beta`
(
    `id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`            varchar(255) NOT NULL COMMENT 'data_id',
    `group_id`           varchar(128) NOT NULL COMMENT 'group_id',
    `app_name`           varchar(128)          DEFAULT NULL COMMENT 'app_name',
    `content`            longtext     NOT NULL COMMENT 'content',
    `beta_ips`           varchar(1024)         DEFAULT NULL COMMENT 'betaIps',
    `md5`                varchar(32)           DEFAULT NULL COMMENT 'md5',
    `gmt_create`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`           text COMMENT 'source user',
    `src_ip`             varchar(50)           DEFAULT NULL COMMENT 'source ip',
    `tenant_id`          varchar(128)          DEFAULT '' COMMENT '租户字段',
    `encrypted_data_key` text         NOT NULL COMMENT '秘钥',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_beta';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_tag   */
/******************************************/
CREATE TABLE `config_info_tag`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) NOT NULL COMMENT 'data_id',
    `group_id`     varchar(128) NOT NULL COMMENT 'group_id',
    `tenant_id`    varchar(128)          DEFAULT '' COMMENT 'tenant_id',
    `tag_id`       varchar(128) NOT NULL COMMENT 'tag_id',
    `app_name`     varchar(128)          DEFAULT NULL COMMENT 'app_name',
    `content`      longtext     NOT NULL COMMENT 'content',
    `md5`          varchar(32)           DEFAULT NULL COMMENT 'md5',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`     text COMMENT 'source user',
    `src_ip`       varchar(50)           DEFAULT NULL COMMENT 'source ip',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_tag';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_tags_relation   */
/******************************************/
CREATE TABLE `config_tags_relation`
(
    `id`        bigint(20) NOT NULL COMMENT 'id',
    `tag_name`  varchar(128) NOT NULL COMMENT 'tag_name',
    `tag_type`  varchar(64)  DEFAULT NULL COMMENT 'tag_type',
    `data_id`   varchar(255) NOT NULL COMMENT 'data_id',
    `group_id`  varchar(128) NOT NULL COMMENT 'group_id',
    `tenant_id` varchar(128) DEFAULT '' COMMENT 'tenant_id',
    `nid`       bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`nid`),
    UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
    KEY         `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_tag_relation';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = group_capacity   */
/******************************************/
CREATE TABLE `group_capacity`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `group_id`          varchar(128) NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
    `quota`             int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
    `usage`             int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
    `max_size`          int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
    `max_aggr_count`    int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
    `max_aggr_size`     int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
    `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
    `gmt_create`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集群、各Group容量信息表';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = his_config_info   */
/******************************************/
CREATE TABLE `his_config_info`
(
    `id`                 bigint(20) unsigned NOT NULL,
    `nid`                bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `data_id`            varchar(255) NOT NULL,
    `group_id`           varchar(128) NOT NULL,
    `app_name`           varchar(128)          DEFAULT NULL COMMENT 'app_name',
    `content`            longtext     NOT NULL,
    `md5`                varchar(32)           DEFAULT NULL,
    `gmt_create`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `src_user`           text,
    `src_ip`             varchar(50)           DEFAULT NULL,
    `op_type`            char(10)              DEFAULT NULL,
    `tenant_id`          varchar(128)          DEFAULT '' COMMENT '租户字段',
    `encrypted_data_key` text         NOT NULL COMMENT '秘钥',
    PRIMARY KEY (`nid`),
    KEY                  `idx_gmt_create` (`gmt_create`),
    KEY                  `idx_gmt_modified` (`gmt_modified`),
    KEY                  `idx_did` (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';


/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = tenant_capacity   */
/******************************************/
CREATE TABLE `tenant_capacity`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `tenant_id`         varchar(128) NOT NULL DEFAULT '' COMMENT 'Tenant ID',
    `quota`             int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
    `usage`             int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
    `max_size`          int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
    `max_aggr_count`    int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
    `max_aggr_size`     int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
    `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
    `gmt_create`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租户容量信息表';


CREATE TABLE `tenant_info`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `kp`            varchar(128) NOT NULL COMMENT 'kp',
    `tenant_id`     varchar(128) default '' COMMENT 'tenant_id',
    `tenant_name`   varchar(128) default '' COMMENT 'tenant_name',
    `tenant_desc`   varchar(256) DEFAULT NULL COMMENT 'tenant_desc',
    `create_source` varchar(32)  DEFAULT NULL COMMENT 'create_source',
    `gmt_create`    bigint(20) NOT NULL COMMENT '创建时间',
    `gmt_modified`  bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
    KEY             `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';

CREATE TABLE `users`
(
    `username` varchar(50)  NOT NULL PRIMARY KEY,
    `password` varchar(500) NOT NULL,
    `enabled`  boolean      NOT NULL
);

CREATE TABLE `roles`
(
    `username` varchar(50) NOT NULL,
    `role`     varchar(50) NOT NULL,
    UNIQUE INDEX `idx_user_role` (`username` ASC, `role` ASC) USING BTREE
);

CREATE TABLE `permissions`
(
    `role`     varchar(50)  NOT NULL,
    `resource` varchar(255) NOT NULL,
    `action`   varchar(8)   NOT NULL,
    UNIQUE INDEX `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
);

INSERT INTO users (username, password, enabled)
VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO roles (username, role)
VALUES ('nacos', 'ROLE_ADMIN');


CREATE database if NOT EXISTS `xxl_job` default character set utf8mb4 collate utf8mb4_unicode_ci;
use `xxl_job`;

SET NAMES utf8mb4;

CREATE TABLE `xxl_job_info`
(
    `id`                        int(11) NOT NULL AUTO_INCREMENT,
    `job_group`                 int(11) NOT NULL COMMENT '执行器主键ID',
    `job_desc`                  varchar(255) NOT NULL,
    `add_time`                  datetime              DEFAULT NULL,
    `update_time`               datetime              DEFAULT NULL,
    `author`                    varchar(64)           DEFAULT NULL COMMENT '作者',
    `alarm_email`               varchar(255)          DEFAULT NULL COMMENT '报警邮件',
    `schedule_type`             varchar(50)  NOT NULL DEFAULT 'NONE' COMMENT '调度类型',
    `schedule_conf`             varchar(128)          DEFAULT NULL COMMENT '调度配置，值含义取决于调度类型',
    `misfire_strategy`          varchar(50)  NOT NULL DEFAULT 'DO_NOTHING' COMMENT '调度过期策略',
    `executor_route_strategy`   varchar(50)           DEFAULT NULL COMMENT '执行器路由策略',
    `executor_handler`          varchar(255)          DEFAULT NULL COMMENT '执行器任务handler',
    `executor_param`            varchar(512)          DEFAULT NULL COMMENT '执行器任务参数',
    `executor_block_strategy`   varchar(50)           DEFAULT NULL COMMENT '阻塞处理策略',
    `executor_timeout`          int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
    `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
    `glue_type`                 varchar(50)  NOT NULL COMMENT 'GLUE类型',
    `glue_source`               mediumtext COMMENT 'GLUE源代码',
    `glue_remark`               varchar(128)          DEFAULT NULL COMMENT 'GLUE备注',
    `glue_updatetime`           datetime              DEFAULT NULL COMMENT 'GLUE更新时间',
    `child_jobid`               varchar(255)          DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
    `trigger_status`            tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度状态：0-停止，1-运行',
    `trigger_last_time`         bigint(13) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
    `trigger_next_time`         bigint(13) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_log`
(
    `id`                        bigint(20) NOT NULL AUTO_INCREMENT,
    `job_group`                 int(11) NOT NULL COMMENT '执行器主键ID',
    `job_id`                    int(11) NOT NULL COMMENT '任务，主键ID',
    `executor_address`          varchar(255) DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
    `executor_handler`          varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
    `executor_param`            varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
    `executor_sharding_param`   varchar(20)  DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
    `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
    `trigger_time`              datetime     DEFAULT NULL COMMENT '调度-时间',
    `trigger_code`              int(11) NOT NULL COMMENT '调度-结果',
    `trigger_msg`               text COMMENT '调度-日志',
    `handle_time`               datetime     DEFAULT NULL COMMENT '执行-时间',
    `handle_code`               int(11) NOT NULL COMMENT '执行-状态',
    `handle_msg`                text COMMENT '执行-日志',
    `alarm_status`              tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
    PRIMARY KEY (`id`),
    KEY                         `I_trigger_time` (`trigger_time`),
    KEY                         `I_handle_code` (`handle_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_log_report`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `trigger_day`   datetime DEFAULT NULL COMMENT '调度-时间',
    `running_count` int(11) NOT NULL DEFAULT '0' COMMENT '运行中-日志数量',
    `suc_count`     int(11) NOT NULL DEFAULT '0' COMMENT '执行成功-日志数量',
    `fail_count`    int(11) NOT NULL DEFAULT '0' COMMENT '执行失败-日志数量',
    `update_time`   datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `i_trigger_day` (`trigger_day`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_logglue`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `job_id`      int(11) NOT NULL COMMENT '任务，主键ID',
    `glue_type`   varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
    `glue_source` mediumtext COMMENT 'GLUE源代码',
    `glue_remark` varchar(128) NOT NULL COMMENT 'GLUE备注',
    `add_time`    datetime    DEFAULT NULL,
    `update_time` datetime    DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_registry`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `registry_group` varchar(50)  NOT NULL,
    `registry_key`   varchar(255) NOT NULL,
    `registry_value` varchar(255) NOT NULL,
    `update_time`    datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY              `i_g_k_v` (`registry_group`,`registry_key`,`registry_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_group`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `app_name`     varchar(64) NOT NULL COMMENT '执行器AppName',
    `title`        varchar(12) NOT NULL COMMENT '执行器名称',
    `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
    `address_list` text COMMENT '执行器地址列表，多地址逗号分隔',
    `update_time`  datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_user`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `username`   varchar(50) NOT NULL COMMENT '账号',
    `password`   varchar(50) NOT NULL COMMENT '密码',
    `role`       tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
    `permission` varchar(255) DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
    PRIMARY KEY (`id`),
    UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `xxl_job_lock`
(
    `lock_name` varchar(50) NOT NULL COMMENT '锁名称',
    PRIMARY KEY (`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_group`(`id`, `app_name`, `title`, `address_type`, `address_list`, `update_time`)
VALUES (1, 'xxl-job-executor-sample', '示例执行器', 0, NULL, '2018-11-03 22:21:31');
INSERT INTO `xxl_job_info`(`id`, `job_group`, `job_desc`, `add_time`, `update_time`, `author`, `alarm_email`,
                           `schedule_type`, `schedule_conf`, `misfire_strategy`, `executor_route_strategy`,
                           `executor_handler`, `executor_param`, `executor_block_strategy`, `executor_timeout`,
                           `executor_fail_retry_count`, `glue_type`, `glue_source`, `glue_remark`, `glue_updatetime`,
                           `child_jobid`)
VALUES (1, 1, '测试任务1', '2018-11-03 22:21:31', '2018-11-03 22:21:31', 'XXL', '', 'CRON', '0 0 0 * * ? *', 'DO_NOTHING',
        'FIRST', 'demoJobHandler', '', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2018-11-03 22:21:31', '');
INSERT INTO `xxl_job_user`(`id`, `username`, `password`, `role`, `permission`)
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL);
INSERT INTO `xxl_job_lock` (`lock_name`)
VALUES ('schedule_lock');

commit;


-- 增加 novel 任务执行器和同步小说数据到 Elasticsearch 的任务
-- 增加 novel 任务执行器和同步小说数据到 Elasticsearch 的任务
INSERT INTO `xxl_job`.`xxl_job_group` (`app_name`, `title`, `address_type`, `address_list`, `update_time`)
VALUES ('xxl-job-executor-novel',
        'novel 任务执行器',
        0,
        NULL,
        now());
INSERT INTO `xxl_job`.`xxl_job_info` (`job_group`,
                                      `job_desc`,
                                      `add_time`,
                                      `update_time`,
                                      `author`,
                                      `alarm_email`,
                                      `schedule_type`,
                                      `schedule_conf`,
                                      `misfire_strategy`,
                                      `executor_route_strategy`,
                                      `executor_handler`,
                                      `executor_param`,
                                      `executor_block_strategy`,
                                      `executor_timeout`,
                                      `executor_fail_retry_count`,
                                      `glue_type`,
                                      `glue_source`,
                                      `glue_remark`,
                                      `glue_updatetime`,
                                      `child_jobid`,
                                      `trigger_status`,
                                      `trigger_last_time`,
                                      `trigger_next_time`)
VALUES ((SELECT id
         FROM xxl_job_group
         WHERE app_name = 'xxl-job-executor-novel'),
        '同步小说数据到 Elasticsearch',
        now(),
        now(),
        'xxyopen',
        '',
        'CRON',
        '0 0 0 1 * ?',
        'DO_NOTHING',
        'FIRST',
        'saveToEsJobHandler',
        '',
        'SERIAL_EXECUTION',
        0,
        0,
        'BEAN',
        '',
        'GLUE代码初始化',
        now(),
        '',
        0,
        0,
        0);