# Author: reparo
# Date: 2021-11-25

# 表：Logs
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | num         | varchar |
# +-------------+---------+
# id 是这个表的主键。
#  
#
# 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
#
# 返回的结果表中的数据可以按 任意顺序 排列。
#
#  
#
# 查询结果格式如下面的例子所示：
#
#  
#
# Logs 表：
# +----+-----+
# | Id | Num |
# +----+-----+
# | 1  | 1   |
# | 2  | 1   |
# | 3  | 1   |
# | 4  | 2   |
# | 5  | 1   |
# | 6  | 2   |
# | 7  | 2   |
# +----+-----+
#
# Result 表：
# +-----------------+
# | ConsecutiveNums |
# +-----------------+
# | 1               |
# +-----------------+
# 1 是唯一连续出现至少三次的数字。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/consecutive-numbers
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Logs;

CREATE TABLE Logs (
                        Id INT PRIMARY KEY AUTO_INCREMENT,
                        Num INT
);

# Case 1:
TRUNCATE TABLE Logs;
INSERT INTO Logs (Num) VALUES (1);
INSERT INTO Logs (Num) VALUES (1);
INSERT INTO Logs (Num) VALUES (1);
INSERT INTO Logs (Num) VALUES (2);
INSERT INTO Logs (Num) VALUES (1);
INSERT INTO Logs (Num) VALUES (2);
INSERT INTO Logs (Num) VALUES (2);
# Case 2:
TRUNCATE TABLE Logs;
INSERT INTO Logs (Num) VALUES (-1);
INSERT INTO Logs (Num) VALUES (-1);
INSERT INTO Logs (Num) VALUES (-1);
# Case 3:
TRUNCATE TABLE Logs;
INSERT INTO Logs (Num) VALUES (3);
INSERT INTO Logs (Num) VALUES (3);
INSERT INTO Logs (Num) VALUES (3);
INSERT INTO Logs (Num) VALUES (3);

# Solution：
## 自关联3次，然后C.Id = B.Id + 1且B.Id = A.Id + 1的情况下 让三个数字相等，然后再取非重复的A.Num
##
## 解答消耗参考:
## Runtime: 731 ms, 20.11%
## Memory Usage: 0 MB, 100.00%
SELECT DISTINCT A.Num AS ConsecutiveNums
FROM Logs A
         JOIN Logs B
         JOIN Logs C
WHERE C.Id = B.Id + 1
  AND B.Id = A.Id + 1
  AND A.Num = B.Num
  AND B.Num = C.Num;