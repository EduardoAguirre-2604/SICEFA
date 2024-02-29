function loginSucursal() {
    let usu = document.getElementById("txtUsuario2").value;
    let con = document.getElementById("txtContrasenia2").value;
    let params = {u: usu, c: con};
    let ruta = "http://localhost:8080/sicefasucursal/api/acceso/login";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.rol === "ADMC") {
                    Swal.fire({
                        title: "Bienvenido",
                        text: "Administrador",
                        icon: "success"
                    })
                            .then(() => {
                                location.href = "http://localhost:8080/sicefasucursal/Principal_Sucursal.html";
                            });
                } else if (response.rol === "ADMS") {
                    Swal.fire({
                        title: "Bienvenido",
                        text: "Administrador Sucursal",
                        icon: "success"
                    })
                            .then(() => {
                                location.href = "http://localhost:8080/sicefasucursal/Principal_Sucursal.html";
                            });
                } else if (response.rol === "EMPS") {
                    Swal.fire({
                        title: "Bienvenido",
                        text: "Empleado",
                        icon: "success"
                    })
                            .then(() => {
                                location.href = "http://localhost:8080/sicefasucursal/Principal_Sucursal.html";
                            });
                } else if (response.rol === "ERROR") {

                    Swal.fire({
                        title: "Error",
                        text: "Sin Acceso",
                        icon: "error"
                    });
                    document.getElementById("txtUsuario2").value = "";
                    document.getElementById("txtContrasenia2").value = "";
                }

            });
}
function loginCentral() {
    let usu = document.getElementById("txtUsuario").value;
    let con = document.getElementById("txtContrasenia").value;
    let params = {u: usu, c: con};
    let ruta = "http://localhost:8080/sicefasucursal/api/acceso/login";
    fetch(ruta,
            {method: "POST",
                headers: {'Content-Type':
                            'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.rol === "ADMC") {
                    Swal.fire({
                        title: "Bienvenido",
                        text: "Administrador",
                        icon: "success"
                    })
                            .then(() => {
                                location.href = "http://localhost:8080/sicefasucursal/Principal_Central.html";
                            });
                } else if (response.rol === "ADMS") {
                    Swal.fire({
                        title: "Error",
                        text: "Sin Acceso",
                        icon: "error"
                    });
                    document.getElementById("txtUsuario").value = "";
                    document.getElementById("txtContrasenia").value = "";
                } else if (response.rol === "EMPS") {
                    Swal.fire({
                        title: "Error",
                        text: "Sin Acceso",
                        icon: "error"
                    });
                    document.getElementById("txtUsuario").value = "";
                    document.getElementById("txtContrasenia").value = "";
                } else if (response.rol === "ERROR") {

                    Swal.fire({
                        title: "Error",
                        text: "Sin Acceso",
                        icon: "error"
                    });
                    document.getElementById("txtUsuario").value = "";
                    document.getElementById("txtContrasenia").value = "";
                }

            });
}