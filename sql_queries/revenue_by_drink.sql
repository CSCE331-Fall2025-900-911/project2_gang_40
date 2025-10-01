SELECT 
    d.drink_name,
    SUM(o.quantity) AS total_sold,
    SUM(o.total_price) AS total_revenue
FROM orders o
JOIN drink_variation dv ON o.variation_id = dv.variation_id
JOIN drinks d ON dv.drink_id = d.drink_id
GROUP BY d.drink_name
ORDER BY total_sold DESC;

