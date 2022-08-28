# Author: reparo
# Date: 2022-08-29

# 表：Employee
# 
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | name        | varchar |
# | salary      | int     |
# | managerId   | int     |
# +-------------+---------+
# Id是该表的主键。
# 该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
# 
# 
# 编写一个SQL查询来查找收入比经理高的员工。
# 
# 以 任意顺序 返回结果表。
# 
# 查询结果格式如下所示。
# 
# 
# 
# 示例 1:
# 
# 输入: 
# Employee 表:
# +----+-------+--------+-----------+
# | id | name  | salary | managerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | Null      |
# | 4  | Max   | 90000  | Null      |
# +----+-------+--------+-----------+
# 输出: 
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
# 解释: Joe 是唯一挣得比经理多的雇员。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/employees-earning-more-than-their-managers
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255),
    salary    INT,
    managerId INT
);

# Case 1:
TRUNCATE TABLE Employee;
INSERT INTO Employee (id, name, salary, managerId) VALUES ('1', 'Joe', 70000, 3);
INSERT INTO Employee (id, name, salary, managerId) VALUES ('2', 'Henry', 80000, 4);
INSERT INTO Employee (id, name, salary, managerId) VALUES ('3', 'Sam', 60000, NULL);
INSERT INTO Employee (id, name, salary, managerId) VALUES ('4', 'Max', 90000, NULL);

# Solution：
## 无技巧，非常简单的自关联
##
## 解答消耗参考:
## Runtime: 391 ms, 66.13%
## Memory Usage: 0 MB, 100.00%
SELECT Employee.name AS `Employee` FROM Employee JOIN Employee E on Employee.managerId = E.id WHERE Employee.salary > E.salary;