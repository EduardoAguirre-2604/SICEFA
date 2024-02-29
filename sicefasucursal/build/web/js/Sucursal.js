
/* global H */

let sucursales;
var ui;
var group;
var map;
function cargarSucursales() {
    // Obtener el valor del checkbox
    const mostrarInactivos = document.getElementById("chkestatusp").checked;

    // Construir la URL de la solicitud fetch basada en el estado del checkbox
    const url = mostrarInactivos
            ? "http://localhost:8080/sicefasucursal/api/sucursal/getAll?estatus=false"
            : "http://localhost:8080/sicefasucursal/api/sucursal/getAll?estatus=true";
    fetch(url)
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                sucursales = response;
                for (let i = 0; i < response.length; i++) {
                    let datos1 = response[i].nombre;
                    let datos2 = response[i].titular;
                    let datos3 = response[i].rfc;
                    let datos4 = response[i].domicilio;
                    let datos5 = response[i].colonia;
                    let datos6 = response[i].codigoPostal;
                    let datos7 = response[i].ciudad;
                    let datos8 = response[i].estado;
                    let datos9 = response[i].telefono;
                    let datos10 = response[i].latitud;
                    let datos11 = response[i].longitud;
                    mostrar += "<tr>";
                    mostrar += "<td> " + datos1 + " </td> ";
                    mostrar += "<td> " + datos2 + "</td>";
                    mostrar += "<td> " + datos3 + " </td> ";
                    mostrar += "<td> " + datos4 + " </td> ";
                    mostrar += "<td> " + datos5 + " </td> ";
                    mostrar += "<td> " + datos6 + " </td> ";
                    mostrar += "<td> " + datos7 + " </td>";
                    mostrar += "<td> " + datos8 + " </td>";
                    mostrar += "<td> " + datos9 + " </td>";
                    mostrar += "<td> " + datos10 + " </td>";
                    mostrar += "<td> " + datos11 + " </td>";
                    mostrar += "<td><button class='btn btn-warning btn-md font-weight-bold font-italic' type='button' data-toggle='modal' data-target='#myModal' onclick='seleccionarSucursal(" + i + ");'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
                    mostrar += "<td>";
                    if (response[i].estatus === 0) {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarSucursal(" + i + ");'><i class='bi bi-check-square-fill'></i> Activar </button>";
                    } else {
                        mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarSucursal(" + i + ");'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblSucursal").innerHTML = mostrar;
            });

}

function cargarSucursalesMap() {
    fetch("http://localhost:8080/sicefasucursal/api/sucursal/getAll?estatus=true").
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
                document.getElementById("nombreS").innerHTML = datosSuc;
            });
}

function seleccionarSucursal(i) {
    
    document.getElementById("nombreSucursal").value = sucursales[i].nombre;
    document.getElementById("nombreTitular").value = sucursales[i].titular;
    document.getElementById("rfc").value = sucursales[i].rfc;
    document.getElementById("domicilio").value = sucursales[i].domicilio;
    document.getElementById("colonia").value = sucursales[i].colonia;
    document.getElementById("codigoPostal").value = sucursales[i].codigoPostal;
    document.getElementById("ciudad").value = sucursales[i].ciudad;
    document.getElementById("estado").value = sucursales[i].estado;
    document.getElementById("telefono").value = sucursales[i].telefono;
    document.getElementById("latitud").value = sucursales[i].latitud;
    document.getElementById("longitud").value = sucursales[i].longitud;
    document.getElementById("estatus").value = sucursales[i].estatus;
    document.getElementById("idSucursal").value = sucursales[i].idSucursal;
}

function eliminarSucursal(i) {
    let idSucursal = sucursales[i].idSucursal;
    fetch("http://localhost:8080/sicefasucursal/api/sucursal/deleteSuc?idS=" + idSucursal)
            .then(response => response.json()).then(response => {
        swal.fire(response.result, "Sucursal Eliminada", "Succes");
        cargarSucursales();
    });
}

function activarSucursal(i) {
    let idSucursal = sucursales[i].idSucursal;
    fetch("http://localhost:8080/sicefasucursal/api/sucursal/activeSuc?idSuc=" + idSucursal)
            .then(response => response.json()).then(response => {
        swal.fire(response.result, "Sucursal Activada", "Success");
        cargarSucursales();
    });
}

function insertarSucursal() {
    let ns = document.getElementById("nombreSucursalAgregar").value;
    let nt = document.getElementById("nombreTitularAgregar").value;
    let rfc = document.getElementById("rfcAgregar").value;
    let dmc = document.getElementById("domicilioAgregar").value;
    let col = document.getElementById("coloniaAgregar").value;
    let estado = document.getElementById("estadoAgregar").value;
    let codP = document.getElementById("codigoPostalAgregar").value;
    let ciu = document.getElementById("ciudadAgregar").value;
    let tel = document.getElementById("telefonoAgregar").value;
    let lat = document.getElementById("latitudAgregar").value;
    let long = document.getElementById("longitudAgregar").value;
    let estatus = document.getElementById("estatusAgregar").value;
    let idSuc = parseInt(document.getElementById("idSucursalAgregar").value);

    let sucursal = {
        nombre: ns, titular: nt, rfc: rfc,
        domicilio: dmc, colonia: col, codigoPostal: codP,
        ciudad: ciu, estado: estado, telefono: tel, latitud: lat, longitud: long, estatus: estatus,
        idSucursal: idSuc};

    let params = {s: JSON.stringify(sucursal)};

    let ruta = "http://localhost:8080/sicefasucursal/api/sucursal/insertarSucursal?";
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
                    Swal.fire("Problemas al insertar", response.error, "ERROR");

                }
                cargarSucursales();
            });


}

function modificarSucursal() {
    let ns = document.getElementById("nombreSucursal").value;
    let nt = document.getElementById("nombreTitular").value;
    let rfc = document.getElementById("rfc").value;
    let dmc = document.getElementById("domicilio").value;
    let col = document.getElementById("colonia").value;
    let estado = document.getElementById("estado").value;
    let codP = document.getElementById("codigoPostal").value;
    let ciu = document.getElementById("ciudad").value;
    let tel = document.getElementById("telefono").value;
    let lat = document.getElementById("latitud").value;
    let long = document.getElementById("longitud").value;
    let estatus = document.getElementById("estatus").value;
    let idSuc = parseInt(document.getElementById("idSucursal").value);

    let sucursal = {
        nombre: ns, titular: nt, rfc: rfc,
        domicilio: dmc, colonia: col, codigoPostal: codP,
        ciudad: ciu, estado: estado, telefono: tel, latitud: lat, longitud: long, estatus: estatus,
        idSucursal: idSuc};

    let params = {suc: JSON.stringify(sucursal)};

    let ruta = "http://localhost:8080/sicefasucursal/api/sucursal/update?";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire("Modificacion correcta", response.result, "success");
                }
                if (response.error) {
                    Swal.fire("Problemas al modificar", response.error, "ERROR");

                }
                cargarSucursales();
            });


}

function buscarSucursales() {
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("busqueda").value.toLowerCase();

    // Filtra los empleados en base al valor de búsqueda
    let sucursalesFiltradas = sucursales.filter(sucursal => {

        let datosSucursal = `${sucursal.nombre} ${sucursal.titular} ${sucursal.rfc} ${sucursal.domicilio} ${sucursal.colonia}${sucursal.codigoPostal}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosSucursal.includes(input);

    });
    mostrarSucursales(sucursalesFiltradas);
}


function mostrarSucursales(sucursales) {

    let mostrar = "";
    for (let i = 0; i < sucursales.length; i++) {
        let datos1 = sucursales[i].nombre;
        let datos2 = sucursales[i].titular;
        let datos3 = sucursales[i].rfc;
        let datos4 = sucursales[i].domicilio;
        let datos5 = sucursales[i].colonia;
        let datos6 = sucursales[i].codigoPostal;
        let datos7 = sucursales[i].ciudad;
        let datos8 = sucursales[i].estado;
        let datos9 = sucursales[i].telefono;
        let datos10 = sucursales[i].latitud;
        let datos11 = sucursales[i].longitud;
        mostrar += "<tr>";
        mostrar += "<td> " + datos1 + " </td> ";
        mostrar += "<td> " + datos2 + "</td>";
        mostrar += "<td> " + datos3 + " </td> ";
        mostrar += "<td> " + datos4 + " </td> ";
        mostrar += "<td> " + datos5 + " </td> ";
        mostrar += "<td> " + datos6 + " </td> ";
        mostrar += "<td> " + datos7 + " </td>";
        mostrar += "<td> " + datos8 + " </td>";
        mostrar += "<td> " + datos9 + " </td>";
        mostrar += "<td> " + datos10 + " </td>";
        mostrar += "<td> " + datos11 + " </td>";
        mostrar += "<td><button class='btn btn-warning btn-md font-weight-bold font-italic' type='button' data-toggle='modal' data-target='#myModal' onclick='seleccionarSucursal(" + i + ");'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar </button> </td>";
        mostrar += "<td>";
        if (sucursales[i].estatus === 0) {
            mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='activarSucursal(" + i + ");'><i class='bi bi-check-square-fill'></i> Activar </button>";
        } else {
            mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarSucursal(" + i + ");'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
        }
        mostrar += "</td>";
        mostrar += "</tr>";
    }
    document.getElementById("tblSucursal").innerHTML = mostrar;
}

function agregarMarcasAGrupo(group, coordinate, html) {
    var marker = new H.map.Marker(coordinate);
    // add custom data to the marker
    marker.setData(html);
    group.addObject(marker);
}

function agregarBurbujas(map) {
     group = new H.map.Group();

    map.addObject(group);

    // add 'tap' event listener, that opens info bubble, to the group
    group.addEventListener('tap', function (evt) {
        // event target is the marker itself, group is a parent event target
        // for all objects that it contains
        var bubble = new H.ui.InfoBubble(evt.target.getGeometry(), {
            // read custom data
            content: evt.target.getData()
        });
        // show info bubble
        ui.addBubble(bubble);
    }, false);

    agregarMarcasAGrupo(group, {lat: 21.0994063, lng: -101.635549320748},
            '<div><a target="_blank">Sucursal Centro Max</a></div>' +
            '<div>Leon, GTO<br /> C.P: 37530</div>');

    agregarMarcasAGrupo(group, {lat: 21.12394441, lng: -101.68101896},
            '<div><a target="_blank">Sucursal Centro</a></div>' +
            '<div>Leon, GTO<br />C.P: 37000</div>');

    agregarMarcasAGrupo(group, {lat: 21.1580824, lng: -101.695276},
            '<div><a target="_blank">Sucursal Plaza Mayor</a></div>' +
            '<div>Leon, GTO<br />C.P: 37150</div>');

    agregarMarcasAGrupo(group, {lat: 21.0625, lng: -101.57861111},
            '<div><a target="_blank">Sucursal Central</a></div>' +
            '<div>Leon, GTO<br />C.P: 37670</div>');
    
    var sucursalSeleccionada = document.getElementById("nombreS");
    
    sucursalSeleccionada.addEventListener('change', function(){
        
        var sucursalS = sucursalSeleccionada.value;
        var geoloc;
                switch (sucursalS){
                   case 'Sucursal Centro Max':
                geoloc = { lat: 21.0994063, lng: -101.635549320748 };
                break;
            case 'Sucursal Centro':
                geoloc = { lat: 21.12394441, lng: -101.68101896 };
                break;
            case 'Sucursal Plaza Mayor':
                geoloc = { lat: 21.1580824, lng: -101.695276 };
                break;
            case 'Sucursal Central':
                geoloc = { lat: 21.0625, lng: -101.57861111 };
                break;
            default:
                geoloc = null; 
        }
        if (geoloc) {
            group.removeAll();
            
            agregarMarcasAGrupo(group, geoloc, '<div>' + sucursalS + '</div>');
            var markers = group.getObjects();
            var marker = markers[0];
            if (marker) {
                // Obtener la geometría del marcador y mostrar la burbuja
                var geometry = marker.getGeometry();
                var bubble = new H.ui.InfoBubble(geometry, {
                    content: marker.getData()
                });
                ui.addBubble(bubble);
            
            map.setCenter(geoloc);
        }
        }
    });
    
}

function cargarMapasSuc() {
    
    var platform = new H.service.Platform({
        apikey: 'wa3-7SjBrxIxpIVWO1rRJgflN9YveHtj4YzY7FkttDk'
    });
    var defaultLayers = platform.createDefaultLayers();

// initialize a map - this map is centered over Europe
     map = new H.Map(document.getElementById("mapa3"),
            defaultLayers.vector.normal.map, {
                center: {lat: 21.12394441, lng: -101.68101896},
                zoom: 12,
                pixelRatio: window.devicePixelRatio || 1
            });

// add a resize listener to make sure that the map occupies the whole container
    window.addEventListener('resize', () => map.getViewPort().resize());

// MapEvents enables the event system
// Behavior implements default interactions for pan/zoom (also on mobile touch environments)
    var behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));

// create default UI with layers provided by the platform
    ui = H.ui.UI.createDefault(map, defaultLayers);

// Now use the map as required...
    agregarBurbujas(map);
    }


//var abrirModalBtn = document.getElementById("abrirModal");
//var cerrarModalBtn = document.getElementById("cerrarModal");
//var modal = document.getElementById("modalMapa");
//
//
//    abrirModalBtn.onclick = function(){
//        modal.style.display = 'block';
//        cargarMapasSuc();
//        
//        
//    };
//    
//    cerrarModalBtn.onclick = function(){
//        modal.style.display = 'none';
//        
//    };
//    
//    // funcion para cerrar el modal cada que se de click fuera de el
//    window.onclick = function(event){
//        if (event.target === modal) {
//        modal.style.display = 'none';
//        
//        }
//    };








