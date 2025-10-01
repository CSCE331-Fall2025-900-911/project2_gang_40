-- Q5 Best of the Worst

-- Use this command to change which day you want to see the peak sales
-- \set week_number 20

WITH week_sales AS (
    SELECT 
        DATE(sales_time) AS sales_day,
        SUM(total_price) AS daily_sales
    FROM sales_history
    WHERE EXTRACT(WEEK FROM sales_time) = :'week_number'
    GROUP BY DATE(sales_time)
),
lowest_day AS (
    SELECT sales_day, daily_sales
    FROM week_sales
    ORDER BY daily_sales ASC
    LIMIT 1
),
top_item AS (
    SELECT 
        d.drink_name,
        SUM(o.quantity) AS total_sold
    FROM orders o
    JOIN sales_history s ON o.sales_id = s.sales_id
    JOIN drink_variation v ON o.variation_id = v.variation_id
    JOIN drinks d ON v.drink_id = d.drink_id
    WHERE DATE(s.sales_time) = (SELECT sales_day FROM lowest_day)
    GROUP BY d.drink_name
    ORDER BY total_sold DESC
    LIMIT 1
)
SELECT 
    TO_CHAR(ld.sales_day, 'FMMonth DD, YYYY') ||
    ' has lowest sales of $' || ROUND(ld.daily_sales, 2) ||
    ' for week ' || EXTRACT(WEEK FROM ld.sales_day)::INT ||
    ' with ' || ti.drink_name || ' as top seller' AS result
FROM lowest_day ld
JOIN top_item ti ON TRUE;