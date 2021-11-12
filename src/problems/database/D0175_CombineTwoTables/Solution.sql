# Author: reparo
# Date: 2021-11-13

# 表1: Person
# 
# +-------------+---------+
# | 列名         | 类型     |
# +-------------+---------+
# | PersonId    | int     |
# | FirstName   | varchar |
# | LastName    | varchar |
# +-------------+---------+
# PersonId 是上表主键
# 表2: Address
# 
# +-------------+---------+
# | 列名         | 类型    |
# +-------------+---------+
# | AddressId   | int     |
# | PersonId    | int     |
# | City        | varchar |
# | State       | varchar |
# +-------------+---------+
# AddressId 是上表主键
# 
# 
# 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供person 的以下信息：
# 
# FirstName, LastName, City, State
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/combine-two-tables
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Address;

CREATE TABLE Person (
  PersonId INT PRIMARY KEY AUTO_INCREMENT,
  FirstName VARCHAR(255),
  LastName VARCHAR(255)
);

CREATE TABLE Address (
  AddressId INT PRIMARY KEY AUTO_INCREMENT,
  PersonId INT,
  City VARCHAR(255),
  State VARCHAR(255)
);

INSERT INTO Person (FirstName, LastName) VALUES ('Milagros', 'Sanford');
INSERT INTO Person (FirstName, LastName) VALUES ('Selma', 'Dotson');
INSERT INTO Person (FirstName, LastName) VALUES ('Doug', 'Mccall');
INSERT INTO Person (FirstName, LastName) VALUES ('Tommie', 'Gilmore');
INSERT INTO Person (FirstName, LastName) VALUES ('Joann', 'Mccarty');
INSERT INTO Person (FirstName, LastName) VALUES ('Ed', 'Dillard');
INSERT INTO Person (FirstName, LastName) VALUES ('Morton', 'Franco');
INSERT INTO Person (FirstName, LastName) VALUES ('Edwin', 'Wall');
INSERT INTO Person (FirstName, LastName) VALUES ('Claudette', 'Cook');
INSERT INTO Person (FirstName, LastName) VALUES ('Nita', 'Morgan');

INSERT INTO Address (PersonId, City, State) VALUES (1, 'Massillon', 'OH');
INSERT INTO Address (PersonId, City, State) VALUES (2, 'Akron', 'OH');
INSERT INTO Address (PersonId, City, State) VALUES (4, 'Albany', 'NY');
INSERT INTO Address (PersonId, City, State) VALUES (5, 'Akron', 'OH');
INSERT INTO Address (PersonId, City, State) VALUES (7, 'Vancouver', 'WA');
INSERT INTO Address (PersonId, City, State) VALUES (8, 'Miami', 'FL');
INSERT INTO Address (PersonId, City, State) VALUES (9, 'Passadena', 'CA');
INSERT INTO Address (PersonId, City, State) VALUES (10, 'Austin', 'TX');

# Solution：
## 简单的对LEFT JOIN的使用，即使右表中没有匹配，也从左表返回所有的行
##
## 解答消耗参考:
## Runtime: 391 ms, 59.20%
## Memory Usage: 0 MB, 100.00%
SELECT FirstName, LastName, City, State FROM Person LEFT JOIN Address A on Person.PersonId = A.PersonId;