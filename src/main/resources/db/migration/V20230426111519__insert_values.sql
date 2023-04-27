SET SCHEMA ecommerce;

INSERT INTO `users`(name, created_at, updated_at) VALUES
    ('bhagavan', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    ('ram', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    ('gopi', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    ('shaym', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());



INSERT INTO `products`(id, category, title, description, price, created_at, updated_at) VALUES
    (UUID(), 'electronics', 'lenovo think pad', 'laptop with high performances', 250.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    (UUID(), 'electronics', 'hp pavilion', 'laptop with high performances', 275.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    (UUID(), 'electronics', 'canon', 'capture memories', 325.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    (UUID(), 'electronics', 'iphone', 'iphone 14', 300.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    (UUID(), 'clothing', 'Levis t-shirt', 'printed t-shirt from levis', 60.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
    (UUID(), 'groceries', 'Onion', 'price per pound', 2.00, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());