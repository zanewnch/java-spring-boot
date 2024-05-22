drop table if exists emp;
drop table if exists dept;

# emp table:
# id, username, password, name, gender, image, job, entryDate, deptId, createTime, updateTime

# unsigned : 無符號，代表非負數
# tinyint : 1 byte, store range is -128 ~ 127, so is usually used to store status or boolean value
# date : '2023-08-04'
# datetime : '2023-08-04 12:23:34'

# Create Table

# emp table:
create table if not exists emp
(
    id         int unsigned primary key auto_increment comment 'The id of employee',
    username   varchar(20) not null unique comment 'The account name',
    password   varchar(20) not null comment 'The password of account',
    name       varchar(10) not null comment 'The real name of user',
    gender     tinyint     not null comment 'The gender of employee, 1 is male, 0 is female',
    image      varchar(100) comment 'The image of employee',
    job        tinyint unsigned comment 'The job level of employee belongs to, 1 : manager, 2 : teacher, 3:student, 4:other',
    entryDate  date comment 'The date of employee entry the company',
    deptId     tinyint unsigned comment 'The department id of employee belongs to',
    createTime datetime    not null comment 'The time of creating this data',
    updateTime datetime    not null comment 'The time of updating this data'
) comment 'The table of employee information';

# department table:
create table if not exists dept
(
    id         int unsigned primary key auto_increment comment 'The id of department',
    name       varchar(20) not null unique comment 'The name of department',
    createTime datetime    not null comment 'The time of creating this data',
    updateTime datetime    not null comment 'The time of updating this data'
) comment 'The table of department information';

# Insert data

INSERT INTO emp
(id, username, password, name, gender, image, job, entrydate, deptId, createTime, updateTime)
VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, now(), now()),
       (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, now(), now()),
       (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, now(), now()),
       (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, now(), now()),
       (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, now(), now()),
       (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, now(), now()),
       (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, now(), now()),
       (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, now(), now()),
       (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, now(), now()),
       (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, now(), now()),
       (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, now(), now()),
       (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, now(), now()),
       (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, now(), now()),
       (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, now(), now()),
       (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', 2, now(), now()),
       (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2007-01-01', 2, now(), now()),
       (17, 'chenyouliang', '123456', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', NULL, now(), now());

insert into dept (id, name, createTime, updateTime)
values (1, '学工部', now(), now()),
       (2, '教研部', now(), now()),
       (3, '咨询部', now(), now()),
       (4, '就业部', now(), now()),
       (5, '人事部', now(), now());


select *
from emp;
select *
from dept;

