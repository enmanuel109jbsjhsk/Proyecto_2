/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aguilar_robert_strategomarvelheroes;
import aguilar_robert_strategomarvelheroes.User;
import aguilar_robert_strategomarvelheroes.MyProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Selvin Aguilar
 */
public class UserManager {
    private static ArrayList<User> usuarios = new ArrayList<>();

    public static void agregarUsuario(User usuario) {
        usuarios.add(usuario);
    }

    public static ArrayList<User> getUsuarios() {
        return usuarios;
    }

    public static boolean verificarUsuario(String nombre, String contrasena) {
        for (User u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
    public static boolean usuarioExiste(String nombreUsuario) {
    for (User u : usuarios) {
        if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
            return true;
        }
    }
    return false;
}
    public static List<User> obtenerUsuariosOrdenadosPorNombreYPuntos() {
    List<User> copia = new ArrayList<>(usuarios);
    copia.sort(Comparator
        .comparingInt(User::getPuntos).reversed()
        .thenComparing(User::getNombre, String.CASE_INSENSITIVE_ORDER));
    return copia;
}
    
    public static void cambiarContrasenaJugadorActual() {
    String nombreJugador = MyProfile.getJugadorActual();

    for (User u : usuarios) {
        if (u.getNombre().equalsIgnoreCase(nombreJugador)) {
            String actual = JOptionPane.showInputDialog(null, "Ingresa tu contraseña actual:");
            if (actual == null) return; // Cancelado

            if (u.getContrasena().equals(actual)) {
                String nueva = JOptionPane.showInputDialog(null, "Ingresa tu nueva contraseña:");
                if (nueva == null || nueva.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Contraseña no válida.");
                    return;
                } else if (nueva.length() < 5 || nueva.length() > 5) {
                    JOptionPane.showMessageDialog(null, "Contraseña nueva debe contener 5 caracteres.");
                    return;
                }

                u.setContrasena(nueva);
                JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta.");
            }
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Jugador actual no encontrado.");
}
    
    public static void eliminarJugadorActual() {
    String nombreJugador = MyProfile.getJugadorActual();

    for (int i = 0; i < usuarios.size(); i++) {
        User u = usuarios.get(i);
        if (u.getNombre().equalsIgnoreCase(nombreJugador)) {
            String contrasena = JOptionPane.showInputDialog(null, "Confirma tu contraseña para eliminar la cuenta:");

            if (contrasena == null) return;

            if (u.getContrasena().equals(contrasena)) {
                usuariosEliminados.add(u);
                usuarios.remove(i);
                JOptionPane.showMessageDialog(null, "Cuenta eliminada correctamente.");
                MyProfile.setJugadorActual(null);
                
                First_Page firstPage = new First_Page();
                firstPage.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No se eliminó la cuenta.");
            }
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
}
    public static void sumarPuntosAUsuario(String nombreUsuario, int puntosASumar) {
    for (User u : usuarios) {
        if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
            int puntosActuales = u.getPuntos();
            u.setPuntos(puntosActuales + puntosASumar);
            break;
        }
    }
}
    private static ArrayList<User> usuariosEliminados = new ArrayList<>();

    public static int getUsuariosActivos() {
        return usuarios.size();
    }

    public static int getUsuariosHistoricos() {
        return usuarios.size() + usuariosEliminados.size();
    }
    private static ArrayList<LogMatchs> logs = new ArrayList<>();

public static void agregarLog(LogMatchs log) {
    logs.add(0, log);
}

public static List<LogMatchs> obtenerLogsDeUsuario(String nombreUsuario) {
    List<LogMatchs> resultado = new ArrayList<>();
    for (LogMatchs log : logs) {
        if (log.getJugador().equalsIgnoreCase(nombreUsuario)) {
            resultado.add(log);
        }
    }
    return resultado;
}
}

