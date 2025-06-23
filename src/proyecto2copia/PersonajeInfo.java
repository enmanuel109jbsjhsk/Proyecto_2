package proyecto2copia; // Asegúrate de que este sea el paquete correcto

public class PersonajeInfo {
    private String nombre;
    private int nivel;
    private String nombreArchivo;
    private boolean esBomba;
    private boolean esNova;
    private boolean esInamovible;
    private boolean esBandera;

    public PersonajeInfo(String nombre, int nivel, String nombreArchivo, boolean inamovible, boolean esBomba, boolean esNova, boolean esBandera) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.nombreArchivo = nombreArchivo;
        this.esInamovible = inamovible;
        this.esBomba = esBomba;
        this.esNova = esNova;
        this.esBandera = esBandera;
    }

    public PersonajeInfo(String nombre, int nivel, String nombreArchivo) {
        this(nombre, nivel, nombreArchivo, false, false, false, false);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public boolean esBomba() {
        return esBomba;
    }

    public boolean esNova() {
        return esNova;
    }

    public boolean esInamovible() {
        return esInamovible;
    }

    public boolean esBandera() {
        return esBandera;
    }

    public static PersonajeInfo[] getHeroes() {
        return new PersonajeInfo[]{
            new PersonajeInfo("Storn", 2, "HEROE2-Storn.png"),
            new PersonajeInfo("MrFantastic", 10, "HEROE10-MrFantastic.png"),
            new PersonajeInfo("CapitaAme", 9, "HEROE9-CapitaAme.png"),
            new PersonajeInfo("ProfessorX", 8, "HEROE8-ProfessorX.png"),
            new PersonajeInfo("NickFury", 8, "HEROE8-NcickFury.png"),
            new PersonajeInfo("Wolcwe", 7, "HEROE7-Wolcwe.png"),
            new PersonajeInfo("Namor", 7, "HEROE7-namor.png"),
            new PersonajeInfo("Spider-Man", 7, "HEROE7-Spider-Man.png"),
            new PersonajeInfo("Silver", 6, "HEROE6-Silver.png"),
            new PersonajeInfo("Hulk", 6, "HEROE6-huilk.png"),
            new PersonajeInfo("Iron", 6, "HEROE6-IRon.png"),
            new PersonajeInfo("Daredevil", 6, "HEROE6-Daredevil.png"),
            new PersonajeInfo("DieFackel", 5, "HEROE5-dieFackel.png"),
            new PersonajeInfo("Ciclops", 5, "HEROE5-ciclops.png"),
            new PersonajeInfo("Thor", 5, "HEROE5-Thor.png"),
            new PersonajeInfo("DieUnsish", 5, "HEROE5-DieUnsish.png"),
            new PersonajeInfo("SheHulk", 4, "HEROE4-sheHult.png"),
            new PersonajeInfo("Punisher", 4, "HEROE4-Punisher.png"),
            new PersonajeInfo("Ghost", 4, "HEROE4-Ghost.png"),
            new PersonajeInfo("Das", 4, "HEROE4-Das.png"),
            new PersonajeInfo("Blade", 4, "HEROE4-Blade.png"),
            new PersonajeInfo("Glantman", 3, "HEROE3-Glantman.png"),
            new PersonajeInfo("Emma", 3, "HEROE3-Emma.png"),
            new PersonajeInfo("Colossus", 3, "HEROE3-Colossus.png"),
            new PersonajeInfo("Elektra", 2, "HEROE2-elektra.png"),
            new PersonajeInfo("Beast", 3, "HEROE3-Beast.png"),
            new PersonajeInfo("Iceman", 2, "HEROE32-Iceman.png"),
            new PersonajeInfo("Spider-girl", 2, "HEROE2-Spider-girl.png"),
            new PersonajeInfo("Phoenex", 2, "HEROE2-Phoenex.png"),
            new PersonajeInfo("Nightcrawler", 2, "HEROE2-Nightcrawler.png"),
            new PersonajeInfo("Gambit", 2, "HEROE2-Gambit.png"),
            new PersonajeInfo("DRStrange", 2, "HEROE2-DRStrange.png"),
            new PersonajeInfo("BlackWidow", 1, "HEROE1-1-BlackWidow.png"),
            new PersonajeInfo("Bandera Heroe", 0, "DieErde.png", false, false, true, true),
            new PersonajeInfo("Nova H1", 0, "Nova.png", false, true, true, false),
            new PersonajeInfo("Nova H2", 0, "Nova.png", false, true, true, false),
            new PersonajeInfo("Nova H3", 0, "Nova.png", false, true, true, false),
            new PersonajeInfo("Nova H4", 0, "Nova.png", false, true, true, false),
            new PersonajeInfo("Nova H5", 0, "Nova.png", false, true, true, false),
            new PersonajeInfo("Nova H6", 0, "Nova.png", false, true, true, false)
        };
    }

    public static PersonajeInfo[] getVillanos() {
        return new PersonajeInfo[]{
            new PersonajeInfo("BlackWidowVillano", 1, "villan1-BlackWidow.png"),
            new PersonajeInfo("Electre", 2, "villan2-Electre.png"),
            new PersonajeInfo("Leader", 2, "villan2-Leader.png"),
            new PersonajeInfo("MrSinister", 2, "villan2-MrSinister.png"),
            new PersonajeInfo("Sandman", 2, "villan2-Sandman.png"),
            new PersonajeInfo("Sentinel1", 2, "villan2-Sentinel1.png"),
            new PersonajeInfo("Sentinel2", 2, "villan2-Sentinel2.png"),
            new PersonajeInfo("Ultron", 2, "villan2-Ultron.png"),
            new PersonajeInfo("Viper", 2, "villan2-Viper.png"),
            new PersonajeInfo("Carnage", 3, "villan3-Carnage.png"),
            new PersonajeInfo("Juggernaut", 3, "villan3-Juggernaut.png"),
            new PersonajeInfo("Lizard", 3, "villan3-Lizard.png"),
            new PersonajeInfo("Moleman", 3, "villan3-Moleman.png"),
            new PersonajeInfo("Rhino", 3, "villan3-Rhino.png"),
            new PersonajeInfo("Abinatiom", 4, "villan4-abinatiom.png"),
            new PersonajeInfo("BlackCat", 4, "villan4-BlackCat.png"),
            new PersonajeInfo("Savbretooth", 4, "villan4-Savbretooth.png"),
            new PersonajeInfo("Thanos", 4, "villan4-Thanos.png"),
            new PersonajeInfo("Deadpool", 5, "villan5-deadpool.png"),
            new PersonajeInfo("DrOctopus", 5, "villan5-DrOctopus.png"),
            new PersonajeInfo("Mysterio", 5, "villan5-Mysterio.png"),
            new PersonajeInfo("Mystique", 5, "villan5-Mystique.png"),
            new PersonajeInfo("Bullseye", 6, "villan6-Bullseye.png"),
            new PersonajeInfo("Omega", 6, "villan6-Omega.png"),
            new PersonajeInfo("Onslau", 6, "villan6-Onslau.png"),
            new PersonajeInfo("RedSkull", 6, "villan6-RedSkull.png"),
            new PersonajeInfo("Apocalypse", 7, "villan7-Apocalypsejpg.png"),
            new PersonajeInfo("DrGrune", 7, "villan7-DrGrune.png"),
            new PersonajeInfo("Venom", 7, "villan7-Venom.png"),
            new PersonajeInfo("Magneto", 8, "villan8-Magneto.png"),
            new PersonajeInfo("Kinping", 8, "villano8_Kinping.png"),
            new PersonajeInfo("Galactus", 9, "villano9-Galactus.png"),
            new PersonajeInfo("DrDoom", 10, "villano10-DrDoom.png"),
            new PersonajeInfo("Bandera Villano", 0, "Dieerde.png", false, false, true, true),
            new PersonajeInfo("Bomba V1", 0, "Bombe.png", true, true, true, false),
            new PersonajeInfo("Bomba V2", 0, "Bombe.png", true, true, true, false),
            new PersonajeInfo("Bomba V3", 0, "Bombe.png", true, true, true, false),
            new PersonajeInfo("Bomba V4", 0, "Bombe.png", true, true, true, false),
            new PersonajeInfo("Bomba V5", 0, "Bombe.png", true, true, true, false),
            new PersonajeInfo("Bomba V6", 0, "Bombe.png", true, true, true, false)
        };
    }
}