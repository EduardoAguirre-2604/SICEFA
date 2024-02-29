CREATE VIEW v_clientes AS
SELECT
    c.idCliente,
    c.email,
    c.fechaRegistro,
    c.estatus,
    p.idPersona,
    p.nombre,
    p.apellidoPaterno,
    p.apellidoMaterno,
    p.genero,
    p.fechaNacimiento,
    p.rfc,
    p.curp,
    p.domicilio,
    p.codigoPostal,
    p.ciudad,
    p.estado,
    p.telefono,
    p.foto
FROM
    cliente c
JOIN
    persona p ON c.idPersona = p.idPersona;


-- -----------------------------------------------------------------------------


DELIMITER $$
CREATE PROCEDURE insertarCliente(
    /* Datos Personales */
    IN var_nombre VARCHAR(64), --  1
    IN var_apellidoPaterno VARCHAR(64), --  2
    IN var_apellidoMaterno VARCHAR(64), --  3
    IN var_genero VARCHAR(15), --  4
    IN var_fechaNacimiento VARCHAR(11), --  5
    IN var_rfc VARCHAR(14), --  6
    IN var_curp VARCHAR(19), --  7
    IN var_domicilio VARCHAR(129), --  8
    IN var_cp VARCHAR(11), --  9
    IN var_ciudad VARCHAR(46), -- 10
    IN var_estado VARCHAR(40), -- 11
    IN var_telefono VARCHAR(20), -- 12
    IN var_foto LONGTEXT, -- 13

    /* Datos del Cliente */
    IN var_email VARCHAR(65), -- 14
    IN var_estatus INT, -- 15

    /* Parametros de Salida */
    OUT var_idPersona INT, -- 16
    OUT var_idCliente INT -- 17
)
BEGIN
    -- Comenzamos insertando los datos de la Persona:
    INSERT INTO persona (nombre, apellidoPaterno, apellidoMaterno, genero,
        fechaNacimiento, rfc, curp, domicilio, codigoPostal,
        ciudad, estado, telefono, foto)
    VALUES (var_nombre, var_apellidoPaterno, var_apellidoMaterno,
        var_genero, var_fechaNacimiento,
        var_rfc, var_curp, var_domicilio, var_cp,
        var_ciudad, var_estado, var_telefono, var_foto);

    -- Obtenemos el ID de Persona que se generó:
    SET var_idPersona = LAST_INSERT_ID();

    -- Insertamos los datos del Cliente:
    INSERT INTO cliente (email, fechaRegistro, estatus, idPersona)
    VALUES (var_email, NOW(), var_estatus, var_idPersona);

    -- Recuperamos el ID de Cliente generado:
    SET var_idCliente = LAST_INSERT_ID();
END
$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE modificarCliente(
    /* ID del Cliente a modificar */
    IN var_idClienteModificar INT, -- 1
    
    /* Nuevos Datos Personales */
    IN var_nombreNuevo VARCHAR(64), --  2
    IN var_apellidoPaternoNuevo VARCHAR(64), --  3
    IN var_apellidoMaternoNuevo VARCHAR(64), --  4
    IN var_generoNuevo VARCHAR(15), --  5
    IN var_fechaNacimientoNuevo VARCHAR(11), --  6
    IN var_rfcNuevo VARCHAR(14), --  7
    IN var_curpNuevo VARCHAR(19), --  8
    IN var_domicilioNuevo VARCHAR(129), --  9
    IN var_cpNuevo VARCHAR(11), --  10
    IN var_ciudadNuevo VARCHAR(46), -- 11
    IN var_estadoNuevo VARCHAR(40), -- 12
    IN var_telefonoNuevo VARCHAR(20), -- 13
    IN var_fotoNueva LONGTEXT, -- 14

    /* Nuevos Datos del Cliente */
    IN var_emailNuevo VARCHAR(65), -- 15
    IN var_fechaRegistro VARCHAR(11), -- 16
     IN var_estatusNuevo INT -- 17
)
BEGIN
    -- Actualizamos los datos de la Persona:
    UPDATE persona
    SET
        nombre = var_nombreNuevo,
        apellidoPaterno = var_apellidoPaternoNuevo,
        apellidoMaterno = var_apellidoMaternoNuevo,
        genero = var_generoNuevo,
        fechaNacimiento = var_fechaNacimientoNuevo,
        rfc = var_rfcNuevo,
        curp = var_curpNuevo,
        domicilio = var_domicilioNuevo,
        codigoPostal = var_cpNuevo,
        ciudad = var_ciudadNuevo,
        estado = var_estadoNuevo,
        telefono = var_telefonoNuevo,
        foto = var_fotoNueva
    WHERE idPersona = (SELECT idPersona FROM cliente WHERE idCliente = var_idClienteModificar);

    -- Actualizamos los datos del Cliente:
    UPDATE cliente
    SET
        email = var_emailNuevo,
        estatus = var_estatusNuevo, 
        fechaRegistro= var_fechaRegistro
    WHERE idCliente = var_idClienteModificar;
END
$$
DELIMITER ;



