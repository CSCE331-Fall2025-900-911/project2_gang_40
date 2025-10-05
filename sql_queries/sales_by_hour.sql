SELECT 
    COUNT(*) AS total_orders,
    SUM(total_price) AS total_sales
FROM sales_history
WHERE DATE(sales_time) = '2025-10-01'
  AND EXTRACT(HOUR FROM sales_time) = 12;
