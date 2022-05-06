DROP TABLE IF EXISTS final;

CREATE TABLE final (
  id int(11) NOT NULL AUTO_INCREMENT,
  name char(50) NOT NULL,
  address    char(50)  NOT NULL ,
  phone    char(50)  NOT NULL ,
  email char(50)  NOT NULL ,
  dob char(50)  NOT NULL ,
  contact char(50)  NULL ,
  age char(50)  NOT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES final WRITE;

INSERT INTO final VALUES (1,'test name','123 test','888.888.8888','testing@test.com','11/22/1933','newsletter','30-50');

UNLOCK TABLES;

