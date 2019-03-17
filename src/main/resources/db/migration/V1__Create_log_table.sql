use log;

create table log (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  type int(10) NOT NULL,
  create_time timestamp NOT NULL,
  content text(100) NOT NULL,
  user_id int(10) NOT NULL,
  exctype int(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;