var clientes;

function  obtenerDatosCliente() {
    //persona
    let idP = document.getElementById("txtIdPersona").value;
    let nombre = document.getElementById("nombres").value;
    let aP = document.getElementById("apellido_paterno").value;
    let aM = document.getElementById("apellido_materno").value;
    let g = document.getElementById("genero").value;
    let fn1 = document.getElementById("fecha_nacimiento").value;
    let rfc = document.getElementById("rfc").value;
    let curp = document.getElementById("curp").value;
    let dom = document.getElementById("domicilio").value;
    let cp = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let edo = document.getElementById("estado").value;
    let tel = document.getElementById("telefono").value;
    let foto = document.getElementById("textoFoto").value;

    let persona = {idPersona: parseInt(idP), nombre: nombre, apellidoPaterno: aP, apellidoMaterno: aM,
        genero: g,
        fechaNacimiento: fn1, rfc: rfc, curp: curp, domicilio: dom, codigoPostal: cp,
        ciudad: ciudad, estado: edo, telefono: tel,
        foto: foto
    };

    //cliente
    let idC = document.getElementById("idCliente").value;
    let fechaI = document.getElementById("fechaRegistro").value;
    let correo = document.getElementById("email").value;
    let activo = document.getElementById("esstatus").value;

    let cliente = {idCliente: parseInt(idC),
        email: correo,
        fechaRegistro: fechaI,
        estatus: parseInt(activo),
        Persona: persona};


    let params = {c: JSON.stringify(cliente)};


    let ruta = "http://localhost:8080/sicefasucursal/api/cliente/insert?";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire("Insercion correcta", response.result, "success");
                }
                if (response.error) {
                    Swal.fire("Problemas para insertar", response.error, "error");
                }
                cargarCatalogoClientes();
            });
}

function  actualizarDatos() {
    //persona
    let idP = document.getElementById("txtIdPersona").value;
    let nombre = document.getElementById("nombres").value;
    let aP = document.getElementById("apellido_paterno").value;
    let aM = document.getElementById("apellido_materno").value;
    let g = document.getElementById("genero").value;
    let fn1 = document.getElementById("fecha_nacimiento").value;
    let rfc = document.getElementById("rfc").value;
    let curp = document.getElementById("curp").value;
    let dom = document.getElementById("domicilio").value;
    let cp = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let edo = document.getElementById("estado").value;
    let tel = document.getElementById("telefono").value;
    let foto = document.getElementById("textoFoto").value;

    let persona = {idPersona: parseInt(idP), nombre: nombre, apellidoPaterno: aP, apellidoMaterno: aM,
        genero: g,
        fechaNacimiento: fn1, rfc: rfc, curp: curp, domicilio: dom, codigoPostal: cp,
        ciudad: ciudad, estado: edo, telefono: tel,
        foto: foto
    };

    //cliente
    let idC = document.getElementById("idCliente").value;
    let fechaI = document.getElementById("fechaRegistro").value;
    let correo = document.getElementById("email").value;
    let activo = document.getElementById("esstatus").value;

    let cliente = {idCliente: parseInt(idC),
        email: correo,
        fechaRegistro: fechaI,
        estatus: parseInt(activo),
        Persona: persona};


    let params = {c: JSON.stringify(cliente)};


    let ruta = "http://localhost:8080/sicefasucursal/api/cliente/update?";
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
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "Problemas para insertar"
                    });
                }
                cargarCatalogoClientes();
            });
}

function cargarCatalogoClientes() {
    // Obtener el valor del checkbox
    const mostrarInactivos = document.getElementById("autopista").checked;
    const url = mostrarInactivos
            ? "http://localhost:8080/sicefasucursal/api/cliente/getAll?activo=false"
            : "http://localhost:8080/sicefasucursal/api/cliente/getAll?activo=true";
    fetch(url)
            .then(response => response.json())
            .then(response => {
                var mostrar = "";
                clientes = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].Persona.nombre + " "
                            + response[i].Persona.apellidoPaterno + " "
                            + response[i].Persona.apellidoMaterno;
                    let datos2 = response[i].Persona.fechaNacimiento + " - "
                            + response[i].Persona.rfc + " - "
                            + response[i].Persona.curp;

                    let datos3 = response[i].Persona.domicilio + " - "
                            + response[i].Persona.codigoPostal + " - "
                            + response[i].Persona.ciudad + " - "
                            + response[i].Persona.estado;

                    let datos4 = response[i].Persona.telefono;

                    let datos5 = response[i].email;

                    let datos6 = response[i].fechaRegistro;

                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' data-toggle='modal' data-target='#myModalEx' onclick='SeleccionarCliente(" + i + ");'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
                    mostrar += "<td>";
                    if (response[i].estatus === 0) {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarCliente(" + i + ");'><i class='bi bi-check-square-fill'></i> Activar </button>";
                    } else {
                         mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarCliente(" + i + ");'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("catalogoClientes").innerHTML = mostrar;
            });
}

function SeleccionarCliente(i) {
    document.getElementById("txtIdPersona").value = clientes[i].Persona.idPersona;
    document.getElementById("nombres").value = clientes[i].Persona.nombre;
    document.getElementById("apellido_paterno").value = clientes[i].Persona.apellidoPaterno;
    document.getElementById("apellido_materno").value = clientes[i].Persona.apellidoMaterno;
    document.getElementById("genero").value = clientes[i].Persona.genero;
    document.getElementById("fecha_nacimiento").value = clientes[i].Persona.fechaNacimiento;
    document.getElementById("rfc").value = clientes[i].Persona.rfc;
    document.getElementById("curp").value = clientes[i].Persona.curp;
    document.getElementById("domicilio").value = clientes[i].Persona.domicilio;
    document.getElementById("codigo_postal").value = clientes[i].Persona.codigoPostal;
    document.getElementById("ciudad").value = clientes[i].Persona.ciudad;
    document.getElementById("estado").value = clientes[i].Persona.estado;
    document.getElementById("telefono").value = clientes[i].Persona.telefono;
    document.getElementById("textoFoto").value = clientes[i].Persona.foto;

    document.getElementById("idCliente").value = clientes[i].idCliente;
    document.getElementById("fechaRegistro").value = clientes[i].fechaRegistro;
    document.getElementById("email").value = clientes[i].email;
    document.getElementById("estatus").value = clientes[i].estatus;
    
}

function activarCliente(i) {
    let idCliente = clientes[i].idCliente;
    fetch("http://localhost:8080/sicefasucursal/api/cliente/regresar?idCli=" + idCliente)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Cliente activado ", "success");
                cargarCatalogoClientes();
            });
}

function eliminarCliente(i) {
    let idCliente = clientes[i].idCliente;
    fetch("http://localhost:8080/sicefasucursal/api/cliente/delete?idC=" + idCliente)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Cliente eliminado correctamente ", "success");
                cargarCatalogoClientes();
            });

}

function cargarImagen() {
    var inputFoto = document.getElementById('inputFoto');
    var imgFoto = document.getElementById('imgFoto');
    var textoFoto = document.getElementById('textoFoto');
    if (inputFoto.files && inputFoto.files[0]) {
        var lector = new FileReader();
        lector.onload = function (c) {
            imgFoto.src = c.target.result;
            textoFoto.value = c.target.result;
        };
        lector.readAsDataURL(inputFoto.files[0]);
    }
}

function buscar(){
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("campoBusqueda").value.toLowerCase();
    // Filtra los empleados en base al valor de búsqueda
    let clientesFiltrados = clientes.filter(cliente => {

        let datosCliente = `${cliente.Persona.nombre} ${cliente.Persona.apellidoPaterno} ${cliente.Persona.apellidoMaterno} ${cliente.Persona.fechaNacimiento} ${cliente.Persona.rfc} ${cliente.Persona.curp} ${cliente.Persona.domicilio} ${cliente.Persona.codigoPostal} ${cliente.Persona.ciudad} ${cliente.Persona.estado} ${cliente.Persona.telefono} ${cliente.fechaRegistro} ${cliente.email}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosCliente.includes(input);
    });
    
    mostrarClientes(clientesFiltrados);
}
function mostrarClientes(clientes) {
    let mostrar = "";
    for (let i = 0; i < clientes.length; i++) {
                    let datos1 = clientes[i].Persona.nombre + " "
                            + clientes[i].Persona.apellidoPaterno + " "
                            + clientes[i].Persona.apellidoMaterno;
                    let datos2 = clientes[i].Persona.fechaNacimiento + " - "
                            + clientes[i].Persona.rfc + " - "
                            + clientes[i].Persona.curp;

                    let datos3 = clientes[i].Persona.domicilio + " - "
                            + clientes[i].Persona.codigoPostal + " - "
                            + clientes[i].Persona.ciudad + " - "
                            + clientes[i].Persona.estado;

                    let datos4 = clientes[i].Persona.telefono;

                    let datos5 = clientes[i].email;

                    let datos6 = clientes[i].fechaRegistro;

                    mostrar += "<tr>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' data-toggle='modal' data-target='#myModalEx' onclick='SeleccionarCliente(" + i + ");'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
                    mostrar += "<td>";
                    if (clientes[i].estatus === 0) {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarCliente(" + i + ");'><i class='bi bi-check-square-fill'></i> Activar </button>";
                    } else {
                         mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarCliente(" + i + ");'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("catalogoClientes").innerHTML = mostrar;
}