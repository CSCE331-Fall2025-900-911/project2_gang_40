CREATE TABLE ingredients (
    ingredient_id INT PRIMARY KEY,
    ingredient_name VARCHAR(50) NOT NULL,
    unit VARCHAR(20),        
    stock_quantity DECIMAL(10,2) DEFAULT 0
);

INSERT INTO Ingredients (ingredient_id, ingredient_name, unit, stock_quantity) VALUES
(1, 'Black Tea Leaves', 'grams', 1000),
(2, 'Green Tea Leaves', 'grams', 800),
(3, 'Thai Tea Mix', 'grams', 500),
(4, 'Milk', 'ml', 2000),
(5, 'Condensed Milk', 'ml', 500),
(6, 'Oat Milk', 'ml', 500),
(7, 'Sugar Syrup', 'ml', 1000),
(8, 'Honey', 'ml', 500),
(9, 'Brown Sugar Syrup', 'ml', 500),
(10, 'Mango Syrup', 'ml', 300),
(11, 'Peach Syrup', 'ml', 300),
(12, 'Lychee Syrup', 'ml', 300),
(13, 'Passion Fruit Syrup', 'ml', 300),
(14, 'Strawberry Syrup', 'ml', 300),
(15, 'Coconut Syrup', 'ml', 300),
(16, 'Tapioca Pearls', 'grams', 1000),
(17, 'Coffee Jelly', 'grams', 500),
(18, 'Honey Jelly', 'grams', 500),
(19, 'Pudding', 'grams', 500),
(20, 'Crystal Boba', 'grams', 300),
(21, 'Mango Popping Boba', 'grams', 300),
(22, 'Strawberry Popping Boba', 'grams', 300),
(23, 'Ice Cream', 'grams', 500),
(24, 'Creama', 'grams', 300);

