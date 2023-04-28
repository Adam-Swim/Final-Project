-- Customers
INSERT INTO customers (customer_id, customer_name, contact) VALUES('LAS_VEGAS_PAVING', 'Las Vegas Paving Corp', 'contact@LVPC.com');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('LAS_VEGAS_METRO_PD', 'Las Vegas Metropolitan Police Department', 'contact@LVMPD.gov');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('COEUR_MINING', 'Coeur Mining company', 'contact@COUER.com');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('US_CRITICAL_METALS', 'US Critical Metals Corp', 'contact@USCMC.com');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('JAPAN_RADIO_COMPANY', 'Japan Radio Company Ltd', 'contact@jrc.co.jp/en');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('US_CUSTOMS_BORDER', 'US Customs and Border Protection', 'contact@cpb.gov');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('LAS_VEGAS_BALLPARK', 'Las Vegas Ballpark facility', 'contact@thelvballpark.com');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('MSI_ROCKDALE', 'Mine Service Inc Rockdale Aggregate Quarries', 'contact@msirockdale.com'); 
INSERT INTO customers (customer_id, customer_name, contact) VALUES('NEVADA_LITHIUM', 'Albemarle Corp Silver Peak Lithium Mine', 'contact@albemarle.com');
INSERT INTO customers (customer_id, customer_name, contact) VALUES('PARAMOUNT', 'Paramount Media Corp', 'contact@paramount.com');

-- Watchdogs
INSERT INTO watchdogs (watchdog_id, mast_height, panel_watts, description, price) VALUES ('BULLDOG', 9, 1650, 'Bulldog solar mobile light tower', 49900.00); 
INSERT INTO watchdogs (watchdog_id, mast_height, panel_watts, description, price) VALUES ('DOBERMAN', 9, 2200, 'Doberman solar mobile light tower', 59900.00);
INSERT INTO watchdogs (watchdog_id, mast_height, panel_watts, description, price) VALUES ('POINTER', 9, 1650, 'Pointer solar mobile communications tower', 59900.00);

-- Accessories
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('THERMAL_CAM', 'Thermal-vision Camera', 'Axis Communications', '150 degree FOV Forward Looking Infrared Camera', '10719.49');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('HD_CAM', 'High Definition Camera', 'Axis Communications', '5K High Definition Optical Zoom Camera', '1899.49');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('MICROPHONE', 'All Weather Microphone', 'Sennheiser', 'All Weather 270 degree Microphone', '1799.99');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('PIN_POINT_MICROPHONE', 'Directional High Sensitivity Microphone', 'Sennheiser' , 'Ultra High Sensitivity 10 degree FOV Ultra Long Range Directional Microphone', '1899.99');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('DIRECTIONAL_SPEAKERS', 'All Weather Directional Speakers', 'AtlasIED', 'EN54-24 Certified 6.5" 2-Way All Weather Speaker with 32-Watt 70V/100V Transformer', '749.99');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('5G_LTE', '5G LTE Communications Array', 'Verizon', 'Local Network 5G LTE Access point', '14895.98');
INSERT INTO accessories (accessory_id, name, manufacturer, description, price) VALUES ('WI-FI_ACCESS_POINT', 'Ruckus 360 degree Wi-Fi Access point', 'Ruckus Commscope', '3 Ruckus 120 degree FOV Wi-Fi Access point mounted 120 degrees apart', '6799.99');

-- Orders
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'LAS_VEGAS_PAVING' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'DOBERMAN' LIMIT 1), 89456.97);
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'JAPAN_RADIO_COMPANY' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'POINTER' LIMIT 1), 81595.97);
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'LAS_VEGAS_BALLPARK' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'BULLDOG' LIMIT 1), 49900.00);
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'MSI_ROCKDALE' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'DOBERMAN' LIMIT 1), 81595.97);
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'PARAMOUNT' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'BULLDOG' LIMIT 1), 49900.00);
INSERT INTO orders (customer_fk, watchdog_fk, total_price) VALUES ((SELECT customer_pk FROM customers WHERE customer_id = 'COEUR_MINING' LIMIT 1), (SELECT watchdog_pk FROM watchdogs WHERE watchdog_id = 'DOBERMAN' LIMIT 1), 59900.00);
