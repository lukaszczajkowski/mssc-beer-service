CREATE TABLE beer
(
    id VARCHAR,
    version INTEGER,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    beer_name VARCHAR,
    beer_style VARCHAR,
    upc VARCHAR,
    price DECIMAL,
    min_on_hand INTEGER,
    quantity_to_brew INTEGER
);