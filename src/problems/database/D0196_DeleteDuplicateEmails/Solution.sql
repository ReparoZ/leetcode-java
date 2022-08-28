# Author: reparo
# Date: 2022-08-29

# 表: Person
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | email       | varchar |
# +-------------+---------+
# id是该表的主键列。
# 该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。
#
#
# 编写一个 SQL 删除语句来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。
#
# 以 任意顺序 返回结果表。 （注意： 仅需要写删除语句，将自动对剩余结果进行查询）
#
# 查询结果格式如下所示。
#
#
#
#
#
# 示例 1:
#
# 输入:
# Person 表:
# +----+------------------+
# | id | email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# 输出:
# +----+------------------+
# | id | email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+
# 解释: john@example.com重复两次。我们保留最小的Id = 1。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/delete-duplicate-emails/
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    email         VARCHAR(255)
);

# Case 1:
TRUNCATE TABLE Person;
INSERT INTO Person (id, email) VALUES (1, 'john@example.com');
INSERT INTO Person (id, email) VALUES (2, 'bob@example.com');
INSERT INTO Person (id, email) VALUES (3, 'john@example.com');
INSERT INTO Person (id, email) VALUES (4, 'john@example.com');

# Solution 1：
## 自主关联找到除了最小ID之外的其他重复ID，然后通过子查询的方式规避同一个SQL中先查询再UPDATE，然后删除
##
## 解答消耗参考:
## Runtime: 593 ms, 87.33%
## Memory Usage: 0 MB, 100.00%
DELETE
FROM Person
WHERE id IN (SELECT *
             FROM (SELECT DISTINCT(P.id)
                   FROM Person
                            JOIN Person P on Person.email = P.email AND Person.id < P.id) as PPi);