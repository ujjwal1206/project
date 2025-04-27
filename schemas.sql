
-- User Service Schema
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(100)
);

-- Parking Slot Service Schema
CREATE TABLE parking_slot (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    slot_number VARCHAR(100),
    available BOOLEAN
);

-- Booking Service Schema
CREATE TABLE booking (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    parking_slot_id BIGINT,
    booking_time TIMESTAMP
);

-- Payment Service Schema
CREATE TABLE payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_id BIGINT,
    amount DOUBLE,
    payment_time TIMESTAMP
);





CREATE DATABASE IF NOT EXISTS parking_system;

USE parking_system;

CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50)
);

CREATE TABLE parking_slots (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  slot_number VARCHAR(50),
  is_available BOOLEAN DEFAULT true
);

CREATE TABLE bookings (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT,
  slot_id BIGINT,
  booking_time VARCHAR(100)
);

CREATE TABLE payments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  booking_id BIGINT,
  amount DOUBLE,
  payment_status VARCHAR(50)
);
