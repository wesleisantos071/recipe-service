INSERT INTO type_of_unity (id, name) VALUES (0, 'Unknown');
INSERT INTO type_of_unity (id, name) VALUES (1, 'Volume');
INSERT INTO type_of_unity (id, name) VALUES (2, 'Weight');
INSERT INTO type_of_unity (id, name) VALUES (3, 'Lenght');
INSERT INTO type_of_unity (id, name) VALUES (4, 'Quantity');

--UOM volume
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (1, 'ml',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (2, 'l',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (3, 'dl',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (4, 'cc',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (5, 'tsp',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (6, 'tbsp',	1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (7, 'fl oz',	1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (8, 'gill',	1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (9, 'cup',		1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (10, 'pint',	1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (11, 'quart',	1);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (12, 'gallon',	1);
--UOM weight
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (14, 'mg',		2);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (15, 'g',		2);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (16, 'kg',		2);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (17, 'ounce',	2);
--UOM lenght
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (18, 'mm',		3);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (19, 'cm',		3);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (20, 'm',		3);
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (21, 'inch',	3);
--Quantity
INSERT INTO unity_of_measure (id, name, type_of_unity_id) VALUES (22, 'cloves',	4);



--ingredients
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	1	,'Salt',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	2	,'Sugar',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	3	,'Pepper',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	4	,'Cayenne Pepper',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	5	,'Crushed red pepper flakes',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	6	,'Curry powder',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	7	,'Chili powder',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	8	,'Cumin',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	9	,'Cinnamon',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	10	,'Garlic powder',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	11	,'Onion powder',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	12	,'Oregano',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	13	,'Paprika',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	14	,'Seasoned salt',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	15	,'Milk',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	16	,'Butter',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	17	,'Margarine',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	18	,'Tomato sauce',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	19	,'Olive Oil',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	20	,'Coconut Oil',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	21	,'Balsamic Vinegar',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	22	,'White Vinegar',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	23	,'Wine Vinegars',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	24	,'Soy sauce',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	25	,'Hot sauce',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	26	,'Ketchup',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	27	,'Yellow Mustard',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	28	,'Dijon Mustard',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	29	,'Mayonnaise',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	30	,'Vanilla extract',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	31	,'Spinach',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	32	,'Spaghetti',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	33	,'Rice',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	34	,'Lentils',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	35	,'Onions',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	36	,'Garlic',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	37	,'Potatoes',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	38	,'Eggs',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	39	,'Red Meat',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	40	,'Chicken',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	41	,'Duck',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	42	,'Shrimp',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	43	,'Fish',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	44	,'Pork',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	45	,'Parmesan cheese',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	46	,'Cheddar cheese',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	47	,'Mozzarella cheese',	FALSE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	48	,'Any cheese',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	49	,'Chicken breasts',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	50	,'Ground beef',	TRUE	,	TRUE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	51	,'Lemon',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	52	,'Orange',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	53	,'Banana',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	54	,'Avocado',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	55	,'Vanilla stick',	FALSE	,	FALSE	);
INSERT INTO ingredient (id, name, is_meat, is_animal_originated) VALUES (	56	,'Salmon',	TRUE	,	TRUE	);

