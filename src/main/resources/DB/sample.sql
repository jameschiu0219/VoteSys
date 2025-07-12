-- 初始資料匯入

INSERT INTO users (`username`, `password`, `role`) VALUES
('Leo','111','user'),
('Sandy','111','user'),
('Randy','111','user'),
('RSY','111','user'),
('James','111','admin');

INSERT INTO vote_item (item_name) VALUES ('珍珠奶茶'), ('綠茶');

INSERT INTO vote_record (voter_name, item_id) VALUES
('Leo', 1),
('Sandy', 1),
('Sandy', 2),
('Randy', 2),
('RSY', 2);


