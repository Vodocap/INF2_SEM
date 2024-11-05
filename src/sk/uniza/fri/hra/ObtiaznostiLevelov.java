package sk.uniza.fri.hra;



/**
 * Trieda ObtiaznostiLevelov.
 *
 * enumeracia obtiaznosti levelov, uklada pocet kazdeho typu bojovnika a odmenu za level
 * @author Matúš Uhlár
 */
public enum ObtiaznostiLevelov {
    /**
     * Lahky
     */
    LAHKY (1, 1, 0, 0, 1, 0, 0, 40),
    /**
     * Stredny
     */
    STREDNY (1, 2, 2, 1, 0, 1, 0, 70),
    /**
     * Tazky
     */
    TAZKY (3, 1, 1, 3, 2, 2, 0, 100),
    /**
     * Minus
     */
    MINUS_PENIAZE(0, 0, 0, 0, 0, 10, 0, 100),
    /**
     * Boss.
     */
    BOSS (5, 0, 0, 3, 2, 0, 4, 0);

    private final int pocetRytierov;
    private final int pocetNinjov;

    private final int odmenaZaLevel;
    private final int pocetLukostrelcov;
    private final int pocetNecromancerov;
    private final int pocetKuzelnikov;
    private final int pocetPiratov;
    private final int pocetBossov;

    ObtiaznostiLevelov(int pocetRytierov, int pocetNinjov, int pocetLukostrelcov, int pocetNecromancerov, int pocetKuzelnikov, int pocetPiratov, int pocetBossov, int odmenaZaLevel) {
        this.pocetRytierov = pocetRytierov;
        this.odmenaZaLevel = odmenaZaLevel;
        this.pocetNinjov = pocetNinjov;
        this.pocetLukostrelcov = pocetLukostrelcov;
        this.pocetNecromancerov = pocetNecromancerov;
        this.pocetKuzelnikov = pocetKuzelnikov;
        this.pocetPiratov = pocetPiratov;
        this.pocetBossov = pocetBossov;
    }

    /**
     * Vrati pocet rytierov.
     *
     * @return pocet rytierov
     */
    public int getPocetRytierov() {
        return this.pocetRytierov;
    }

    /**
     * Vrati pocet ninjov.
     *
     * @return pocet ninjov
     */
    public int getPocetNinjov() {
        return this.pocetNinjov;
    }

    /**
     * Vrati pocet lukostrelcov.
     *
     * @return pocet lukostrelcov
     */
    public int getPocetLukostrelcov() {
        return this.pocetLukostrelcov;
    }

    /**
     * Vrati pocet necromancerov.
     *
     * @return pocet necromancerov
     */
    public int getPocetNecromancerov() {
        return this.pocetNecromancerov;
    }

    /**
     * Vrati pocet kuzelnikov.
     *
     * @return pocet kuzelnikov
     */
    public int getPocetKuzelnikov() {
        return this.pocetKuzelnikov;
    }

    /**
     * Vrati pocet piratov.
     *
     * @return pocet piratov
     */
    public int getPocetPiratov() {
        return this.pocetPiratov;
    }

    /**
     * Vrati pocet bossov.
     *
     * @return pocet bossov
     */
    public int getPocetBossov() {
        return this.pocetBossov;
    }

    /**
     * Vrati odmena za level.
     *
     * @return odmena za level
     */
    public int getOdmenaZaLevel() {
        return this.odmenaZaLevel;
    }


}
