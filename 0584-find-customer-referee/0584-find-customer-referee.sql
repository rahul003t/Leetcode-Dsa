# Write your MySQL query statement below
SELECT name FROM customer WHERE IFNULL(referee_id,0) <> 2