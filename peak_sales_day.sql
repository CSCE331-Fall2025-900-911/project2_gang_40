-- Q3 Peak Sales Day

-- Use this command to change which day you want to see the peak sales
-- \set input_date '2025-08-25'

WITH ranked_sales AS (
    SELECT
        DATE(sales_time) AS sales_day,
        total_price,
        ROW_NUMBER() OVER (
            PARTITION BY DATE(sales_time)
            ORDER BY total_price DESC
        ) AS rn
    FROM sales_history
    WHERE DATE(sales_time) = DATE :'input_date'
)
SELECT 
    TO_CHAR(sales_day, 'FMMonth DD, YYYY') || 
    ' has $' || ROUND(SUM(total_price), 2) || ' of top sales' AS result
FROM ranked_sales
WHERE rn <= 10
GROUP BY sales_day;