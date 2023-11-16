CREATE TABLE product(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name varchar(256) not null,
  description varchar(256) not null,
  price decimal(13,2) not null,
  expiration_date date not null,
  stock int,
  supplier varchar(256),
  active tinyint(1) not null
);