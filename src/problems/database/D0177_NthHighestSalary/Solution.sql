# Author: reparo
# Date: 2021-11-25

# 编写一个 SQL 查询，获取 Employee 表中第n高的薪水（Salary）。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述Employee表，n = 2时，应返回第二高的薪水200。如果不存在第n高的薪水，那么查询应返回null。
#
# +------------------------+
# | getNthHighestSalary(2) |
# +------------------------+
# | 200                    |
# +------------------------+
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/nth-highest-salary
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
                          Id INT PRIMARY KEY AUTO_INCREMENT,
                          Salary INT
);

INSERT INTO Employee (Salary) VALUES (100);
INSERT INTO Employee (Salary) VALUES (200);
INSERT INTO Employee (Salary) VALUES (300);
DROP FUNCTION IF EXISTS getNthHighestSalary;

# Solution：
## 用子查询先查出来前N个，然后在找其中最小的，如果查询的名次超过了总数据量，则用条件判断语句识别并返回NULL
##
## 解答消耗参考:
## Runtime: 376 ms, 52.49%
## Memory Usage: 0 MB, 100.00%
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT READS SQL DATA
BEGIN
    RETURN (
        SELECT IF(N <= COUNT(*), MIN(Salary), NULL) FROM (SELECT Salary FROM Employee GROUP BY Salary ORDER BY Salary DESC LIMIT N) SalaryTable
        );
END;

# Test:
SELECT getNthHighestSalary(1), getNthHighestSalary(2), getNthHighestSalary(3), getNthHighestSalary(4);