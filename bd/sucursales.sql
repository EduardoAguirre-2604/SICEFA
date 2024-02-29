DROP PROCEDURE IF EXISTS insertarSucursal;
DELIMITER $$
CREATE PROCEDURE insertarSucursal(
    /* Datos Sucursal */
    IN  var_nombre VARCHAR(49),    -- 1
    IN  var_titular VARCHAR(49),    -- 2
    IN  var_rfc VARCHAR(15),    -- 3
    IN  var_domicilio VARCHAR(129),    -- 4
    IN  var_colonia VARCHAR(65),    -- 5
    IN  var_codigoPostal VARCHAR(11),    -- 6
    IN  var_ciudad VARCHAR(65),    -- 7
    IN  var_estado VARCHAR(49),    -- 8
    IN  var_telefono VARCHAR(20),    -- 9
    IN  var_latitud VARCHAR(65),    -- 10
    IN  var_longitud VARCHAR(65),    -- 11

    /* Parametros de Salida */
    OUT var_idSucursal INT,    -- 12
    OUT var_idUsuario INT,    -- 13
    OUT var_nombreUsuario VARCHAR(33),    -- 14
    OUT var_contrasenia VARCHAR(33)    -- 15
)
BEGIN
    DECLARE idUsuarioMax INT;

    -- Comenzamos insertando los datos de la Sucursal:
    INSERT INTO sucursal(nombre, titular, rfc, domicilio, colonia, codigoPostal,
        ciudad, estado, telefono, latitud, longitud, estatus)
    VALUES(var_nombre, var_titular, var_rfc, var_domicilio, var_colonia, var_codigoPostal,
        var_ciudad, var_estado, var_telefono, var_latitud, var_longitud, 1);

    -- Recuperamos el ID de la Sucursal que se genero:
    SET var_idSucursal = LAST_INSERT_ID();

    -- Generamos el nombre del Usuario Administrador que por default tendra la Sucursal:
    SET idUsuarioMax = 1 + (SELECT MAX(idUsuario) FROM usuario);
    SET var_nombreUsuario = CONCAT('Admins', idUsuarioMax);
    SET var_contrasenia = var_nombreUsuario;

    -- Insertamos los datos del Usuario que tendra el Empleado:
    INSERT INTO usuario (nombreUsuario, contrasenia, rol)
    VALUES (var_nombreUsuario, var_contrasenia, 'ADMS');

    -- Recuperamos el ID de Usuario generado:
    SET var_idUsuario = LAST_INSERT_ID();
END
$$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE modificarSucursal(
    /* Datos a Modificar */
    IN var_idSucursal INT, -- 1
    IN var_nombre VARCHAR(49),    -- 2
    IN var_titular VARCHAR(49),    -- 3
    IN var_rfc VARCHAR(15),    -- 4
    IN var_domicilio VARCHAR(129),    -- 5
    IN var_colonia VARCHAR(65),    -- 6
    IN var_codigoPostal VARCHAR(11),    -- 7
    IN var_ciudad VARCHAR(65),    -- 8
    IN var_estado VARCHAR(49),    -- 9
    IN var_telefono VARCHAR(20),    -- 10
    IN var_latitud VARCHAR(65),    -- 11
    IN var_longitud VARCHAR(65)    -- 12
)
BEGIN
    -- Actualizamos los datos de la Sucursal:
    UPDATE sucursal
    SET
        nombre = var_nombre,
        titular = var_titular,
        rfc = var_rfc,
        domicilio = var_domicilio,
        colonia = var_colonia,
        codigoPostal = var_codigoPostal,
        ciudad = var_ciudad,
        estado = var_estado,
        telefono = var_telefono,
        latitud = var_latitud,
        longitud = var_longitud
        
    WHERE idSucursal = var_idSucursal;
END $$

DELIMITER ;