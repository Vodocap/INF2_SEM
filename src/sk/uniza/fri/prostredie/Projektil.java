package sk.uniza.fri.prostredie;

/**
 * Trieda Projektil.
 *
 * vytvorí projektyl na lubovolnej pozícií, projektyl sa dokáže pohnúť do lava aj do prava a po dosiahnutí určitej pozície zmizne.
 * 
 * @author Matúš Uhlár
 * 
 * 
 * 
 */
public class Projektil {
    private static final int NARAZENIE_NA_POZICI_X_NALAVO = 150;
    private static final int NARAZENIE_NA_POZICI_X_NAPRAVO = 650;
    private static final int VELKOST_KROKU = 4;
    private Obrazok obrazokProjektilu;
    private int poziciaX;
    private int poziciaY;


    
    /**
     * Projektil Konštruktor
     *
     * konštruktor inicializuje pozíciu a obrázok projektylu 
     *
     * @param  poziciaX pozicia x projektilu
     * @param  poziciaY pozicia y projektilu
     * @param  cestaKObrazkuProjektylu cesta k obrazku projektilu
     */
    public Projektil(int poziciaX, int poziciaY, String cestaKObrazkuProjektylu) {
        this.obrazokProjektilu = new Obrazok(cestaKObrazkuProjektylu);
        this.obrazokProjektilu.zmenPolohu(poziciaX, poziciaY);
        this.obrazokProjektilu.zobraz();
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        
    }
    
    /**
     * Metóda pohniSa
     * 
     * projektyl sa začne hýbať do strany udanej booleanom smerPohybu true - pôjde do lava, false - pôjde do prava.
     *
     * @param smerPohybu boolean ktory urcuje ktorym smerom sa projektil pohne
     */
    public void pohniSa(boolean smerPohybu) {
        
        if (smerPohybu) {
            while (!this.narazilSi(smerPohybu)) {
                int vzdialenostKroku = -VELKOST_KROKU;
                this.obrazokProjektilu.zmenPolohu(this.poziciaX + vzdialenostKroku, this.poziciaY);
                this.poziciaX += vzdialenostKroku;
            
            }
        } else {
            while (!this.narazilSi(smerPohybu)) {
                int vzdialenostKroku = VELKOST_KROKU;        
                this.obrazokProjektilu.zmenPolohu(this.poziciaX + vzdialenostKroku, this.poziciaY);
                this.poziciaX += vzdialenostKroku;
            
            }
            
        }
    }

    private boolean narazilSi(boolean strana) {
        if (!strana) {
            if (this.poziciaX >= NARAZENIE_NA_POZICI_X_NAPRAVO) {
                this.obrazokProjektilu.skry();
                return true;

            }
        } else {
            if (this.poziciaX <= NARAZENIE_NA_POZICI_X_NALAVO) {
                this.obrazokProjektilu.skry();
                return true;

            }
        }
        return false;
    }

}
