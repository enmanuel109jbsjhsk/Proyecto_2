/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aguilar_robert_strategomarvelheroes;

/**
 *
 * @author Selvin Aguilar
 */
public class BattleStats {
    public static int partidasJugadas = 0;
    public static int victoriasHeroes = 0;
    public static int victoriasVillanos = 0;

    public static void registrarVictoria(boolean heroeGano) {
        partidasJugadas++;
        if (heroeGano) {
            victoriasHeroes++;
        } else {
            victoriasVillanos++;
        }
    }

    public static int getPartidasJugadas() {
        return partidasJugadas;
    }

    public static int getVictoriasHeroes() {
        return victoriasHeroes;
    }

    public static int getVictoriasVillanos() {
        return victoriasVillanos;
    }
}
