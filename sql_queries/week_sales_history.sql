SELECT 'WEEK ' || EXTRACT(WEEK FROM sales_time) || ' in ' || 'YEAR ' || EXTRACT(YEAR FROM sales_time) ||
        ' has ' || COUNT(*) || ' orders' AS num_orders
    FROM sales_history
    GROUP BY EXTRACT(YEAR FROM sales_time), EXTRACT(WEEK FROM sales_time)
    ORDER BY EXTRACT(YEAR FROM sales_time), EXTRACT(WEEK FROM sales_time);

