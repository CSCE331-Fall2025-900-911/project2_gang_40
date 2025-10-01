SELECT 
    'THESE ARE LOW: ' || ingredient_name || ' (Qty: ' || stock_quantity || ' ' || unit::text || ')' AS low_stock_items
FROM ingredients
WHERE stock_quantity <= 500
ORDER BY stock_quantity ASC;
