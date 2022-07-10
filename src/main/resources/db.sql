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
CREATE table `t_dongtai` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `uid` varchar(36) NOT NULL ,
    `media_list` text ,
    `text` text ,
    `nickName` text ,
    `avatarUrl` text ,
    `pinglun_num` int(11) default 0 ,
    `shoucang_num` int(11) default 0 ,
    `dian_zan` int(11) default 0 ,
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `location` text ,
    PRIMARY KEY (`id`)
)

CREATE table `t_pinglun` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `uid` varchar(36) NOT NULL comment '本条评论人Id',
    `fuid` varchar(36) NOT NULL comment '回复给那个人的Id',
    `did` varchar(36) NOT NULL comment '动态Id',
    `text` text comment '评论内容',
    `nickName` text comment '昵称',
    `avatarUrl` text comment '头像地址',
    `level` numeric comment '评论级别，123级评论',
    `dian_zan` int(11) default 0 comment '被点赞数',
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `location` text ,
    PRIMARY KEY (`id`)
)