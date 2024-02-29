package org.utl.dsm403.sicefa.model;

public class Inventario {

    private int idInventario;
    private Producto producto;
    private int Sucursal;
    private int existencias;

    public Inventario() {
    }

    public Inventario(int idInventario, Producto Producto, int Sucursal, int existencias) {
        this.idInventario = idInventario;
        this.producto = Producto;
        this.Sucursal = Sucursal;
        this.existencias = existencias;
    }

    public Inventario(Producto Producto, int Sucursal, int existencias) {
        this.producto = Producto;
        this.Sucursal = Sucursal;
        this.existencias = existencias;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto Producto) {
        this.producto = Producto;
    }

    public int getSucursal() {
        return Sucursal;
    }

    public void setSucursal(int Sucursal) {
        this.Sucursal = Sucursal;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario{");
        sb.append("idInventario:").append(idInventario);
        sb.append(", Producto:").append(producto);
        sb.append(", Sucursal:").append(Sucursal);
        sb.append(", existencias:").append(existencias);
        sb.append('}');
        return sb.toString();
    }
}
