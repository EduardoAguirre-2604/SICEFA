/* global fetch, Swal */

function ingresar() {
    let u = document.getElementById("username").value;
    let c = document.getElementById("password").value;
    let params = {u: u, c: c};
    let ruta = "http://localhost:8080/sicefasucursal/api/acceso/login";
    fetch(ruta,
        {
            method: "POST",
            headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
            body: new URLSearchParams(params)
        })
        .then(response => response.json())
        .then(response => {

            if (response.rol === "ADMC") {
                Swal.fire("BIENVENIDO","¡Administrador Central!", "success")
                .then(() => {
                    location.href = "http://localhost:8080/sicefasucursal/Principal.html";
                });
            } else if (response.rol === "ADMS") {
                Swal.fire("BIENVENIDO","¡Administrador Sucursal!", "success")
                .then(() => {
                    location.href = "http://localhost:8080/sicefasucursal/Principal.html";
                });
            } else if (response.rol === "EMPS") {
                Swal.fire("BIENVENIDO","¡Empleado!", "success")
                .then(() => {
                    location.href = "http://localhost:8080/sicefasucursal/Principal.html";
                });
            } else if (response.rol === "ERROR") {
                Swal.fire("INVALIDO","¡Credencial Incorrecta!", "error");
                document.getElementById("username").value = "";
                document.getElementById("password").value = "";
            }
        });
}
