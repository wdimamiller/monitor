CREATE TABLE `Service` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `host` varchar(20) NOT NULL,
  `port` varchar(20) NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;