package sk.uniza.fri.prostredie;

/**
 * Trieda Healthbar.
 * podla zadaných parametrov vytvorí a vykreslí healthbar ktorý sa pri zmene počtu životov inštancie bojovníka zmenšuje/zväčšuje a mení farby
 * 
 * @author Matúš Uhlár
 * 
 * 
 * 
 */
public class Healthbar {
    private static final String CIERNA_FARBA = "black";
    private static final String CERVENA_FARBA = "red";
    private static final String ZELENA_FARBA = "green";
    private static final String ZLTA_FARBA = "yellow";
    private int maximalneZivoty;
    private Obdlznik obdlznikAktualnychZivotov;
    private Obdlznik obdlznikMaximalnychZivotov;
    
    
    /**
     * Healthbar Konštruktor
     * 
     * v konštruktore sa inicializujú 2 obdlžniky, jeden farebný a druhý čierny, čierny obdlžnik ukazuje maximálne životy bojovníka, obdlžniky sú velkosti počet životov * 20
     * 
     * @param zivotyBojovnika Parameter
     */
    public Healthbar(int zivotyBojovnika) {
        this.maximalneZivoty = zivotyBojovnika;
        if (this.maximalneZivoty > 8) {
            this.obdlznikMaximalnychZivotov = new Obdlznik();
            this.obdlznikMaximalnychZivotov.zmenFarbu(CIERNA_FARBA);
            this.obdlznikAktualnychZivotov = new Obdlznik();
            this.obdlznikAktualnychZivotov.zmenFarbu(ZELENA_FARBA);
            this.obdlznikAktualnychZivotov.zmenStrany(this.maximalneZivoty * 5, 30);
            this.obdlznikMaximalnychZivotov.zmenStrany(this.maximalneZivoty * 5, 30);
        } else {
            this.obdlznikMaximalnychZivotov = new Obdlznik();
            this.obdlznikMaximalnychZivotov.zmenFarbu(CIERNA_FARBA);
            this.obdlznikAktualnychZivotov = new Obdlznik();
            this.obdlznikAktualnychZivotov.zmenFarbu(ZELENA_FARBA);
            this.obdlznikAktualnychZivotov.zmenStrany(this.maximalneZivoty * 10, 30);
            this.obdlznikMaximalnychZivotov.zmenStrany(this.maximalneZivoty * 10, 30);
        }

        
    }
    
    /**
     * Metóda vykresliAktualneZivoty
     * 
     * vykreslí farebný obdlžnik s aktuálnymi životmi bojovníka, ak sú aktuálne životy väčšie ako 2/3 s maximálnych životov tak je obdlžnik zelený, ak sú aktuálne životy menšie
     * ako 2/3 maximálnych životov a väčšie ako 1/3 maximálnych životov tak je obdlžnik žltý, ak sú aktuálne životy menšie ako 1/3 maximálnych životov tak obdlžnik bude červený.
     * 
     * @param pocetZivotov Parameter
     */
    public void vykresliAktualneZivoty(int pocetZivotov) {
        if (pocetZivotov > 8 || this.maximalneZivoty > 8) {
            this.obdlznikAktualnychZivotov.zmenStrany(pocetZivotov * 5, 30);
            if (pocetZivotov >  Math.round(this.maximalneZivoty / 3) * 2) {
                this.obdlznikAktualnychZivotov.zmenFarbu(ZELENA_FARBA);
            } else if (pocetZivotov <= Math.round(this.maximalneZivoty / 3) * 2 && pocetZivotov > Math.round(this.maximalneZivoty / 3) * 1) {
                this.obdlznikAktualnychZivotov.zmenFarbu(ZLTA_FARBA);
            } else if (pocetZivotov <= Math.round(this.maximalneZivoty / 3) * 1) {
                this.obdlznikAktualnychZivotov.zmenFarbu(CERVENA_FARBA);
            }
        } else {
            this.obdlznikAktualnychZivotov.zmenStrany(pocetZivotov * 10, 30);
            if (pocetZivotov >  Math.round(this.maximalneZivoty / 3) * 2) {
                this.obdlznikAktualnychZivotov.zmenFarbu(ZELENA_FARBA);
            } else if (pocetZivotov <= Math.round(this.maximalneZivoty / 3) * 2 && pocetZivotov > Math.round(this.maximalneZivoty / 3) * 1) {
                this.obdlznikAktualnychZivotov.zmenFarbu(ZLTA_FARBA);
            } else if (pocetZivotov <= Math.round(this.maximalneZivoty / 3) * 1) {
                this.obdlznikAktualnychZivotov.zmenFarbu(CERVENA_FARBA);
            }
        }



    }
    
    /**
     * Metóda nakresliSaNaSpravneMiesto
     *
     * nakreslí oba obdlžniky na správne miesto na plátne
     *
     * @param poziciaBojovnikaX Parameter
     * @param poziciaBojovnikaY Parameter
     */
    public void nakresliSaNaSpravneMiesto(int poziciaBojovnikaX, int poziciaBojovnikaY) {
        this.obdlznikMaximalnychZivotov.zmenPolohu(poziciaBojovnikaX - 75, poziciaBojovnikaY + 150);
        this.obdlznikAktualnychZivotov.zmenPolohu(poziciaBojovnikaX - 75, poziciaBojovnikaY + 150);
        this.obdlznikMaximalnychZivotov.zobraz();
        this.obdlznikAktualnychZivotov.zobraz();
    }
    
    /**
     * Metóda zmazSa
     *
     * zmaže obidva obldžniky 
     *
     */
    public void zmazSa() {
        this.obdlznikAktualnychZivotov.skry();
        this.obdlznikMaximalnychZivotov.skry();
    
    }
}
