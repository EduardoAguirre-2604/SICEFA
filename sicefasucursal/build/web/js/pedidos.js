let pedidos;

function cargarCatPedidos() {
    // Obtener el valor del checkbox
    const mostrarAtendidos = document.getElementById("autopista").checked;
    // Construir la URL de la solicitud fetch basada en el estado del checkbox
    const url = mostrarAtendidos
            ? "http://localhost:8080/sicefasucursal/api/pedido/getAll?estatus=false"
            : "http://localhost:8080/sicefasucursal/api/pedido/getAll?estatus=true";
    fetch(url)
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                pedidos = response;
                for (let i = 0; i < response.length; i++) {
                    mostrar += "<tr>";
                    mostrar += "<td>" + response[i].idCompra + "</td>";
                    mostrar += "<td>" + response[i].fecha + "</td>";
                    mostrar += "<td>" + response[i].nombreSucursal + "</td>";
                    mostrar += "<td>" + response[i].codigoPostalSucursal + "</td>";
                    mostrar += "<td>" + response[i].ciudadSucursal + "</td>";
                    mostrar += "<td>" + response[i].estadoSucursal + "</td>";
                    mostrar += "<td>" + response[i].nombreEmpleado + "</td>";
                    mostrar += "<td>" + response[i].nombreProducto + "</td>";
                    mostrar += "<td>" + response[i].cantidadProducto + "</td>";
                    mostrar += "<td>" + response[i].precioCompra + "</td>";
                    mostrar += "<td>" + response[i].totalPedido + "</td>";
                    mostrar += "<td>";
                    if (response[i].estatus === 1) {
                        mostrar += "<button class='btn btn-warning btn-md font-weight-bold font-italic' onclick='atenderPedido(" + response[i].idCompra + ");'> <i class='bi bi-clipboard-data-fill'></i> PENDIENTE </button>";
                        mostrar += "<br> De clic para ATENDER";
                    } else {
                        mostrar += "<button class='btn btn-success btn-md font-weight-bold font-italic' onclick='' disable=''> ATENDIDA </button>";
                    }
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblPedidos").innerHTML = mostrar;
            });
}
function atenderPedido(idCompra) {
    fetch("http://localhost:8080/sicefasucursal/api/pedido/atender?idCompra=" + idCompra)
            .then(response => response.json())
            .then(response => {
                Swal.fire("ATENDIDO", "Pedido atendido con éxito", "success");
                cargarCatPedidos();
            });
}