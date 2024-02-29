/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm403.sicefa.model;

/**
 *
 * @author perez
 */
public class Cliente {
    private int idCliente;
    private String email;
    private String fechaRegistro;
    private int estatus;
    private Persona Persona;

    public Cliente(){
        
    }

    public Cliente(int idCliente, String email, String fechaRegistro, int estatus, Persona Persona) {
        this.idCliente = idCliente;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
        this.Persona = Persona;
    }

    public Cliente(String email, String fechaRegistro, int estatus, Persona Persona) {
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
        this.Persona = Persona;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente:").append(idCliente);
        sb.append(", email:").append(email);
        sb.append(", fechaRegistro:").append(fechaRegistro);
        sb.append(", estatus:").append(estatus);
        sb.append(", Persona:").append(Persona);
        sb.append('}');
        return sb.toString();
    }  
}
