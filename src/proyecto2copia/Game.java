/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2copia;

import aguilar_robert_strategomarvelheroes.BattleStats;
import aguilar_robert_strategomarvelheroes.First_Page;
import aguilar_robert_strategomarvelheroes.LogMatchs;
import aguilar_robert_strategomarvelheroes.UserManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 *
 * @author Cantarero
 */
public class Game extends javax.swing.JFrame {

    private static String oponente;

    public static void setOponente(String oponenteSeleccionado) {
        oponente = oponenteSeleccionado;
    }

    private JButton[][] matriz;
    private JLabel[][] estadoTablero;
    private JLabel[] matrizHeroe;
    private JLabel[] matrizVillano;
    private JButton[] matrizHeroeEliminado;
    private JButton[] matrizVillanoEliminado;
    private JButton botonSeleccionado = null;
    private JButton[] casillasRestringidas;
    private boolean turnoHeroe = true;
    private boolean ventanaExpandidaParaEliminados = false;
    private boolean bandoElegido = false;
    private int Heroes;
    private int Villanos;
    private boolean PriEliminacion;
    private static String jugadorActual = null;

    public Game() {
        initComponents();
        setSize(855, 805);
        setLocationRelativeTo(null);
        this.jugadorActual = jugadorActual;
        jPanel1.setLocation(jPanel1.getX() - 410, jPanel1.getY());
        UsrTurno.setVisible(false);
        matriz = new JButton[][]{
            {CAS1, CAS2, CAS3, CAS4, CAS5, CAS6, CAS7, CAS8, CAS9, CAS10},
            {CAS11, CAS12, CAS13, CAS14, CAS15, CAS16, CAS17, CAS18, CAS19, CAS20},
            {CAS21, CAS22, CAS23, CAS24, CAS25, CAS26, CAS27, CAS28, CAS29, CAS30},
            {CAS31, CAS32, CAS33, CAS34, CAS35, CAS36, CAS37, CAS38, CAS39, CAS40},
            {CAS41, CAS42, CAS43Null1, CAS44Null1, CAS45, CAS46, CAS47Null1, CAS48Null1, CAS49, CAS50},
            {CAS51, CAS52, CAS53Null1, CAS54Null1, CAS55, CAS56, CAS57Null1, CAS58Null1, CAS59, CAS60},
            {CAS61, CAS62, CAS63, CAS64, CAS65, CAS66, CAS67, CAS68, CAS69, CAS70},
            {CAS71, CAS72, CAS73, CAS74, CAS75, CAS76, CAS77, CAS78, CAS79, CAS80},
            {CAS81, CAS82, CAS83, CAS84, CAS85, CAS86, CAS87, CAS88, CAS89, CAS90},
            {CAS91, CAS92, CAS93, CAS94, CAS95, CAS96, CAS97, CAS98, CAS99, CAS100}
        };

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                if (matriz[fila][col] != null) {
                    matriz[fila][col].setEnabled(false);
                }
            }
        }
        estadoTablero = new JLabel[10][10];
        jButton1.setEnabled(false);
        matrizHeroe = new JLabel[]{
            H1, H2, H3, H4, H5, H6, H7, H8, H9, H10,
            H11, H12, H13, H14, H15, H16, H17, H18, H19, H20,
            H21, H22, H23, H24, H25, H26, H27, H28, H29, H30,
            H31, H32, H33, H34, H35, H36, H37, H38, H39, H40
        };

        matrizVillano = new JLabel[]{
            V1, V2, V3, V4, V5, V6, V7, V8, V9, V10,
            V11, V12, V13, V14, V15, V16, V17, V18, V19, V20,
            V21, V22, V23, V24, V25, V26, V27, V28, V29, V30,
            V31, V32, V33, V34, V35, V36, V37, V38, V39, V40
        };

        matrizHeroeEliminado = new JButton[]{
            EliminadoH1, EliminadoH2, EliminadoH3, EliminadoH4, EliminadoH5,
            EliminadoH6, EliminadoH7, EliminadoH8, EliminadoH9, EliminadoH10,
            EliminadoH11, EliminadoH12, EliminadoH13, EliminadoH14, EliminadoH15,
            EliminadoH16, EliminadoH17, EliminadoH18, EliminadoH19, EliminadoH20,
            EliminadoH21, EliminadoH22, EliminadoH23, EliminadoH24, EliminadoH25,
            EliminadoH26, EliminadoH27, EliminadoH28, EliminadoH29, EliminadoH30,
            EliminadoH31, EliminadoH32, EliminadoH33, EliminadoH34, EliminadoH35,
            EliminadoH36, EliminadoH37, EliminadoH38, EliminadoH39, EliminadoH40
        };

        matrizVillanoEliminado = new JButton[]{
            EliminadoV1, EliminadoV2, EliminadoV3, EliminadoV4, EliminadoV5,
            EliminadoV6, EliminadoV7, EliminadoV8, EliminadoV9, EliminadoV10,
            EliminadoV11, EliminadoV12, EliminadoV13, EliminadoV14, EliminadoV15,
            EliminadoV16, EliminadoV17, EliminadoV18, EliminadoV19, EliminadoV20,
            EliminadoV21, EliminadoV22, EliminadoV23, EliminadoV24, EliminadoV25,
            EliminadoV26, EliminadoV27, EliminadoV28, EliminadoV29, EliminadoV30,
            EliminadoV31, EliminadoV32, EliminadoV33, EliminadoV34, EliminadoV35,
            EliminadoV36, EliminadoV37, EliminadoV38, EliminadoV39, EliminadoV40
        };
        Heroes = 39;
        Villanos = 39;
        casillasRestringidas = new JButton[]{
            CAS43Null1, CAS44Null1, CAS47Null1, CAS48Null1,
            CAS53Null1, CAS54Null1, CAS57Null1, CAS58Null1
        };

        colocarFichasPersonalizado();

        actualizarVisibilidadPersonajes();

        if (jPanel2 != null) {
            jPanel2.setVisible(false);
        }
        if (jPanel6 != null) {
            jPanel6.setVisible(false);
        }

        for (JButton btn : matrizHeroeEliminado) {
            if (btn != null) {
                btn.setVisible(false);
            }
        }
        for (JButton btn : matrizVillanoEliminado) {
            if (btn != null) {
                btn.setVisible(false);
            }
        }
        jPanel5.setVisible(false);
        if (jPanel4 != null) {
            jPanel4.setVisible(true);
        }
        if (jPanel3 != null) {
            jPanel3.setVisible(false);
        }

        if (Usreleccion != null) {
            Usreleccion.setText(jugadorActual);
        }

        if (jButton3 != null) {
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (UsrVillano != null && Usreleccion != null) {
                        UsrVillano.setText(Usreleccion.getText());
                    }
                    if (UsrHeroe != null) {
                        UsrHeroe.setText(oponente);
                    }

                    if (jPanel4 != null) {
                        jPanel4.setVisible(false);
                        for (int fila = 0; fila < matriz.length; fila++) {
                            for (int col = 0; col < matriz[fila].length; col++) {
                                if (matriz[fila][col] != null) {
                                    matriz[fila][col].setEnabled(true);
                                }
                            }
                        }
                        jButton1.setEnabled(true);
                        UsrTurno.setVisible(true);

                    }
                    bandoElegido = true; // 
                    actualizarVisibilidadPersonajes();
                }
            });

        }

        if (jButton2 != null) {
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (UsrHeroe != null && Usreleccion != null) {
                        UsrHeroe.setText(Usreleccion.getText());
                    }
                    if (UsrVillano != null) {
                        UsrVillano.setText(oponente);
                    }

                    if (jPanel4 != null) {
                        jPanel4.setVisible(false);
                        for (int fila = 0; fila < matriz.length; fila++) {
                            for (int col = 0; col < matriz[fila].length; col++) {
                                if (matriz[fila][col] != null) {
                                    matriz[fila][col].setEnabled(true);
                                }
                            }
                        }
                        jButton1.setEnabled(true);
                        UsrTurno.setVisible(true);

                    }
                    bandoElegido = true;
                    actualizarVisibilidadPersonajes();
                }
            });

        }
        actualizarVisibilidadPersonajesInicial();

    }

    public static void setJugadorActual(String User) {
        jugadorActual = User;
    }

    public static String getJugadorActual() {
        return jugadorActual;
    }

    private void actualizarVisibilidadPersonajesInicial() {
        ImageIcon heroesFondoIcon = new ImageIcon(Game.class.getResource("/proyecto2copia/Heroes/heroes-fondo.png"));
        ImageIcon villanosFondoIcon = new ImageIcon(Game.class.getResource("/proyecto2copia/Villanos/villanos-fondo.png"));

        for (JLabel heroe : matrizHeroe) {
            if (heroe != null) {
                Image fondoheroe = heroesFondoIcon.getImage().getScaledInstance(heroe.getWidth(), heroe.getHeight(), Image.SCALE_SMOOTH);
                heroe.setIcon(new ImageIcon(fondoheroe));
            }
        }
        for (JLabel villano : matrizVillano) {
            if (villano != null) {
                Image fondovillano = villanosFondoIcon.getImage().getScaledInstance(villano.getWidth(), villano.getHeight(), Image.SCALE_SMOOTH);
                villano.setIcon(new ImageIcon(fondovillano));
            }

        }
        activarMovimiento();
    }

    private void escalarImagenHEROES() {
        asignarIconoHeroe(H1, "HEROE2-Storn.png");
        asignarIconoHeroe(H2, "HEROE10-MrFantastic.png");
        asignarIconoHeroe(H3, "HEROE9-CapitaAme.png");
        asignarIconoHeroe(H4, "HEROE8-ProfessorX.png");
        asignarIconoHeroe(H5, "HEROE8-NcickFury.png");
        asignarIconoHeroe(H6, "HEROE7-Wolcwe.png");
        asignarIconoHeroe(H7, "HEROE7-namor.png");
        asignarIconoHeroe(H8, "HEROE7-Spider-Man.png");
        asignarIconoHeroe(H9, "HEROE6-Silver.png");
        asignarIconoHeroe(H10, "HEROE6-huilk.png");
        asignarIconoHeroe(H11, "HEROE6-IRon.png");
        asignarIconoHeroe(H12, "HEROE6-Daredevil.png");
        asignarIconoHeroe(H13, "HEROE5-dieFackel.png");
        asignarIconoHeroe(H14, "HEROE5-ciclops.png");
        asignarIconoHeroe(H15, "HEROE5-Thor.png");
        asignarIconoHeroe(H16, "HEROE5-DieUnsish.png");
        asignarIconoHeroe(H17, "HEROE4-sheHult.png");
        asignarIconoHeroe(H18, "HEROE4-Punisher.png");
        asignarIconoHeroe(H19, "HEROE4-Ghost.png");
        asignarIconoHeroe(H20, "HEROE4-Das.png");
        asignarIconoHeroe(H21, "HEROE4-Blade.png");
        asignarIconoHeroe(H22, "HEROE3-Glantman.png");
        asignarIconoHeroe(H23, "HEROE3-Emma.png");
        asignarIconoHeroe(H24, "HEROE3-Colossus.png");
        asignarIconoHeroe(H25, "HEROE2-elektra.png");
        asignarIconoHeroe(H26, "HEROE3-Beast.png");
        asignarIconoHeroe(H27, "HEROE2-Iceman.png");
        asignarIconoHeroe(H28, "HEROE2-Spider-girl.png");
        asignarIconoHeroe(H29, "HEROE2-Phoenex.png");
        asignarIconoHeroe(H30, "HEROE2-Nightcrawler.png");
        asignarIconoHeroe(H31, "HEROE2-Gambit.png");
        asignarIconoHeroe(H32, "HEROE2-DRStrange.png");
        asignarIconoHeroe(H33, "HEROE1-1-BlackWidow.png");
        asignarIconoHeroe(H34, "DieErde.png");
        asignarIconoHeroe(H35, "Nova.png");
        asignarIconoHeroe(H36, "Nova.png");
        asignarIconoHeroe(H37, "Nova.png");
        asignarIconoHeroe(H38, "Nova.png");
        asignarIconoHeroe(H39, "Nova.png");
        asignarIconoHeroe(H40, "Nova.png");
    }

    private void escalarImagenVillanos() {
        asignarIconoVillano(V1, "villan1-BlackWidow.png");
        asignarIconoVillano(V2, "villan2-Electre.png");
        asignarIconoVillano(V3, "villan2-Leader.png");
        asignarIconoVillano(V4, "villan2-MrSinister.png");
        asignarIconoVillano(V5, "villan2-Sandman.png");
        asignarIconoVillano(V6, "villan2-Sentinel1.png");
        asignarIconoVillano(V7, "villan2-Sentinel2.png");
        asignarIconoVillano(V8, "villan2-Ultron.png");
        asignarIconoVillano(V9, "villan2-Viper.png");
        asignarIconoVillano(V10, "villan3-Carnage.png");
        asignarIconoVillano(V11, "villan3-Juggernaut.png");
        asignarIconoVillano(V12, "villan3-Lizard.png");
        asignarIconoVillano(V13, "villan3-Moleman.png");
        asignarIconoVillano(V14, "villan3-Rhino.png");
        asignarIconoVillano(V15, "villan4-abinatiom.png");
        asignarIconoVillano(V16, "villan4-BlackCat.png");
        asignarIconoVillano(V17, "villan4-Savbretooth.png");
        asignarIconoVillano(V18, "villan4-Thanos.png");
        asignarIconoVillano(V19, "villan5-deadpool.png");
        asignarIconoVillano(V20, "villan5-DrOctopus.png");
        asignarIconoVillano(V21, "villan5-Mysterio.png");
        asignarIconoVillano(V22, "villan5-Mystique.png");
        asignarIconoVillano(V23, "villan6-Bullseye.png");
        asignarIconoVillano(V24, "villan6-Omega.png");
        asignarIconoVillano(V25, "villan6-Onslau.png");
        asignarIconoVillano(V26, "villan6-RedSkull.png");
        asignarIconoVillano(V27, "villan7-Apocalypsejpg.png");
        asignarIconoVillano(V28, "villan7-DrGrune.png");
        asignarIconoVillano(V29, "villan7-Venom.png");
        asignarIconoVillano(V30, "villan8-Magneto.png");
        asignarIconoVillano(V31, "villano8_Kinping.png");
        asignarIconoVillano(V32, "villano9-Galactus.png");
        asignarIconoVillano(V33, "villano10-DrDoom.png");
        asignarIconoVillano(V34, "Dieerde.png");
        asignarIconoVillano(V35, "Bombe.png");
        asignarIconoVillano(V36, "Bombe.png");
        asignarIconoVillano(V37, "Bombe.png");
        asignarIconoVillano(V38, "Bombe.png");
        asignarIconoVillano(V39, "Bombe.png");
        asignarIconoVillano(V40, "Bombe.png");
    }

    private void asignarIconoVillano(JLabel label, String nombreArchivo) {
        ImageIcon imagenvillanos = new ImageIcon(Game.class.getResource("/proyecto2copia/Villanos/" + nombreArchivo));
        Image imagenfinal = imagenvillanos.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imagenfinal));
    }

    private void asignarIconoHeroe(JLabel label, String nombreArchivo) {
        ImageIcon imagenheroes = new ImageIcon(Game.class.getResource("/proyecto2copia/Heroes/" + nombreArchivo));
        Image imagenfinal = imagenheroes.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imagenfinal));
    }

    public void colocarFichasPersonalizado() {
        Random rnd = new Random();

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                estadoTablero[r][c] = null;
            }
        }

        int tierraColHeroe = rnd.nextInt(8) + 1;
        int tierraColVillano = rnd.nextInt(8) + 1;

        estadoTablero[0][tierraColHeroe] = matrizHeroe[33];
        estadoTablero[9][tierraColVillano] = matrizVillano[33];

        if (tierraColHeroe - 1 >= 0) {
            estadoTablero[0][tierraColHeroe - 1] = matrizHeroe[34];
        }
        estadoTablero[1][tierraColHeroe] = matrizHeroe[35];
        if (tierraColHeroe + 1 <= 9) {
            estadoTablero[0][tierraColHeroe + 1] = matrizHeroe[36];
        }
        if (tierraColVillano - 1 >= 0) {
            estadoTablero[9][tierraColVillano - 1] = matrizVillano[34];
        }
        estadoTablero[8][tierraColVillano] = matrizVillano[35];
        if (tierraColVillano + 1 <= 9) {
            estadoTablero[9][tierraColVillano + 1] = matrizVillano[36];
        }
        int[] bombasHIndices = {37, 38, 39};
        for (int idx : bombasHIndices) {
            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(2);
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizHeroe[idx];
                    colocado = true;
                }
            }
        }
        int[] bombasVIndices = {37, 38, 39};
        for (int idx : bombasVIndices) {
            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(2) + 8;
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizVillano[idx];
                    colocado = true;
                }
            }
        }

        int[] rango2HeroeIndices = {0, 24, 26, 27, 28, 29, 30, 31};
        for (int idx : rango2HeroeIndices) {
            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(2) + 2;
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizHeroe[idx];
                    colocado = true;
                }
            }
        }
        int[] rango2VillanoIndices = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int idx : rango2VillanoIndices) {
            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(2) + 6;
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizVillano[idx];
                    colocado = true;
                }
            }
        }

        boolean[] usadosH = new boolean[40];
        usadosH[33] = true;
        usadosH[34] = true;
        usadosH[35] = true;
        usadosH[36] = true;
        usadosH[37] = true;
        usadosH[38] = true;
        usadosH[39] = true;
        for (int i : rango2HeroeIndices) {
            usadosH[i] = true;
        }

        for (int i = 0; i < matrizHeroe.length; i++) {
            if (usadosH[i]) {
                continue;
            }

            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(4);
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizHeroe[i];
                    colocado = true;
                }
            }
        }

        boolean[] usadosV = new boolean[40];
        usadosV[33] = true;
        usadosV[34] = true;
        usadosV[35] = true;
        usadosV[36] = true;
        usadosV[37] = true;
        usadosV[38] = true;
        usadosV[39] = true;
        for (int i : rango2VillanoIndices) {
            usadosV[i] = true;
        }

        for (int i = 0; i < matrizVillano.length; i++) {
            if (usadosV[i]) {
                continue;
            }

            boolean colocado = false;
            while (!colocado) {
                int fila = rnd.nextInt(4) + 6;
                int col = rnd.nextInt(10);
                if (estadoTablero[fila][col] == null && !esCasillaRestringida(matriz[fila][col])) {
                    estadoTablero[fila][col] = matrizVillano[i];
                    colocado = true;
                }
            }
        }

        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                JLabel ficha = estadoTablero[fila][col];
                if (ficha != null) {
                    Point posBtn = matriz[fila][col].getLocation();
                    int newX = posBtn.x + (matriz[fila][col].getWidth() - ficha.getWidth()) / 2;
                    int newY = posBtn.y + (matriz[fila][col].getHeight() - ficha.getHeight()) / 2;
                    ficha.setLocation(newX, newY);
                }
            }
        }
    }

    private PersonajeInfo obtenerInfoPersonaje(JLabel label) {
        if (label == null) {
            return null;
        }
        Object info = label.getClientProperty("personajeInfo");
        if (info instanceof PersonajeInfo) {
            return (PersonajeInfo) info;
        }
        return null;
    }

    public void activarMovimiento() {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                JButton casilla = matriz[fila][col];

                casilla.addActionListener(e -> {
                    Point cordenadas = encontrarCoordenadas(casilla);

                    if (botonSeleccionado == null) {
                        JLabel personajeEnCasilla = estadoTablero[cordenadas.x][cordenadas.y];

                        if (personajeEnCasilla != null) {
                            if (esPersonajeInamovible(personajeEnCasilla)) {
                                return;
                            }

                            boolean esHeroe = esPersonajeHeroe(personajeEnCasilla);

                            if ((turnoHeroe && esHeroe) || (!turnoHeroe && !esHeroe)) {
                                botonSeleccionado = casilla;
                                casilla.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                            } else {
                            }
                        } else {
                        }
                    } else {
                        Point coordsSeleccionado = encontrarCoordenadas(botonSeleccionado);
                        if (coordsSeleccionado == null) {
                            reiniciarSeleccion();
                            return;
                        }

                        JLabel personajeAMover = estadoTablero[coordsSeleccionado.x][coordsSeleccionado.y];
                        if (personajeAMover == null) {
                            reiniciarSeleccion();
                            return;
                        }

                        if (esPersonajeInamovible(personajeAMover)) {
                            reiniciarSeleccion();
                            return;
                        }

                        boolean esPersonajeAMoverHeroe = esPersonajeHeroe(personajeAMover);
                        if ((turnoHeroe && !esPersonajeAMoverHeroe) || (!turnoHeroe && esPersonajeAMoverHeroe)) {
                            reiniciarSeleccion();
                            return;
                        }

                        JLabel personajeEnDestino = estadoTablero[cordenadas.x][cordenadas.y];

                        if (personajeEnDestino == null && esMovimientoValido(personajeAMover, botonSeleccionado, casilla) && !esCasillaRestringida(casilla)) {

                            moverPersonaje(personajeAMover, botonSeleccionado, casilla);
                            turnoHeroe = !turnoHeroe;
                            actualizarVisibilidadPersonajes();
                        } else if (personajeEnDestino != null && esPersonajeAMoverHeroe != esPersonajeHeroe(personajeEnDestino)
                                && esMovimientoValido(personajeAMover, botonSeleccionado, casilla)
                                && !esCasillaRestringida(casilla)) {

                            manejarEnfrentamiento(personajeAMover, personajeEnDestino, casilla);
                            turnoHeroe = !turnoHeroe;
                        } else if (casilla == botonSeleccionado) {
                        } else {
                            System.out.println("Movimiento no válido o casilla ocupada por el mismo bando.");
                        }
                        reiniciarSeleccion();
                    }
                });
            }
        }
    }

    private void reiniciarSeleccion() {
        if (botonSeleccionado != null) {
            botonSeleccionado.setBorder(null);
            botonSeleccionado = null;
        }
    }

    private void moverPersonaje(JLabel personaje, JButton origen, JButton destino) {
        Point destinoP = destino.getLocation();
        personaje.setBounds(destinoP.x + (destino.getWidth() - personaje.getWidth()) / 2,
                destinoP.y + (destino.getHeight() - personaje.getHeight()) / 2,
                personaje.getWidth(), personaje.getHeight());
        Point origenCoords = encontrarCoordenadas(origen);
        Point destinoCoords = encontrarCoordenadas(destino);
        estadoTablero[origenCoords.x][origenCoords.y] = null;
        estadoTablero[destinoCoords.x][destinoCoords.y] = personaje;
    }

    private boolean esMovimientoValido(JLabel personaje, JButton origen, JButton destino) {
        Point CeldaorigenCordenada = encontrarCoordenadas(origen);
        Point CeldaDestinoCordenada = encontrarCoordenadas(destino);
        if (CeldaorigenCordenada == null || CeldaDestinoCordenada == null) {
            return false;
        }
        if (CeldaorigenCordenada.x == CeldaDestinoCordenada.x && CeldaorigenCordenada.y == CeldaDestinoCordenada.y) {
            return false;
        }
        if (esPersonajeInamovible(personaje)) {
            return false;
        }
        if (esPersonajeRango2(personaje)) {
            if (CeldaorigenCordenada.x == CeldaDestinoCordenada.x) {
                int fila = CeldaorigenCordenada.x;
                int ColumnaInicio = Math.min(CeldaorigenCordenada.y, CeldaDestinoCordenada.y) + 1;
                int ColumnaFinal = Math.max(CeldaorigenCordenada.y, CeldaDestinoCordenada.y);
                for (int col = ColumnaInicio; col < ColumnaFinal; col++) {
                    if (estadoTablero[fila][col] != null) {
                        return false;
                    }
                }
                return true;
            } else if (CeldaorigenCordenada.y == CeldaDestinoCordenada.y) {
                int col = CeldaorigenCordenada.y;
                int FiLInicio = Math.min(CeldaorigenCordenada.x, CeldaDestinoCordenada.x) + 1;
                int FiLFinal = Math.max(CeldaorigenCordenada.x, CeldaDestinoCordenada.x);
                for (int fila = FiLInicio; fila < FiLFinal; fila++) {
                    if (estadoTablero[fila][col] != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } else {
            return (Math.abs(CeldaorigenCordenada.x - CeldaDestinoCordenada.x) == 1 && CeldaorigenCordenada.y == CeldaDestinoCordenada.y)
                    || (Math.abs(CeldaorigenCordenada.y - CeldaDestinoCordenada.y) == 1 && CeldaorigenCordenada.x == CeldaDestinoCordenada.x);
        }
    }

    private boolean esCasillaRestringida(JButton casilla) {
        for (JButton restringida : casillasRestringidas) {
            if (restringida == casilla) {
                return true;
            }
        }
        return false;
    }

    private Point encontrarCoordenadas(JButton button) {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                if (matriz[fila][col] == button) {
                    return new Point(fila, col);
                }
            }
        }
        return null;
    }

    private Point encontrarCoordenadasPorLabel(JLabel personaje) {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                if (estadoTablero[fila][col] == personaje) {
                    return new Point(fila, col);
                }
            }
        }
        return null;
    }

    private String obtenerNombreArchivoDeJLabel(JLabel label) {
        Object clientProperty = label.getClientProperty("nombreArchivo");
        if (clientProperty instanceof String) {
            return (String) clientProperty;
        }
        PersonajeInfo[] heroes = PersonajeInfo.getHeroes();
        for (int i = 0; i < heroes.length; i++) {
            if (i < matrizHeroe.length && matrizHeroe[i] == label) {
                return heroes[i].getNombreArchivo();
            }
        }
        PersonajeInfo[] villanos = PersonajeInfo.getVillanos();
        for (int i = 0; i < villanos.length; i++) {
            if (i < matrizVillano.length && matrizVillano[i] == label) {
                return villanos[i].getNombreArchivo();
            }
        }
        return null;
    }

    private boolean esPersonajeHeroe(JLabel label) {
        for (JLabel heroe : matrizHeroe) {
            if (heroe == label) {
                return true;
            }
        }
        return false;
    }

    private boolean esPersonajeInamovible(JLabel label) {
        for (int i = 33; i <= 39; i++) {
            if (matrizHeroe[i] == label) {
                return true;
            }
        }
        for (int i = 33; i <= 39; i++) {
            if (matrizVillano[i] == label) {
                return true;
            }
        }
        return false;
    }

    private boolean esPersonajeRango2(JLabel label) {
        if (matrizHeroe[0] == label) {
            return true;
        }
        for (int i = 24; i <= 31; i++) {
            if (matrizHeroe[i] == label) {
                return true;
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (matrizVillano[i] == label) {
                return true;
            }
        }
        return false;
    }

    private void actualizarVisibilidadPersonajes() {
        ImageIcon heroesFondoIcon = new ImageIcon(Game.class.getResource("/proyecto2copia/Heroes/heroes-fondo.png"));
        ImageIcon villanosFondoIcon = new ImageIcon(Game.class.getResource("/proyecto2copia/Villanos/villanos-fondo.png"));
        for (JLabel heroe : matrizHeroe) {
            Image fondoheroe;
            if (!turnoHeroe) {
                fondoheroe = heroesFondoIcon.getImage().getScaledInstance(heroe.getWidth(), heroe.getHeight(), Image.SCALE_SMOOTH);
                heroe.setIcon(new ImageIcon(fondoheroe));
                UsrTurno.setText("Villano");
            } else {
                asignarIconoHeroe(heroe, obtenerNombreArchivoDeJLabel(heroe));
            }
        }
        for (JLabel villano : matrizVillano) {
            Image fondovillano;
            if (turnoHeroe) {
                fondovillano = villanosFondoIcon.getImage().getScaledInstance(villano.getWidth(), villano.getHeight(), Image.SCALE_SMOOTH);
                villano.setIcon(new ImageIcon(fondovillano));
                UsrTurno.setText("Heroe");
            } else {
                asignarIconoVillano(villano, obtenerNombreArchivoDeJLabel(villano));
            }
        }
    }

    private boolean esBomba(JLabel label) {
        PersonajeInfo info = null;
        if (esPersonajeHeroe(label)) {
            PersonajeInfo[] heroes = PersonajeInfo.getHeroes();
            String nombreArchivo = obtenerNombreArchivoDeJLabel(label);
            for (PersonajeInfo p : heroes) {
                if (p.getNombreArchivo().equals(nombreArchivo)) {
                    info = p;
                    break;
                }
            }
        } else {
            PersonajeInfo[] villanos = PersonajeInfo.getVillanos();
            String nombreArchivo = obtenerNombreArchivoDeJLabel(label);
            for (PersonajeInfo p : villanos) {
                if (p.getNombreArchivo().equals(nombreArchivo)) {
                    info = p;
                    break;
                }
            }
        }
        return info != null && info.getNivel() == 0;
    }

    private boolean esTierra(JLabel label) {
        PersonajeInfo info = null;
        String nombreArchivo = obtenerNombreArchivoDeJLabel(label);

        for (PersonajeInfo p : PersonajeInfo.getHeroes()) {
            if (p.getNombreArchivo().equals(nombreArchivo)) {
                info = p;
                break;
            }
        }
        if (info == null) {
            for (PersonajeInfo p : PersonajeInfo.getVillanos()) {
                if (p.getNombreArchivo().equals(nombreArchivo)) {
                    info = p;
                    break;
                }
            }
        }

        return info != null && info.esBandera();
    }

    private boolean esRango3(JLabel label) {
        PersonajeInfo info = null;
        if (esPersonajeHeroe(label)) {
            PersonajeInfo[] heroes = PersonajeInfo.getHeroes();
            String nombreArchivo = obtenerNombreArchivoDeJLabel(label);
            for (PersonajeInfo p : heroes) {
                if (p.getNombreArchivo().equals(nombreArchivo)) {
                    info = p;
                    break;
                }
            }
        } else {
            PersonajeInfo[] villanos = PersonajeInfo.getVillanos();
            String nombreArchivo = obtenerNombreArchivoDeJLabel(label);
            for (PersonajeInfo p : villanos) {
                if (p.getNombreArchivo().equals(nombreArchivo)) {
                    info = p;
                    break;
                }
            }
        }
        return info != null && info.getNivel() == 3;
    }

    private boolean tieneMovimientosDisponibles(JLabel[] personajes) {
        for (int i = 0; i < personajes.length; i++) {
            JLabel personaje = personajes[i];

            // Ignora los personajes inamovibles
            if (i >= 33 && i <= 39) {
                continue;
            }

            if (personaje != null && personaje.isVisible() && !esPersonajeInamovible(personaje)) {
                Point origen = encontrarCoordenadasPorLabel(personaje);
                if (origen == null) {
                    continue;
                }

                if (esPersonajeRango2(personaje)) {
                    for (int dy = -1; dy <= 1; dy += 2) {
                        int y = origen.y + dy;
                        while (y >= 0 && y < 10) {
                            JButton destino = matriz[origen.x][y];
                            if (esMovimientoValido(personaje, matriz[origen.x][origen.y], destino)) {
                                return true;
                            }
                            if (estadoTablero[origen.x][y] != null) {
                                break; // Hay alguien bloqueando
                            }
                            y += dy;
                        }
                    }

                    for (int dx = -1; dx <= 1; dx += 2) {
                        int x = origen.x + dx;
                        while (x >= 0 && x < 10) {
                            JButton destino = matriz[x][origen.y];
                            if (esMovimientoValido(personaje, matriz[origen.x][origen.y], destino)) {
                                return true;
                            }
                            if (estadoTablero[x][origen.y] != null) {
                                break;
                            }
                            x += dx;
                        }
                    }

                } else {
                    int[][] direcciones = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    for (int[] d : direcciones) {
                        int x = origen.x + d[0];
                        int y = origen.y + d[1];
                        if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                            JButton destino = matriz[x][y];
                            if (esMovimientoValido(personaje, matriz[origen.x][origen.y], destino)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void manejarEnfrentamiento(JLabel atacante, JLabel defensor, JButton celdaDestino) {
        boolean atacanteEsHeroe = esPersonajeHeroe(atacante);
        JLabel heroeEnCombate = atacanteEsHeroe ? atacante : defensor;
        JLabel villanoEnCombate = atacanteEsHeroe ? defensor : atacante;
        String nombreArchivoHeroe = obtenerNombreArchivoDeJLabel(heroeEnCombate);
        String nombreArchivoVillano = obtenerNombreArchivoDeJLabel(villanoEnCombate);
        PersonajeInfo infoHeroe = null;
        if (nombreArchivoHeroe != null) {
            for (PersonajeInfo p : PersonajeInfo.getHeroes()) {
                if (p.getNombreArchivo().equals(nombreArchivoHeroe)) {
                    infoHeroe = p;
                    break;
                }
            }
        }
        PersonajeInfo infoVillano = null;
        if (nombreArchivoVillano != null) {
            for (PersonajeInfo p : PersonajeInfo.getVillanos()) {
                if (p.getNombreArchivo().equals(nombreArchivoVillano)) {
                    infoVillano = p;
                    break;
                }
            }
        }
        if (jPanel2 != null) {
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int col = 0; col < matriz[fila].length; col++) {
                    if (matriz[fila][col] != null) {
                        matriz[fila][col].setEnabled(false);
                    }
                }
            }
            jPanel2.setVisible(true);
            jButton1.setEnabled(false);
        }
        if (infoHeroe != null && VSHeroe != null && nombreheroe != null && nivelheroe != null) {
            ImageIcon iconoHeroe = new ImageIcon(Game.class.getResource("/proyecto2copia/Heroes/" + infoHeroe.getNombreArchivo()));
            Image imagenHeroeFinal = iconoHeroe.getImage().getScaledInstance(VSHeroe.getWidth(), VSHeroe.getHeight(), Image.SCALE_SMOOTH);
            VSHeroe.setIcon(new ImageIcon(imagenHeroeFinal));
            nombreheroe.setText(infoHeroe.getNombre());
            nivelheroe.setText("Nivel: " + infoHeroe.getNivel());
        } else {
            if (VSHeroe != null) {
                VSHeroe.setIcon(null);
            }
            if (nombreheroe != null) {
                nombreheroe.setText("");
            }
            if (nivelheroe != null) {
                nivelheroe.setText("");
            }
        }
        if (infoVillano != null && VSVillano != null && nombrevillano != null && nivelvillano != null) {
            ImageIcon iconoVillano = new ImageIcon(Game.class.getResource("/proyecto2copia/Villanos/" + infoVillano.getNombreArchivo()));
            Image imagenVillanoFinal = iconoVillano.getImage().getScaledInstance(VSVillano.getWidth(), VSVillano.getHeight(), Image.SCALE_SMOOTH);
            VSVillano.setIcon(new ImageIcon(imagenVillanoFinal));
            nombrevillano.setText(infoVillano.getNombre());
            nivelvillano.setText("Nivel: " + infoVillano.getNivel());
        } else {
            if (VSVillano != null) {
                VSVillano.setIcon(null);
            }
            if (nombrevillano != null) {
                nombrevillano.setText("");
            }
            if (nivelvillano != null) {
                nivelvillano.setText("");
            }
        }
        int nivelAtacante = (infoHeroe != null && atacanteEsHeroe) ? infoHeroe.getNivel() : (infoVillano != null && !atacanteEsHeroe) ? infoVillano.getNivel() : -1;
        int nivelDefensor = (infoHeroe != null && !atacanteEsHeroe) ? infoHeroe.getNivel() : (infoVillano != null && atacanteEsHeroe) ? infoVillano.getNivel() : -1;
        JLabel ganador = null;
        JLabel perdedor = null;
        boolean dobleEliminacion = false;
        if (esBomba(defensor)) {
            if (esRango3(atacante)) {
                ganador = atacante;
                perdedor = defensor;
            } else {
                ganador = defensor;
                perdedor = atacante;
            }
        } else if (nivelAtacante == nivelDefensor) {
            System.out.println("¡Mismo rango! Ambos personajes se eliminan.");
            ganador = null;
            perdedor = atacante;
            dobleEliminacion = true;
        } else if (nivelAtacante == 1 && nivelDefensor == 10) {
            ganador = atacante;
            perdedor = defensor;
            System.out.println("Rango 1 derrota a Rango 10!");
        } else if (nivelAtacante >= nivelDefensor) {
            ganador = atacante;
            perdedor = defensor;
            System.out.println("¡El atacante ha ganado!");
        } else {
            ganador = defensor;
            perdedor = atacante;
            System.out.println("¡El defensor ha ganado!");
        }
        String Usrheroe = UsrHeroe.getText();
        String Usrvillano = UsrVillano.getText();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        if (esTierra(defensor)) {
            if (!turnoHeroe) {
                ganador = atacante;
                perdedor = defensor;
                jPanel2.setVisible(false);
                jPanel3.setVisible(true);

                UsrGanador.setText(Usrvillano);
                Bandoganador.setText("Villano");
                TipodeSlv.setText("Se Capturo");
                UsrPerdedor.setText("Heroe");
                UsrPerdedor2.setText(Usrheroe);
                Fecha.setText(fechaFormateada);
                
                BattleStats.partidasJugadas++;
                BattleStats.victoriasVillanos++;
                
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                LogMatchs logGanador = new LogMatchs(oponente, "Ganó", "Villanos", jugadorActual, fecha);
                LogMatchs logPerdedor = new LogMatchs(jugadorActual, "Perdió", "Heroes", oponente, fecha);
                UserManager.agregarLog(logGanador);
                UserManager.agregarLog(logPerdedor);
            
                UserManager.sumarPuntosAUsuario(UsrGanador1.getText().trim(), 3);
            } else if (turnoHeroe) {
                ganador = atacante;
                perdedor = defensor;
                jPanel2.setVisible(false);
                jPanel3.setVisible(true);
                UsrGanador.setText(Usrvillano);
                Bandoganador.setText("Heroe");
                TipodeSlv.setText("Se Salvo");
                UsrPerdedor.setText("Villanos");
                UsrPerdedor2.setText(Usrvillano);
                Fecha.setText(fechaFormateada);
                
                BattleStats.partidasJugadas++;
                BattleStats.victoriasHeroes++;
                
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                LogMatchs logGanador = new LogMatchs(oponente, "Ganó", "Heroes", jugadorActual, fecha);
                LogMatchs logPerdedor = new LogMatchs(jugadorActual, "Perdió", "Villanos", oponente, fecha);
                UserManager.agregarLog(logGanador);
                UserManager.agregarLog(logPerdedor);
            
                UserManager.sumarPuntosAUsuario(UsrGanador1.getText().trim(), 3);
            }
        }
        Point destinoCoords = encontrarCoordenadas(celdaDestino);
        Point origenCoords = encontrarCoordenadas(botonSeleccionado);
        if (dobleEliminacion) {
            if (atacante != null) {
                atacante.setVisible(false);
                estadoTablero[origenCoords.x][origenCoords.y] = null;
                agregarAEliminados(atacante);
                if (esPersonajeHeroe(atacante)) {
                    Heroes--;
                } else {
                    Villanos--;
                }
            }
            if (defensor != null) {
                defensor.setVisible(false);
                estadoTablero[destinoCoords.x][destinoCoords.y] = null;
                agregarAEliminados(defensor);
                if (esPersonajeHeroe(defensor)) {
                    Heroes--;
                } else {
                    Villanos--;
                }
            }
        } else {
            if (perdedor != null) {
                perdedor.setVisible(false);
                if (ganador == atacante) {
                    estadoTablero[destinoCoords.x][destinoCoords.y] = null;
                } else {
                    estadoTablero[origenCoords.x][origenCoords.y] = null;
                }
                agregarAEliminados(perdedor);
                if (esPersonajeHeroe(perdedor)) {
                    Heroes--;
                } else {
                    Villanos--;
                }
            }
            if (ganador == atacante) {
                moverPersonaje(atacante, botonSeleccionado, celdaDestino);
            }
        }
        if (!ventanaExpandidaParaEliminados && (dobleEliminacion || (perdedor != null))) {
            setSize(1655, 805);
            setLocationRelativeTo(null);
            if (!PriEliminacion) {
                jPanel1.setLocation(jPanel1.getX() + 350, jPanel1.getY());
                PriEliminacion = true;
            }
        }
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jPanel2 != null) {
                    jPanel2.setVisible(false);
                    for (int fila = 0; fila < matriz.length; fila++) {
                        for (int col = 0; col < matriz[fila].length; col++) {
                            if (matriz[fila][col] != null) {
                                matriz[fila][col].setEnabled(true);
                            }
                        }
                    }
                    if (!tieneMovimientosDisponibles(matrizHeroe)) {
                        jPanel3.setVisible(true);
                        UsrGanador.setText(UsrVillano.getText());
                        Bandoganador.setText("Villano");
                        TipodeSlv.setText("Heroe sin movimientos");
                        UsrPerdedor.setText(UsrHeroe.getText());
                        Fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
                        jButton1.setEnabled(false);
                        for (int fila = 0; fila < matriz.length; fila++) {
                        for (int col = 0; col < matriz[fila].length; col++) {
                            if (matriz[fila][col] != null) {
                                matriz[fila][col].setEnabled(true);
                            }
                        }
                    }
                        
                    }

                    if (!tieneMovimientosDisponibles(matrizVillano)) {
                        jPanel3.setVisible(true);
                        UsrGanador.setText(UsrHeroe.getText());
                        Bandoganador.setText("Heroe");
                        TipodeSlv.setText("Villano sin movimientos");
                        UsrPerdedor.setText(UsrVillano.getText());
                        Fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
                        jButton1.setEnabled(false);
                        for (int fila = 0; fila < matriz.length; fila++) {
                        for (int col = 0; col < matriz[fila].length; col++) {
                            if (matriz[fila][col] != null) {
                                matriz[fila][col].setEnabled(true);
                            }
                        }
                    }
                    }
                    jButton1.setEnabled(true);
                    if (VSHeroe != null) {
                        VSHeroe.setIcon(null);
                    }
                    if (VSVillano != null) {
                        VSVillano.setIcon(null);
                    }
                    if (nombreheroe != null) {
                        nombreheroe.setText("");
                    }
                    if (nombrevillano != null) {
                        nombrevillano.setText("");
                    }
                    if (nivelheroe != null) {
                        nivelheroe.setText("");
                    }
                    if (nivelvillano != null) {
                        nivelvillano.setText("");
                    }
                }
                actualizarVisibilidadPersonajes();
                ((Timer) e.getSource()).stop();
            }
        });

        timer.setRepeats(false);
        timer.start();

    }

    private void agregarAEliminados(JLabel personajeEliminado) {
        String nombreArchivoEliminado = obtenerNombreArchivoDeJLabel(personajeEliminado);
        if (nombreArchivoEliminado == null) {
            System.err.println("Error: No se pudo obtener el nombre de archivo para el personaje eliminado.");
            return;
        }

        if (esPersonajeHeroe(personajeEliminado)) {
            for (int i = 0; i < matrizHeroeEliminado.length; i++) {
                if (matrizHeroeEliminado[i].getIcon() == null) {
                    ImageIcon iconoEliminado = new ImageIcon(Game.class.getResource("/proyecto2copia/Heroes/" + nombreArchivoEliminado));
                    Image imagenEliminado = iconoEliminado.getImage().getScaledInstance(
                            matrizHeroeEliminado[i].getWidth(), matrizHeroeEliminado[i].getHeight(), Image.SCALE_SMOOTH);
                    matrizHeroeEliminado[i].setIcon(new ImageIcon(imagenEliminado));
                    matrizHeroeEliminado[i].setVisible(true);
                    break;
                }
            }
        } else {
            for (int i = 0; i < matrizVillanoEliminado.length; i++) {
                if (matrizVillanoEliminado[i].getIcon() == null) {
                    ImageIcon iconoEliminado = new ImageIcon(Game.class.getResource("/proyecto2copia/Villanos/" + nombreArchivoEliminado));
                    Image imagenEliminado = iconoEliminado.getImage().getScaledInstance(
                            matrizVillanoEliminado[i].getWidth(), matrizVillanoEliminado[i].getHeight(), Image.SCALE_SMOOTH);
                    matrizVillanoEliminado[i].setIcon(new ImageIcon(imagenEliminado));
                    matrizVillanoEliminado[i].setVisible(true);
                    break;
                }
            }
        }
    }

    public void Rendirse() {
        jPanel6.setVisible(true);
        jPanel6.setLocation(jPanel3.getX(), jPanel3.getY());

    }

    public void confirmarRendirse() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        String Usrheroe = UsrHeroe.getText();
        String Usrvillano = UsrVillano.getText();
        if (turnoHeroe) {
            jPanel5.setVisible(true);
            jPanel5.setLocation(jPanel3.getX(), jPanel3.getY());
            UsrGanador1.setText(Usrvillano);
            Bandoganador1.setText("Villano");
            UsrPerdedor1.setText(Usrheroe);
            Fecha1.setText(fechaFormateada);
            BandoPerdedor.setText("Heroes");
            
            BattleStats.partidasJugadas++;
            BattleStats.victoriasVillanos++;
            
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                LogMatchs logGanador = new LogMatchs(oponente, "Ganó", "Villanos", jugadorActual, fecha);
                LogMatchs logPerdedor = new LogMatchs(jugadorActual, "Perdió", "Heroes", oponente, fecha);
                UserManager.agregarLog(logGanador);
                UserManager.agregarLog(logPerdedor);
            
            UserManager.sumarPuntosAUsuario(UsrGanador1.getText().trim(), 3);

        }
        if (!turnoHeroe) {
            jPanel5.setVisible(true);
            jPanel5.setLocation(jPanel3.getX(), jPanel3.getY());
            UsrGanador1.setText(Usrheroe);
            Bandoganador1.setText("Heroe");
            UsrPerdedor1.setText(Usrvillano);
            Fecha1.setText(fechaFormateada);
            BandoPerdedor.setText("Villanos");
            
            BattleStats.partidasJugadas++;
            BattleStats.victoriasHeroes++;
            
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                LogMatchs logGanador = new LogMatchs(oponente, "Ganó", "Heroes", jugadorActual, fecha);
                LogMatchs logPerdedor = new LogMatchs(jugadorActual, "Perdió", "Villanos", oponente, fecha);
                UserManager.agregarLog(logGanador);
                UserManager.agregarLog(logPerdedor);
            
            UserManager.sumarPuntosAUsuario(UsrGanador1.getText().trim(), 3);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        UsrPerdedor2 = new javax.swing.JLabel();
        JLabel25 = new javax.swing.JLabel();
        Bandoganador = new javax.swing.JLabel();
        JLabel14 = new javax.swing.JLabel();
        TipodeSlv = new javax.swing.JLabel();
        JLabel17 = new javax.swing.JLabel();
        JLabel16 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        UsrPerdedor = new javax.swing.JLabel();
        UsrGanador = new javax.swing.JLabel();
        JLabel18 = new javax.swing.JLabel();
        JLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Usreleccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        VSVillano = new javax.swing.JLabel();
        VSHeroe = new javax.swing.JLabel();
        nombrevillano = new javax.swing.JLabel();
        nivelvillano = new javax.swing.JLabel();
        nombreheroe = new javax.swing.JLabel();
        nivelheroe = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        BandoPerdedor = new javax.swing.JLabel();
        Bandoganador1 = new javax.swing.JLabel();
        UsrPerdedor1 = new javax.swing.JLabel();
        JLabel19 = new javax.swing.JLabel();
        JLabel20 = new javax.swing.JLabel();
        JLabel21 = new javax.swing.JLabel();
        JLabel22 = new javax.swing.JLabel();
        Fecha1 = new javax.swing.JLabel();
        JLabel23 = new javax.swing.JLabel();
        UsrGanador1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CAS1 = new javax.swing.JButton();
        CAS2 = new javax.swing.JButton();
        CAS3 = new javax.swing.JButton();
        CAS4 = new javax.swing.JButton();
        CAS5 = new javax.swing.JButton();
        CAS6 = new javax.swing.JButton();
        CAS7 = new javax.swing.JButton();
        CAS8 = new javax.swing.JButton();
        CAS9 = new javax.swing.JButton();
        CAS10 = new javax.swing.JButton();
        CAS11 = new javax.swing.JButton();
        CAS12 = new javax.swing.JButton();
        CAS13 = new javax.swing.JButton();
        CAS14 = new javax.swing.JButton();
        CAS15 = new javax.swing.JButton();
        CAS16 = new javax.swing.JButton();
        CAS17 = new javax.swing.JButton();
        CAS18 = new javax.swing.JButton();
        CAS19 = new javax.swing.JButton();
        CAS20 = new javax.swing.JButton();
        CAS21 = new javax.swing.JButton();
        CAS22 = new javax.swing.JButton();
        CAS23 = new javax.swing.JButton();
        CAS24 = new javax.swing.JButton();
        CAS25 = new javax.swing.JButton();
        CAS26 = new javax.swing.JButton();
        CAS27 = new javax.swing.JButton();
        CAS28 = new javax.swing.JButton();
        CAS29 = new javax.swing.JButton();
        CAS30 = new javax.swing.JButton();
        CAS31 = new javax.swing.JButton();
        CAS32 = new javax.swing.JButton();
        CAS33 = new javax.swing.JButton();
        CAS34 = new javax.swing.JButton();
        CAS35 = new javax.swing.JButton();
        CAS37 = new javax.swing.JButton();
        CAS36 = new javax.swing.JButton();
        CAS38 = new javax.swing.JButton();
        CAS39 = new javax.swing.JButton();
        CAS40 = new javax.swing.JButton();
        CAS42 = new javax.swing.JButton();
        CAS41 = new javax.swing.JButton();
        CAS43Null1 = new javax.swing.JButton();
        CAS44Null1 = new javax.swing.JButton();
        CAS46 = new javax.swing.JButton();
        CAS48Null1 = new javax.swing.JButton();
        CAS49 = new javax.swing.JButton();
        CAS50 = new javax.swing.JButton();
        CAS51 = new javax.swing.JButton();
        CAS52 = new javax.swing.JButton();
        CAS53Null1 = new javax.swing.JButton();
        CAS54Null1 = new javax.swing.JButton();
        CAS55 = new javax.swing.JButton();
        CAS56 = new javax.swing.JButton();
        CAS57Null1 = new javax.swing.JButton();
        CAS58Null1 = new javax.swing.JButton();
        CAS59 = new javax.swing.JButton();
        CAS60 = new javax.swing.JButton();
        CAS61 = new javax.swing.JButton();
        CAS62 = new javax.swing.JButton();
        CAS64 = new javax.swing.JButton();
        CAS63 = new javax.swing.JButton();
        CAS65 = new javax.swing.JButton();
        CAS66 = new javax.swing.JButton();
        CAS67 = new javax.swing.JButton();
        CAS68 = new javax.swing.JButton();
        CAS69 = new javax.swing.JButton();
        CAS70 = new javax.swing.JButton();
        CAS80 = new javax.swing.JButton();
        CAS79 = new javax.swing.JButton();
        CAS78 = new javax.swing.JButton();
        CAS77 = new javax.swing.JButton();
        CAS76 = new javax.swing.JButton();
        CAS75 = new javax.swing.JButton();
        CAS74 = new javax.swing.JButton();
        CAS73 = new javax.swing.JButton();
        CAS72 = new javax.swing.JButton();
        CAS71 = new javax.swing.JButton();
        CAS81 = new javax.swing.JButton();
        CAS91 = new javax.swing.JButton();
        CAS92 = new javax.swing.JButton();
        CAS82 = new javax.swing.JButton();
        CAS83 = new javax.swing.JButton();
        CAS93 = new javax.swing.JButton();
        CAS94 = new javax.swing.JButton();
        CAS84 = new javax.swing.JButton();
        CAS85 = new javax.swing.JButton();
        CAS95 = new javax.swing.JButton();
        CAS96 = new javax.swing.JButton();
        CAS86 = new javax.swing.JButton();
        CAS87 = new javax.swing.JButton();
        CAS97 = new javax.swing.JButton();
        CAS98 = new javax.swing.JButton();
        CAS88 = new javax.swing.JButton();
        CAS89 = new javax.swing.JButton();
        CAS99 = new javax.swing.JButton();
        CAS100 = new javax.swing.JButton();
        CAS90 = new javax.swing.JButton();
        CAS47Null1 = new javax.swing.JButton();
        CAS45 = new javax.swing.JButton();
        H2 = new javax.swing.JLabel();
        H1 = new javax.swing.JLabel();
        H3 = new javax.swing.JLabel();
        H4 = new javax.swing.JLabel();
        H5 = new javax.swing.JLabel();
        H6 = new javax.swing.JLabel();
        H7 = new javax.swing.JLabel();
        H8 = new javax.swing.JLabel();
        H9 = new javax.swing.JLabel();
        H10 = new javax.swing.JLabel();
        H11 = new javax.swing.JLabel();
        H12 = new javax.swing.JLabel();
        H13 = new javax.swing.JLabel();
        H14 = new javax.swing.JLabel();
        H15 = new javax.swing.JLabel();
        H16 = new javax.swing.JLabel();
        H17 = new javax.swing.JLabel();
        H18 = new javax.swing.JLabel();
        H19 = new javax.swing.JLabel();
        H20 = new javax.swing.JLabel();
        H21 = new javax.swing.JLabel();
        H22 = new javax.swing.JLabel();
        H23 = new javax.swing.JLabel();
        H24 = new javax.swing.JLabel();
        H25 = new javax.swing.JLabel();
        H26 = new javax.swing.JLabel();
        H27 = new javax.swing.JLabel();
        H28 = new javax.swing.JLabel();
        H29 = new javax.swing.JLabel();
        H30 = new javax.swing.JLabel();
        H31 = new javax.swing.JLabel();
        H32 = new javax.swing.JLabel();
        H33 = new javax.swing.JLabel();
        H34 = new javax.swing.JLabel();
        H35 = new javax.swing.JLabel();
        H36 = new javax.swing.JLabel();
        H37 = new javax.swing.JLabel();
        H38 = new javax.swing.JLabel();
        H39 = new javax.swing.JLabel();
        V1 = new javax.swing.JLabel();
        H40 = new javax.swing.JLabel();
        V2 = new javax.swing.JLabel();
        V3 = new javax.swing.JLabel();
        V4 = new javax.swing.JLabel();
        V5 = new javax.swing.JLabel();
        V6 = new javax.swing.JLabel();
        V7 = new javax.swing.JLabel();
        V8 = new javax.swing.JLabel();
        V9 = new javax.swing.JLabel();
        V10 = new javax.swing.JLabel();
        V11 = new javax.swing.JLabel();
        V12 = new javax.swing.JLabel();
        V13 = new javax.swing.JLabel();
        V14 = new javax.swing.JLabel();
        V15 = new javax.swing.JLabel();
        V16 = new javax.swing.JLabel();
        V17 = new javax.swing.JLabel();
        V18 = new javax.swing.JLabel();
        V19 = new javax.swing.JLabel();
        V20 = new javax.swing.JLabel();
        V21 = new javax.swing.JLabel();
        V22 = new javax.swing.JLabel();
        V23 = new javax.swing.JLabel();
        V24 = new javax.swing.JLabel();
        V25 = new javax.swing.JLabel();
        V26 = new javax.swing.JLabel();
        V27 = new javax.swing.JLabel();
        V28 = new javax.swing.JLabel();
        V29 = new javax.swing.JLabel();
        V30 = new javax.swing.JLabel();
        V31 = new javax.swing.JLabel();
        V32 = new javax.swing.JLabel();
        V33 = new javax.swing.JLabel();
        V34 = new javax.swing.JLabel();
        V35 = new javax.swing.JLabel();
        V36 = new javax.swing.JLabel();
        V37 = new javax.swing.JLabel();
        V38 = new javax.swing.JLabel();
        V39 = new javax.swing.JLabel();
        V40 = new javax.swing.JLabel();
        EliminadoH1 = new javax.swing.JButton();
        EliminadoH2 = new javax.swing.JButton();
        EliminadoH3 = new javax.swing.JButton();
        EliminadoH4 = new javax.swing.JButton();
        EliminadoH5 = new javax.swing.JButton();
        EliminadoH6 = new javax.swing.JButton();
        EliminadoH7 = new javax.swing.JButton();
        EliminadoH8 = new javax.swing.JButton();
        EliminadoH9 = new javax.swing.JButton();
        EliminadoH10 = new javax.swing.JButton();
        EliminadoH11 = new javax.swing.JButton();
        EliminadoH12 = new javax.swing.JButton();
        EliminadoH13 = new javax.swing.JButton();
        EliminadoH14 = new javax.swing.JButton();
        EliminadoH15 = new javax.swing.JButton();
        EliminadoH16 = new javax.swing.JButton();
        EliminadoH17 = new javax.swing.JButton();
        EliminadoH18 = new javax.swing.JButton();
        EliminadoH19 = new javax.swing.JButton();
        EliminadoH20 = new javax.swing.JButton();
        EliminadoH21 = new javax.swing.JButton();
        EliminadoH22 = new javax.swing.JButton();
        EliminadoH23 = new javax.swing.JButton();
        EliminadoH24 = new javax.swing.JButton();
        EliminadoH25 = new javax.swing.JButton();
        EliminadoH26 = new javax.swing.JButton();
        EliminadoH27 = new javax.swing.JButton();
        EliminadoH28 = new javax.swing.JButton();
        EliminadoH29 = new javax.swing.JButton();
        EliminadoH30 = new javax.swing.JButton();
        EliminadoH31 = new javax.swing.JButton();
        EliminadoH32 = new javax.swing.JButton();
        EliminadoH33 = new javax.swing.JButton();
        EliminadoH34 = new javax.swing.JButton();
        EliminadoH35 = new javax.swing.JButton();
        EliminadoH36 = new javax.swing.JButton();
        EliminadoH37 = new javax.swing.JButton();
        EliminadoH38 = new javax.swing.JButton();
        EliminadoH39 = new javax.swing.JButton();
        EliminadoH40 = new javax.swing.JButton();
        EliminadoV1 = new javax.swing.JButton();
        EliminadoV2 = new javax.swing.JButton();
        EliminadoV3 = new javax.swing.JButton();
        EliminadoV4 = new javax.swing.JButton();
        EliminadoV5 = new javax.swing.JButton();
        EliminadoV6 = new javax.swing.JButton();
        EliminadoV7 = new javax.swing.JButton();
        EliminadoV8 = new javax.swing.JButton();
        EliminadoV9 = new javax.swing.JButton();
        EliminadoV10 = new javax.swing.JButton();
        EliminadoV11 = new javax.swing.JButton();
        EliminadoV12 = new javax.swing.JButton();
        EliminadoV13 = new javax.swing.JButton();
        EliminadoV14 = new javax.swing.JButton();
        EliminadoV15 = new javax.swing.JButton();
        EliminadoV16 = new javax.swing.JButton();
        EliminadoV17 = new javax.swing.JButton();
        EliminadoV18 = new javax.swing.JButton();
        EliminadoV19 = new javax.swing.JButton();
        EliminadoV20 = new javax.swing.JButton();
        EliminadoV21 = new javax.swing.JButton();
        EliminadoV22 = new javax.swing.JButton();
        EliminadoV23 = new javax.swing.JButton();
        EliminadoV24 = new javax.swing.JButton();
        EliminadoV25 = new javax.swing.JButton();
        EliminadoV26 = new javax.swing.JButton();
        EliminadoV27 = new javax.swing.JButton();
        EliminadoV28 = new javax.swing.JButton();
        EliminadoV29 = new javax.swing.JButton();
        EliminadoV30 = new javax.swing.JButton();
        EliminadoV31 = new javax.swing.JButton();
        EliminadoV32 = new javax.swing.JButton();
        EliminadoV33 = new javax.swing.JButton();
        EliminadoV34 = new javax.swing.JButton();
        EliminadoV35 = new javax.swing.JButton();
        EliminadoV36 = new javax.swing.JButton();
        EliminadoV37 = new javax.swing.JButton();
        EliminadoV38 = new javax.swing.JButton();
        EliminadoV39 = new javax.swing.JButton();
        EliminadoV40 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        UsrTurno = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        UsrVillano = new javax.swing.JLabel();
        UsrHeroe = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CAS101 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jButton6.setBackground(new java.awt.Color(0, 0, 102));
        jButton6.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton6.setText("REGRESAR A MENU ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(40, 180, 270, 40);

        UsrPerdedor2.setBackground(new java.awt.Color(0, 51, 0));
        UsrPerdedor2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        UsrPerdedor2.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(UsrPerdedor2);
        UsrPerdedor2.setBounds(170, 110, 140, 50);

        JLabel25.setBackground(new java.awt.Color(0, 51, 0));
        JLabel25.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel25.setForeground(new java.awt.Color(0, 0, 51));
        JLabel25.setText("Perdedores:");
        jPanel3.add(JLabel25);
        JLabel25.setBounds(60, 140, 140, 50);

        Bandoganador.setBackground(new java.awt.Color(0, 51, 0));
        Bandoganador.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        Bandoganador.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(Bandoganador);
        Bandoganador.setBounds(170, 10, 140, 50);

        JLabel14.setBackground(new java.awt.Color(0, 51, 0));
        JLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel14.setForeground(new java.awt.Color(0, 0, 51));
        JLabel14.setText("Ganaron los:");
        jPanel3.add(JLabel14);
        JLabel14.setBounds(20, 10, 210, 50);

        TipodeSlv.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        TipodeSlv.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(TipodeSlv);
        TipodeSlv.setBounds(20, 80, 200, 30);

        JLabel17.setBackground(new java.awt.Color(0, 51, 0));
        JLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel17.setForeground(new java.awt.Color(0, 0, 51));
        JLabel17.setText("Fecha:");
        jPanel3.add(JLabel17);
        JLabel17.setBounds(100, 180, 100, 50);

        JLabel16.setBackground(new java.awt.Color(0, 51, 0));
        JLabel16.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel16.setForeground(new java.awt.Color(0, 0, 51));
        JLabel16.setText("Ganador:");
        jPanel3.add(JLabel16);
        JLabel16.setBounds(60, 40, 140, 50);

        Fecha.setBackground(new java.awt.Color(0, 51, 0));
        Fecha.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(Fecha);
        Fecha.setBounds(190, 180, 140, 50);

        UsrPerdedor.setBackground(new java.awt.Color(0, 51, 0));
        UsrPerdedor.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        UsrPerdedor.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(UsrPerdedor);
        UsrPerdedor.setBounds(170, 140, 140, 50);

        UsrGanador.setBackground(new java.awt.Color(0, 51, 0));
        UsrGanador.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        UsrGanador.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.add(UsrGanador);
        UsrGanador.setBounds(170, 40, 140, 50);

        JLabel18.setBackground(new java.awt.Color(0, 51, 0));
        JLabel18.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel18.setForeground(new java.awt.Color(0, 0, 51));
        JLabel18.setText("Perdedor:");
        jPanel3.add(JLabel18);
        JLabel18.setBounds(60, 110, 140, 50);

        JLabel15.setBackground(new java.awt.Color(0, 51, 0));
        JLabel15.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        JLabel15.setForeground(new java.awt.Color(0, 0, 51));
        JLabel15.setText("La Tierra");
        jPanel3.add(JLabel15);
        JLabel15.setBounds(200, 70, 140, 50);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/Fondo_Ganador.png"))); // NOI18N
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 0, 490, 250);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(680, 320, 860, 340);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton2.setText("HEROE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(240, 140, 110, 40);

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton3.setText("VILLANO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(110, 140, 110, 40);

        Usreleccion.setFont(new java.awt.Font("Swis721 Blk BT", 1, 24)); // NOI18N
        Usreleccion.setForeground(new java.awt.Color(51, 0, 51));
        jPanel4.add(Usreleccion);
        Usreleccion.setBounds(140, 70, 200, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/fomdo_eleccion.png"))); // NOI18N
        jPanel4.add(jLabel11);
        jLabel11.setBounds(90, 20, 280, 180);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(620, 300, 410, 240);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        jPanel2.add(VSVillano);
        VSVillano.setBounds(270, 50, 90, 120);
        jPanel2.add(VSHeroe);
        VSHeroe.setBounds(60, 50, 90, 120);

        nombrevillano.setBackground(new java.awt.Color(51, 0, 51));
        nombrevillano.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        nombrevillano.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        nombrevillano.setOpaque(true);
        jPanel2.add(nombrevillano);
        nombrevillano.setBounds(270, 180, 110, 30);

        nivelvillano.setBackground(new java.awt.Color(51, 0, 51));
        nivelvillano.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        nivelvillano.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        nivelvillano.setOpaque(true);
        jPanel2.add(nivelvillano);
        nivelvillano.setBounds(270, 210, 110, 30);

        nombreheroe.setBackground(new java.awt.Color(0, 51, 0));
        nombreheroe.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        nombreheroe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombreheroe.setOpaque(true);
        jPanel2.add(nombreheroe);
        nombreheroe.setBounds(60, 180, 110, 30);

        nivelheroe.setBackground(new java.awt.Color(0, 51, 0));
        nivelheroe.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        nivelheroe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nivelheroe.setOpaque(true);
        jPanel2.add(nivelheroe);
        nivelheroe.setBounds(60, 210, 110, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/FondoVS.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 10, 440, 240);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(620, 310, 420, 260);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jButton5.setBackground(new java.awt.Color(0, 0, 102));
        jButton5.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton5.setText("NO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(180, 140, 110, 40);

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton4.setText("SI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(50, 140, 110, 40);

        JLabel24.setBackground(new java.awt.Color(0, 51, 0));
        JLabel24.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel24.setForeground(new java.awt.Color(0, 0, 51));
        JLabel24.setText("¿DESEA CONFIRMAR RETIRO?");
        jPanel6.add(JLabel24);
        JLabel24.setBounds(10, 80, 320, 50);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/Fondo_Ganador.png"))); // NOI18N
        jPanel6.add(jLabel13);
        jLabel13.setBounds(0, 0, 490, 250);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(20, 410, 860, 340);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jButton7.setBackground(new java.awt.Color(0, 0, 102));
        jButton7.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 14)); // NOI18N
        jButton7.setText("REGRESAR A MENU ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);
        jButton7.setBounds(40, 180, 270, 40);

        BandoPerdedor.setBackground(new java.awt.Color(0, 51, 0));
        BandoPerdedor.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        BandoPerdedor.setForeground(new java.awt.Color(0, 0, 51));
        jPanel5.add(BandoPerdedor);
        BandoPerdedor.setBounds(30, 140, 140, 50);

        Bandoganador1.setBackground(new java.awt.Color(0, 51, 0));
        Bandoganador1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        Bandoganador1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel5.add(Bandoganador1);
        Bandoganador1.setBounds(170, 10, 140, 50);

        UsrPerdedor1.setBackground(new java.awt.Color(0, 51, 0));
        UsrPerdedor1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        UsrPerdedor1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel5.add(UsrPerdedor1);
        UsrPerdedor1.setBounds(140, 70, 140, 50);

        JLabel19.setBackground(new java.awt.Color(0, 51, 0));
        JLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel19.setForeground(new java.awt.Color(0, 0, 51));
        JLabel19.setText("se ha rendido con los");
        jPanel5.add(JLabel19);
        JLabel19.setBounds(50, 100, 320, 50);

        JLabel20.setBackground(new java.awt.Color(0, 51, 0));
        JLabel20.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel20.setForeground(new java.awt.Color(0, 0, 51));
        JLabel20.setText("Ganaron los:");
        jPanel5.add(JLabel20);
        JLabel20.setBounds(30, 10, 210, 50);

        JLabel21.setBackground(new java.awt.Color(0, 51, 0));
        JLabel21.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel21.setForeground(new java.awt.Color(0, 0, 51));
        JLabel21.setText("Fecha:");
        jPanel5.add(JLabel21);
        JLabel21.setBounds(150, 140, 100, 50);

        JLabel22.setBackground(new java.awt.Color(0, 51, 0));
        JLabel22.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel22.setForeground(new java.awt.Color(0, 0, 51));
        JLabel22.setText("Ganador:");
        jPanel5.add(JLabel22);
        JLabel22.setBounds(50, 40, 140, 50);

        Fecha1.setBackground(new java.awt.Color(0, 51, 0));
        Fecha1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        Fecha1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel5.add(Fecha1);
        Fecha1.setBounds(210, 140, 140, 50);

        JLabel23.setBackground(new java.awt.Color(0, 51, 0));
        JLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        JLabel23.setForeground(new java.awt.Color(0, 0, 51));
        JLabel23.setText("ya que");
        jPanel5.add(JLabel23);
        JLabel23.setBounds(50, 70, 140, 50);

        UsrGanador1.setBackground(new java.awt.Color(0, 51, 0));
        UsrGanador1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        UsrGanador1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel5.add(UsrGanador1);
        UsrGanador1.setBounds(170, 40, 140, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/Fondo_Ganador.png"))); // NOI18N
        jPanel5.add(jLabel12);
        jLabel12.setBounds(0, 0, 490, 250);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(20, 20, 860, 340);

        CAS1.setBackground(new java.awt.Color(51, 51, 51));
        CAS1.setBorder(null);
        CAS1.setContentAreaFilled(false);
        jPanel1.add(CAS1);
        CAS1.setBounds(510, 90, 60, 70);

        CAS2.setBackground(new java.awt.Color(51, 51, 51));
        CAS2.setBorder(null);
        CAS2.setContentAreaFilled(false);
        jPanel1.add(CAS2);
        CAS2.setBounds(570, 90, 70, 70);

        CAS3.setBackground(new java.awt.Color(51, 51, 51));
        CAS3.setBorder(null);
        CAS3.setContentAreaFilled(false);
        jPanel1.add(CAS3);
        CAS3.setBounds(640, 90, 60, 70);

        CAS4.setBackground(new java.awt.Color(51, 51, 51));
        CAS4.setBorder(null);
        CAS4.setContentAreaFilled(false);
        jPanel1.add(CAS4);
        CAS4.setBounds(700, 90, 70, 70);

        CAS5.setBackground(new java.awt.Color(51, 51, 51));
        CAS5.setBorder(null);
        CAS5.setContentAreaFilled(false);
        jPanel1.add(CAS5);
        CAS5.setBounds(770, 100, 60, 60);

        CAS6.setBackground(new java.awt.Color(51, 51, 51));
        CAS6.setBorder(null);
        CAS6.setContentAreaFilled(false);
        jPanel1.add(CAS6);
        CAS6.setBounds(830, 90, 70, 70);

        CAS7.setBackground(new java.awt.Color(51, 51, 51));
        CAS7.setBorder(null);
        CAS7.setContentAreaFilled(false);
        jPanel1.add(CAS7);
        CAS7.setBounds(900, 100, 60, 60);

        CAS8.setBackground(new java.awt.Color(51, 51, 51));
        CAS8.setBorder(null);
        CAS8.setContentAreaFilled(false);
        jPanel1.add(CAS8);
        CAS8.setBounds(960, 100, 70, 60);

        CAS9.setBackground(new java.awt.Color(51, 51, 51));
        CAS9.setBorder(null);
        CAS9.setContentAreaFilled(false);
        jPanel1.add(CAS9);
        CAS9.setBounds(1030, 100, 63, 60);

        CAS10.setBackground(new java.awt.Color(51, 51, 51));
        CAS10.setBorder(null);
        CAS10.setContentAreaFilled(false);
        jPanel1.add(CAS10);
        CAS10.setBounds(1090, 90, 65, 70);

        CAS11.setBackground(new java.awt.Color(51, 51, 51));
        CAS11.setBorder(null);
        CAS11.setContentAreaFilled(false);
        jPanel1.add(CAS11);
        CAS11.setBounds(510, 160, 60, 65);

        CAS12.setBackground(new java.awt.Color(51, 51, 51));
        CAS12.setBorder(null);
        CAS12.setContentAreaFilled(false);
        jPanel1.add(CAS12);
        CAS12.setBounds(570, 160, 70, 65);

        CAS13.setBackground(new java.awt.Color(51, 51, 51));
        CAS13.setBorder(null);
        CAS13.setContentAreaFilled(false);
        jPanel1.add(CAS13);
        CAS13.setBounds(640, 160, 60, 65);

        CAS14.setBackground(new java.awt.Color(51, 51, 51));
        CAS14.setBorder(null);
        CAS14.setContentAreaFilled(false);
        jPanel1.add(CAS14);
        CAS14.setBounds(700, 160, 70, 65);

        CAS15.setBackground(new java.awt.Color(51, 51, 51));
        CAS15.setBorder(null);
        CAS15.setContentAreaFilled(false);
        jPanel1.add(CAS15);
        CAS15.setBounds(770, 160, 60, 65);

        CAS16.setBackground(new java.awt.Color(51, 51, 51));
        CAS16.setBorder(null);
        CAS16.setContentAreaFilled(false);
        jPanel1.add(CAS16);
        CAS16.setBounds(830, 160, 70, 65);

        CAS17.setBackground(new java.awt.Color(51, 51, 51));
        CAS17.setBorder(null);
        CAS17.setContentAreaFilled(false);
        jPanel1.add(CAS17);
        CAS17.setBounds(900, 160, 60, 65);

        CAS18.setBackground(new java.awt.Color(51, 51, 51));
        CAS18.setBorder(null);
        CAS18.setContentAreaFilled(false);
        jPanel1.add(CAS18);
        CAS18.setBounds(960, 160, 70, 65);

        CAS19.setBackground(new java.awt.Color(51, 51, 51));
        CAS19.setBorder(null);
        CAS19.setContentAreaFilled(false);
        jPanel1.add(CAS19);
        CAS19.setBounds(1030, 160, 63, 65);

        CAS20.setBackground(new java.awt.Color(51, 51, 51));
        CAS20.setBorder(null);
        CAS20.setContentAreaFilled(false);
        jPanel1.add(CAS20);
        CAS20.setBounds(1090, 160, 70, 65);

        CAS21.setBackground(new java.awt.Color(51, 51, 51));
        CAS21.setForeground(new java.awt.Color(255, 255, 255));
        CAS21.setBorder(null);
        CAS21.setContentAreaFilled(false);
        jPanel1.add(CAS21);
        CAS21.setBounds(510, 230, 60, 60);

        CAS22.setBackground(new java.awt.Color(51, 51, 51));
        CAS22.setForeground(new java.awt.Color(255, 255, 255));
        CAS22.setBorder(null);
        CAS22.setContentAreaFilled(false);
        jPanel1.add(CAS22);
        CAS22.setBounds(570, 230, 70, 60);

        CAS23.setBackground(new java.awt.Color(51, 51, 51));
        CAS23.setForeground(new java.awt.Color(255, 255, 255));
        CAS23.setBorder(null);
        CAS23.setContentAreaFilled(false);
        jPanel1.add(CAS23);
        CAS23.setBounds(640, 230, 60, 60);

        CAS24.setBackground(new java.awt.Color(51, 51, 51));
        CAS24.setForeground(new java.awt.Color(255, 255, 255));
        CAS24.setBorder(null);
        CAS24.setContentAreaFilled(false);
        jPanel1.add(CAS24);
        CAS24.setBounds(700, 230, 70, 60);

        CAS25.setBackground(new java.awt.Color(51, 51, 51));
        CAS25.setForeground(new java.awt.Color(255, 255, 255));
        CAS25.setBorder(null);
        CAS25.setContentAreaFilled(false);
        jPanel1.add(CAS25);
        CAS25.setBounds(770, 230, 60, 60);

        CAS26.setBackground(new java.awt.Color(51, 51, 51));
        CAS26.setForeground(new java.awt.Color(255, 255, 255));
        CAS26.setBorder(null);
        CAS26.setContentAreaFilled(false);
        jPanel1.add(CAS26);
        CAS26.setBounds(830, 230, 70, 60);

        CAS27.setBackground(new java.awt.Color(51, 51, 51));
        CAS27.setForeground(new java.awt.Color(255, 255, 255));
        CAS27.setBorder(null);
        CAS27.setContentAreaFilled(false);
        jPanel1.add(CAS27);
        CAS27.setBounds(900, 230, 60, 60);

        CAS28.setBackground(new java.awt.Color(51, 51, 51));
        CAS28.setForeground(new java.awt.Color(255, 255, 255));
        CAS28.setBorder(null);
        CAS28.setContentAreaFilled(false);
        jPanel1.add(CAS28);
        CAS28.setBounds(960, 230, 70, 60);

        CAS29.setBackground(new java.awt.Color(51, 51, 51));
        CAS29.setForeground(new java.awt.Color(255, 255, 255));
        CAS29.setBorder(null);
        CAS29.setContentAreaFilled(false);
        jPanel1.add(CAS29);
        CAS29.setBounds(1030, 230, 63, 60);

        CAS30.setBackground(new java.awt.Color(51, 51, 51));
        CAS30.setForeground(new java.awt.Color(255, 255, 255));
        CAS30.setBorder(null);
        CAS30.setContentAreaFilled(false);
        jPanel1.add(CAS30);
        CAS30.setBounds(1090, 230, 70, 60);

        CAS31.setBackground(new java.awt.Color(51, 51, 51));
        CAS31.setForeground(new java.awt.Color(255, 255, 255));
        CAS31.setBorder(null);
        CAS31.setContentAreaFilled(false);
        jPanel1.add(CAS31);
        CAS31.setBounds(510, 290, 60, 60);

        CAS32.setBackground(new java.awt.Color(51, 51, 51));
        CAS32.setForeground(new java.awt.Color(255, 255, 255));
        CAS32.setBorder(null);
        CAS32.setContentAreaFilled(false);
        jPanel1.add(CAS32);
        CAS32.setBounds(570, 290, 70, 60);

        CAS33.setBackground(new java.awt.Color(51, 51, 51));
        CAS33.setForeground(new java.awt.Color(255, 255, 255));
        CAS33.setBorder(null);
        CAS33.setContentAreaFilled(false);
        jPanel1.add(CAS33);
        CAS33.setBounds(640, 290, 60, 60);

        CAS34.setBackground(new java.awt.Color(51, 51, 51));
        CAS34.setForeground(new java.awt.Color(255, 255, 255));
        CAS34.setBorder(null);
        CAS34.setContentAreaFilled(false);
        jPanel1.add(CAS34);
        CAS34.setBounds(700, 290, 67, 60);

        CAS35.setBackground(new java.awt.Color(51, 51, 51));
        CAS35.setForeground(new java.awt.Color(255, 255, 255));
        CAS35.setBorder(null);
        CAS35.setContentAreaFilled(false);
        jPanel1.add(CAS35);
        CAS35.setBounds(770, 290, 60, 60);

        CAS37.setBackground(new java.awt.Color(51, 51, 51));
        CAS37.setForeground(new java.awt.Color(255, 255, 255));
        CAS37.setBorder(null);
        CAS37.setContentAreaFilled(false);
        jPanel1.add(CAS37);
        CAS37.setBounds(900, 290, 60, 60);

        CAS36.setBackground(new java.awt.Color(51, 51, 51));
        CAS36.setForeground(new java.awt.Color(255, 255, 255));
        CAS36.setBorder(null);
        CAS36.setContentAreaFilled(false);
        jPanel1.add(CAS36);
        CAS36.setBounds(830, 290, 70, 60);

        CAS38.setBackground(new java.awt.Color(51, 51, 51));
        CAS38.setForeground(new java.awt.Color(255, 255, 255));
        CAS38.setBorder(null);
        CAS38.setContentAreaFilled(false);
        jPanel1.add(CAS38);
        CAS38.setBounds(960, 290, 70, 60);

        CAS39.setBackground(new java.awt.Color(51, 51, 51));
        CAS39.setForeground(new java.awt.Color(255, 255, 255));
        CAS39.setBorder(null);
        CAS39.setContentAreaFilled(false);
        jPanel1.add(CAS39);
        CAS39.setBounds(1030, 290, 63, 60);

        CAS40.setBackground(new java.awt.Color(51, 51, 51));
        CAS40.setForeground(new java.awt.Color(255, 255, 255));
        CAS40.setBorder(null);
        CAS40.setContentAreaFilled(false);
        jPanel1.add(CAS40);
        CAS40.setBounds(1090, 290, 70, 60);

        CAS42.setBackground(new java.awt.Color(51, 51, 51));
        CAS42.setForeground(new java.awt.Color(255, 255, 255));
        CAS42.setBorder(null);
        CAS42.setContentAreaFilled(false);
        jPanel1.add(CAS42);
        CAS42.setBounds(570, 350, 70, 60);

        CAS41.setBackground(new java.awt.Color(51, 51, 51));
        CAS41.setForeground(new java.awt.Color(255, 255, 255));
        CAS41.setBorder(null);
        CAS41.setContentAreaFilled(false);
        jPanel1.add(CAS41);
        CAS41.setBounds(510, 350, 60, 60);

        CAS43Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS43Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS43Null1.setBorder(null);
        CAS43Null1.setContentAreaFilled(false);
        jPanel1.add(CAS43Null1);
        CAS43Null1.setBounds(640, 350, 70, 60);

        CAS44Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS44Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS44Null1.setBorder(null);
        CAS44Null1.setContentAreaFilled(false);
        jPanel1.add(CAS44Null1);
        CAS44Null1.setBounds(690, 350, 80, 60);

        CAS46.setBackground(new java.awt.Color(51, 51, 51));
        CAS46.setForeground(new java.awt.Color(255, 255, 255));
        CAS46.setBorder(null);
        CAS46.setContentAreaFilled(false);
        jPanel1.add(CAS46);
        CAS46.setBounds(830, 350, 70, 60);

        CAS48Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS48Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS48Null1.setBorder(null);
        CAS48Null1.setContentAreaFilled(false);
        jPanel1.add(CAS48Null1);
        CAS48Null1.setBounds(970, 350, 62, 70);

        CAS49.setBackground(new java.awt.Color(51, 51, 51));
        CAS49.setForeground(new java.awt.Color(255, 255, 255));
        CAS49.setBorder(null);
        CAS49.setContentAreaFilled(false);
        jPanel1.add(CAS49);
        CAS49.setBounds(1030, 350, 60, 65);

        CAS50.setBackground(new java.awt.Color(51, 51, 51));
        CAS50.setForeground(new java.awt.Color(255, 255, 255));
        CAS50.setBorder(null);
        CAS50.setContentAreaFilled(false);
        jPanel1.add(CAS50);
        CAS50.setBounds(1090, 350, 70, 64);

        CAS51.setBackground(new java.awt.Color(51, 51, 51));
        CAS51.setForeground(new java.awt.Color(255, 255, 255));
        CAS51.setBorder(null);
        CAS51.setContentAreaFilled(false);
        jPanel1.add(CAS51);
        CAS51.setBounds(510, 410, 60, 62);

        CAS52.setBackground(new java.awt.Color(51, 51, 51));
        CAS52.setForeground(new java.awt.Color(255, 255, 255));
        CAS52.setBorder(null);
        CAS52.setContentAreaFilled(false);
        jPanel1.add(CAS52);
        CAS52.setBounds(570, 410, 70, 62);

        CAS53Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS53Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS53Null1.setBorder(null);
        CAS53Null1.setContentAreaFilled(false);
        jPanel1.add(CAS53Null1);
        CAS53Null1.setBounds(640, 410, 60, 63);

        CAS54Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS54Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS54Null1.setBorder(null);
        CAS54Null1.setContentAreaFilled(false);
        jPanel1.add(CAS54Null1);
        CAS54Null1.setBounds(700, 410, 70, 63);

        CAS55.setBackground(new java.awt.Color(51, 51, 51));
        CAS55.setForeground(new java.awt.Color(255, 255, 255));
        CAS55.setBorder(null);
        CAS55.setContentAreaFilled(false);
        jPanel1.add(CAS55);
        CAS55.setBounds(770, 410, 60, 60);

        CAS56.setBackground(new java.awt.Color(51, 51, 51));
        CAS56.setForeground(new java.awt.Color(255, 255, 255));
        CAS56.setBorder(null);
        CAS56.setContentAreaFilled(false);
        jPanel1.add(CAS56);
        CAS56.setBounds(830, 410, 70, 61);

        CAS57Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS57Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS57Null1.setBorder(null);
        CAS57Null1.setContentAreaFilled(false);
        jPanel1.add(CAS57Null1);
        CAS57Null1.setBounds(900, 420, 70, 54);

        CAS58Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS58Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS58Null1.setBorder(null);
        CAS58Null1.setContentAreaFilled(false);
        jPanel1.add(CAS58Null1);
        CAS58Null1.setBounds(970, 420, 62, 54);

        CAS59.setBackground(new java.awt.Color(51, 51, 51));
        CAS59.setForeground(new java.awt.Color(255, 255, 255));
        CAS59.setBorder(null);
        CAS59.setContentAreaFilled(false);
        jPanel1.add(CAS59);
        CAS59.setBounds(1030, 420, 60, 60);

        CAS60.setBackground(new java.awt.Color(51, 51, 51));
        CAS60.setForeground(new java.awt.Color(255, 255, 255));
        CAS60.setBorder(null);
        CAS60.setContentAreaFilled(false);
        jPanel1.add(CAS60);
        CAS60.setBounds(1090, 420, 70, 60);

        CAS61.setBackground(new java.awt.Color(51, 51, 51));
        CAS61.setForeground(new java.awt.Color(255, 255, 255));
        CAS61.setBorder(null);
        CAS61.setContentAreaFilled(false);
        jPanel1.add(CAS61);
        CAS61.setBounds(510, 470, 60, 70);

        CAS62.setBackground(new java.awt.Color(51, 51, 51));
        CAS62.setForeground(new java.awt.Color(255, 255, 255));
        CAS62.setBorder(null);
        CAS62.setContentAreaFilled(false);
        jPanel1.add(CAS62);
        CAS62.setBounds(570, 470, 70, 70);

        CAS64.setBackground(new java.awt.Color(51, 51, 51));
        CAS64.setForeground(new java.awt.Color(255, 255, 255));
        CAS64.setBorder(null);
        CAS64.setContentAreaFilled(false);
        jPanel1.add(CAS64);
        CAS64.setBounds(700, 470, 70, 70);

        CAS63.setBackground(new java.awt.Color(51, 51, 51));
        CAS63.setForeground(new java.awt.Color(255, 255, 255));
        CAS63.setBorder(null);
        CAS63.setContentAreaFilled(false);
        jPanel1.add(CAS63);
        CAS63.setBounds(640, 470, 60, 70);

        CAS65.setBackground(new java.awt.Color(51, 51, 51));
        CAS65.setForeground(new java.awt.Color(255, 255, 255));
        CAS65.setBorder(null);
        CAS65.setContentAreaFilled(false);
        jPanel1.add(CAS65);
        CAS65.setBounds(770, 470, 60, 70);

        CAS66.setBackground(new java.awt.Color(51, 51, 51));
        CAS66.setForeground(new java.awt.Color(255, 255, 255));
        CAS66.setBorder(null);
        CAS66.setContentAreaFilled(false);
        jPanel1.add(CAS66);
        CAS66.setBounds(830, 470, 70, 70);

        CAS67.setBackground(new java.awt.Color(51, 51, 51));
        CAS67.setForeground(new java.awt.Color(255, 255, 255));
        CAS67.setBorder(null);
        CAS67.setContentAreaFilled(false);
        jPanel1.add(CAS67);
        CAS67.setBounds(900, 470, 60, 70);

        CAS68.setBackground(new java.awt.Color(51, 51, 51));
        CAS68.setForeground(new java.awt.Color(255, 255, 255));
        CAS68.setBorder(null);
        CAS68.setContentAreaFilled(false);
        jPanel1.add(CAS68);
        CAS68.setBounds(960, 480, 70, 70);

        CAS69.setBackground(new java.awt.Color(51, 51, 51));
        CAS69.setForeground(new java.awt.Color(255, 255, 255));
        CAS69.setBorder(null);
        CAS69.setContentAreaFilled(false);
        jPanel1.add(CAS69);
        CAS69.setBounds(1030, 480, 60, 60);

        CAS70.setBackground(new java.awt.Color(51, 51, 51));
        CAS70.setForeground(new java.awt.Color(255, 255, 255));
        CAS70.setBorder(null);
        CAS70.setContentAreaFilled(false);
        jPanel1.add(CAS70);
        CAS70.setBounds(1090, 470, 70, 70);

        CAS80.setBackground(new java.awt.Color(51, 51, 51));
        CAS80.setForeground(new java.awt.Color(255, 255, 255));
        CAS80.setBorder(null);
        CAS80.setContentAreaFilled(false);
        jPanel1.add(CAS80);
        CAS80.setBounds(1090, 540, 70, 60);

        CAS79.setBackground(new java.awt.Color(51, 51, 51));
        CAS79.setForeground(new java.awt.Color(255, 255, 255));
        CAS79.setBorder(null);
        CAS79.setContentAreaFilled(false);
        jPanel1.add(CAS79);
        CAS79.setBounds(1030, 540, 63, 60);

        CAS78.setBackground(new java.awt.Color(51, 51, 51));
        CAS78.setForeground(new java.awt.Color(255, 255, 255));
        CAS78.setBorder(null);
        CAS78.setContentAreaFilled(false);
        jPanel1.add(CAS78);
        CAS78.setBounds(960, 540, 70, 60);

        CAS77.setBackground(new java.awt.Color(51, 51, 51));
        CAS77.setForeground(new java.awt.Color(255, 255, 255));
        CAS77.setBorder(null);
        CAS77.setContentAreaFilled(false);
        jPanel1.add(CAS77);
        CAS77.setBounds(900, 540, 62, 60);

        CAS76.setBackground(new java.awt.Color(51, 51, 51));
        CAS76.setForeground(new java.awt.Color(255, 255, 255));
        CAS76.setBorder(null);
        CAS76.setContentAreaFilled(false);
        jPanel1.add(CAS76);
        CAS76.setBounds(830, 540, 70, 60);

        CAS75.setBackground(new java.awt.Color(51, 51, 51));
        CAS75.setForeground(new java.awt.Color(255, 255, 255));
        CAS75.setBorder(null);
        CAS75.setContentAreaFilled(false);
        jPanel1.add(CAS75);
        CAS75.setBounds(770, 540, 60, 60);

        CAS74.setBackground(new java.awt.Color(51, 51, 51));
        CAS74.setForeground(new java.awt.Color(255, 255, 255));
        CAS74.setBorder(null);
        CAS74.setContentAreaFilled(false);
        jPanel1.add(CAS74);
        CAS74.setBounds(640, 540, 60, 60);

        CAS73.setBackground(new java.awt.Color(51, 51, 51));
        CAS73.setForeground(new java.awt.Color(255, 255, 255));
        CAS73.setBorder(null);
        CAS73.setContentAreaFilled(false);
        jPanel1.add(CAS73);
        CAS73.setBounds(700, 540, 70, 60);

        CAS72.setBackground(new java.awt.Color(51, 51, 51));
        CAS72.setForeground(new java.awt.Color(255, 255, 255));
        CAS72.setBorder(null);
        CAS72.setContentAreaFilled(false);
        jPanel1.add(CAS72);
        CAS72.setBounds(570, 540, 70, 60);

        CAS71.setBackground(new java.awt.Color(51, 51, 51));
        CAS71.setForeground(new java.awt.Color(255, 255, 255));
        CAS71.setBorder(null);
        CAS71.setContentAreaFilled(false);
        jPanel1.add(CAS71);
        CAS71.setBounds(510, 540, 60, 61);

        CAS81.setBackground(new java.awt.Color(51, 51, 51));
        CAS81.setForeground(new java.awt.Color(255, 255, 255));
        CAS81.setBorder(null);
        CAS81.setContentAreaFilled(false);
        jPanel1.add(CAS81);
        CAS81.setBounds(510, 600, 60, 60);

        CAS91.setBackground(new java.awt.Color(51, 51, 51));
        CAS91.setForeground(new java.awt.Color(255, 255, 255));
        CAS91.setBorder(null);
        CAS91.setContentAreaFilled(false);
        jPanel1.add(CAS91);
        CAS91.setBounds(510, 660, 60, 70);

        CAS92.setBackground(new java.awt.Color(51, 51, 51));
        CAS92.setForeground(new java.awt.Color(255, 255, 255));
        CAS92.setBorder(null);
        CAS92.setContentAreaFilled(false);
        jPanel1.add(CAS92);
        CAS92.setBounds(570, 660, 70, 70);

        CAS82.setBackground(new java.awt.Color(51, 51, 51));
        CAS82.setForeground(new java.awt.Color(255, 255, 255));
        CAS82.setBorder(null);
        CAS82.setContentAreaFilled(false);
        jPanel1.add(CAS82);
        CAS82.setBounds(570, 600, 70, 62);

        CAS83.setBackground(new java.awt.Color(51, 51, 51));
        CAS83.setForeground(new java.awt.Color(255, 255, 255));
        CAS83.setBorder(null);
        CAS83.setContentAreaFilled(false);
        jPanel1.add(CAS83);
        CAS83.setBounds(640, 600, 60, 60);

        CAS93.setBackground(new java.awt.Color(51, 51, 51));
        CAS93.setForeground(new java.awt.Color(255, 255, 255));
        CAS93.setBorder(null);
        CAS93.setContentAreaFilled(false);
        jPanel1.add(CAS93);
        CAS93.setBounds(640, 660, 62, 70);

        CAS94.setBackground(new java.awt.Color(51, 51, 51));
        CAS94.setForeground(new java.awt.Color(255, 255, 255));
        CAS94.setBorder(null);
        CAS94.setContentAreaFilled(false);
        jPanel1.add(CAS94);
        CAS94.setBounds(700, 660, 70, 70);

        CAS84.setBackground(new java.awt.Color(51, 51, 51));
        CAS84.setForeground(new java.awt.Color(255, 255, 255));
        CAS84.setBorder(null);
        CAS84.setContentAreaFilled(false);
        jPanel1.add(CAS84);
        CAS84.setBounds(700, 600, 70, 61);

        CAS85.setBackground(new java.awt.Color(51, 51, 51));
        CAS85.setForeground(new java.awt.Color(255, 255, 255));
        CAS85.setBorder(null);
        CAS85.setContentAreaFilled(false);
        jPanel1.add(CAS85);
        CAS85.setBounds(770, 600, 62, 60);

        CAS95.setBackground(new java.awt.Color(51, 51, 51));
        CAS95.setForeground(new java.awt.Color(255, 255, 255));
        CAS95.setBorder(null);
        CAS95.setContentAreaFilled(false);
        jPanel1.add(CAS95);
        CAS95.setBounds(770, 660, 60, 70);

        CAS96.setBackground(new java.awt.Color(51, 51, 51));
        CAS96.setForeground(new java.awt.Color(255, 255, 255));
        CAS96.setBorder(null);
        CAS96.setContentAreaFilled(false);
        jPanel1.add(CAS96);
        CAS96.setBounds(830, 660, 70, 70);

        CAS86.setBackground(new java.awt.Color(51, 51, 51));
        CAS86.setForeground(new java.awt.Color(255, 255, 255));
        CAS86.setBorder(null);
        CAS86.setContentAreaFilled(false);
        jPanel1.add(CAS86);
        CAS86.setBounds(830, 600, 70, 60);

        CAS87.setBackground(new java.awt.Color(51, 51, 51));
        CAS87.setForeground(new java.awt.Color(255, 255, 255));
        CAS87.setBorder(null);
        CAS87.setContentAreaFilled(false);
        jPanel1.add(CAS87);
        CAS87.setBounds(900, 600, 60, 60);

        CAS97.setBackground(new java.awt.Color(51, 51, 51));
        CAS97.setForeground(new java.awt.Color(255, 255, 255));
        CAS97.setBorder(null);
        CAS97.setContentAreaFilled(false);
        jPanel1.add(CAS97);
        CAS97.setBounds(900, 660, 61, 70);

        CAS98.setBackground(new java.awt.Color(51, 51, 51));
        CAS98.setForeground(new java.awt.Color(255, 255, 255));
        CAS98.setBorder(null);
        CAS98.setContentAreaFilled(false);
        jPanel1.add(CAS98);
        CAS98.setBounds(960, 660, 70, 70);

        CAS88.setBackground(new java.awt.Color(51, 51, 51));
        CAS88.setForeground(new java.awt.Color(255, 255, 255));
        CAS88.setBorder(null);
        CAS88.setContentAreaFilled(false);
        jPanel1.add(CAS88);
        CAS88.setBounds(960, 600, 70, 60);

        CAS89.setBackground(new java.awt.Color(51, 51, 51));
        CAS89.setForeground(new java.awt.Color(255, 255, 255));
        CAS89.setBorder(null);
        CAS89.setContentAreaFilled(false);
        jPanel1.add(CAS89);
        CAS89.setBounds(1030, 600, 60, 60);

        CAS99.setBackground(new java.awt.Color(51, 51, 51));
        CAS99.setForeground(new java.awt.Color(255, 255, 255));
        CAS99.setBorder(null);
        CAS99.setContentAreaFilled(false);
        jPanel1.add(CAS99);
        CAS99.setBounds(1030, 660, 63, 70);

        CAS100.setBackground(new java.awt.Color(51, 51, 51));
        CAS100.setForeground(new java.awt.Color(255, 255, 255));
        CAS100.setBorder(null);
        CAS100.setContentAreaFilled(false);
        jPanel1.add(CAS100);
        CAS100.setBounds(1090, 660, 70, 70);

        CAS90.setBackground(new java.awt.Color(51, 51, 51));
        CAS90.setForeground(new java.awt.Color(255, 255, 255));
        CAS90.setBorder(null);
        CAS90.setContentAreaFilled(false);
        jPanel1.add(CAS90);
        CAS90.setBounds(1090, 600, 70, 60);

        CAS47Null1.setBackground(new java.awt.Color(51, 51, 51));
        CAS47Null1.setForeground(new java.awt.Color(255, 255, 255));
        CAS47Null1.setBorder(null);
        CAS47Null1.setContentAreaFilled(false);
        jPanel1.add(CAS47Null1);
        CAS47Null1.setBounds(900, 350, 80, 70);

        CAS45.setBackground(new java.awt.Color(51, 51, 51));
        CAS45.setForeground(new java.awt.Color(255, 255, 255));
        CAS45.setBorder(null);
        CAS45.setContentAreaFilled(false);
        jPanel1.add(CAS45);
        CAS45.setBounds(770, 350, 60, 60);

        H2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H2);
        H2.setBounds(580, 620, 40, 50);

        H1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H1);
        H1.setBounds(520, 620, 40, 50);

        H3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H3);
        H3.setBounds(640, 620, 40, 50);

        H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H4);
        H4.setBounds(700, 620, 40, 50);

        H5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H5);
        H5.setBounds(770, 620, 40, 50);

        H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H6);
        H6.setBounds(1020, 680, 40, 50);

        H7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H7);
        H7.setBounds(1080, 680, 40, 50);

        H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H8);
        H8.setBounds(970, 660, 40, 50);

        H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H9);
        H9.setBounds(1030, 660, 40, 50);

        H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H10);
        H10.setBounds(1090, 660, 40, 50);

        H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H11);
        H11.setBounds(520, 560, 40, 50);

        H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H12);
        H12.setBounds(580, 560, 40, 50);

        H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H13);
        H13.setBounds(640, 560, 40, 50);

        H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H14);
        H14.setBounds(700, 560, 40, 50);

        H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H15);
        H15.setBounds(770, 560, 40, 50);

        H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H16);
        H16.setBounds(1020, 620, 40, 50);

        H17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H17);
        H17.setBounds(1080, 620, 40, 50);

        H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H18);
        H18.setBounds(970, 600, 40, 50);

        H19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H19);
        H19.setBounds(1030, 600, 40, 50);

        H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H20);
        H20.setBounds(1090, 600, 40, 50);

        H21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H21);
        H21.setBounds(520, 500, 40, 50);

        H22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H22);
        H22.setBounds(580, 500, 40, 50);

        H23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H23);
        H23.setBounds(640, 500, 40, 50);

        H24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H24);
        H24.setBounds(700, 500, 40, 50);

        H25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H25);
        H25.setBounds(770, 500, 40, 50);

        H26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H26);
        H26.setBounds(1020, 560, 40, 50);

        H27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H27);
        H27.setBounds(1080, 560, 40, 50);

        H28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H28);
        H28.setBounds(970, 540, 40, 50);

        H29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H29);
        H29.setBounds(1030, 540, 40, 50);

        H30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H30);
        H30.setBounds(1090, 540, 40, 50);

        H31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H31);
        H31.setBounds(520, 440, 40, 50);

        H32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H32);
        H32.setBounds(580, 440, 40, 50);

        H33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H33);
        H33.setBounds(640, 440, 40, 50);

        H34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H34);
        H34.setBounds(700, 440, 40, 50);

        H35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H35);
        H35.setBounds(770, 440, 40, 50);

        H36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H36);
        H36.setBounds(1020, 500, 40, 50);

        H37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H37);
        H37.setBounds(1080, 500, 40, 50);

        H38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H38);
        H38.setBounds(970, 480, 40, 50);

        H39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H39);
        H39.setBounds(1030, 480, 40, 50);

        V1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V1);
        V1.setBounds(520, 100, 40, 50);

        H40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(H40);
        H40.setBounds(1090, 480, 40, 50);

        V2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V2);
        V2.setBounds(580, 100, 40, 50);

        V3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V3);
        V3.setBounds(640, 100, 40, 50);

        V4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V4);
        V4.setBounds(700, 100, 40, 50);

        V5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V5);
        V5.setBounds(770, 100, 40, 50);

        V6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V6);
        V6.setBounds(1020, 140, 40, 50);

        V7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V7);
        V7.setBounds(1080, 140, 40, 50);

        V8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V8);
        V8.setBounds(990, 100, 40, 50);

        V9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V9);
        V9.setBounds(1050, 100, 40, 50);

        V10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V10);
        V10.setBounds(1110, 100, 40, 50);

        V11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V11);
        V11.setBounds(520, 140, 40, 50);

        V12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V12);
        V12.setBounds(580, 140, 40, 50);

        V13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V13);
        V13.setBounds(640, 140, 40, 50);

        V14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V14);
        V14.setBounds(700, 140, 40, 50);

        V15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V15);
        V15.setBounds(770, 140, 40, 50);

        V16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V16);
        V16.setBounds(1020, 200, 40, 50);

        V17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V17);
        V17.setBounds(1080, 200, 40, 50);

        V18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V18);
        V18.setBounds(990, 160, 40, 50);

        V19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V19);
        V19.setBounds(1050, 160, 40, 50);

        V20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V20);
        V20.setBounds(1110, 160, 40, 50);

        V21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V21);
        V21.setBounds(520, 200, 40, 50);

        V22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V22);
        V22.setBounds(580, 200, 40, 50);

        V23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V23);
        V23.setBounds(640, 200, 40, 50);

        V24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V24);
        V24.setBounds(700, 200, 40, 50);

        V25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V25);
        V25.setBounds(770, 200, 40, 50);

        V26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V26);
        V26.setBounds(1020, 260, 40, 50);

        V27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V27);
        V27.setBounds(1080, 260, 40, 50);

        V28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V28);
        V28.setBounds(990, 220, 40, 50);

        V29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V29);
        V29.setBounds(1050, 220, 40, 50);

        V30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V30);
        V30.setBounds(1110, 220, 40, 50);

        V31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V31);
        V31.setBounds(520, 260, 40, 50);

        V32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V32);
        V32.setBounds(580, 260, 40, 50);

        V33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V33);
        V33.setBounds(640, 260, 40, 50);

        V34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V34);
        V34.setBounds(700, 260, 40, 50);

        V35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V35);
        V35.setBounds(770, 260, 40, 50);

        V36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V36);
        V36.setBounds(1020, 320, 40, 50);

        V37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V37);
        V37.setBounds(1080, 320, 40, 50);

        V38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V38);
        V38.setBounds(990, 280, 40, 50);

        V39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V39);
        V39.setBounds(1050, 280, 40, 50);

        V40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/DieErde.png"))); // NOI18N
        jPanel1.add(V40);
        V40.setBounds(1110, 280, 40, 50);

        EliminadoH1.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH1.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH1.setContentAreaFilled(false);
        jPanel1.add(EliminadoH1);
        EliminadoH1.setBounds(160, 190, 60, 70);

        EliminadoH2.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH2.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH2.setContentAreaFilled(false);
        jPanel1.add(EliminadoH2);
        EliminadoH2.setBounds(100, 190, 60, 70);

        EliminadoH3.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH3.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH3.setContentAreaFilled(false);
        jPanel1.add(EliminadoH3);
        EliminadoH3.setBounds(220, 190, 60, 70);

        EliminadoH4.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH4.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH4.setContentAreaFilled(false);
        jPanel1.add(EliminadoH4);
        EliminadoH4.setBounds(340, 190, 60, 70);

        EliminadoH5.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH5.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH5.setContentAreaFilled(false);
        jPanel1.add(EliminadoH5);
        EliminadoH5.setBounds(280, 190, 60, 70);

        EliminadoH6.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH6.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH6.setContentAreaFilled(false);
        jPanel1.add(EliminadoH6);
        EliminadoH6.setBounds(100, 260, 60, 70);

        EliminadoH7.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH7.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH7.setContentAreaFilled(false);
        jPanel1.add(EliminadoH7);
        EliminadoH7.setBounds(160, 260, 60, 70);

        EliminadoH8.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH8.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH8.setContentAreaFilled(false);
        jPanel1.add(EliminadoH8);
        EliminadoH8.setBounds(220, 260, 60, 70);

        EliminadoH9.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH9.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH9.setContentAreaFilled(false);
        jPanel1.add(EliminadoH9);
        EliminadoH9.setBounds(280, 260, 60, 70);

        EliminadoH10.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH10.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH10.setContentAreaFilled(false);
        jPanel1.add(EliminadoH10);
        EliminadoH10.setBounds(340, 260, 60, 70);

        EliminadoH11.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH11.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH11.setContentAreaFilled(false);
        jPanel1.add(EliminadoH11);
        EliminadoH11.setBounds(340, 330, 60, 70);

        EliminadoH12.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH12.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH12.setContentAreaFilled(false);
        jPanel1.add(EliminadoH12);
        EliminadoH12.setBounds(100, 330, 60, 70);

        EliminadoH13.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH13.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH13.setContentAreaFilled(false);
        jPanel1.add(EliminadoH13);
        EliminadoH13.setBounds(220, 330, 60, 70);

        EliminadoH14.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH14.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH14.setContentAreaFilled(false);
        jPanel1.add(EliminadoH14);
        EliminadoH14.setBounds(160, 330, 60, 70);

        EliminadoH15.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH15.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH15.setContentAreaFilled(false);
        jPanel1.add(EliminadoH15);
        EliminadoH15.setBounds(280, 330, 60, 70);

        EliminadoH16.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH16.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH16.setContentAreaFilled(false);
        jPanel1.add(EliminadoH16);
        EliminadoH16.setBounds(160, 400, 60, 70);

        EliminadoH17.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH17.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH17.setContentAreaFilled(false);
        jPanel1.add(EliminadoH17);
        EliminadoH17.setBounds(100, 400, 60, 70);

        EliminadoH18.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH18.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH18.setContentAreaFilled(false);
        jPanel1.add(EliminadoH18);
        EliminadoH18.setBounds(220, 400, 60, 70);

        EliminadoH19.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH19.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH19.setContentAreaFilled(false);
        jPanel1.add(EliminadoH19);
        EliminadoH19.setBounds(340, 400, 60, 70);

        EliminadoH20.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH20.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH20.setContentAreaFilled(false);
        jPanel1.add(EliminadoH20);
        EliminadoH20.setBounds(280, 400, 60, 70);

        EliminadoH21.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH21.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH21.setContentAreaFilled(false);
        jPanel1.add(EliminadoH21);
        EliminadoH21.setBounds(100, 470, 60, 70);

        EliminadoH22.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH22.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH22.setContentAreaFilled(false);
        jPanel1.add(EliminadoH22);
        EliminadoH22.setBounds(160, 470, 60, 70);

        EliminadoH23.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH23.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH23.setContentAreaFilled(false);
        jPanel1.add(EliminadoH23);
        EliminadoH23.setBounds(220, 470, 60, 70);

        EliminadoH24.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH24.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH24.setContentAreaFilled(false);
        jPanel1.add(EliminadoH24);
        EliminadoH24.setBounds(280, 470, 60, 70);

        EliminadoH25.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH25.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH25.setContentAreaFilled(false);
        jPanel1.add(EliminadoH25);
        EliminadoH25.setBounds(340, 470, 60, 70);

        EliminadoH26.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH26.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH26.setContentAreaFilled(false);
        jPanel1.add(EliminadoH26);
        EliminadoH26.setBounds(340, 540, 60, 70);

        EliminadoH27.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH27.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH27.setContentAreaFilled(false);
        jPanel1.add(EliminadoH27);
        EliminadoH27.setBounds(100, 540, 60, 70);

        EliminadoH28.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH28.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH28.setContentAreaFilled(false);
        jPanel1.add(EliminadoH28);
        EliminadoH28.setBounds(220, 540, 60, 70);

        EliminadoH29.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH29.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH29.setContentAreaFilled(false);
        jPanel1.add(EliminadoH29);
        EliminadoH29.setBounds(160, 540, 60, 70);

        EliminadoH30.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH30.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH30.setContentAreaFilled(false);
        jPanel1.add(EliminadoH30);
        EliminadoH30.setBounds(280, 540, 60, 70);

        EliminadoH31.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH31.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH31.setContentAreaFilled(false);
        jPanel1.add(EliminadoH31);
        EliminadoH31.setBounds(100, 610, 60, 70);

        EliminadoH32.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH32.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH32.setContentAreaFilled(false);
        jPanel1.add(EliminadoH32);
        EliminadoH32.setBounds(220, 610, 60, 70);

        EliminadoH33.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH33.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH33.setContentAreaFilled(false);
        jPanel1.add(EliminadoH33);
        EliminadoH33.setBounds(220, 610, 60, 70);

        EliminadoH34.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH34.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH34.setContentAreaFilled(false);
        jPanel1.add(EliminadoH34);
        EliminadoH34.setBounds(280, 610, 60, 70);

        EliminadoH35.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH35.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH35.setContentAreaFilled(false);
        jPanel1.add(EliminadoH35);
        EliminadoH35.setBounds(340, 610, 60, 70);

        EliminadoH36.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH36.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH36.setContentAreaFilled(false);
        jPanel1.add(EliminadoH36);
        EliminadoH36.setBounds(100, 680, 60, 70);

        EliminadoH37.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH37.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH37.setContentAreaFilled(false);
        jPanel1.add(EliminadoH37);
        EliminadoH37.setBounds(160, 680, 60, 70);

        EliminadoH38.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH38.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH38.setContentAreaFilled(false);
        jPanel1.add(EliminadoH38);
        EliminadoH38.setBounds(220, 680, 60, 70);

        EliminadoH39.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH39.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH39.setContentAreaFilled(false);
        jPanel1.add(EliminadoH39);
        EliminadoH39.setBounds(280, 680, 60, 70);

        EliminadoH40.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoH40.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoH40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoH40.setContentAreaFilled(false);
        jPanel1.add(EliminadoH40);
        EliminadoH40.setBounds(340, 680, 60, 70);

        EliminadoV1.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV1.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV1.setContentAreaFilled(false);
        jPanel1.add(EliminadoV1);
        EliminadoV1.setBounds(1260, 180, 60, 70);

        EliminadoV2.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV2.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV2.setContentAreaFilled(false);
        EliminadoV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV2ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV2);
        EliminadoV2.setBounds(1320, 180, 60, 70);

        EliminadoV3.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV3.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV3.setContentAreaFilled(false);
        jPanel1.add(EliminadoV3);
        EliminadoV3.setBounds(1380, 180, 60, 70);

        EliminadoV4.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV4.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV4.setContentAreaFilled(false);
        jPanel1.add(EliminadoV4);
        EliminadoV4.setBounds(1440, 180, 60, 70);

        EliminadoV5.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV5.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV5.setContentAreaFilled(false);
        jPanel1.add(EliminadoV5);
        EliminadoV5.setBounds(1500, 180, 60, 70);

        EliminadoV6.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV6.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV6.setContentAreaFilled(false);
        jPanel1.add(EliminadoV6);
        EliminadoV6.setBounds(1260, 250, 60, 70);

        EliminadoV7.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV7.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV7.setContentAreaFilled(false);
        EliminadoV7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV7ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV7);
        EliminadoV7.setBounds(1320, 250, 60, 70);

        EliminadoV8.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV8.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV8.setContentAreaFilled(false);
        jPanel1.add(EliminadoV8);
        EliminadoV8.setBounds(1380, 250, 60, 70);

        EliminadoV9.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV9.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV9.setContentAreaFilled(false);
        jPanel1.add(EliminadoV9);
        EliminadoV9.setBounds(1440, 250, 60, 70);

        EliminadoV10.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV10.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV10.setContentAreaFilled(false);
        jPanel1.add(EliminadoV10);
        EliminadoV10.setBounds(1500, 250, 60, 70);

        EliminadoV11.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV11.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV11.setContentAreaFilled(false);
        jPanel1.add(EliminadoV11);
        EliminadoV11.setBounds(1380, 320, 60, 70);

        EliminadoV12.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV12.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV12.setContentAreaFilled(false);
        jPanel1.add(EliminadoV12);
        EliminadoV12.setBounds(1440, 320, 60, 70);

        EliminadoV13.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV13.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV13.setContentAreaFilled(false);
        jPanel1.add(EliminadoV13);
        EliminadoV13.setBounds(1500, 320, 60, 70);

        EliminadoV14.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV14.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV14.setContentAreaFilled(false);
        jPanel1.add(EliminadoV14);
        EliminadoV14.setBounds(1260, 320, 60, 70);

        EliminadoV15.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV15.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV15.setContentAreaFilled(false);
        EliminadoV15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV15ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV15);
        EliminadoV15.setBounds(1320, 320, 60, 70);

        EliminadoV16.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV16.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV16.setContentAreaFilled(false);
        jPanel1.add(EliminadoV16);
        EliminadoV16.setBounds(1260, 390, 60, 70);

        EliminadoV17.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV17.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV17.setContentAreaFilled(false);
        EliminadoV17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV17ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV17);
        EliminadoV17.setBounds(1320, 390, 60, 70);

        EliminadoV18.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV18.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV18.setContentAreaFilled(false);
        jPanel1.add(EliminadoV18);
        EliminadoV18.setBounds(1380, 390, 60, 70);

        EliminadoV19.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV19.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV19.setContentAreaFilled(false);
        jPanel1.add(EliminadoV19);
        EliminadoV19.setBounds(1440, 390, 60, 70);

        EliminadoV20.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV20.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV20.setContentAreaFilled(false);
        jPanel1.add(EliminadoV20);
        EliminadoV20.setBounds(1500, 390, 60, 70);

        EliminadoV21.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV21.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV21.setContentAreaFilled(false);
        jPanel1.add(EliminadoV21);
        EliminadoV21.setBounds(1260, 460, 60, 70);

        EliminadoV22.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV22.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV22.setContentAreaFilled(false);
        EliminadoV22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV22ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV22);
        EliminadoV22.setBounds(1320, 460, 60, 70);

        EliminadoV23.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV23.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV23.setContentAreaFilled(false);
        jPanel1.add(EliminadoV23);
        EliminadoV23.setBounds(1380, 460, 60, 70);

        EliminadoV24.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV24.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV24.setContentAreaFilled(false);
        jPanel1.add(EliminadoV24);
        EliminadoV24.setBounds(1440, 460, 60, 70);

        EliminadoV25.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV25.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV25.setContentAreaFilled(false);
        jPanel1.add(EliminadoV25);
        EliminadoV25.setBounds(1500, 460, 60, 70);

        EliminadoV26.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV26.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV26.setContentAreaFilled(false);
        jPanel1.add(EliminadoV26);
        EliminadoV26.setBounds(1380, 600, 60, 70);

        EliminadoV27.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV27.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV27.setContentAreaFilled(false);
        jPanel1.add(EliminadoV27);
        EliminadoV27.setBounds(1440, 600, 60, 70);

        EliminadoV28.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV28.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV28.setContentAreaFilled(false);
        jPanel1.add(EliminadoV28);
        EliminadoV28.setBounds(1500, 600, 60, 70);

        EliminadoV29.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV29.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV29.setContentAreaFilled(false);
        jPanel1.add(EliminadoV29);
        EliminadoV29.setBounds(1260, 600, 60, 70);

        EliminadoV30.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV30.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV30.setContentAreaFilled(false);
        EliminadoV30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV30ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV30);
        EliminadoV30.setBounds(1320, 600, 60, 70);

        EliminadoV31.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV31.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV31.setContentAreaFilled(false);
        jPanel1.add(EliminadoV31);
        EliminadoV31.setBounds(1260, 530, 60, 70);

        EliminadoV32.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV32.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV32.setContentAreaFilled(false);
        EliminadoV32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV32ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV32);
        EliminadoV32.setBounds(1320, 530, 60, 70);

        EliminadoV33.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV33.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV33.setContentAreaFilled(false);
        jPanel1.add(EliminadoV33);
        EliminadoV33.setBounds(1380, 530, 60, 70);

        EliminadoV34.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV34.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV34.setContentAreaFilled(false);
        jPanel1.add(EliminadoV34);
        EliminadoV34.setBounds(1440, 530, 60, 70);

        EliminadoV35.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV35.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV35.setContentAreaFilled(false);
        jPanel1.add(EliminadoV35);
        EliminadoV35.setBounds(1500, 530, 60, 70);

        EliminadoV36.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV36.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV36.setContentAreaFilled(false);
        jPanel1.add(EliminadoV36);
        EliminadoV36.setBounds(1260, 670, 60, 70);

        EliminadoV37.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV37.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV37.setContentAreaFilled(false);
        EliminadoV37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminadoV37ActionPerformed(evt);
            }
        });
        jPanel1.add(EliminadoV37);
        EliminadoV37.setBounds(1320, 670, 60, 70);

        EliminadoV38.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV38.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV38.setContentAreaFilled(false);
        jPanel1.add(EliminadoV38);
        EliminadoV38.setBounds(1380, 670, 60, 70);

        EliminadoV39.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV39.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV39.setContentAreaFilled(false);
        jPanel1.add(EliminadoV39);
        EliminadoV39.setBounds(1440, 670, 60, 70);

        EliminadoV40.setBackground(new java.awt.Color(51, 51, 51));
        EliminadoV40.setForeground(new java.awt.Color(255, 255, 255));
        EliminadoV40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        EliminadoV40.setContentAreaFilled(false);
        jPanel1.add(EliminadoV40);
        EliminadoV40.setBounds(1500, 670, 60, 70);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton1.setText("RENDIRSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(540, 10, 190, 40);

        UsrTurno.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jPanel1.add(UsrTurno);
        UsrTurno.setBounds(910, 20, 120, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setText("Turno:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(840, 20, 70, 30);

        UsrVillano.setBackground(new java.awt.Color(51, 0, 51));
        UsrVillano.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        UsrVillano.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(UsrVillano);
        UsrVillano.setBounds(660, 730, 160, 30);

        UsrHeroe.setBackground(new java.awt.Color(0, 51, 0));
        UsrHeroe.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        UsrHeroe.setForeground(new java.awt.Color(0, 51, 0));
        jPanel1.add(UsrHeroe);
        UsrHeroe.setBounds(630, 60, 160, 30);

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("VILLANO:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 730, 120, 30);

        jLabel7.setBackground(new java.awt.Color(0, 51, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 0));
        jLabel7.setText("HEROE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(550, 60, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Turno:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(840, 20, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/eliminadosHeroe1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, -120, 530, 1010);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/eliminadosvilla1.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1250, -120, 510, 1010);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/tab.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1590, 770);

        CAS101.setBackground(new java.awt.Color(51, 51, 51));
        CAS101.setForeground(new java.awt.Color(255, 255, 255));
        CAS101.setBorder(null);
        CAS101.setContentAreaFilled(false);
        jPanel1.add(CAS101);
        CAS101.setBounds(1490, 220, 70, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2copia/eliminadosvilla1.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1250, -120, 510, 1010);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1590, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminadoV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV2ActionPerformed

    private void EliminadoV7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV7ActionPerformed

    private void EliminadoV15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV15ActionPerformed

    private void EliminadoV17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV17ActionPerformed

    private void EliminadoV22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV22ActionPerformed

    private void EliminadoV30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV30ActionPerformed

    private void EliminadoV32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV32ActionPerformed

    private void EliminadoV37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminadoV37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminadoV37ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Rendirse();
        if (jPanel4 != null) {
            jPanel4.setVisible(false);
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int col = 0; col < matriz[fila].length; col++) {
                    if (matriz[fila][col] != null) {
                        matriz[fila][col].setEnabled(false);
                    }
                }
            }
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel6.setVisible(false);
        confirmarRendirse();
        if (jPanel4 != null) {
            jPanel4.setVisible(false);
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int col = 0; col < matriz[fila].length; col++) {
                    if (matriz[fila][col] != null) {
                        matriz[fila][col].setEnabled(false);
                    }
                }
            }
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel6.setVisible(false);
        if (jPanel4 != null) {
            jPanel4.setVisible(false);
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int col = 0; col < matriz[fila].length; col++) {
                    if (matriz[fila][col] != null) {
                        matriz[fila][col].setEnabled(true);
                    }
                }
            }
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        First_Page firstPage = new First_Page();
        firstPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        First_Page firstPage = new First_Page();
        firstPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BandoPerdedor;
    private javax.swing.JLabel Bandoganador;
    private javax.swing.JLabel Bandoganador1;
    private javax.swing.JButton CAS1;
    private javax.swing.JButton CAS10;
    private javax.swing.JButton CAS100;
    private javax.swing.JButton CAS101;
    private javax.swing.JButton CAS11;
    private javax.swing.JButton CAS12;
    private javax.swing.JButton CAS13;
    private javax.swing.JButton CAS14;
    private javax.swing.JButton CAS15;
    private javax.swing.JButton CAS16;
    private javax.swing.JButton CAS17;
    private javax.swing.JButton CAS18;
    private javax.swing.JButton CAS19;
    private javax.swing.JButton CAS2;
    private javax.swing.JButton CAS20;
    private javax.swing.JButton CAS21;
    private javax.swing.JButton CAS22;
    private javax.swing.JButton CAS23;
    private javax.swing.JButton CAS24;
    private javax.swing.JButton CAS25;
    private javax.swing.JButton CAS26;
    private javax.swing.JButton CAS27;
    private javax.swing.JButton CAS28;
    private javax.swing.JButton CAS29;
    private javax.swing.JButton CAS3;
    private javax.swing.JButton CAS30;
    private javax.swing.JButton CAS31;
    private javax.swing.JButton CAS32;
    private javax.swing.JButton CAS33;
    private javax.swing.JButton CAS34;
    private javax.swing.JButton CAS35;
    private javax.swing.JButton CAS36;
    private javax.swing.JButton CAS37;
    private javax.swing.JButton CAS38;
    private javax.swing.JButton CAS39;
    private javax.swing.JButton CAS4;
    private javax.swing.JButton CAS40;
    private javax.swing.JButton CAS41;
    private javax.swing.JButton CAS42;
    private javax.swing.JButton CAS43Null1;
    private javax.swing.JButton CAS44Null1;
    private javax.swing.JButton CAS45;
    private javax.swing.JButton CAS46;
    private javax.swing.JButton CAS47Null1;
    private javax.swing.JButton CAS48Null1;
    private javax.swing.JButton CAS49;
    private javax.swing.JButton CAS5;
    private javax.swing.JButton CAS50;
    private javax.swing.JButton CAS51;
    private javax.swing.JButton CAS52;
    private javax.swing.JButton CAS53Null1;
    private javax.swing.JButton CAS54Null1;
    private javax.swing.JButton CAS55;
    private javax.swing.JButton CAS56;
    private javax.swing.JButton CAS57Null1;
    private javax.swing.JButton CAS58Null1;
    private javax.swing.JButton CAS59;
    private javax.swing.JButton CAS6;
    private javax.swing.JButton CAS60;
    private javax.swing.JButton CAS61;
    private javax.swing.JButton CAS62;
    private javax.swing.JButton CAS63;
    private javax.swing.JButton CAS64;
    private javax.swing.JButton CAS65;
    private javax.swing.JButton CAS66;
    private javax.swing.JButton CAS67;
    private javax.swing.JButton CAS68;
    private javax.swing.JButton CAS69;
    private javax.swing.JButton CAS7;
    private javax.swing.JButton CAS70;
    private javax.swing.JButton CAS71;
    private javax.swing.JButton CAS72;
    private javax.swing.JButton CAS73;
    private javax.swing.JButton CAS74;
    private javax.swing.JButton CAS75;
    private javax.swing.JButton CAS76;
    private javax.swing.JButton CAS77;
    private javax.swing.JButton CAS78;
    private javax.swing.JButton CAS79;
    private javax.swing.JButton CAS8;
    private javax.swing.JButton CAS80;
    private javax.swing.JButton CAS81;
    private javax.swing.JButton CAS82;
    private javax.swing.JButton CAS83;
    private javax.swing.JButton CAS84;
    private javax.swing.JButton CAS85;
    private javax.swing.JButton CAS86;
    private javax.swing.JButton CAS87;
    private javax.swing.JButton CAS88;
    private javax.swing.JButton CAS89;
    private javax.swing.JButton CAS9;
    private javax.swing.JButton CAS90;
    private javax.swing.JButton CAS91;
    private javax.swing.JButton CAS92;
    private javax.swing.JButton CAS93;
    private javax.swing.JButton CAS94;
    private javax.swing.JButton CAS95;
    private javax.swing.JButton CAS96;
    private javax.swing.JButton CAS97;
    private javax.swing.JButton CAS98;
    private javax.swing.JButton CAS99;
    private javax.swing.JButton EliminadoH1;
    private javax.swing.JButton EliminadoH10;
    private javax.swing.JButton EliminadoH11;
    private javax.swing.JButton EliminadoH12;
    private javax.swing.JButton EliminadoH13;
    private javax.swing.JButton EliminadoH14;
    private javax.swing.JButton EliminadoH15;
    private javax.swing.JButton EliminadoH16;
    private javax.swing.JButton EliminadoH17;
    private javax.swing.JButton EliminadoH18;
    private javax.swing.JButton EliminadoH19;
    private javax.swing.JButton EliminadoH2;
    private javax.swing.JButton EliminadoH20;
    private javax.swing.JButton EliminadoH21;
    private javax.swing.JButton EliminadoH22;
    private javax.swing.JButton EliminadoH23;
    private javax.swing.JButton EliminadoH24;
    private javax.swing.JButton EliminadoH25;
    private javax.swing.JButton EliminadoH26;
    private javax.swing.JButton EliminadoH27;
    private javax.swing.JButton EliminadoH28;
    private javax.swing.JButton EliminadoH29;
    private javax.swing.JButton EliminadoH3;
    private javax.swing.JButton EliminadoH30;
    private javax.swing.JButton EliminadoH31;
    private javax.swing.JButton EliminadoH32;
    private javax.swing.JButton EliminadoH33;
    private javax.swing.JButton EliminadoH34;
    private javax.swing.JButton EliminadoH35;
    private javax.swing.JButton EliminadoH36;
    private javax.swing.JButton EliminadoH37;
    private javax.swing.JButton EliminadoH38;
    private javax.swing.JButton EliminadoH39;
    private javax.swing.JButton EliminadoH4;
    private javax.swing.JButton EliminadoH40;
    private javax.swing.JButton EliminadoH5;
    private javax.swing.JButton EliminadoH6;
    private javax.swing.JButton EliminadoH7;
    private javax.swing.JButton EliminadoH8;
    private javax.swing.JButton EliminadoH9;
    private javax.swing.JButton EliminadoV1;
    private javax.swing.JButton EliminadoV10;
    private javax.swing.JButton EliminadoV11;
    private javax.swing.JButton EliminadoV12;
    private javax.swing.JButton EliminadoV13;
    private javax.swing.JButton EliminadoV14;
    private javax.swing.JButton EliminadoV15;
    private javax.swing.JButton EliminadoV16;
    private javax.swing.JButton EliminadoV17;
    private javax.swing.JButton EliminadoV18;
    private javax.swing.JButton EliminadoV19;
    private javax.swing.JButton EliminadoV2;
    private javax.swing.JButton EliminadoV20;
    private javax.swing.JButton EliminadoV21;
    private javax.swing.JButton EliminadoV22;
    private javax.swing.JButton EliminadoV23;
    private javax.swing.JButton EliminadoV24;
    private javax.swing.JButton EliminadoV25;
    private javax.swing.JButton EliminadoV26;
    private javax.swing.JButton EliminadoV27;
    private javax.swing.JButton EliminadoV28;
    private javax.swing.JButton EliminadoV29;
    private javax.swing.JButton EliminadoV3;
    private javax.swing.JButton EliminadoV30;
    private javax.swing.JButton EliminadoV31;
    private javax.swing.JButton EliminadoV32;
    private javax.swing.JButton EliminadoV33;
    private javax.swing.JButton EliminadoV34;
    private javax.swing.JButton EliminadoV35;
    private javax.swing.JButton EliminadoV36;
    private javax.swing.JButton EliminadoV37;
    private javax.swing.JButton EliminadoV38;
    private javax.swing.JButton EliminadoV39;
    private javax.swing.JButton EliminadoV4;
    private javax.swing.JButton EliminadoV40;
    private javax.swing.JButton EliminadoV5;
    private javax.swing.JButton EliminadoV6;
    private javax.swing.JButton EliminadoV7;
    private javax.swing.JButton EliminadoV8;
    private javax.swing.JButton EliminadoV9;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Fecha1;
    private javax.swing.JLabel H1;
    private javax.swing.JLabel H10;
    private javax.swing.JLabel H11;
    private javax.swing.JLabel H12;
    private javax.swing.JLabel H13;
    private javax.swing.JLabel H14;
    private javax.swing.JLabel H15;
    private javax.swing.JLabel H16;
    private javax.swing.JLabel H17;
    private javax.swing.JLabel H18;
    private javax.swing.JLabel H19;
    private javax.swing.JLabel H2;
    private javax.swing.JLabel H20;
    private javax.swing.JLabel H21;
    private javax.swing.JLabel H22;
    private javax.swing.JLabel H23;
    private javax.swing.JLabel H24;
    private javax.swing.JLabel H25;
    private javax.swing.JLabel H26;
    private javax.swing.JLabel H27;
    private javax.swing.JLabel H28;
    private javax.swing.JLabel H29;
    private javax.swing.JLabel H3;
    private javax.swing.JLabel H30;
    private javax.swing.JLabel H31;
    private javax.swing.JLabel H32;
    private javax.swing.JLabel H33;
    private javax.swing.JLabel H34;
    private javax.swing.JLabel H35;
    private javax.swing.JLabel H36;
    private javax.swing.JLabel H37;
    private javax.swing.JLabel H38;
    private javax.swing.JLabel H39;
    private javax.swing.JLabel H4;
    private javax.swing.JLabel H40;
    private javax.swing.JLabel H5;
    private javax.swing.JLabel H6;
    private javax.swing.JLabel H7;
    private javax.swing.JLabel H8;
    private javax.swing.JLabel H9;
    private javax.swing.JLabel JLabel14;
    private javax.swing.JLabel JLabel15;
    private javax.swing.JLabel JLabel16;
    private javax.swing.JLabel JLabel17;
    private javax.swing.JLabel JLabel18;
    private javax.swing.JLabel JLabel19;
    private javax.swing.JLabel JLabel20;
    private javax.swing.JLabel JLabel21;
    private javax.swing.JLabel JLabel22;
    private javax.swing.JLabel JLabel23;
    private javax.swing.JLabel JLabel24;
    private javax.swing.JLabel JLabel25;
    private javax.swing.JLabel TipodeSlv;
    private javax.swing.JLabel UsrGanador;
    private javax.swing.JLabel UsrGanador1;
    private javax.swing.JLabel UsrHeroe;
    private javax.swing.JLabel UsrPerdedor;
    private javax.swing.JLabel UsrPerdedor1;
    private javax.swing.JLabel UsrPerdedor2;
    private javax.swing.JLabel UsrTurno;
    private javax.swing.JLabel UsrVillano;
    private javax.swing.JLabel Usreleccion;
    private javax.swing.JLabel V1;
    private javax.swing.JLabel V10;
    private javax.swing.JLabel V11;
    private javax.swing.JLabel V12;
    private javax.swing.JLabel V13;
    private javax.swing.JLabel V14;
    private javax.swing.JLabel V15;
    private javax.swing.JLabel V16;
    private javax.swing.JLabel V17;
    private javax.swing.JLabel V18;
    private javax.swing.JLabel V19;
    private javax.swing.JLabel V2;
    private javax.swing.JLabel V20;
    private javax.swing.JLabel V21;
    private javax.swing.JLabel V22;
    private javax.swing.JLabel V23;
    private javax.swing.JLabel V24;
    private javax.swing.JLabel V25;
    private javax.swing.JLabel V26;
    private javax.swing.JLabel V27;
    private javax.swing.JLabel V28;
    private javax.swing.JLabel V29;
    private javax.swing.JLabel V3;
    private javax.swing.JLabel V30;
    private javax.swing.JLabel V31;
    private javax.swing.JLabel V32;
    private javax.swing.JLabel V33;
    private javax.swing.JLabel V34;
    private javax.swing.JLabel V35;
    private javax.swing.JLabel V36;
    private javax.swing.JLabel V37;
    private javax.swing.JLabel V38;
    private javax.swing.JLabel V39;
    private javax.swing.JLabel V4;
    private javax.swing.JLabel V40;
    private javax.swing.JLabel V5;
    private javax.swing.JLabel V6;
    private javax.swing.JLabel V7;
    private javax.swing.JLabel V8;
    private javax.swing.JLabel V9;
    private javax.swing.JLabel VSHeroe;
    private javax.swing.JLabel VSVillano;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel nivelheroe;
    private javax.swing.JLabel nivelvillano;
    private javax.swing.JLabel nombreheroe;
    private javax.swing.JLabel nombrevillano;
    // End of variables declaration//GEN-END:variables
}
