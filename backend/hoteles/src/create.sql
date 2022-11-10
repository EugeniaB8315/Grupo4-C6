CREATE TABLE if not exists categorias (
     id int NOT NULL auto_increment,
     titulo varchar(45) NOT NULL,
     descripcion varchar(45) NOT NULL,
     imagen varchar(255),
     primary key(id));

INSERT INTO categorias
VALUES (default,'hoteles', 'Alojamiento en hoteles','https://www.istockphoto.com/es/foto/maleta-en-habitaci%C3%B3n-de-hotel-gm1400834458-454286129' ),
       (default,'hostales', 'Alojamiento en hostales','https://www.istockphoto.com/es/foto/juventud-hostal-dormitorio-gm182498079-12199270?phrase=hostal'),
       (default,'apartamentos', 'alojamiento en apartamentos', 'https://www.istockphoto.com/es/foto/complejo-moderno-de-edificios-residenciales-en-europa-gm1165384568-320657672?phrase=apartamento'),
       (default,'break and brekfast', 'alojamiento brak ad fast', 'https://www.istockphoto.com/es/foto/primer-plano-de-la-mujer-cauc%C3%A1sica-rompiendo-huevos-y-haciendo-huevos-soleados-cocina-gm1182718316-332230553?phrase=break%20a%20breakfast');
