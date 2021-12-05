# Author: reparo
# Date: 2021-11-25

# 编写一个 SQL 查询来实现分数排名。
# 
# 如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
# 
# +----+-------+
# | Id | Score |
# +----+-------+
# | 1  | 3.50  |
# | 2  | 3.65  |
# | 3  | 4.00  |
# | 4  | 3.85  |
# | 5  | 4.00  |
# | 6  | 3.65  |
# +----+-------+
# 例如，根据上述给定的Scores 表，你的查询应该返回（按分数从高到低排列）：
# 
# +-------+------+
# | Score | Rank |
# +-------+------+
# | 4.00  | 1    |
# | 4.00  | 1    |
# | 3.85  | 2    |
# | 3.65  | 3    |
# | 3.65  | 3    |
# | 3.50  | 4    |
# +-------+------+
# 重要提示：对于 MySQL 解决方案，如果要转义用作列名的保留字，可以在关键字之前和之后使用撇号。例如 `Rank`
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/rank-scores
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

# DDL:
CREATE DATABASE IF NOT EXISTS leetcode DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE leetcode;
DROP TABLE IF EXISTS Scores;

CREATE TABLE Scores (
                          Id INT PRIMARY KEY AUTO_INCREMENT,
                          Score DECIMAL(3, 2)
);

INSERT INTO Scores (Score) VALUES (3.5);
INSERT INTO Scores (Score) VALUES (3.65);
INSERT INTO Scores (Score) VALUES (4.0);
INSERT INTO Scores (Score) VALUES (3.85);
INSERT INTO Scores (Score) VALUES (4.0);
INSERT INTO Scores (Score) VALUES (3.65);

# Solution：
## 用子查询查出来大于N的分数个数赋值Rank
##
## 解答消耗参考:
## Runtime: 731 ms, 20.11%
## Memory Usage: 0 MB, 100.00%
SELECT Score,
       (SELECT COUNT(DISTINCT Score) FROM Scores WHERE Score >= TEMP_TABLE.Score) AS 'Rank'
FROM Scores TEMP_TABLE
ORDER BY Score DESC;