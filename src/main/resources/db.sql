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
    `shoucang_num` int(11) default 0 ,
    `dian_zan` int(11) default 0 ,
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `location` text ,
    PRIMARY KEY (`id`)
)
