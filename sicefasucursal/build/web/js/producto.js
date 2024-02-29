var productos;

function  obtenerDatosProducto() {
    let idProducto = document.getElementById("idProducto").value;
    let nombre = document.getElementById("nombre").value;
    let nombreGenerico = document.getElementById("nombreGenerico").value;
    let formaFarmaceutica = document.getElementById("formaFarmaceutica").value;
    let presentacion = document.getElementById("presentacion").value;
    let principalIndicacion = document.getElementById("principalIndicacion").value;
    let precioCompra = document.getElementById("precioCompra").value;
    let precioVenta = document.getElementById("precioVenta").value;
    let unidadMedida = document.getElementById("unidadMedida").value;
    let foto = document.getElementById("textoFoto").value;
    let codigoBarras = document.getElementById("codigoBarras").value;
    let estatus = document.getElementById("estatus").value;
    let contraindicaciones = document.getElementById("contraindicaciones").value;
    let concentracion = document.getElementById("concentracion").value;
    let unidadesEnvase = document.getElementById("unidadesEnvase").value;
    let textoFoto = document.getElementById("rutaFoto").value;

    let producto = {idProducto: parseInt(idProducto), nombre: nombre, nombreGenerico: nombreGenerico, formaFarmaceutica: formaFarmaceutica,
        unidadMedida: unidadMedida, presentacion: presentacion, principalIndicacion: principalIndicacion, contraindicaciones: contraindicaciones, concentracion: concentracion,
        unidadesEnvase: parseInt(unidadesEnvase), precioCompra: parseFloat(precioCompra), precioVenta: parseFloat(precioVenta),
        foto: foto, rutaFoto: textoFoto, codigoBarras: codigoBarras, estatus: parseInt(estatus)
    };

    //alert( JSON.stringify(producto));
    let params = {p: JSON.stringify(producto)};


    let ruta = "http://localhost:8080/sicefasucursal/api/producto/insert?";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire("Insercion correctaa", response.result, "success");
                }
                if (response.error) {
                    Swal.fire("Problemas para insertar", response.error, "error");
                }
                cargarCatalogoProductos();

            });
}


function  modificarProducto() {
    let idProducto = document.getElementById("idProducto").value;
    let nombre = document.getElementById("nombre").value;
    let nombreGenerico = document.getElementById("nombreGenerico").value;
    let formaFarmaceutica = document.getElementById("formaFarmaceutica").value;
    let presentacion = document.getElementById("presentacion").value;
    let principalIndicacion = document.getElementById("principalIndicacion").value;
    let precioCompra = document.getElementById("precioCompra").value;
    let precioVenta = document.getElementById("precioVenta").value;
    let unidadMedida = document.getElementById("unidadMedida").value;
    let rutaFoto = document.getElementById("rutaFoto").value;
    let codigoBarras = document.getElementById("codigoBarras").value;
    let estatus = document.getElementById("estatus").value;
    let contraindicaciones = document.getElementById("contraindicaciones").value;
    let concentracion = document.getElementById("concentracion").value;
    let unidadesEnvase = document.getElementById("unidadesEnvase").value;
    let textoFoto = document.getElementById("textoFoto").value;

    let producto = {idProducto: parseInt(idProducto), nombre: nombre, nombreGenerico: nombreGenerico, formaFarmaceutica: formaFarmaceutica,
        unidadMedida: unidadMedida, presentacion: presentacion, principalIndicacion: principalIndicacion, contraindicaciones: contraindicaciones, concentracion: concentracion,
        unidadesEnvase: parseInt(unidadesEnvase), precioCompra: parseFloat(precioCompra), precioVenta: parseFloat(precioVenta),
        foto: rutaFoto, rutaFoto: textoFoto, codigoBarras: codigoBarras, estatus: parseInt(estatus)
    };


    let params = {p: JSON.stringify(producto)};


    let ruta = "http://localhost:8080/sicefasucursal/api/producto/update?";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire("Actualizacion correctaa", response.result, "success");
                }
                if (response.error) {
                    Swal.fire("Problemas para actualizar", response.error, "error");
                }
                cargarCatalogoProductos();

            });
}

function cargarCatalogoProductos() {
    const mostrarInactivos = document.getElementById("autopista").checked;

    const url = mostrarInactivos
            ? "http://localhost:8080/sicefasucursal/api/producto/getAll?estatus=false"
            : "http://localhost:8080/sicefasucursal/api/producto/getAll?estatus=true";
    fetch(url)
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                productos = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].nombre;

                    let datos2 = response[i].nombreGenerico + " "
                            + response[i].formaFarmaceutica;

                    let datos3 = response[i].unidadMedida + " - "
                            + response[i].presentacion;

                    let datos4 = response[i].principalIndicacion + " - "
                            + response[i].contraindicaciones + " - "
                            + response[i].concentracion;
                    let datos5 = response[i].unidadesEnvase;

                    let datos6 = response[i].precioCompra + " - "
                            + response[i].precioVenta;
                    let datos7 = response[i].foto + " - "
                            + response[i].rutaFoto;
                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td>" + datos7 + "</td>";
                    mostrar += "<td>" + response[i].codigoBarras + "</td>";
                    mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' type='button' data-toggle='modal' data-target='#myModalSele'  onclick='SeleccionarProducto(" + i + ");'> <i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
                    mostrar += "<td>";
                    if (response[i].estatus === 0) {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarProducto(" + i + ");'> <i class='bi bi-check-square-fill'></i> Activar </button>";
                    } else {
                        mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarProducto(" + i + ");'> <i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                        mostrar += "<td>" + response[i].codigoBarras + "</td>"; // Mueve esta línea dentro del bloque else
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblProductos").innerHTML = mostrar;
            });
}


function SeleccionarProducto(i) {

    document.getElementById("idProducto").value = productos[i].idProducto;
    document.getElementById("nombre").value = productos[i].nombre;
    document.getElementById("nombreGenerico").value = productos[i].nombreGenerico;
    document.getElementById("formaFarmaceutica").value = productos[i].formaFarmaceutica;
    document.getElementById("presentacion").value = productos[i].presentacion;
    document.getElementById("principalIndicacion").value = productos[i].principalIndicacion;
    document.getElementById("precioCompra").value = productos[i].precioCompra;
    document.getElementById("precioVenta").value = productos[i].precioVenta;
    document.getElementById("unidadMedida").value = productos[i].unidadMedida;
    document.getElementById("rutaFoto").value = productos[i].rutaFoto;
    document.getElementById("codigoBarras").value = productos[i].codigoBarras;
    document.getElementById("estatus").value = productos[i].estatus;
    document.getElementById("contraindicaciones").value = productos[i].contraindicaciones;
    document.getElementById("concentracion").value = productos[i].concentracion;
    document.getElementById("unidadesEnvase").value = productos[i].unidadesEnvase;
    document.getElementById("rutaFoto").value = productos[i].foto;
    document.getElementById("textoFoto").value = productos[i].rutaFoto;


}

function eliminarProducto(i) {
    let idProducto = productos[i].idProducto;
    fetch("http://localhost:8080/sicefasucursal/api/producto/delete?idP=" + idProducto)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Producto Eliminado ", "success");
                cargarCatalogoProductos();
            });
}

function activarProducto(i) {
    let idProducto = productos[i].idProducto;

//    alert("eliminar "+idEmpleado);
    fetch("http://localhost:8080/sicefasucursal/api/producto/regresar?idPr=" + idProducto)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Producto activado ", "success");
                cargarCatalogoProductos();
            });
}


function buscarProductos() {
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("busqueda").value.toLowerCase();

    // Filtra los empleados en base al valor de búsqueda
    let productosFiltrados = productos.filter(producto => {

        let datosProducto = `${producto.nombre} ${producto.nombreGenerico} ${producto.formaFarmaceutica} ${producto.unidadMedida} ${producto.presentacion}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosProducto.includes(input);
    });
    mostrarProductos(productosFiltrados);
}

function mostrarProductos(productos) {
    let mostrar = "";
    for (let i = 0; i < productos.length; i++) {
        let datos1 = productos[i].nombre;

        let datos2 = productos[i].nombreGenerico + " "
                + productos[i].formaFarmaceutica;

        let datos3 = productos[i].unidadMedida + " - "
                + productos[i].presentacion;

        let datos4 = productos[i].principalIndicacion + " - "
                + productos[i].contraindicaciones + " - "
                + productos[i].concentracion;
        let datos5 = productos[i].unidadesEnvase;

        let datos6 = productos[i].precioCompra + " - "
                + productos[i].precioVenta;
        let datos7 = productos[i].foto + " - "
                + productos[i].rutaFoto;
        mostrar += "<tr>";
        mostrar += "<td>" + datos1 + "</td>";
        mostrar += "<td>" + datos2 + "</td>";
        mostrar += "<td>" + datos3 + "</td>";
        mostrar += "<td>" + datos4 + "</td>";
        mostrar += "<td>" + datos5 + "</td>";
        mostrar += "<td>" + datos6 + "</td>";
        mostrar += "<td>" + datos7 + "</td>";
        mostrar += "<td>" + productos[i].codigoBarras + "</td>";
        mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' type='button' data-toggle='modal' data-target='#myModalSele'  onclick='SeleccionarProducto(" + i + ");'> <i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
        mostrar += "<td>";
        if (productos[i].estatus === 0) {
            mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarProducto(" + i + ");'> <i class='bi bi-check-square-fill'></i> Activar </button>";
        } else {
            mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarProducto(" + i + ");'> <i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
            mostrar += "<td>" + productos[i].codigoBarras + "</td>"; // Mueve esta línea dentro del bloque else
        }
        mostrar += "</td>";
        mostrar += "</tr>";
    }
    document.getElementById("tblProductos").innerHTML = mostrar;
}


function cargarImagen() {
    var inputFoto = document.getElementById('inputFoto');
    var imgFoto = document.getElementById('imgFoto');
    var textoFoto = document.getElementById('textoFoto');

    if (inputFoto.files && inputFoto.files[0]) {
        var lector = new FileReader();

        lector.onload = function (e) {
            imgFoto.src = e.target.result;
            textoFoto.value = e.target.result;
        };

        lector.readAsDataURL(inputFoto.files[0]);
    }
}
