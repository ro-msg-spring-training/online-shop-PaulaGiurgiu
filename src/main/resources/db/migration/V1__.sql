CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE location_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE product_category_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE revenue_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE supplier_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE customer
(
    id         INT          NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE location
(
    id      INT NOT NULL,
    name    VARCHAR(255),
    country VARCHAR(255),
    city    VARCHAR(255),
    county  VARCHAR(255),
    street  VARCHAR(255),
    CONSTRAINT pk_location PRIMARY KEY (id)
);

CREATE TABLE "order"
(
    id          INT NOT NULL,
    location_id INT,
    customer_id INT,
    created     date,
    country     VARCHAR(255),
    city        VARCHAR(255),
    county      VARCHAR(255),
    street      VARCHAR(255),
    CONSTRAINT pk_order PRIMARY KEY (id)
);

CREATE TABLE order_detail
(
    quantity   INT,
    order_id   INT NOT NULL,
    product_id INT NOT NULL,
    CONSTRAINT pk_order_detail PRIMARY KEY (order_id, product_id)
);

CREATE TABLE product
(
    id                  INT NOT NULL,
    name                VARCHAR(255),
    description         VARCHAR(1000),
    price               DECIMAL,
    weight              DOUBLE PRECISION,
    product_category_id INT,
    supplier_id         INT,
    image_url           VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_category
(
    id          INT NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(1000),
    CONSTRAINT pk_product_category PRIMARY KEY (id)
);

CREATE TABLE revenue
(
    id          INT NOT NULL,
    location_id INT,
    date        date,
    sum         DECIMAL,
    CONSTRAINT pk_revenue PRIMARY KEY (id)
);

CREATE TABLE stock
(
    quantity    INT,
    location_id INT NOT NULL,
    product_id  INT NOT NULL,
    CONSTRAINT pk_stock PRIMARY KEY (location_id, product_id)
);

CREATE TABLE supplier
(
    id   INT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_supplier PRIMARY KEY (id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_password UNIQUE (password);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_username UNIQUE (username);

ALTER TABLE location
    ADD CONSTRAINT uc_location_country UNIQUE (country);

ALTER TABLE "order"
    ADD CONSTRAINT uc_order_country UNIQUE (country);

ALTER TABLE order_detail
    ADD CONSTRAINT FK_ORDER_DETAIL_ON_ORDER FOREIGN KEY (order_id) REFERENCES "order" (id);

ALTER TABLE order_detail
    ADD CONSTRAINT FK_ORDER_DETAIL_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_LOCATION FOREIGN KEY (location_id) REFERENCES location (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCT_CATEGORY FOREIGN KEY (product_category_id) REFERENCES product_category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES supplier (id);

ALTER TABLE revenue
    ADD CONSTRAINT FK_REVENUE_ON_LOCATION FOREIGN KEY (location_id) REFERENCES location (id);

ALTER TABLE stock
    ADD CONSTRAINT FK_STOCK_ON_LOCATION FOREIGN KEY (location_id) REFERENCES location (id);

ALTER TABLE stock
    ADD CONSTRAINT FK_STOCK_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);