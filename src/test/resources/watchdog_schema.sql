DROP TABLE IF EXISTS order_accessories;
DROP TABLE IF EXISTS order_options;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS accessories;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS watchdogs;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
   customer_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
   customer_id varchar(64) NOT NULL,
   customer_name varchar(64) NOT NULL,
   contact varchar(64) NOT NULL, 
   PRIMARY KEY (customer_pk)
   );
   
CREATE TABLE watchdogs (
   watchdog_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
   watchdog_id varchar(32) NOT NULL,
   mast_height int NOT NULL,
   panel_watts int NOT NULL,
   description varchar(128) NOT NULL,
   price decimal(7,2) NOT NULL,
   watchdog_model varchar(32) NOT NULL,
   PRIMARY KEY (watchdog_pk)
   );
   
CREATE TABLE orders (
    order_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_fk int UNSIGNED NOT NULL,
    watchdog_fk int UNSIGNED NOT NULL,
    total_price decimal(8,2) NOT NULL,
    PRIMARY KEY (order_pk),
    FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
    FOREIGN KEY (watchdog_fk) REFERENCES watchdogs (watchdog_pk) ON DELETE CASCADE
    );
    
CREATE TABLE accessories (
   accessory_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
   accessory_id varchar(64) NOT NULL,
   name varchar(64) NOT NULL,
   manufacturer varchar(64) NOT NULL,
   description varchar(128) NOT NULL,
   price decimal(7,2) NOT NULL,
   PRIMARY KEY (accessory_pk)
   );
   
CREATE TABLE order_accessories (
   accessory_fk int UNSIGNED NOT NULL,
   order_fk int UNSIGNED NOT NULL,
   FOREIGN KEY (accessory_fk) REFERENCES accessories (accessory_pk) ON DELETE CASCADE,
   FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE
   );