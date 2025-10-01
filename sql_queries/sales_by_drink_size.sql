-- Gets total sales by all drink sizes

SELECT
    ds.size_name as drink_size,
    COUNT(o.quantity) as num_sold,
    SUM(o.price) as total_revenue
FROM orders o
JOIN drink_variation dv ON o.variation_id = dv.variation_id
JOIN drink_sizes ds ON dv.size_id = ds.size_id
GROUP BY ds.size_name
ORDER BY num_sold DESC;