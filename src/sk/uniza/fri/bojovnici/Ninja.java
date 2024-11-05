package sk.uniza.fri.bojovnici;

import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.obrazky.Obrazky;
import sk.uniza.fri.prostredie.Healthbar;
import sk.uniza.fri.prostredie.Obrazok;
import sk.uniza.fri.prostredie.Projektil;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

/**
 * Trieda Ninja.
 * je jednym z typov bojonikov.
 * @author Matúš Uhlár
 */
public class Ninja extends Bojovnik {
    private static final int POZCICIA_BOJOVNIKA_X_NALAVO = 150;
    private static final int POZCICIA_BOJOVNIKA_X_NAPRAVO = 650;
    private static final int POZICIA_BOJOVNIKA_Y = 300;


    private Obrazok obrazokBojovnika;
    private Obrazky obrazky;
    private Projektil projektil;
    private Healthbar healthbar;
    private int poskodenie;
    private int zivoty;
    private final int cena;
    private final int brnenie;
    private final int critSanca;
    private final int maximalneZivoty;
    private boolean smer;
    private Random generatorCritSance;
    private Hrac hrac;
    private int pocetKritickychUtokov;
    private int pocetVylieceni;

    /**
     * Ninja Konštruktor
     *
     *
     *
     */
    public Ninja() {



        this.pocetKritickychUtokov = 0;
        this.pocetVylieceni = 0;
        this.cena = 25;
        this.zivoty = 5;
        this.poskodenie = 8;
        this.brnenie = 0;
        this.critSanca = 2;
        this.maximalneZivoty = this.zivoty;
        this.obrazky = Obrazky.NINJA;
        this.healthbar = new Healthbar(this.zivoty);
        this.generatorCritSance = new Random();

    }

    @Override
    public void umiestniBojovnika(boolean smer) {
        this.smer = smer;
        if (smer) {
            this.obrazokBojovnika = new Obrazok(this.obrazky.getCestaObrazokBojovnikaNalavo());
            this.obrazokBojovnika.zmenPolohu(POZCICIA_BOJOVNIKA_X_NALAVO, POZICIA_BOJOVNIKA_Y);
            this.healthbar.nakresliSaNaSpravneMiesto(POZCICIA_BOJOVNIKA_X_NALAVO, POZICIA_BOJOVNIKA_Y);
            this.obrazokBojovnika.zobraz();
        } else {
            this.obrazokBojovnika = new Obrazok(this.obrazky.getCestaObrazokBojovnikaNapravo());
            this.obrazokBojovnika.zmenPolohu(POZCICIA_BOJOVNIKA_X_NAPRAVO, POZICIA_BOJOVNIKA_Y);
            this.healthbar.nakresliSaNaSpravneMiesto(POZCICIA_BOJOVNIKA_X_NAPRAVO, POZICIA_BOJOVNIKA_Y);
            this.obrazokBojovnika.zobraz();
        }
    }

    @Override
    public void utrzPoskodenie(int utrzenePoskodenie) {
        this.zivoty = this.zivoty + this.brnenie - utrzenePoskodenie;
        this.pouziSpecialnuSchopnost(this.hrac);
        this.healthbar.vykresliAktualneZivoty(this.zivoty);

        if (!this.zistiCiZijes()) {
            this.vymazBojovnika();

        }
    }

    @Override
    public boolean zistiCiZijes() {
        if (this.zivoty <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void vymazBojovnika() {
        this.obrazokBojovnika.skry();
        this.healthbar.zmazSa();
    }

    @Override
    public void zautoc(boolean smer, Hrac hrac, Bojovnik protivnik) {
        this.hrac = hrac;
        boolean posilnenyUtok = false;
        if (this.critSanca >= this.generatorCritSance.nextInt(3)) {
            posilnenyUtok = true;
        }


        if (!smer) {
            if (posilnenyUtok) {
                this.pocetKritickychUtokov++;
                this.projektil = new Projektil(POZCICIA_BOJOVNIKA_X_NALAVO, POZICIA_BOJOVNIKA_Y, this.obrazky.getCestaObrazokKritickehoProjektyluBojovnikaNalavo()); //zautoci z lava
                this.projektil.pohniSa(smer);
                protivnik.utrzPoskodenie(this.poskodenie + protivnik.getBrnenie());
            } else {
                this.projektil = new Projektil(POZCICIA_BOJOVNIKA_X_NALAVO, POZICIA_BOJOVNIKA_Y, this.obrazky.getCestaObrazokProjektyluBojovnikaNalavo()); //zautoci z lava
                this.projektil.pohniSa(smer);
                protivnik.utrzPoskodenie(this.poskodenie);
            }

        } else {
            if (posilnenyUtok) {
                this.pocetKritickychUtokov++;
                this.projektil = new Projektil(POZCICIA_BOJOVNIKA_X_NAPRAVO, POZICIA_BOJOVNIKA_Y, this.obrazky.getCestaObrazokKritickehoProjektyluBojovnikaNapravo()); //zautoci z prava
                this.projektil.pohniSa(smer);
                protivnik.utrzPoskodenie(this.poskodenie + protivnik.getBrnenie());
            } else {
                this.projektil = new Projektil(POZCICIA_BOJOVNIKA_X_NAPRAVO, POZICIA_BOJOVNIKA_Y, this.obrazky.getCestaObrazokProjektyluBojovnikaNapravo()); //zautoci z prava
                this.projektil.pohniSa(smer);
                protivnik.utrzPoskodenie(this.poskodenie);
            }
        }
    }

    @Override
    public void pouziSpecialnyObrazok(boolean smer) {
        if (smer) {
            this.obrazokBojovnika.zmenObrazok(this.obrazky.getCestaSpecialnyObrazokBojovnikaNalavo());
            this.obrazokBojovnika.zmenPolohu(POZCICIA_BOJOVNIKA_X_NALAVO, POZICIA_BOJOVNIKA_Y);
            this.obrazokBojovnika.zobraz();
        } else {
            this.obrazokBojovnika.zmenObrazok(this.obrazky.getCestaSpecialnyObrazokBojovnikaNapravo());
            this.obrazokBojovnika.zmenPolohu(POZCICIA_BOJOVNIKA_X_NAPRAVO, POZICIA_BOJOVNIKA_Y);
            this.obrazokBojovnika.zobraz();
        }
    }

    @Override
    public void pouziSpecialnuSchopnost(Hrac hrac) {
        if (this.zivoty == 1) {
            this.pouziSpecialnyObrazok(this.smer);
            this.pocetVylieceni++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            this.obrazokBojovnika.skry();
            this.setZivotyNaPlne();
            this.healthbar.vykresliAktualneZivoty(this.zivoty);
            this.umiestniBojovnika(this.smer);

        }
    }


    @Override
    public int getPoskodenieBojovnika() {
        return this.poskodenie;
    }

    @Override
    public int getZivoty() {
        return this.zivoty;
    }

    @Override
    public int getBrnenie() {
        return this.brnenie;
    }

    @Override
    public int getCritSanca() {
        return this.critSanca;
    }

    @Override
    public void setPoskodenie(int novePoskodenie) {
        this.poskodenie = novePoskodenie;
    }

    @Override
    public void setZivotyNaPlne() {
        this.zivoty = this.maximalneZivoty;
        this.healthbar.vykresliAktualneZivoty(this.zivoty);

    }

    @Override
    public void vypisInformacieOBojovnikovi(boolean podrobne) {

        if (podrobne) {
            System.out.println("Bojovnik typu: Ninja ");
            System.out.printf("Pocet zivotov: %d \n", this.zivoty);
            System.out.printf("Vyska poskodenia: %d \n", this.poskodenie);
            System.out.printf("Brnenie: %d \n", this.brnenie);
            System.out.printf("Sanca na kriticky utok: %d z 3 \n", this.critSanca);
            System.out.println("Schopnost: Ak mu ostane presne 1 zivot dolieci sa, aby mal plne zivoty");
            System.out.println("");
        } else {
            System.out.print("Ninja (Zivoty: " + (new DecimalFormat("###")).format(this.getPercentaZivotov()) + "%) ");
        }
    }


    @Override
    public int getCena() {
        return this.cena;
    }

    private double getPercentaZivotov() {
        double naVynasobenie = (double)this.zivoty / (double)this.maximalneZivoty;
        return naVynasobenie * 100;
    }

    @Override
    public HashMap<String, Integer> dajStatistiky() {
        HashMap<String, Integer> vysledok = new HashMap<String, Integer>();
        vysledok.put("Počet vyliečení ninjov: ", this.pocetVylieceni);
        vysledok.put("Počet kritických útokov: ", this.pocetKritickychUtokov);
        return vysledok;
    }
}
