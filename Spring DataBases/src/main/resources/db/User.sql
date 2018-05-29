CREATE TABLE `user` (
`id`  int(11) NULL ,
`name`  varchar(255) NULL ,
`department_id`  int(11) NULL ,
`create_time`  date NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

CREATE TABLE `department` (
`id`  int(11) NOT NULL ,
`name`  varchar(45) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;