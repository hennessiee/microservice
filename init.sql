CREATE DATABASE IF NOT EXISTS micro;

-- Drop the user if it exists
DROP USER IF EXISTS 'root'@'%';

-- Create the user and grant privileges
CREATE USER 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
