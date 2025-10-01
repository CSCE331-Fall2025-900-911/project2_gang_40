SELECT 
    TO_CHAR(sales_time, 'Day') AS day_of_week,
    COUNT(sales_id) AS num_orders,
    SUM(total_price) AS total_sales
FROM sales_history
GROUP BY TO_CHAR(sales_time, 'Day')
ORDER BY total_sales DESC;