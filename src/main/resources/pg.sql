CREATE TABLE users (
 id SERIAL PRIMARY KEY,
 login text NOT NULL UNIQUE,
 password text NOT NULL,
 mail text,
 admin boolean
);

CREATE TABLE orders (
 id SERIAL PRIMARY KEY,
 users_id int NOT NULL REFERENCES users(id),
 customer text NOT NULL,
 order_products char(60) NOT NULL,
 order_date date,
 order_price int NOT NULL
)