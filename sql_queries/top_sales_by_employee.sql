SELECT 
    e.first_name || ' ' || e.last_name AS employee_name,
    SUM(s.total_price) as total_spent,
    COUNT(s.sales_id) as num_orders
FROM sales_history s
JOIN employees e ON s.employee_id = e.employee_id
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY num_orders DESC;