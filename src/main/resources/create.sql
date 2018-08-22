CREATE DATABASE IF NOT EXISTS `test`;
USE `test`;

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `menu`;
INSERT INTO `menu` (`id`, `parent_id`, `name`) VALUES
    (0, -1, 'MENU'),
    (1, 0, 'Home'),
    (2, 0, 'Certification Exam'),
    (3, 0, 'Sample questions'),
    (4, 0, 'My Books'),
    (5, 0, 'Articles'),
    (6, 0, 'News'),
    (7, 0, 'Mix'),
    (8, 0, 'Feedbacks'),
    (9, 0, 'About'),
    (10, 2, 'Exam preparation: step by step'),
    (11, 2, 'Exam Topics'),
    (12, 2, 'Exam Experience'),
    (13, 3, 'Oracle'),
    (14, 13, '1Z0-803 (OCA 7)'),
    (15, 13, '1Z0-804 (OCP 7)'),
    (16, 13, '1Z0-805 (Upgrade to Java SE 7)'),
    (17, 13, '1Z0-808 (OCA 8)'),
    (18, 13, '1Z0-809 (OCP 8)'),
    (19, 13, '1Z0-810 (Upgrade SE 7 to 8 OCP)'),
    (20, 13, '1Z0-813 (Upgrade to SE 8 OCP)'),
    (21, 4, 'My Certification Notes');
