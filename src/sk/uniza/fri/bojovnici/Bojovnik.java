package sk.uniza.fri.bojovnici;

import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.prostredie.Healthbar;
import sk.uniza.fri.prostredie.Obrazok;
import sk.uniza.fri.prostredie.Projektil;

import java.util.HashMap;

/**
 * Trieda Bojovník.
 * je abstraktnou triedou po ktorej dedia vsetky typy bojovnikov metody
 *
 * @author Matúš Uhlár
 */
public abstract class Bojovnik {



    private Obrazok obrazokBojovnika;

    private Projektil projektil;
    private Healthbar healthbar;
    private int poskodenie;
    private int zivoty;
    private int brnenie;
    private int critSanca;
    private int maximalneZivoty;


    /**
     * Bojovnik Konštruktor
     *
     * pri kazdom z potomkov inicializuje rozdielne hodnoty zivotov, brnenia, poskodenia, kritickej sance
     */
    public Bojovnik() {



        
        
    }

    /**
     * Metóda umiestniBojovnika
     *
     * podla parametra smer umiestni bojovnika bud na lavu alebo pravu stranu
     *
     * @param smer boolean urcujuci stranu na ktoru sa bojovnik umiestni
     */
    public void umiestniBojovnika(boolean smer) {
    }


    /**
     * Metóda utrzPoskodenie
     *
     * bojovník si zníži životy podla toho kolko poskodenia utrží - jeho brnenie, ak je po utržení požkodenia mrtvy (metoda zistiCiZijes())
     * tak umrie a vymaže sa z plátna aj s healthbarom s pomocou metody vymazMrtvehoBojovnika()
     *
     * @param utrzenePoskodenie poskodenie ktore bojovnik utrzi
     */
    public void utrzPoskodenie(int utrzenePoskodenie) {

    }

    /**
     * Metóda zistiCiZijes
     *
     * zistí či je bojovík nažive resp či má viacej ako 0 životov ak áno vráti true, ak má 0 alebo menej životov tak vráti false.
     *
     * @return boolean true/false
     */
    public boolean zistiCiZijes() {
        return this.zivoty > 0;
    }

    /**
     * Metóda vymazBojovnika
     *
     * vymaže z plátna mrtveho bojovníka a jeho healthbar
     */
    public void vymazBojovnika() {
        this.obrazokBojovnika.skry();
        this.healthbar.zmazSa();
    }

    /**
     * Metóda utocZLava
     *
     * pre lavú stranu
     * nastaví začiatočnú pozíciu projektylu s vhodným obrázkom a zavolá mu metodu pohniSa(false)
     *
     * @param smer
     * boolean podla ktoreho sa urci smer ktory bojovnik zautoci
     * @param hrac
     * hrac ktory sa na suboj pozera
     * @param protivnik
     * protivnik na ktoreho bojovnik utoci
     */
    public void zautoc(boolean smer, Hrac hrac, Bojovnik protivnik) {


    }



    /**
     * Metóda pouziSpecialnyObrazok
     *
     * pouzije bojovnikovi priradeny specialny obrazok podla parametra smer urci stranu na ktorej tak urobi
     *
     * @param smer
     *  strana na ktorej sa specialny obrazok vykresli
     */
    public void pouziSpecialnyObrazok(boolean smer) {

    }

    /**
     * Metóda getPoskodenieBojovnika
     *
     * vráti hodnotu poškodenia bojovníka
     *
     * @return int poskodenie
     */
    public int getPoskodenieBojovnika() {
        return this.poskodenie;
    }


    /**
     * Metóda getZivoty
     *
     * vráti hodnotu životov bojovníka
     *
     * @return int zivoty
     */
    public int getZivoty() {
        return this.zivoty;
    }

    /**
     * Metóda getBrnenie
     *
     * vráti hodnotu brnenia bojovníka
     *
     * @return int brnenie
     */
    public int getBrnenie() {
        return this.brnenie;
    }

    /**
     * Metóda getCritSancuBojovnika
     *
     * vráti hodnotu critSance bojovníka
     *
     * @return int critSanca
     */
    public int getCritSanca() {
        return this.critSanca;
    }

    /**
     * Metóda setDamageBojovnika
     *
     * nastaví hodnotu poškodenia bojovníka na hodnotu v parametri
     *
     * @param novePoskodenie
     * nove poskodenie bojovnika
     *
     */
    public void setPoskodenie(int novePoskodenie) {
        this.poskodenie = novePoskodenie;
    }

    /**
     * Metóda setZivotyNaPlne
     *
     * nastaví bojovníkovi plné životy podla jeho typu
     *
     *
     */
    public void setZivotyNaPlne() {

    }


    /**
     * Metóda vypisInformacieOBojovnikovi
     *
     * vypise informacie o bojovnikovi, podla booleanu bodrobne urobi podrobny alebo skrateny vypis
     *
     *
     * @param podrobne
     * boolean rozhodujuci o skratenom/dlhom zapise
     */
    public void vypisInformacieOBojovnikovi(boolean podrobne) {

    }


    /**
     * Metóda pouziSpecialnuSchopnost
     *
     * pouzije specialnu schopnost bojovnika, kazdy typ ma rozdielnu specialnu schopnost
     *
     *
     * @param hrac hrac ktory je ucastnikom v hre
     */
    public void pouziSpecialnuSchopnost (Hrac hrac) {

    }

    /**
     * Metóda getCena
     *
     * vrati cenu Bojovnika v obchode
     *
     * @return cena
     */
    public int getCena() {
        return 0;
    }

    /**
     *
     *
     * @return vrati hashmap štatistik priradenych bojovnikovi
     *
     */
    public HashMap<String, Integer> dajStatistiky() {
        return null;
    }


}
