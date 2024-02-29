/* global Swal, fetch */

let empleados;
function cargarCatEmpleado() {
    // Obtener el valor del checkbox
    const mostrarInactivos = document.getElementById("autopista").checked;

    // Construir la URL de la solicitud fetch basada en el estado del checkbox
    const url = mostrarInactivos
            ? "http://localhost:8080/sicefasucursal/api/empleado/getAll?activo=false"
            : "http://localhost:8080/sicefasucursal/api/empleado/getAll?activo=true";
    fetch(url)
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                empleados = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].fechaIngreso + " - " +
                            response[i].puesto + " - " +
                            response[i].salarioBruto + " - " +
                            response[i].email;
                    let datos2 = response[i].persona.nombre + " " +
                            response[i].persona.apellidoPaterno + " " +
                            response[i].persona.apellidoMaterno;
                    let datos3 = response[i].persona.fechaNacimiento + " - " +
                            response[i].persona.rfc + " - " +
                            response[i].persona.curp;
                    let datos4 = response[i].persona.domicilio + " - " +
                            response[i].persona.codigoPostal + " - " +
                            response[i].persona.ciudad + " - " +
                            response[i].persona.estado;
                    let datos5 = response[i].usuario.nombreUsuario + " - " +
                            response[i].usuario.rol;
                    let datos6 = response[i].sucursal.nombre + " - " +
                            response[i].sucursal.domicilio + " - " +
                            response[i].sucursal.colonia + " - " +
                            response[i].sucursal.telefono;
                    mostrar += "<tr>";
                    mostrar += "<td>" + response[i].codigo + "</td>";
                    mostrar += "<td>" + datos1 + "</td>";
                    mostrar += "<td>" + datos2 + "</td>";
                    mostrar += "<td>" + datos3 + "</td>";
                    mostrar += "<td>" + datos4 + "</td>";
                    mostrar += "<td>" + response[i].persona.telefono + "</td>";
                    mostrar += "<td>" + datos5 + "</td>";
                    mostrar += "<td>" + datos6 + "</td>";
                    mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' data-toggle='modal' data-target='#myModalEx' onclick='modificarEmpleado(" + i + ");'> <i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
                    mostrar += "<td>";
                    if (response[i].activo === 0) {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarEmpleado(" + i + ");'> <i class='bi bi-check-square-fill'></i> Activar </button>";
                    } else {
                        mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarEmpleado(" + i + ");'> <i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblEmpleados").innerHTML = mostrar;
            });
}
function buscarEmpleados() {
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("inputBusqueda").value.toLowerCase();

    // Filtra los empleados en base al valor de búsqueda
    let empleadosFiltrados = empleados.filter(empleado => {

        let datosEmpleado = `${empleado.codigo} ${empleado.fechaIngreso} ${empleado.puesto} ${empleado.salarioBruto} ${empleado.email} ${empleado.persona.nombre} ${empleado.persona.apellidoPaterno} ${empleado.persona.apellidoMaterno} ${empleado.persona.fechaNacimiento} ${empleado.persona.rfc} ${empleado.persona.curp} ${empleado.persona.domicilio} ${empleado.persona.codigoPostal} ${empleado.persona.ciudad} ${empleado.persona.estado} ${empleado.persona.telefono} ${empleado.usuario.nombreUsuario} ${empleado.usuario.rol} ${empleado.sucursal.nombre} ${empleado.sucursal.domicilio} ${empleado.sucursal.colonia} ${empleado.sucursal.telefono}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosEmpleado.includes(input);
    });

    mostrarEmpleados(empleadosFiltrados);
}

function mostrarEmpleados(empleados) {
    let mostrar = "";
    for (let i = 0; i < empleados.length; i++) {
        let datos1 = empleados[i].fechaIngreso + " - " +
                empleados[i].puesto + " - " +
                empleados[i].salarioBruto + " - " +
                empleados[i].email;
        let datos2 = empleados[i].persona.nombre + " " +
                empleados[i].persona.apellidoPaterno + " " +
                empleados[i].persona.apellidoMaterno;
        let datos3 = empleados[i].persona.fechaNacimiento + " - " +
                empleados[i].persona.rfc + " - " +
                empleados[i].persona.curp;
        let datos4 = empleados[i].persona.domicilio + " - " +
                empleados[i].persona.codigoPostal + " - " +
                empleados[i].persona.ciudad + " - " +
                empleados[i].persona.estado;
        let datos5 = empleados[i].usuario.nombreUsuario + " - " +
                empleados[i].usuario.rol;
        let datos6 = empleados[i].sucursal.nombre + " - " +
                empleados[i].sucursal.domicilio + " - " +
                empleados[i].sucursal.colonia + " - " +
                empleados[i].sucursal.telefono;
        mostrar += "<tr>";
        mostrar += "<td>" + empleados[i].codigo + "</td>";
        mostrar += "<td>" + datos1 + "</td>";
        mostrar += "<td>" + datos2 + "</td>";
        mostrar += "<td>" + datos3 + "</td>";
        mostrar += "<td>" + datos4 + "</td>";
        mostrar += "<td>" + empleados[i].persona.telefono + "</td>";
        mostrar += "<td>" + datos5 + "</td>";
        mostrar += "<td>" + datos6 + "</td>";
        mostrar += "<td> <button class='btn btn-warning btn-md font-weight-bold font-italic' data-toggle='modal' data-target='#myModalEx' onclick='modificarEmpleado(" + i + ");'> <i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
        mostrar += "<td>";
        if (empleados[i].activo === 0) {
            mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarEmpleado(" + i + ");'> <i class='bi bi-check-square-fill'></i> Activar </button>";
        } else {
            mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarEmpleado(" + i + ");'> <i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
        }
        mostrar += "</td>";
        mostrar += "</tr>";
    }
    document.getElementById("tblEmpleados").innerHTML = mostrar;
}

function eliminarEmpleado(i) {
    let idEmpleado = empleados[i].idEmpleado;

    fetch("http://localhost:8080/sicefasucursal/api/empleado/delete?idE=" + idEmpleado)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Empleado eliminado con éxito", "success");
                cargarCatEmpleado();
            });
}
function activarEmpleado(i) {
    let idEmpleado = empleados[i].idEmpleado;

    fetch("http://localhost:8080/sicefasucursal/api/empleado/activar?idE=" + idEmpleado)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Empleado activado con éxito", "success");
                cargarCatEmpleado();
            });
}

function obtenerDatosEmpleado() {
    let idPersona = document.getElementById("idPersona").value;
    let nombres = document.getElementById("nombres").value;
    let apellidoPaterno = document.getElementById("apellido_paterno").value;
    let apellidoMaterno = document.getElementById("apellido_materno").value;
    let genero = document.getElementById("genero").value;
    let fechaNacimientoInput = document.getElementById("fecha_nacimiento");

    let fechaNacimiento = new Date(fechaNacimientoInput.value);

    let fechaNacimientoComoString = fechaNacimiento.toISOString().split('T')[0];
    let rfc = document.getElementById("rfc").value;
    let curp = document.getElementById("curp").value;
    let domicilio = document.getElementById("domicilio").value;
    let codigoPostal = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;
    let telefono = document.getElementById("telefono").value;
    let foto = document.getElementById("textoFoto").value;
    let persona = {idPersona: parseInt(idPersona), nombre: nombres, apellidoPaterno: apellidoPaterno,
        apellidoMaterno: apellidoMaterno, genero: genero,
        fechaNacimiento: fechaNacimientoComoString, rfc: rfc,
        curp: curp, domicilio: domicilio, codigoPostal: codigoPostal,
        ciudad: ciudad, estado: estado, telefono: telefono, foto: foto};

    let idUsuario = document.getElementById("idUsuario").value;
    let nombreU = document.getElementById("usuario").value;
    let contrasenia = document.getElementById("contrasenia").value;
    let rol = document.getElementById("rol").value;
    let usuario = {idUsuario: parseInt(idUsuario), nombreUsuario: nombreU, contrasenia: contrasenia, rol: rol};

    let idSucursal = document.getElementById("idSucursal").value;
    let sucursal = {idSucursal: parseInt(idSucursal)};

    let idEmpleado = document.getElementById("idEmpleado").value;
    let codigo = document.getElementById("codigoEmpleado").value;
    let fechaIngreso = document.getElementById("fecha_ingreso").value;
    let puesto = document.getElementById("puesto").value;
    let salarioBrutoMensual = document.getElementById("salario_bruto_mensual").value;
    let email = document.getElementById("email").value;
    let activo = document.getElementById("estatus").value;

    let empleado = {idEmpleado: parseInt(idEmpleado), codigo: codigo, fechaIngreso: fechaIngreso, puesto: puesto,
        salarioBruto: parseFloat(salarioBrutoMensual), email: email, activo: parseInt(activo),
        persona: persona, usuario: usuario, sucursal: sucursal};

    let params = {e: JSON.stringify(empleado)};
    

    let ruta = "http://localhost:8080/sicefasucursal/api/empleado/insert?";

    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire(response.result, "¡Inserción Correcta!", "success");
                } else if (response.error) {
                    Swal.fire(response.result, "Problemas al Insertar", "error");
                }
                cargarCatEmpleado();
            });
}
function updateEmpleado() {
    let idPersona = document.getElementById("idPersona").value;
    let nombres = document.getElementById("nombres").value;
    let apellidoPaterno = document.getElementById("apellido_paterno").value;
    let apellidoMaterno = document.getElementById("apellido_materno").value;
    let genero = document.getElementById("genero").value;
    let fechaNacimientoInput = document.getElementById("fecha_nacimiento");

    let fechaNacimiento = new Date(fechaNacimientoInput.value);

    let fechaNacimientoComoString = fechaNacimiento.toISOString().split('T')[0];
    let rfc = document.getElementById("rfc").value;
    let curp = document.getElementById("curp").value;
    let domicilio = document.getElementById("domicilio").value;
    let codigoPostal = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;
    let telefono = document.getElementById("telefono").value;
    let foto = document.getElementById("textoFoto").value;
    let persona = {idPersona: parseInt(idPersona), nombre: nombres, apellidoPaterno: apellidoPaterno,
        apellidoMaterno: apellidoMaterno, genero: genero,
        fechaNacimiento: fechaNacimientoComoString, rfc: rfc,
        curp: curp, domicilio: domicilio, codigoPostal: codigoPostal,
        ciudad: ciudad, estado: estado, telefono: telefono, foto: foto};

    let idUsuario = document.getElementById("idUsuario").value;
    let nombreU = document.getElementById("usuario").value;
    let contrasenia = document.getElementById("contrasenia").value;
    let rol = document.getElementById("rol").value;
    let usuario = {idUsuario: parseInt(idUsuario), nombreUsuario: nombreU, contrasenia: contrasenia, rol: rol};

    let idSucursal = document.getElementById("idSucursal").value;
    let sucursal = {idSucursal: parseInt(idSucursal)};

    let idEmpleado = document.getElementById("idEmpleado").value;
    let codigo = document.getElementById("codigoEmpleado").value;
    let fechaIngreso = document.getElementById("fecha_ingreso").value;
    let puesto = document.getElementById("puesto").value;
    let salarioBrutoMensual = document.getElementById("salario_bruto_mensual").value;
    let email = document.getElementById("email").value;
    let activo = document.getElementById("estatus").value;

    let empleado = {idEmpleado: parseInt(idEmpleado), codigo: codigo, fechaIngreso: fechaIngreso, puesto: puesto,
        salarioBruto: parseFloat(salarioBrutoMensual), email: email, activo: parseInt(activo),
        persona: persona, usuario: usuario, sucursal: sucursal};

    let params = {e: JSON.stringify(empleado)};

    let ruta = "http://localhost:8080/sicefasucursal/api/empleado/update?";

    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire(response.result, "¡Modificación Correcta!", "success");
                } else if (response.error) {
                    Swal.fire(response.result, "Problemas al Modificar", "error");
                }
                cargarCatEmpleado();
            });
}
function modificarEmpleado(i) {
    document.getElementById("idPersona").value = empleados[i].persona.idPersona;
    document.getElementById("nombres").value = empleados[i].persona.nombre;
    document.getElementById("apellido_paterno").value = empleados[i].persona.apellidoPaterno;
    document.getElementById("apellido_materno").value = empleados[i].persona.apellidoMaterno;
    document.getElementById("genero").value = empleados[i].persona.genero;
    document.getElementById("fecha_nacimiento").value = empleados[i].persona.fechaNacimiento;
    document.getElementById("rfc").value = empleados[i].persona.rfc;
    document.getElementById("curp").value = empleados[i].persona.curp;
    document.getElementById("domicilio").value = empleados[i].persona.domicilio;
    document.getElementById("codigo_postal").value = empleados[i].persona.codigoPostal;
    document.getElementById("ciudad").value = empleados[i].persona.ciudad;
    document.getElementById("estado").value = empleados[i].persona.estado;
    document.getElementById("telefono").value = empleados[i].persona.telefono;
    document.getElementById("textoFoto").value = empleados[i].persona.foto;

    document.getElementById("idEmpleado").value = empleados[i].idEmpleado;
    document.getElementById("codigoEmpleado").value = empleados[i].codigo;
    document.getElementById("fecha_ingreso").value = empleados[i].fechaIngreso;
    document.getElementById("puesto").value = empleados[i].puesto;
    document.getElementById("salario_bruto_mensual").value = empleados[i].salarioBruto;
    document.getElementById("email").value = empleados[i].email;
    document.getElementById("estatus").value = empleados[i].activo;

    document.getElementById("idUsuario").value = empleados[i].usuario.idUsuario;
    document.getElementById("usuario").value = empleados[i].usuario.nombreUsuario;
    document.getElementById("contrasenia").value = empleados[i].usuario.contrasenia;
    document.getElementById("rol").value = empleados[i].usuario.rol;

    document.getElementById("idSucursal").value = empleados[i].sucursal.idSucursal;
}

function cargarSucursales() {
    fetch("http://localhost:8080/sicefasucursal/api/empleado/getAllSuc").
            then(response => response.json()).
            then(response => {
                let sucursales = response;
                let datosSuc = "";
                datosSuc += "<option value='' disabled selected>";
                datosSuc += "Selecciona la sucursal";
                datosSuc += "</option>";
                for (let i = 0; i < sucursales.length; i++) {
                    datosSuc += "<option value='" + sucursales[i].idSucursal + "'>";
                    datosSuc += sucursales[i].nombre;
                    datosSuc += "</option>";
                }
                document.getElementById("idSucursal").innerHTML = datosSuc;
            });
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
function leerFoto() {
    inputFile = document.getElementById("inputFoto");
    inputFile.onchange = function (evt) {
        cargarFotografia(inputFile);
    };
}

function cargarFotografia(objetoInputFile) {
    // Revisamos que el usuario haya seleccionado un archivo:
    if (objetoInputFile.files && objetoInputFile.files[0]) {
        let tipoArchivo = objetoInputFile.files[0].type;

        // Verificamos si el archivo seleccionado es una imagen
        if (tipoArchivo.startsWith('image/')) {
            let reader = new FileReader();

            // Agregamos un oyente al lector del archivo para que,
            // en cuanto el usuario cargue una imagen, esta se lea
            // y se convierta automáticamente en una cadena de Base64:
            reader.onload = function (e) {
                let fotoB64 = e.target.result;
                document.getElementById("imgFoto").src = fotoB64;
                document.getElementById("textoFoto").value = fotoB64;
            };

            // Leemos el archivo que seleccionó el usuario y lo
            // convertimos en una cadena con la Base64:
            reader.readAsDataURL(objetoInputFile.files[0]);
        } else {
            alert("Por favor, selecciona un archivo de imagen válido.");
            // Puedes agregar una lógica adicional aquí según tus necesidades.
        }
    }
}
