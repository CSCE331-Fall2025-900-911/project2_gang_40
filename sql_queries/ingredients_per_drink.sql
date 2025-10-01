SELECT
    d.drink_name,
    i.ingredient_name,
    di.quantity,
    i.unit
FROM drink_ingredients di
JOIN drinks d on di.drink_id = d.drink_id
JOIN ingredients i ON di.ingredient_id = i.ingredient_id
ORDER BY d.drink_name, i.ingredient_name;