# Author: reparo
# Date: 2022-08-29

# 表: Employee
#
# +--------------+---------+
# | Column Name  | Type    |
# +--------------+---------+
# | id           | int     |
# | name         | varchar |
# | salary       | int     |
# | departmentId | int     |
# +--------------+---------+
# Id是该表的主键列。
# departmentId是Department表中ID的外键。
# 该表的每一行都表示员工的ID、姓名和工资。它还包含了他们部门的ID。
#
#
# 表: Department
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | name        | varchar |
# +-------------+---------+
# Id是该表的主键列。
# 该表的每一行表示部门ID和部门名。
#
#
# 公司的主管们感兴趣的是公司每个部门中谁赚的钱最多。一个部门的 高收入者 是指一个员工的工资在该部门的 不同 工资中 排名前三 。
#
# 编写一个SQL查询，找出每个部门中 收入高的员工 。
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
# +----+-------+--------+--------------+
# | id | name  | salary | departmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 85000  | 1            |
# | 2  | Henry | 80000  | 2            |
# | 3  | Sam   | 60000  | 2            |
# | 4  | Max   | 90000  | 1            |
# | 5  | Janet | 69000  | 1            |
# | 6  | Randy | 85000  | 1            |
# | 7  | Will  | 70000  | 1            |
# +----+-------+--------+--------------+
# Department  表:
# +----+-------+
# | id | name  |
# +----+-------+
# | 1  | IT    |
# | 2  | Sales |
# +----+-------+
# 输出:
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Max      | 90000  |
# | IT         | Joe      | 85000  |
# | IT         | Randy    | 85000  |
# | IT         | Will     | 70000  |
# | Sales      | Henry    | 80000  |
# | Sales      | Sam      | 60000  |
# +------------+----------+--------+
# 解释:
# 在IT部门:
# - Max的工资最高
# - 兰迪和乔都赚取第二高的独特的薪水
# - 威尔的薪水是第三高的
#
# 在销售部:
# - 亨利的工资最高
# - 山姆的薪水第二高
# - 没有第三高的工资，因为只有两名员工
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/department-top-three-salaries/
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
INSERT INTO Employee (id, name, salary, departmentId) VALUES (1, 'Joe', 85000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (2, 'Henry', 80000, 2);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (3, 'Sam', 60000, 2);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (4, 'Max', 90000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (5, 'Janet', 69000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (6, 'Randy', 85000, 1);
INSERT INTO Employee (id, name, salary, departmentId) VALUES (7, 'Will', 70000, 1);

TRUNCATE TABLE Department;
INSERT INTO Department (id, name) VALUES (1, 'IT');
INSERT INTO Department (id, name) VALUES (2, 'Sales');

# Solution 1：
## 开窗函数DENSE_RANK、PARTITION的基础使用，使用了子查询
##
## 解答消耗参考:
## Runtime: 898 ms, 75.70%
## Memory Usage: 0 MB, 100.00%
SELECT Department, Employee, Salary
FROM (SELECT D.name                                                             AS Department,
             Employee.name                                                      AS Employee,
             salary                                                             AS Salary,
             DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS `Rank`
      FROM Employee
               JOIN Department D on Employee.departmentId = D.id) AS ED
WHERE `Rank` < 4;

# Solution 2：
## 开窗函数DENSE_RANK、PARTITION的基础使用，并且使用了MySQL CTE(公共表表达式)
##
## 解答消耗参考:
## Runtime: 913 ms, 66.76%
## Memory Usage: 0 MB, 100.00%
WITH Salary_Rank AS (SELECT D.name                                                             AS Department,
                            Employee.name                                                      AS Employee,
                            salary                                                             AS Salary,
                            DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS `Rank`
                     FROM Employee
                              JOIN Department D on Employee.departmentId = D.id)
SELECT Department, Employee, Salary
FROM Salary_Rank
WHERE `Rank` < 4;