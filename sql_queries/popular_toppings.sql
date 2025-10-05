SELECT
    t.topping_name,
    COUNT(o.quantity) as num_sold,
    SUM(o.price) as total_revenue
FROM orders o
JOIN drink_variation dv ON o.variation_id = dv.variation_id
JOIN toppings t ON dv.topping_id = t.topping_id
GROUP BY t.topping_name
ORDER BY num_sold DESC;