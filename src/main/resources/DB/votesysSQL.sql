-- 建立使用者資料表（Spring Security + JWT 登入）
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(100) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role` VARCHAR(50) NOT NULL
);

-- 建立投票項目表
CREATE TABLE IF NOT EXISTS vote_item  (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL
);

-- 建立投票紀錄表（複合主鍵：使用者 + 項目）
CREATE TABLE IF NOT EXISTS vote_record (
    voter_name VARCHAR(100),
    item_id INT,
    FOREIGN KEY (item_id) REFERENCES vote_item(item_id),
    Primary key(voter_name,item_id)
);

-- Stored Procedure：後台新增投票項目
DELIMITER //

CREATE PROCEDURE add_vote_item(IN itemName VARCHAR(255))
BEGIN
    INSERT INTO vote_item (item_name) VALUES (itemName);
END//

-- Stored Procedure：對指定項目投票
CREATE PROCEDURE vote(IN voter VARCHAR(100), IN itemId INT)
BEGIN
    INSERT INTO vote_record (voter_name, item_id) VALUES (voter, itemId);
END//

DELIMITER ;