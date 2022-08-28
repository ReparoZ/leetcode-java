# Author: reparo
# Date: 2022-08-29

# 编写一个 SQL 查询，查找Person 表中所有重复的电子邮箱。
# 
# 示例：
# 
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# 根据以上输入，你的查询应返回以下结果：
# 
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+
# 说明：所有电子邮箱都是小写字母。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/duplicate-emails
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255)
);

# Case 1:
TRUNCATE TABLE Person;
INSERT INTO Person (id, email) VALUES ('1', 'a@b.com');
INSERT INTO Person (id, email) VALUES ('2', 'c@d.com');
INSERT INTO Person (id, email) VALUES ('3', 'a@b.com');

# Solution：
## 无技巧，GROUP BY的基础使用
##
## 解答消耗参考:
## Runtime: 418 ms, 33.20%
## Memory Usage: 0 MB, 100.00%
SELECT email AS Email FROM Person GROUP BY email HAVING COUNT(email) > 1;