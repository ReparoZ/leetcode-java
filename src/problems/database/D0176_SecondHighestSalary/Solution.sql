# Author: reparo
# Date: 2021-11-21

# 编写一个 SQL 查询，获取 Employee表中第二高的薪水（Salary）。
# 
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述Employee表，SQL查询应该返回200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
# 
# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/second-highest-salary
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

# Solution：
## 简单的对MAX的考察和对AS修改字段名的考察
##
## 解答消耗参考:
## Runtime: 209 ms, 68.25%
## Memory Usage: 0 MB, 100.00%
SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Salary < (SELECT MAX(Salary) FROM Employee);
