INSERT INTO recipetask.ingredient (category, name)
VALUES
    ('Vegetable', 'Carrot'),
    ('Meat', 'Chicken Breast'),
    ('Dairy', 'Cheddar Cheese'),
    ('Grain', 'Rice');


INSERT INTO recipetask.recipe (cooking_time, servings, instructions, name)
VALUES
    (30, 4, 'Cook rice and chicken separately, then combine.', 'Chicken Rice Bowl'),
    (60, 6, 'Bake at 350°F for 45 minutes.', 'Cheese Casserole'),
    (45, 8, 'Chop carrots and cook with broth.', 'Carrot Soup');


-- For Chicken Rice Bowl (recipe ID = 1)
INSERT INTO recipetask.recipe_ingredients (ingredients_id, recipes_id)
VALUES
    (1, 1),  -- Carrot used in Chicken Rice Bowl
    (2, 1),  -- Chicken Breast used in Chicken Rice Bowl
    (4, 1);  -- Rice used in Chicken Rice Bowl

-- For Cheese Casserole (recipe ID = 2)
INSERT INTO recipetask.recipe_ingredients (ingredients_id, recipes_id)
VALUES
    (3, 2),  -- Cheddar Cheese used in Cheese Casserole
    (4, 2);  -- Rice used in Cheese Casserole

-- For Carrot Soup (recipe ID = 3)
INSERT INTO recipetask.recipe_ingredients (ingredients_id, recipes_id)
VALUES
    (1, 3);  -- Carrot used in Carrot Soup