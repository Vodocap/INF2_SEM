package sk.uniza.fri.hra;

/**
 *
 *
 * Trieda Level.
 *
 * reprezentuje rôzne levely v hre, vracia a vypisuje team
 *
 * @author Matúš Uhlár
 */
public class Level {

    private Team bojovniciVLeveli;
    private final int odmena;
    private final ObtiaznostiLevelov obtiaznost;

    /**
     * Instantiates a new Level.
     *
     * @param obtiaznost the obtiaznost
     */
    public Level (ObtiaznostiLevelov obtiaznost) {

        this.obtiaznost = obtiaznost;
        this.bojovniciVLeveli = new Team();
        this.odmena = obtiaznost.getOdmenaZaLevel();
        this.pridajBojovnikovPodlaObtiaznosti();


    }

    /**
     * Vypis informacie o leveli.
     *
     * vypise informacie o leveli
     */
    public void vypisInformacieOLeveli() {
        System.out.println("obtiaznost tohoto levelu: " + this.obtiaznost);
        System.out.println("Bojovníci v tomto leveli: ");
        this.bojovniciVLeveli.vypisBojovnikovVTeame(false);
        System.out.println("\nOdmena: " + this.odmena);
    }



    private void pridajBojovnikovPodlaObtiaznosti() {
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetRytierov(), 0);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetNinjov(), 1);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetLukostrelcov(), 2);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetNecromancerov(), 3);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetKuzelnikov(), 4);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetPiratov(), 5);
        this.bojovniciVLeveli.vytvorSiBojovnikov(this.obtiaznost.getPocetBossov(), 6);
    }


    /**
     * Vrati bojovnikov v leveli.
     *
     * @return bojovnici v leveli
     */
    public Team getBojovniciVLeveli() {

        return this.bojovniciVLeveli;
    }


    /**
     * Vrati odmenu.
     *
     * vrati penaznu odmenu za level
     *
     * @return the odmena
     */
    public int getOdmena() {
        return this.odmena;
    }
}
