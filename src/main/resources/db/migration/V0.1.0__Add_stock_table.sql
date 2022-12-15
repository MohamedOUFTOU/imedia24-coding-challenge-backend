ALTER TABLE  products
    ADD stock_id  BIGINT NOT NULL;

CREATE TABLE products_stock
(
    stock_id         BIGINT     NOT NULL AUTO_INCREMENT
        CONSTRAINT pk_product_stock_id PRIMARY KEY,
    quantity       DECIMAL           NOT NULL,
    created_at  TIMESTAMP     NOT NULL,
    updated_at  TIMESTAMP     NOT NULL
);
