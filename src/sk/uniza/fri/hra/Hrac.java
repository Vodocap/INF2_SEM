package sk.uniza.fri.hra;

import sk.uniza.fri.bojovnici.Bojovnik;

/**
 * Trieda Hrac.
 *
 * reprezentuje hraca (pouzivatela).
 *
 * vracia hracov team, vracia a vie nastavit hracove peniaze,
 * nastavuje aktualny level hraca, vie si kupit bojovnikov a vracia aj meno hraca
 *
 *
 * @author Matúš Uhlár
 */
public class Hrac {

    private String menoHraca;
    private Level aktualnyLevel;
    private int peniaze;
    private Team hracovTeam;

    /**
     * Konstruktor triedy Hrac.
     *
     * @param menoHraca the meno hraca
     * @param peniaze   the peniaze
     */
    public Hrac(String menoHraca, int peniaze) {
        this.hracovTeam = new Team();
        this.peniaze = peniaze;
        this.menoHraca = menoHraca;
    }

    /**
     * Vracia hracov team.
     *
     * @return the hracov team
     */
    public Team getHracovTeam() {
        return this.hracovTeam;
    }

    /**
     * Nastavi peniaze na novu hodnotu.
     *
     * @param peniaze the peniaze
     */
    public void setPeniaze(int peniaze) {
        this.peniaze = peniaze;
    }

    /**
     * Nastavi hracovi novy aktualny level .
     *
     * @param aktualnyLevel the aktualny level
     */
    public void setAktualnyLevel(Level aktualnyLevel) {
        if (aktualnyLevel != null) {
            this.aktualnyLevel = aktualnyLevel;
            this.aktualnyLevel.vypisInformacieOLeveli();
        }


    }

    /**
     * Kup si bojovnika.
     *
     * Ak ma hrac peniaze na kupu bojovnika tak ho prida do hracovho teamu bojovnikov
     *
     * @param bojovnik the bojovnik
     */
    public void kupSiBojovnika(Bojovnik bojovnik) {

        if ((this.peniaze - bojovnik.getCena()) >= 0) {
            this.peniaze -= bojovnik.getCena();
            this.hracovTeam.pridajBojovnika(bojovnik);
        } else {
            System.out.println("\nzial tohoto bojovnika si nemozes dovolit kup si lacnejsieho alebo zacni boj \n");
        }

    }


    /**
     * Vrati peniaze.
     *
     * @return the peniaze
     */
    public int getPeniaze() {
        return this.peniaze;
    }

    /**
     * Vrati meno hraca.
     *
     * @return the meno hraca
     */
    public String getMenoHraca() {
        return this.menoHraca;
    }





}
