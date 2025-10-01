SELECT EXTRACT(YEAR FROM sales_time) AS year,
       EXTRACT(WEEK FROM sales_time) AS week,
       SUM(total_price) AS total_sales,
       COUNT(*) AS num_orders
FROM sales_history
GROUP BY year, week
ORDER BY year, week;

