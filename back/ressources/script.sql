-- Table User
CREATE TABLE User
(
    id         BIGINT PRIMARY KEY,
    username   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL
);

-- Table UserProfile
CREATE TABLE UserProfile
(
    id            BIGINT PRIMARY KEY,
    user_id       BIGINT       NOT NULL,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    date_of_birth DATE         NOT NULL,
    address       VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES User (id)
);

-- Table Agency
CREATE TABLE Agency
(
    id      BIGINT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city    VARCHAR(255),
    country VARCHAR(255)
);

-- Table VehicleCategory
CREATE TABLE VehicleCategory
(
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    acriss_code VARCHAR(10)
);

-- Table RentalOffer
CREATE TABLE RentalOffer
(
    id                  BIGINT PRIMARY KEY,
    agency_id           BIGINT         NOT NULL,
    vehicle_category_id BIGINT         NOT NULL,
    departure_city      VARCHAR(255)   NOT NULL,
    return_city         VARCHAR(255)   NOT NULL,
    start_date          TIMESTAMP      NOT NULL,
    end_date            TIMESTAMP      NOT NULL,
    price               DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (agency_id) REFERENCES Agency (id),
    FOREIGN KEY (vehicle_category_id) REFERENCES VehicleCategory (id)
);

-- Table Reservation
CREATE TABLE Reservation
(
    id              BIGINT PRIMARY KEY,
    user_id         BIGINT         NOT NULL,
    rental_offer_id BIGINT         NOT NULL,
    start_date      TIMESTAMP      NOT NULL,
    end_date        TIMESTAMP      NOT NULL,
    total_price     DECIMAL(10, 2) NOT NULL,
    created_at      TIMESTAMP      NOT NULL,
    updated_at      TIMESTAMP      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (rental_offer_id) REFERENCES RentalOffer (id)
);

-- Table Payment
CREATE TABLE Payment
(
    id             BIGINT PRIMARY KEY,
    reservation_id BIGINT         NOT NULL,
    status         VARCHAR(50)    NOT NULL,
    amount         DECIMAL(10, 2) NOT NULL,
    payment_date   TIMESTAMP      NOT NULL,
    provider       VARCHAR(255),
    FOREIGN KEY (reservation_id) REFERENCES Reservation (id)
);

-- Table Favorite
CREATE TABLE Favorite
(
    id       BIGINT PRIMARY KEY,
    user_id  BIGINT NOT NULL,
    offer_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (offer_id) REFERENCES RentalOffer (id)
);

-- Table UserPreferences
CREATE TABLE UserPreferences
(
    id                    BIGINT PRIMARY KEY,
    user_id               BIGINT NOT NULL,
    language              VARCHAR(50),
    currency              VARCHAR(10),
    notifications_enabled BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES User (id)
);

-- Table Notification
CREATE TABLE Notification
(
    id         BIGINT PRIMARY KEY,
    user_id    BIGINT    NOT NULL,
    content    TEXT      NOT NULL,
    type       VARCHAR(50),
    is_read    BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (id)
);
