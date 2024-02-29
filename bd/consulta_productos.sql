create view v_productos_suc_1 as
 SELECT 
        p.idProducto AS idProducto,
        p.nombre AS nombre,
        p.nombreGenerico AS nombreGenerico,
        p.formaFarmaceutica AS formaFarmaceutica,
        p.unidadMedida AS unidadMedida,
        p.presentacion AS presentacion,
        p.principalIndicacion AS principalIndicacion,
        p.contraindicaciones AS contraindicaciones,
        p.concentracion AS concentracion,
        p.unidadesEnvase AS unidadesEnvase,
        p.precioCompra AS precioCompra,
        p.precioVenta AS precioVenta,
        p.foto AS foto,
        p.rutaFoto AS rutaFoto,
        p.codigoBarras AS codigoBarras,
        p.estatus AS estatus,
        i.idInventario as idInventario,
        i.existencias AS existencias,
        i.idSucursal as idSucursal
    FROM
        producto p
    JOIN
        inventario i ON p.idProducto = i.idProducto
    WHERE
        i.idSucursal = 2;

select * from v_productos_suc_1;



create view v_productos_suc_2 as
  SELECT 
        p.idProducto AS idProducto,
        p.nombre AS nombre,
        p.nombreGenerico AS nombreGenerico,
        p.formaFarmaceutica AS formaFarmaceutica,
        p.unidadMedida AS unidadMedida,
        p.presentacion AS presentacion,
        p.principalIndicacion AS principalIndicacion,
        p.contraindicaciones AS contraindicaciones,
        p.concentracion AS concentracion,
        p.unidadesEnvase AS unidadesEnvase,
        p.precioCompra AS precioCompra,
        p.precioVenta AS precioVenta,
        p.foto AS foto,
        p.rutaFoto AS rutaFoto,
        p.codigoBarras AS codigoBarras,
        p.estatus AS estatus,
        i.idInventario as idInventario,
        i.existencias AS existencias,
        i.idSucursal as idSucursal
    FROM
        producto p
    JOIN
        inventario i ON p.idProducto = i.idProducto
    WHERE
        i.idSucursal = 3;

create view v_productos_suc_3 as
SELECT 
        p.idProducto AS idProducto,
        p.nombre AS nombre,
        p.nombreGenerico AS nombreGenerico,
        p.formaFarmaceutica AS formaFarmaceutica,
        p.unidadMedida AS unidadMedida,
        p.presentacion AS presentacion,
        p.principalIndicacion AS principalIndicacion,
        p.contraindicaciones AS contraindicaciones,
        p.concentracion AS concentracion,
        p.unidadesEnvase AS unidadesEnvase,
        p.precioCompra AS precioCompra,
        p.precioVenta AS precioVenta,
        p.foto AS foto,
        p.rutaFoto AS rutaFoto,
        p.codigoBarras AS codigoBarras,
        p.estatus AS estatus,
        i.idInventario as idInventario,
        i.existencias AS existencias,
        i.idSucursal as idSucursal
    FROM
        producto p
    JOIN
        inventario i ON p.idProducto = i.idProducto
    WHERE
        i.idSucursal = 4;

select * from v_productos_suc_3;
select * from v_productos_suc_2;
select * from v_productos_suc_1;