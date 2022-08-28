# Author: reparo
# Date: 2022-08-29

# 表：Employee
# 
# +--------------+---------+
# | 列名          | 类型    |
# +--------------+---------+
# | id           | int     |
# | name         | varchar |
# | salary       | int     |
# | departmentId | int     |
# +--------------+---------+
# id是此表的主键列。
# departmentId是Department表中ID的外键。
# 此表的每一行都表示员工的ID、姓名和工资。它还包含他们所在部门的ID。
# 
# 
# 表：Department
# 
# +-------------+---------+
# | 列名         | 类型    |
# +-------------+---------+
# | id          | int     |
# | name        | varchar |
# +-------------+---------+
# id是此表的主键列。
# 此表的每一行都表示一个部门的ID及其名称。
# 
# 
# 编写SQL查询以查找每个部门中薪资最高的员工。
# 按 任意顺序 返回结果表。
# 查询结果格式如下例所示。
# 
# 
# 
# 示例 1:
# 
# 输入：
# Employee 表:
# +----+-------+--------+--------------+
# | id | name  | salary | departmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 70000  | 1            |
# | 2  | Jim   | 90000  | 1            |
# | 3  | Henry | 80000  | 2            |
# | 4  | Sam   | 60000  | 2            |
# | 5  | Max   | 90000  | 1            |
# +----+-------+--------+--------------+
# Department 表:
# +----+-------+
# | id | name  |
# +----+-------+
# | 1  | IT    |
# | 2  | Sales |
# +----+-------+
# 输出：
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Jim      | 90000  |
# | Sales      | Henry    | 80000  |
# | IT         | Max      | 90000  |
# +------------+----------+--------+
# 解释：Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/department-highest-salary
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;

CREATE TABLE Employee
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(255),
    salary       INT,
    departmentId INT
);

CREATE TABLE Department
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

# Case 1:
TRUNCATE TABLE Employee;
INSERT INTO Employee (id, name, salary, departmentId) VALUES (1, 'Joe', 70000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (2, 'Jim', 90000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (3, 'Henry', 80000, 2);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (4, 'Sam', 60000, 2);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (5, 'Max', 90000, 1);

TRUNCATE TABLE Department;
INSERT INTO Department (id, name) VALUES (1, 'IT');
INSERT INTO Department (id, name) VALUES (2, 'Sales');

# Solution 1：
## 开窗函数RANK、PARTITION的基础使用，使用了子查询
##
## 解答消耗参考:
## Runtime: 713 ms, 43.81%
## Memory Usage: 0 MB, 100.00%
SELECT Department, Employee, Salary
FROM (SELECT D.name                                                       AS Department,
             Employee.name                                                AS Employee,
             salary                                                       AS Salary,
             RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS `Rank`
      FROM Employee
               JOIN Department D on Employee.departmentId = D.id) AS ED
WHERE `Rank` = 1;

# Solution 2：
## 开窗函数RANK、PARTITION的基础使用，并且使用了MySQL CTE(公共表表达式)
##
## 解答消耗参考:
## Runtime: 659 ms, 87.70%
## Memory Usage: 0 MB, 100.00%
WITH Salary_Rank AS (SELECT D.name                                                       AS Department,
                            Employee.name                                                AS Employee,
                            salary                                                       AS Salary,
                            RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS `Rank`
                     FROM Employee
                              JOIN Department D on Employee.departmentId = D.id)
SELECT Department, Employee, Salary
FROM Salary_Rank
WHERE `Rank` = 1;