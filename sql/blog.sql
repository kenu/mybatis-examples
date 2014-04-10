CREATE TABLE javatest.`blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(400) NOT NULL,
  `article` varchar(4000) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into javatest.`blog` (subject, article, datetime) 
values ('blog', 'Content Article, hello', now());

select * from javatest.`blog`

