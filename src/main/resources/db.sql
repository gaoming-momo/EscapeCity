CREATE TABLE `Counters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL DEFAULT '1',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE table `t_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nick_name` varchar(50) NOT NULL,
    `user_id` varchar(36) NOT NULL,
    PRIMARY KEY (`id`)
)
CREATE TABLE `t_dongtai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) NOT NULL,
  `media_list` text,
  `text` text,
  `nickName` text,
  `avatarUrl` text,
  `shoucang_num` int(11) DEFAULT '0',
  `dian_zan` int(11) DEFAULT '0',
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `location` text,
  `pinglun_num` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
)

CREATE TABLE `t_pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) DEFAULT NULL COMMENT '本条评论人Id',
  `fuid` varchar(36) DEFAULT NULL COMMENT '回复给那个人的Id',
  `did` int(36) DEFAULT NULL COMMENT '动态Id',
  `text` text COMMENT '评论内容',
  `nickName` text COMMENT '昵称',
  `avatarUrl` text COMMENT '头像地址',
  `level` decimal(10,0) DEFAULT NULL COMMENT '评论级别，123级评论',
  `dian_zan` int(11) DEFAULT '0' COMMENT '被点赞数',
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `location` text,
  PRIMARY KEY (`id`)
)

CREATE TABLE `t_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `type` varchar(20) DEFAULT '' COMMENT '消息类型，pinglun,dianzan,shoucang,sixing',
  `msg` text COMMENT '消息内容，自定义内容',
  `pid` int(11) DEFAULT NULL COMMENT '对应的评论id',
  `fuid` varchar(20) DEFAULT '' COMMENT '评论对象所有者的Id',
  `did` int(11) DEFAULT NULL COMMENT '动态Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='一个消息表，存储评论、点赞、收藏、私信等消息'