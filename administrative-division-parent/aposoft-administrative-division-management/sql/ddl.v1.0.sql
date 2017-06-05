create schema if not exists `administrative_division`;
create user 'administrative-division'@'localhost' IDENTIFIED BY 'pass';
grant all privileges on `administrative_division`.* to 'administrative-division'@'localhost';
flush PRIVILEGES;
-- 使用行政区划库
USE `administrative_division`;
-- 创建行政区划库
DROP TABLE IF EXISTS `administrative_division`;
DROP TABLE IF EXISTS `division_yearly_detail`;
DROP TABLE IF EXISTS `division_yearly_history`;

CREATE TABLE `administrative_division` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(6) NOT NULL COMMENT '编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `parent` varchar(6) DEFAULT NULL COMMENT '上级行政区划编码,1级时为空',
  `division_level` tinyint(1) DEFAULT NULL COMMENT '行政级别',
  `establish_date` date DEFAULT NULL COMMENT '创建日期',
  `version` int(11) DEFAULT NULL COMMENT '顺序递增版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `DIVISION_CODE_UNIQUE_IDX` (`code`),
  KEY `DIVISION_PARENT_CODE_IDX` (`parent`),
  KEY `DIVISION_LEVEL_IDX` (`division_level`),
  CONSTRAINT `DIVISION_PARENT_CODE` FOREIGN KEY (`parent`) REFERENCES `administrative_division` (`code`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区划信息';


-- 创建操作历史库,主要使用统计局年度统计记录
CREATE TABLE IF NOT EXISTS `division_yearly_history`(
	`id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `publish_time` TIMESTAMP COMMENT '发布日期',
    `final_date` DATE COMMENT '统计截止日期',
    `source` VARCHAR(50) COMMENT '来源',
	`url` VARCHAR(300) NOT NULL UNIQUE COMMENT '发布URL'
)ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8 COMMENT='行政区划年度统计历史';

-- 创建操作历史详情
CREATE TABLE IF NOT EXISTS `division_yearly_detail`(
	`id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
	`statistical_id` int COMMENT '所属统计记录ID',
    `code` VARCHAR(6) NOT NULL COMMENT '编码',
    `name` VARCHAR(50) NOT NULL COMMENT '名称',
	CONSTRAINT `DIVISION_YEARLY_DETAIL_REF_ID` FOREIGN KEY DIVISION_YEARLY_DETAIL_STATISTICAL_ID (`statistical_id`) REFERENCES  `division_yearly_history` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8 COMMENT='行政区划年度统计明细';