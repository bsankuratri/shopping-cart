CREATE SCHEMA IF NOT EXISTS ecommerce;
SET SCHEMA ecommerce;

CREATE TABLE IF NOT EXISTS `users` (
    `name` varchar(36) NOT NULL PRIMARY KEY,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS `products` (
    `id` varchar(36) NOT NULL PRIMARY KEY,
    `category` varchar(50) NOT NULL,
    `title` varchar(100) NOT NULL,
    `description` varchar(1024),
    `price` DOUBLE PRECISION NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS `cart` (
    `user_name` varchar(36) NOT NULL,
    `product_id` varchar(36) NOT NULL,
    `quantity` INTEGER NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);