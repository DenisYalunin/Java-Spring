-- liquibase formatted sql

-- changeset admin:1
CREATE TABLE categories (
                            id BIGSERIAL PRIMARY KEY,
                            title VARCHAR(255) NOT NULL
);

CREATE TABLE news (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      text TEXT NOT NULL,
                      date TIMESTAMP WITH TIME ZONE NOT NULL,
                      category_id BIGINT REFERENCES categories(id)
);