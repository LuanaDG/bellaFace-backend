-- EXECUTAR NO MySQL/

-- CRIAR BANCO DE DADOS:

   CREATE DATABASE bellaface;
   
   
   CREATE TABLE bellaface.product (
   id integer AUTO_INCREMENT NOT NULL,
   name varchar(255) NOT NULL,
   description varchar(100) NOT NULL,
   price decimal(16,7) NOT NULL,
   created date NOT NULL,
   PRIMARY KEY (id)
   );
   
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Perfume', 'Lady Million 200ml', 300.00, '2019-11-22');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Hidratante', 'Natura toque de seda', 30.1234567, '2020-06-10');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Baton', 'Vult gloss rosê', 25.00, '2020-01-15');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Máscara de cílios', 'Black volume 3D', 55.00, '2019-10-26');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Esmalte', 'Risquê nude', 5.00, '2020-04-02');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Base', 'BBcream bege ', 75.00, '2020-04-02');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Pó Compacto', 'Boca Rosa translúcido', 65.00, '2019-12-12');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Sombra', 'MaryKay colors', 35.00, '2020-03-29');
   INSERT INTO bellaface.product (name, description, price, created) VALUES('Creme facial', 'LaRoche hidratação', 95.00, '2020-08-07');
   
   
   
   CREATE TABLE bellaface.customer (
   id integer AUTO_INCREMENT NOT NULL,
   name varchar(255) NOT NULL,
   login varchar(20) NOT NULL,
   password varchar(20) NOT NULL,
   PRIMARY KEY (id)
   );
   
   INSERT INTO bellaface.customer (name, login, password) VALUES('Aroma Cosméticos', '249587000166', '654321');
   INSERT INTO bellaface.customer (name, login, password) VALUES('La Bella Cosmetics', '635897000152', '345678');
   INSERT INTO bellaface.customer (name, login, password) VALUES('Oh Maria Cosméticos', '365796000140', '852963');
   INSERT INTO bellaface.customer (name, login, password) VALUES('Cosmetics Skelt', '121364000132', '123456');
   
   
   
   CREATE TABLE bellaface.order (
   id integer AUTO_INCREMENT NOT NULL,
   customer_id integer NOT NULL,
   total_order decimal(16,7) NOT NULL,
   created_at datetime NOT NULL default CURRENT_TIMESTAMP,
   comments varchar(255) NOT NULL,
   PRIMARY KEY (id),
   CONSTRAINT fk_id FOREIGN KEY (customer_id) REFERENCES bellaface.customer (id)
   );
   
   
   
   CREATE TABLE bellaface.order_product (
   order_id integer NOT NULL,
   product_id integer NOT NULL,
   quantity integer NOT NULL,
   created_at datetime NOT NULL default CURRENT_TIMESTAMP,
   unit_price decimal(16,7) NOT NULL,
   total_price decimal(16,7) NOT NULL,
   PRIMARY KEY (order_id,product_id),
   CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES bellaface.order (id),
   CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES bellaface.product (id)
   );
   -- primary key (order_id, product_id) para que o produto não se repita e seja inserido apenas uma vez
   
   
   
 
   