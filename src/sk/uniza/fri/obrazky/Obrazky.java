package sk.uniza.fri.obrazky;



/**
 * Trieda Obrazky.
 * enumeracia kde su ulozene obrazky bojovnikov a projektilov
 *
 *
 * @author Matúš Uhlár
 *
 *
 */
public enum Obrazky {
    /**
     * Rytier obrazky.
     */
    RYTIER("pics/rytier_nalavo.png",
            "pics/rytier_napravo.png",
            "pics/nahnevany_rytier_nalavo.png",
            "pics/nahnevany_rytier_napravo.png",
            "pics/meč_nalavo.png",
            "pics/meč_napravo.png",
            "pics/kriticky_meč_nalavo.png",
            "pics/kriticky_meč_napravo.png"),

    /**
     * Ninja obrazky.
     */
    NINJA("pics/ninja_nalavo.png",
            "pics/ninja_napravo.png",
            "pics/healujuci_ninja_nalavo.png",
            "pics/healujuci_ninja_napravo.png",
            "pics/šuriken_nalavo.png",
            "pics/šuriken_napravo.png",
            "pics/kriticky_šuriken_nalavo.png",
            "pics/kriticky_šuriken_napravo.png"),

    /**
     * Lukostrelec obrazky.
     */
    LUKOSTRELEC("pics/lukostrelec_nalavo.png",
            "pics/lukostrelec_napravo.png",
            "pics/lukostrelec_nalavo.png",
            "pics/lukostrelec_napravo.png",
            "pics/šíp_nalavo.png",
            "pics/šíp_napravo.png",
            "pics/kriticky_šíp_nalavo.png",
            "pics/kriticky_šíp_napravo.png"),

    /**
     * Necromancer obrazky.
     */
    NECROMANCER("pics/necromancer_nalavo.png",
            "pics/necromancer_napravo.png",
            "pics/necromancer_ozivuje_nalavo.png",
            "pics/necromancer_ozivuje_napravo.png",
            "pics/necro_orb_nalavo.png",
            "pics/necro_orb_napravo.png",
            "pics/kriticky_necro_orb_nalavo.png",
            "pics/kriticky_necro_orb_napravo.png"),

    /**
     * Kuzelnik obrazky.
     */
    KUZELNIK("pics/kuzelnik_nalavo.png",
            "pics/kuzelnik_napravo.png",
            "pics/kuzelnik_nalavo.png",
            "pics/kuzelnik_napravo.png",
            "pics/wizard_orb_nalavo.png",
            "pics/wizard_orb_napravo.png",
            "pics/wizard_orb_nalavo.png",
            "pics/wizard_orb_napravo.png"),

    /**
     * Pirat obrazky.
     */
    PIRAT("pics/pirat_nalavo.png",
            "pics/pirat_napravo.png",
            "pics/pirat_peniaze_nalavo.png",
            "pics/pirat_peniaze_napravo.png",
            "pics/gulka_nalavo.png",
            "pics/gulka_napravo.png",
            "pics/kriticka_gulka_nalavo.png",
            "pics/kriticka_gulka_napravo.png"),

    /**
     * Boss obrazky.
     */
    BOSS("pics/boss_nalavo.png",
            "pics/boss_napravo.png",
            "pics/boss_nalavo.png",
            "pics/boss_napravo.png",
            "pics/naboje_nalavo.png",
            "pics/naboje_napravo.png",
            "pics/kriticke_naboje_nalavo.png",
            "pics/kriticke_naboje_napravo.png"),
    ;

    private final String cestaObrazokBojovnikaNalavo;
    private final String cestaObrazokBojovnikaNapravo;
    private final String cestaSpecialnyObrazokBojovnikaNalavo;
    private final String cestaSpecialnyObrazokBojovnikaNapravo;
    private final String cestaObrazokProjektyluBojovnikaNalavo;
    private final String cestaObrazokProjektyluBojovnikaNapravo;
    private final String cestaObrazokKritickehoProjektyluBojovnikaNalavo;
    private final String cestaObrazokKritickehoProjektyluBojovnikaNapravo;

    Obrazky(
            String cestaObrazokBojovnikaNalavo, String cestaObrazokBojovnikaNapravo,
            String cestaSpecialnyObrazokBojovnikaNalavo, String cestaSpecialnyObrazokBojovnikaNapravo,
            String cestaObrazokProjektyluBojovnikaNalavo, String cestaObrazokProjektyluBojovnikaNapravo,
            String cestaObrazokKritickehoProjektyluBojovnikaNalavo, String cestaObrazokKritickehoProjektyluBojovnikaNapravo) {

        this.cestaObrazokBojovnikaNalavo = cestaObrazokBojovnikaNalavo;
        this.cestaObrazokBojovnikaNapravo = cestaObrazokBojovnikaNapravo;
        this.cestaSpecialnyObrazokBojovnikaNalavo = cestaSpecialnyObrazokBojovnikaNalavo;
        this.cestaSpecialnyObrazokBojovnikaNapravo = cestaSpecialnyObrazokBojovnikaNapravo;
        this.cestaObrazokProjektyluBojovnikaNalavo = cestaObrazokProjektyluBojovnikaNalavo;
        this.cestaObrazokProjektyluBojovnikaNapravo = cestaObrazokProjektyluBojovnikaNapravo;
        this.cestaObrazokKritickehoProjektyluBojovnikaNalavo = cestaObrazokKritickehoProjektyluBojovnikaNalavo;
        this.cestaObrazokKritickehoProjektyluBojovnikaNapravo = cestaObrazokKritickehoProjektyluBojovnikaNapravo;
    }

    /**
     * Vrati cesta obrazok bojovnika nalavo.
     *
     * @return cesta obrazok bojovnika nalavo
     */
    public String getCestaObrazokBojovnikaNalavo() {
        return this.cestaObrazokBojovnikaNalavo;
    }

    /**
     * Vrati cesta obrazok bojovnika napravo.
     *
     * @return cesta obrazok bojovnika napravo
     */
    public String getCestaObrazokBojovnikaNapravo() {
        return this.cestaObrazokBojovnikaNapravo;
    }

    /**
     * Vrati cesta specialny obrazok bojovnika nalavo.
     *
     * @return cesta specialny obrazok bojovnika nalavo
     */
    public String getCestaSpecialnyObrazokBojovnikaNalavo() {
        return this.cestaSpecialnyObrazokBojovnikaNalavo;
    }

    /**
     * Vrati cesta specialny obrazok bojovnika napravo.
     *
     * @return cesta specialny obrazok bojovnika napravo
     */
    public String getCestaSpecialnyObrazokBojovnikaNapravo() {
        return this.cestaSpecialnyObrazokBojovnikaNapravo;
    }

    /**
     * Vrati cesta obrazok projektylu bojovnika nalavo.
     *
     * @return cesta obrazok projektylu bojovnika nalavo
     */
    public String getCestaObrazokProjektyluBojovnikaNalavo() {
        return this.cestaObrazokProjektyluBojovnikaNalavo;
    }

    /**
     * Vrati cesta obrazok projektylu bojovnika napravo.
     *
     * @return cesta obrazok projektylu bojovnika napravo
     */
    public String getCestaObrazokProjektyluBojovnikaNapravo() {
        return this.cestaObrazokProjektyluBojovnikaNapravo;
    }

    /**
     * Vrati cesta obrazok kritickeho projektylu bojovnika nalavo.
     *
     * @return cesta obrazok kritickeho projektylu bojovnika nalavo
     */
    public String getCestaObrazokKritickehoProjektyluBojovnikaNalavo() {
        return this.cestaObrazokKritickehoProjektyluBojovnikaNalavo;
    }

    /**
     * Vrati cesta obrazok kritickeho projektylu bojovnika napravo.
     *
     * @return cesta obrazok kritickeho projektylu bojovnika napravo
     */
    public String getCestaObrazokKritickehoProjektyluBojovnikaNapravo() {
        return this.cestaObrazokKritickehoProjektyluBojovnikaNapravo;
    }




}
