function fecha1(){
    
let fechaActual = new Date();

let labelFecha = document.getElementById("fechaActual");

let opcionesFecha = { weekday: 'long', year: 'numeric', month: '2-digit', day: '2-digit' };
let fechaFormateada = fechaActual.toLocaleDateString('es-ES', opcionesFecha);

labelFecha.textContent = fechaFormateada;

}
function fecha2(){
    
let fechaActual = new Date();

let labelFecha = document.getElementById("fechaActual2");

let opcionesFecha = { weekday: 'long', year: 'numeric', month: '2-digit', day: '2-digit' };
let fechaFormateada = fechaActual.toLocaleDateString('es-ES', opcionesFecha);

labelFecha.textContent = fechaFormateada;

}
