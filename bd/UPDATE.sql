USE sicefa;

UPDATE empleado SET activo=1 WHERE idEmpleado = 1;

UPDATE empleado SET activo=1 WHERE idEmpleado = 2;

UPDATE empleado SET activo=1 WHERE idEmpleado = 3;

SELECT * FROM empleado;
SELECT * FROM cliente;
SELECT * FROM persona;
SELECT * FROM usuario;
SELECT * FROM compra;
SELECT * FROm detalleCompra;
SELECt * FROM inventario;
SELECT * FROM sucursal;

UPDATE compra SET estatus=1 WHERE idCompra = 1;

UPDATE compra SET estatus=1 WHERE idCompra = 2;

UPDATE compra SET estatus=1 WHERE idCompra = 3;

UPDATE compra SET estatus=1 WHERE idCompra = 4;

UPDATE compra SET estatus=1 WHERE idCompra = 5;

SELECT rol FROM usuario WHERE nombreUsuario= '20230816ADMC' AND contrasenia= '20230816ADMC';

CALL insertarEmpleado('NombrePrueba', 'ApellidoPaternoPrueba', 'ApellidoMaternoPrueba', 'GeneroPrueba', '01/01/2000', 
'RFC1234567890', 'CURP123456789012345', 'DomicilioPrueba', '12345', 'CiudadPrueba', 'EstadoPrueba', '1234567890', 'Base64Foto', 
1, 'UsuarioPrueba', 'ContraseñaPrueba', 'RolPrueba', 'correo@ejemplo.com', 'PuestoPrueba', 50000.0,
 @idPersona, @idUsuario, @idEmpleado, @codigoEmpleado);
SELECT @idPersona, @idUsuario, @idEmpleado, @codigoEmpleado;

-- Supongamos que tienes un empleado con idEmpleado igual a 1 que deseas modificar
-- y proporciona valores de muestra para los parámetros del procedimiento almacenado.

CALL modificarEmpleado(
    1,                    -- var_idEmpleado
    'Juan',               -- var_nombre
    'Gómez',              -- var_apellidoPaterno
    'Pérez',              -- var_apellidoMaterno
    'Masculino',          -- var_genero
    '1990-05-15',         -- var_fechaNacimiento
    'RGOP123456',         -- var_rfc
    'CURP78901234567890', -- var_curp
    'Calle 123',          -- var_domicilio
    '12345',              -- var_cp
    'Ciudad Ejemplo',     -- var_ciudad
    'Estado Ejemplo',     -- var_estado
    '123-456-7890',       -- var_telefono
    'Base64StringFoto',   -- var_foto (ejemplo de cadena Base64 para la foto)

    'juanito',            -- var_nombreUsuario
    'contraseña123',      -- var_contrasenia
    'empleado',           -- var_rol

    'juan@email.com',     -- var_email
    'Desarrollador',      -- var_puesto
    50000.00,             -- var_salarioBruto
    1                     -- var_idSucursal
);

