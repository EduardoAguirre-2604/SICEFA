var productos;

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
                    mostrar += "</tr>";
                }
                document.getElementById("tblProductos").innerHTML = mostrar;
            });
}

function cargarCatalogoProductosSuc1() {
    fetch("http://localhost:8080/sicefasucursal/api/inventario/getAllUno")
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                productos = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].producto.nombre || '';

                    let datos2 = (response[i].producto.nombreGenerico || '') + " "
                            + (response[i].producto.formaFarmaceutica || '');

                    let datos3 = (response[i].producto.unidadMedida || '') + " - "
                            + (response[i].producto.presentacion || '');

                    let datos4 = (response[i].producto.principalIndicacion || '') + " - "
                            + (response[i].producto.contraindicaciones || '') + " - "
                            + (response[i].producto.concentracion || '');

                    let datos5 = response[i].producto.unidadesEnvase || '';

                    let datos6 = (response[i].producto.precioCompra || '') + " - "
                            + (response[i].producto.precioVenta || '');

                    let datos7 = (response[i].producto.foto || '') + " - "
                            + (response[i].producto.rutaFoto || '');

                    let codigoBarras = response[i].producto.codigoBarras || '';

                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td>" + datos7 + "</td>";
                    mostrar += "<td>" + codigoBarras + "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblProductos").innerHTML = mostrar;
            });
}

function cargarCatalogoProductosSuc2() {
    fetch("http://localhost:8080/sicefasucursal/api/inventario/getAllDos")
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                productos = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].producto.nombre || '';

                    let datos2 = (response[i].producto.nombreGenerico || '') + " "
                            + (response[i].producto.formaFarmaceutica || '');

                    let datos3 = (response[i].producto.unidadMedida || '') + " - "
                            + (response[i].producto.presentacion || '');

                    let datos4 = (response[i].producto.principalIndicacion || '') + " - "
                            + (response[i].producto.contraindicaciones || '') + " - "
                            + (response[i].producto.concentracion || '');

                    let datos5 = response[i].producto.unidadesEnvase || '';

                    let datos6 = (response[i].producto.precioCompra || '') + " - "
                            + (response[i].producto.precioVenta || '');

                    let datos7 = (response[i].producto.foto || '') + " - "
                            + (response[i].producto.rutaFoto || '');

                    let codigoBarras = response[i].producto.codigoBarras || '';

                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td>" + datos7 + "</td>";
                    mostrar += "<td>" + codigoBarras + "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblProductos").innerHTML = mostrar;
            });
}

function cargarCatalogoProductosSuc3() {
    fetch("http://localhost:8080/sicefasucursal/api/inventario/getAllTres")
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                productos = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].producto.nombre || '';

                    let datos2 = (response[i].producto.nombreGenerico || '') + " "
                            + (response[i].producto.formaFarmaceutica || '');

                    let datos3 = (response[i].producto.unidadMedida || '') + " - "
                            + (response[i].producto.presentacion || '');

                    let datos4 = (response[i].producto.principalIndicacion || '') + " - "
                            + (response[i].producto.contraindicaciones || '') + " - "
                            + (response[i].producto.concentracion || '');

                    let datos5 = response[i].producto.unidadesEnvase || '';

                    let datos6 = (response[i].producto.precioCompra || '') + " - "
                            + (response[i].producto.precioVenta || '');

                    let datos7 = (response[i].producto.foto || '') + " - "
                            + (response[i].producto.rutaFoto || '');

                    let codigoBarras = response[i].producto.codigoBarras || '';

                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td>" + datos7 + "</td>";
                    mostrar += "<td>" + codigoBarras + "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblProductos").innerHTML = mostrar;
            });
}

function buscarProductosTodos() {
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("busqueda").value.toLowerCase();

    // Filtra los empleados en base al valor de búsqueda
    let productosFiltrados = productos.filter(producto => {

        let datosProducto = `${producto.nombre} ${producto.nombreGenerico} ${producto.formaFarmaceutica} ${producto.unidadMedida} ${producto.presentacion}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosProducto.includes(input);
    });
    mostrarProductosTodos(productosFiltrados);
}

function mostrarProductosTodos(productos) {
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
        mostrar += "</tr>";
    }
    document.getElementById("tblProductos").innerHTML = mostrar;
}
var boton0 = document.getElementById('boton0');
var boton1 = document.getElementById('boton1');
var boton2 = document.getElementById('boton2');
var boton3 = document.getElementById('boton3');
var boton4 = document.getElementById('boton4');
var campoTexto = document.getElementById('busqueda');
var miCheckbox = document.getElementById('mycheck2');

boton0.addEventListener('click', function () {
    boton2.disabled = false;
    campoTexto.disabled = false;
    miCheckbox.disabled = false;
});
boton1.addEventListener('click', function () {
    boton2.disabled = true;
    campoTexto.disabled = true;
    miCheckbox.disabled = true;
});
boton3.addEventListener('click', function () {
    boton2.disabled = true;
    campoTexto.disabled = true;
    miCheckbox.disabled = true;
});
boton4.addEventListener('click', function () {
    boton2.disabled = true;
    campoTexto.disabled = true;
    miCheckbox.disabled = true;
});