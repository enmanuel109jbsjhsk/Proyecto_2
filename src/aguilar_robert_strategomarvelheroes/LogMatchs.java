/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aguilar_robert_strategomarvelheroes;

/**
 *
 * @author Selvin Aguilar
 */
public class LogMatchs {
    public String jugador;
    public String resultado;
    public String bando;
    public String oponente;
    public String fecha;

    public LogMatchs(String jugador, String resultado, String bando, String oponente, String fecha) {
        this.jugador = jugador;
        this.resultado = resultado;
        this.bando = bando;
        this.oponente = oponente;
        this.fecha = fecha;
    }

    public String getJugador() { return jugador; }
    public String getResultado() { return resultado; }
    public String getBando() { return bando; }
    public String getOponente() { return oponente; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Fecha: " + fecha +
               "\nResultado: " + resultado +
               "\nBando: " + bando +
               "\nOponente: " + oponente +
               "\n------------------------\n";
    }
}
