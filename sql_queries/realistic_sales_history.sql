--  Q2 Realistic Sales History

SELECT
    TO_CHAR(sales_time, 'HH12') || ' ' || LOWER(TO_CHAR(sales_time, 'AM')) ||
    ' has ' || COUNT(sales_id) || ' orders totaling $' || TO_CHAR(SUM(total_price), 'FM9999990.00') AS hour_summary
FROM sales_history
GROUP BY TO_CHAR(sales_time, 'HH12') || ' ' || LOWER(TO_CHAR(sales_time, 'AM')), EXTRACT(HOUR FROM sales_time)
ORDER BY EXTRACT(HOUR FROM sales_time);