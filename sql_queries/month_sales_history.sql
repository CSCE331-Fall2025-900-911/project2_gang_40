SELECT TO_CHAR(sales_time, 'Mon YYYY') || ' has ' || COUNT(*) || ' orders' AS num_orders
FROM sales_history
GROUP BY TO_CHAR(sales_time, 'Mon YYYY')
ORDER BY MIN(sales_time);