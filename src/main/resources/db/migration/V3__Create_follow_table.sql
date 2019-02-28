create table follow (
                    id int(10) unsigned NOT NULL AUTO_INCREMENT,
                    user_id int(10) NOT NULL,
                    followed_id int(10) NOT NULL,
                    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;