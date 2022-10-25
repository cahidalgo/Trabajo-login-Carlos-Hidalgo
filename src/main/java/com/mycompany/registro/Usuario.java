package com.mycompany.registro;

/**
 *
 * @author Carlos
 */
public class Usuario {
    private String nombre;
    private String user;
    private String email;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String nombre,String user, String email, String contraseña) {
        this.nombre=nombre;
        this.user = user;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    public String getContraseña() {
        return contraseña;
    }
    
    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", user=" + user + ", email=" + email + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
