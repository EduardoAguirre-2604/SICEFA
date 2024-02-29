package org.utl.dsm403.sicefa.model;

public class Pedido {
    private int idCompra;
    private String fecha;
    private int estatus;
    private String nombreSucursal;
    private String codigoPostalSucursal;
    private String ciudadSucursal;
    private String estadoSucursal;
    private String nombreEmpleado;
    private String nombreProducto;
    private int cantidadProducto;
    private float precioCompra;
    private double totalPedido;

    public Pedido() {
    }

    public Pedido(int idCompra, String fecha, int estatus, String nombreSucursal, String codigoPostalSucursal, String ciudadSucursal, String estadoSucursal, String nombreEmpleado, String nombreProducto, int cantidadProducto, float precioCompra, double totalPedido) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.estatus = estatus;
        this.nombreSucursal = nombreSucursal;
        this.codigoPostalSucursal = codigoPostalSucursal;
        this.ciudadSucursal = ciudadSucursal;
        this.estadoSucursal = estadoSucursal;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioCompra = precioCompra;
        this.totalPedido = totalPedido;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCodigoPostalSucursal() {
        return codigoPostalSucursal;
    }

    public void setCodigoPostalSucursal(String codigoPostalSucursal) {
        this.codigoPostalSucursal = codigoPostalSucursal;
    }

    public String getCiudadSucursal() {
        return ciudadSucursal;
    }

    public void setCiudadSucursal(String ciudadSucursal) {
        this.ciudadSucursal = ciudadSucursal;
    }

    public String getEstadoSucursal() {
        return estadoSucursal;
    }

    public void setEstadoSucursal(String estadoSucursal) {
        this.estadoSucursal = estadoSucursal;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compra{");
        sb.append("idCompra:").append(idCompra);
        sb.append(", fecha:").append(fecha);
        sb.append(", estatus:").append(estatus);
        sb.append(", nombreSucursal:").append(nombreSucursal);
        sb.append(", codigoPostalSucursal:").append(codigoPostalSucursal);
        sb.append(", ciudadSucursal:").append(ciudadSucursal);
        sb.append(", estadoSucursal:").append(estadoSucursal);
        sb.append(", nombreEmpleado:").append(nombreEmpleado);
        sb.append(", nombreProducto:").append(nombreProducto);
        sb.append(", cantidadProducto:").append(cantidadProducto);
        sb.append(", precioCompra:").append(precioCompra);
        sb.append(", totalPedido:").append(totalPedido);
        sb.append('}');
        return sb.toString();
    }
    
    
}
