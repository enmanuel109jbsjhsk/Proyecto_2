/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aguilar_robert_strategomarvelheroes;

/**
 *
 * @author Selvin Aguilar
 */
public class User {
    private String user;
    private String password;
    private int puntos;

    public User(String user, String password, int puntos) {
        this.user = user;
        this.password = password;
        puntos = 0;
    }

    public String getNombre() {
        return user;
    }

    public String getContrasena() {
        return password;
    }
    
    public int getPuntos(){
        return puntos;
    }
    public void setContrasena(String nuevaContrasena) {
    this.password = nuevaContrasena;
}
    public void setPuntos(int puntos) {
    this.puntos = puntos;
}
}