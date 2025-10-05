SELECT 'WEEK ' || TO_CHAR(DATE_TRUNC('week', sales_time), 'IW') 
        || ' in YEAR ' || TO_CHAR(DATE_TRUNC('week', sales_time), 'IYYY') AS week_label,
    COUNT(*) AS num_orders
FROM sales_history
GROUP BY DATE_TRUNC('week', sales_time)
ORDER BY MIN(DATE_TRUNC('week', sales_time));
