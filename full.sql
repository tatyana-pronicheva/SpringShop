START TRANSACTION;
DROP TABLE IF EXISTS products_list;
CREATE TABLE products_list (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(50), cost INT);
INSERT INTO products_list (title, cost) VALUES ('Milk', 50), ('Bread', 20), ('Meat', 200), ('Butter', 200), ('Eggs', 100);
COMMIT;