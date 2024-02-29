use sicefa;

CREATE VIEW v_productos AS
    SELECT 
        idProducto AS idProducto,
        nombre AS nombre,
        nombreGenerico AS nombreGenerico,
        formaFarmaceutica AS formaFarmaceutica,
        unidadMedida AS unidadMedida,
        presentacion AS presentacion,
        principalIndicacion AS principalIndicacion,
        contraindicaciones AS contraindicaciones,
        concentracion AS concentracion,
        unidadesEnvase AS unidadesEnvase,
        precioCompra AS precioCompra,
        precioVenta AS precioVenta,
        foto AS foto,
        rutaFoto AS rutaFoto,
        codigoBarras AS codigoBarras,
        estatus AS estatus
    FROM
        producto;
        
SELECT * FROM v_productos;

-- Procedimiento almacenado para insertar un nuevo Producto.
DROP PROCEDURE IF EXISTS insertarProducto;
DELIMITER $$
CREATE PROCEDURE insertarProducto(/* Datos Personales */
									
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_nombreGenerico VARCHAR(64),    --  2
                                    IN    var_formaFarmaceutica VARCHAR(64),    --  3
                                    IN  var_unidadMedida         VARCHAR(64),     --  4
                                    IN  var_presentacion VARCHAR(64),    --  5
                                    IN  var_principalIndicacion VARCHAR(64),    --  6
                                    IN  var_contraindicaciones  VARCHAR(64),    --  7
                                    IN    var_concentracion       VARCHAR(64),   --  8
                                    IN  var_unidadesEnvase             int,    --  9
                                    IN  var_precioCompra          float,    -- 10
                                    IN  var_precioVenta          float ,  -- 11
                                    IN    var_foto        LONGTEXT,    -- 12
                                    IN    var_rutaFoto           LONGTEXT,       -- 13
                                   IN    var_codigoBarras        VARCHAR(128),       -- 14
                                 
                                    IN  var_estatus   int ,   -- 15
                                    out var_idProducto      INT    -- 16       --
                                 )
    BEGIN
        -- Comenzamos insertando los datos de la Persona:
        INSERT INTO producto (nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion,
        principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto,
        rutaFoto, codigoBarras, estatus) 
        VALUES( var_nombre, var_nombreGenerico, var_formaFarmaceutica,
                            var_unidadMedida, var_presentacion,
                            var_principalIndicacion, var_contraindicaciones, var_concentracion, var_unidadesEnvase,
                            var_precioCompra, var_precioVenta, var_foto, var_rutaFoto,var_codigoBarras,var_estatus);
       
        
        SET var_idProducto = LAST_INSERT_ID();
       
       
    END
$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE modificarProducto(
									IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_nombreGenerico VARCHAR(64),    --  2
                                    IN    var_formaFarmaceutica VARCHAR(64),    --  3
                                    IN  var_unidadMedida         VARCHAR(64),     --  4
                                    IN  var_presentacion VARCHAR(64),    --  5
                                    IN  var_principalIndicacion longtext,    --  6
                                    IN  var_contraindicaciones  longtext,    --  7
                                    IN    var_concentracion       VARCHAR(64),   --  8
                                    IN  var_unidadesEnvase             int,    --  9
                                    IN  var_precioCompra          float,    -- 10
                                    IN  var_precioVenta          float ,  -- 11
                                    IN    var_foto        LONGTEXT,    -- 12
                                    IN    var_rutaFoto           LONGTEXT,       -- 13
									IN    var_codigoBarras        VARCHAR(128),       -- 14
                                 
                                    IN  var_estatus   int,    -- 15
                                    in var_idProducto      INT -- 16
)
BEGIN
update producto set
nombre=var_nombre,
nombreGenerico=var_nombreGenerico,
formaFarmaceutica=var_formaFarmaceutica,
unidadMedida=var_unidadMedida,
presentacion=var_presentacion,
principalIndicacion=var_principalIndicacion,
contraindicaciones=var_contraindicaciones,
concentracion=var_concentracion,
unidadesEnvase=var_unidadesEnvase,
precioCompra=var_precioCompra,
precioVenta=var_precioVenta,
foto=var_foto,
rutaFoto=var_rutaFoto,
codigoBarras=var_codigoBarras,
estatus=var_estatus
where idProducto=var_idProducto;

END
$$

DELIMITER ;