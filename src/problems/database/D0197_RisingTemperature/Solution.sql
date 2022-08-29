# Author: reparo
# Date: 2022-08-29

# 表：Weather
# 
# +---------------+---------+
# | Column Name   | Type    |
# +---------------+---------+
# | id            | int     |
# | recordDate    | date    |
# | temperature   | int     |
# +---------------+---------+
# id 是这个表的主键
# 该表包含特定日期的温度信息
# 
# 
# 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
# 
# 返回结果 不要求顺序 。
# 
# 查询结果格式如下例。
# 
# 
# 
# 示例 1：
# 
# 输入：
# Weather 表：
# +----+------------+-------------+
# | id | recordDate | Temperature |
# +----+------------+-------------+
# | 1  | 2015-01-01 | 10          |
# | 2  | 2015-01-02 | 25          |
# | 3  | 2015-01-03 | 20          |
# | 4  | 2015-01-04 | 30          |
# +----+------------+-------------+
# 输出：
# +----+
# | id |
# +----+
# | 2  |
# | 4  |
# +----+
# 解释：
# 2015-01-02 的温度比前一天高（10 -> 25）
# 2015-01-04 的温度比前一天高（20 -> 30）
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/rising-temperature
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Weather;

CREATE TABLE Weather
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    recordDate  DATE,
    temperature INT
);

# Case 1:
TRUNCATE TABLE Weather;
INSERT INTO Weather (id, recordDate, temperature) VALUES (1, '2015-01-01', 10);
INSERT INTO Weather (id, recordDate, temperature) VALUES (2, '2015-01-02', 25);
INSERT INTO Weather (id, recordDate, temperature) VALUES (3, '2015-01-03', 20);
INSERT INTO Weather (id, recordDate, temperature) VALUES (4, '2015-01-04', 30);

# Solution 1：
## 通过子查询查找每一行对应的前一天的数据，并且当天的气温更高
##
## 解答消耗参考:
## Runtime: 1125 ms, 5.02%
## Memory Usage: 0 MB, 100.00%
SELECT W1.id AS id
FROM Weather W1
WHERE W1.recordDate = (SELECT W1.recordDate
                       FROM Weather W2
                       WHERE W2.recordDate = DATE_SUB(W1.recordDate, INTERVAL 1 DAY)
                         AND W1.temperature > W2.temperature);

# Solution 2：
## 对开窗函数LEAD的建单考察
##
## 解答消耗参考:
## Runtime: 413 ms, 84.11%
## Memory Usage: 0 MB, 100.00%
SELECT NextId AS id
FROM (SELECT recordDate                                      AS OriginDate,
             temperature                                     AS OriginTemprature,
             LEAD(id, 1) over (ORDER BY recordDate)          AS NextId,
             LEAD(recordDate, 1) over (ORDER BY recordDate)  AS NextDate,
             LEAD(temperature, 1) over (ORDER BY recordDate) AS NextTemprature
      FROM Weather) as W
WHERE NextTemprature > OriginTemprature
  AND DATEDIFF(OriginDate, NextDate) = 1;