# Author: reparo
# Date: 2022-08-29

# 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
#
# Customers 表：
#
# +----+-------+
# | Id | Name  |
# +----+-------+
# | 1  | Joe   |
# | 2  | Henry |
# | 3  | Sam   |
# | 4  | Max   |
# +----+-------+
# Orders 表：
#
# +----+------------+
# | Id | CustomerId |
# +----+------------+
# | 1  | 3          |
# | 2  | 1          |
# +----+------------+
# 例如给定上述表格，你的查询应返回：
#
# +-----------+
# | Customers |
# +-----------+
# | Henry     |
# | Max       |
# +-----------+
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/customers-who-never-order
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Orders;

CREATE TABLE Customers
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE Orders
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT
);

# Case 1:
TRUNCATE TABLE Customers;
INSERT INTO Customers (id, name) VALUES (1, 'Joe');
INSERT INTO Customers (id, name) VALUES (2, 'Henry');
INSERT INTO Customers (id, name) VALUES (3, 'Sam');
INSERT INTO Customers (id, name) VALUES (4, 'Max');

TRUNCATE TABLE Orders;
INSERT INTO Orders (id, customerId) VALUES (1, 3);
INSERT INTO Orders (id, customerId) VALUES (2, 1);

# Solution：
## 无技巧，GROUP BY的基础使用，先查出订购过的所有用户，再从Customers的查询结果中排除
##
## 解答消耗参考:
## Runtime: 511 ms, 88.62%
## Memory Usage: 0 MB, 100.00%
SELECT name AS `Customers`
FROM Customers
WHERE id NOT IN (SELECT DISTINCT(customerId)
                 FROM Orders);