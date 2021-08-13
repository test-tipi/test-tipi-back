create table tipitest.person(
	id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador de la persona',
    name VARCHAR(100) NOT NULL COMMENT 'Nombre de la persona',
    last_name VARCHAR(100) NOT NULL COMMENT 'Apellido de la persona',
    age INT NOT NULL COMMENT 'Edad'
) COMMENT 'Tabla para almacenar personas';
