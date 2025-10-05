-- Gets top 10 highest spending customers

SELECT 
    c.first_name || ' ' || c.last_name AS customer_name,
    SUM(s.total_price) AS total_spent,
    COUNT(s.sales_id) AS num_orders
FROM sales_history s
JOIN customers c ON s.customer_id = c.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
ORDER BY total_spent DESC
LIMIT 10;