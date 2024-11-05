package sk.uniza.fri.hra;

import sk.uniza.fri.vynimky.PrazdnyTeam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Trieda Simulacia.
 * trieda ktora simuluje boj dvohc timov bojovnikov
 *
 *
 * @author Matúš Uhlár
 *
 *
 */
public class Simulacia {


    private Team[] teamy;
    private Random generatorPoradia;
    private int poradie;
    private Hrac hrac;
    private int pocetZabitychHracom;
    private int pocetHracovychZonmretych;
    private int pocetUtokovVhre;
    private ArrayList<HashMap<String, Integer>> celkoveStatistiky;

    /**
     * Konstruktor triedy Simulacia.
     *
     */
    public Simulacia() {

        this.celkoveStatistiky = new ArrayList<HashMap<String, Integer>>();
        this.pocetUtokovVhre = 0;
        this.pocetHracovychZonmretych = 0;
        this.pocetZabitychHracom = 0;
        this.generatorPoradia = new Random();
        this.teamy = new Team[2];



        this.poradie = this.generatorPoradia.nextInt(2);

    }

    private boolean vratZcislaBoolean(int cislo) {
        return cislo == 0;
    }


    /**
     * Spusti boj.
     *
     *
     * simuluje boj medzi dvoma timami bojovnikov v parametri
     * v parametri ma aj hraca
     *
     * @param prvyTeam  prvy team
     * @param druhyTeam druhy team
     * @param hrac hrac
     * @return the boolean
     */
    public boolean spustiBoj(Team prvyTeam, Team druhyTeam, Hrac hrac) {

        if (prvyTeam == null || druhyTeam == null) {
            System.out.println("jeden z tímov sa rovná null");
            return false;
        }

        if (hrac == null) {
            System.out.println("Hráč neexistuje");
            return false;
        }




        this.hrac = hrac;
        this.teamy[0] = prvyTeam;
        this.teamy[1] = druhyTeam;

        if (this.teamy[0].getBojovnikNaIndexe(0) == null || this.teamy[1].getBojovnikNaIndexe(0) == null) {
            try {
                throw new PrazdnyTeam();
            } catch (PrazdnyTeam e) {
                System.out.println("Jeden z teamov je prazny");
                return false;
            }
        }

        this.teamy[0].getBojovnikNaIndexe(0).umiestniBojovnika(true);
        this.teamy[1].getBojovnikNaIndexe(0).umiestniBojovnika(false);



        while (!this.jeKoniec()) {

            int moduloPoradie = this.poradie % 2;


            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            this.teamy[moduloPoradie].getBojovnikNaIndexe(0).zautoc(this.vratZcislaBoolean((moduloPoradie + 1) % 2), this.hrac, this.teamy[(moduloPoradie + 1) % 2].getBojovnikNaIndexe(0));
            this.pocetUtokovVhre++;
            if (!this.teamy[(moduloPoradie + 1) % 2].getBojovnikNaIndexe(0).zistiCiZijes()) {

                if (moduloPoradie == 0) {
                    this.pocetZabitychHracom++;
                } else {
                    this.pocetHracovychZonmretych++;
                }

                this.teamy[(moduloPoradie + 1) % 2].odoberBojovnikaZIndexu(0).vymazBojovnika();

                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                if (!this.jeKoniec()) {
                    this.teamy[(moduloPoradie + 1) % 2].getBojovnikNaIndexe(0).setZivotyNaPlne();
                    this.teamy[(moduloPoradie + 1) % 2].getBojovnikNaIndexe(0).umiestniBojovnika(this.vratZcislaBoolean((moduloPoradie + 1) % 2));
                }

            }

            this.poradie++;


        }
        this.spravCiastocneStatistiky();
        if (!this.teamy[0].siPrazdny()) {
            this.teamy[0].getBojovnikNaIndexe(0).vymazBojovnika();
            System.out.println("*********************VYHRAL SI*********************");
            return true;

        } else if (!this.teamy[1].siPrazdny()) {
            this.teamy[1].getBojovnikNaIndexe(0).vymazBojovnika();
            System.out.println("*********************PREHRAL SI*********************");

            return false;

        }
        return false;

    }

    private void spravCiastocneStatistiky() {
        HashMap<String, Integer> vysledok = new HashMap<String, Integer>();
        vysledok.put("Počet nepriateľských bojovníkov zabitých hráčom: ", this.pocetZabitychHracom);
        vysledok.put("Počet bojovníkov ktorí hráčovi umreli: ", this.pocetHracovychZonmretych);
        vysledok.put("Počet Všetkých útokov v hre: ", this.pocetUtokovVhre);

        for (int i = 0; i < this.teamy.length; i++) {
            for (String s : this.teamy[i].dajStatistikyTeamu().keySet()) {
                if (vysledok.containsKey(s) && this.teamy[i].dajStatistikyTeamu().get(s) != null && vysledok.get(s) != null) {
                    Integer novaHodnota = this.teamy[i].dajStatistikyTeamu().get(s) + vysledok.get(s);
                    vysledok.put(s, novaHodnota);

                } else if (this.teamy[i].dajStatistikyTeamu().get(s) != null) {
                    vysledok.put(s, this.teamy[i].dajStatistikyTeamu().get(s));
                }
            }
        }

        this.celkoveStatistiky.add(vysledok);
    }

    /**
     *
     * vracia hashset so vsetkymi statistikami ktore sa pocas vsetkych simulaci udiali
     *
     * @return hashset so vsetkymi statistikami ktore sa udiali pocas vsetkych simulaci
     */
    public HashMap<String, Integer> vratCelkoveStatistiky() {
        HashMap<String, Integer> vysledok = new HashMap<>();
        for (HashMap<String, Integer> hashMap : this.celkoveStatistiky) {
            for (String s : hashMap.keySet()) {
                if (vysledok.containsKey(s) && hashMap.get(s) != null && vysledok.get(s) != null) {
                    Integer novaHodnota = hashMap.get(s) + vysledok.get(s);
                    vysledok.put(s, novaHodnota);

                } else if (hashMap.get(s) != null) {
                    vysledok.put(s, hashMap.get(s));
                }
            }
        }
        return vysledok;
    }
    private boolean jeKoniec() {
        return this.teamy[0].siPrazdny() || this.teamy[1].siPrazdny();
    }

}
