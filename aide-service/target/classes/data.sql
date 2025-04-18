-- Create Aide Table
CREATE TABLE IF NOT EXISTS aide (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create Service Table
CREATE TABLE IF NOT EXISTS service (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL  
);

-- Create Request Table
CREATE TABLE IF NOT EXISTS request (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Ensures automatic timestamp
    aide_id BIGINT,
    service_id BIGINT,
    FOREIGN KEY (aide_id) REFERENCES aide(id) ON DELETE CASCADE, -- Prevent orphaned records
    FOREIGN KEY (service_id) REFERENCES service(id) ON DELETE CASCADE
);

-- Insert Initial Data into Aide Table
INSERT INTO aide (name) VALUES
('Johnny Cash'),
('Betty Boop'),
('Kim Kardashian');

-- Insert Initial Data into Service Table
INSERT INTO service (service_name) VALUES 
('Home Cleaning'),
('Gardening'),
('Personal Shopping');

-- Insert Initial Data into Request Table
INSERT INTO request (request_date, aide_id, service_id) VALUES
(DEFAULT, 1, 1),  -- Johnny Cash for Home Cleaning
(DEFAULT, 2, 2),  -- Betty Boop for Gardening
(DEFAULT, 3, 3);  -- Kim Kardashian for Personal Shopping
