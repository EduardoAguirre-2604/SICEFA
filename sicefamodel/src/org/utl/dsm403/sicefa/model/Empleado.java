package org.utl.dsm403.sicefa.model;

public class Empleado {
    private int idEmpleado;
    private String codigo;
    private String fechaIngreso;
    private String puesto;
    private float salarioBruto;
    private String email;
    private int activo;
    private Persona persona; //objEmpleado.persona.getIdPersona();
    private Usuario usuario;
    private Sucursal sucursal;
    
    public Empleado(){
        
    }

    public Empleado(int idEmpleado, String codigo, String fechaIngreso, String puesto, float salarioBruto, String email, int activo, Persona persona, Usuario usuario, Sucursal sucursal) {
        this.idEmpleado = idEmpleado;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salarioBruto = salarioBruto;
        this.email = email;
        this.activo = activo;
        this.persona = persona;
        this.usuario = usuario;
        this.sucursal = sucursal;
    }

    public Empleado(String codigo, String fechaIngreso, String puesto, float salarioBruto, String email, int activo, Persona persona, Usuario usuario, Sucursal sucursal) {
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salarioBruto = salarioBruto;
        this.email = email;
        this.activo = activo;
        this.persona = persona;
        this.usuario = usuario;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado:").append(idEmpleado);
        sb.append(", codigo:").append(codigo);
        sb.append(", fechaIngreso:").append(fechaIngreso);
        sb.append(", puesto:").append(puesto);
        sb.append(", salarioBruto:").append(salarioBruto);
        sb.append(", email:").append(email);
        sb.append(", activo:").append(activo);
        sb.append(", persona:").append(persona);
        sb.append(", usuario:").append(usuario);
        sb.append(", sucursal:").append(sucursal);
        sb.append('}');
        return sb.toString();
    }
}
