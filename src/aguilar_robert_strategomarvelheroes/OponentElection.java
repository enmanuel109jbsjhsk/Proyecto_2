/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aguilar_robert_strategomarvelheroes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Selvin Aguilar
 */
public class OponentElection {
    // Variable estática para que esté disponible desde otras clases
    private static String oponenteSeleccionado;
    public static void mostrarSeleccionDeUsuario(String jugadorActual) {
        ArrayList<User> usuarios = UserManager.getUsuarios();
        ArrayList<String> nombresDisponibles = new ArrayList<>();

        for (User u : usuarios) {
            if (!u.getNombre().trim().equalsIgnoreCase(jugadorActual.trim())) {
                nombresDisponibles.add(u.getNombre());
            }
        }

        if (nombresDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay otros usuarios registrados para jugar contra.");
            oponenteSeleccionado = null;
            return;
        }

        String[] nombres = nombresDisponibles.toArray(new String[0]);
        oponenteSeleccionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un oponente:",
                "Elegir Oponente",
                JOptionPane.PLAIN_MESSAGE,
                null,
                nombres,
                nombres[0]
        );

        if (oponenteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún usuario.");
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Has seleccionado:\n" +
                "Oponente: " + oponenteSeleccionado);
    }
    
}
