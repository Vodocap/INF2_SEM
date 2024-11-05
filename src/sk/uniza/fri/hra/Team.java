package sk.uniza.fri.hra;

import sk.uniza.fri.bojovnici.Bojovnik;
import sk.uniza.fri.bojovnici.Rytier;
import sk.uniza.fri.bojovnici.Ninja;
import sk.uniza.fri.bojovnici.Necromancer;
import sk.uniza.fri.bojovnici.Lukostrelec;
import sk.uniza.fri.bojovnici.Kuzelnik;
import sk.uniza.fri.bojovnici.Boss;
import sk.uniza.fri.bojovnici.Pirat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Trieda Team.
 * vytvorí team ktorému sa dajú pridávať a uberať bojovníci, taktiež si vie vytvoriť vlastných bojovníkov.
 *
 * @author Matúš Uhlár
 */
public class Team {
    private ArrayList<Bojovnik> zoznamVyradenychBojovnikovVsetkych;
    private ArrayList<Bojovnik> zoznamBojovnikov;
    private Random generatorCisel;
    private ArrayList<Bojovnik> zoznamVyradenychBojovnikov;

    /**
     * Konstruktor tiedy Team.
     */
    public Team() {

        this.generatorCisel = new Random();
        this.zoznamBojovnikov = new ArrayList<Bojovnik>();
        this.zoznamVyradenychBojovnikov = new ArrayList<Bojovnik>();
        this.zoznamVyradenychBojovnikovVsetkych = new ArrayList<Bojovnik>();
    }

    /**
     * Metóda dajVyradenychBojovnikovNaIndexe.
     *
     * vracia arraylist bojovnikov vyradenych z teamu
     *
     * @return the array list
     */
    public ArrayList<Bojovnik> dajVyradenychBojovnikov() {
        if (!this.zoznamVyradenychBojovnikovVsetkych.isEmpty()) {
            this.zoznamVyradenychBojovnikovVsetkych.remove(0);
        }
        return this.zoznamVyradenychBojovnikov;
    }

    /**
     * Metóda getBojovnikNaIndexe
     *
     *     vráti bojovníka na indexe z parametra
     *
     *
     *
     * @param indexHladanehoBojovnika the index hladaneho bojovnika
     * @return Bojovnik hladanyBojovnik
     */
    public Bojovnik getBojovnikNaIndexe(int indexHladanehoBojovnika) {
        if (!this.zoznamBojovnikov.isEmpty()) {
            return this.zoznamBojovnikov.get(indexHladanehoBojovnika);
        }
        return null;

    }

    /**
     * Metóda pridajBojovnika
     *
     *     pridá bojovníka do Teamu
     *
     * @param bojovnik bojovnik
     */
    public void pridajBojovnika(Bojovnik bojovnik) {
        if (!this.zoznamBojovnikov.contains(bojovnik) && bojovnik != null) {
            this.zoznamBojovnikov.add(bojovnik);
        } else {
            System.out.println("tento bojovník sa už v tíme nachádza");
        }


    }

    /**
     * Metóda odoberBojovnikaZIndexu
     *
     *     odstráni bojovníka na indexe z parametra a ak nie je necromancer prida ho na zoznam vyradenych bojovnikov
     *
     * @param indexOdoberanehoBojovnika index odoberaneho bojovnika
     * @return bojovnik
     */
    public Bojovnik odoberBojovnikaZIndexu(int indexOdoberanehoBojovnika) {

        if (!(this.getBojovnikNaIndexe(indexOdoberanehoBojovnika) instanceof Necromancer)) {
            this.zoznamVyradenychBojovnikov.add(this.getBojovnikNaIndexe(indexOdoberanehoBojovnika));
        }
        this.zoznamVyradenychBojovnikovVsetkych.add(this.getBojovnikNaIndexe(indexOdoberanehoBojovnika));
        return this.zoznamBojovnikov.remove(indexOdoberanehoBojovnika);
    }

    /**
     * Metóda siPrazdny
     *
     *     zistí či je Team prázdny ak áno vráti true ak nie vráti false
     *
     * @return true/false
     */
    public boolean siPrazdny() {
        if (this.zoznamBojovnikov.isEmpty()) {
            return true;
        }
        return false;
    }


    /**
     * Vytvor si bojovnikov.
     *
     * @param pocetBojovnikov pocet bojovnikov
     * @param typBojovnikov typ bojovnikov ak je typ -1 tak vytvori nahodnych bojovnikov
     */
    public void vytvorSiBojovnikov(int pocetBojovnikov, int typBojovnikov) {
        if (typBojovnikov < 0) {
            for (int i = 0; i < pocetBojovnikov; i++) {
                switch (this.generatorCisel.nextInt(7)) {

                    case 0:
                        this.zoznamBojovnikov.add(new Rytier());
                        break;

                    case 1:
                        this.zoznamBojovnikov.add(new Ninja());
                        break;

                    case 2:
                        this.zoznamBojovnikov.add(new Lukostrelec());
                        break;

                    case 3:
                        this.zoznamBojovnikov.add(new Necromancer(this));
                        break;

                    case 4:
                        this.zoznamBojovnikov.add(new Kuzelnik());
                        break;

                    case 5:
                        this.zoznamBojovnikov.add(new Pirat());
                        break;

                    case 6:
                        this.zoznamBojovnikov.add(new Boss());
                        break;
                }

            }

        } else {
            for (int i = 0; i < pocetBojovnikov; i++) {
                switch (typBojovnikov) {

                    case 0:
                        this.zoznamBojovnikov.add(new Rytier());
                        break;

                    case 1:
                        this.zoznamBojovnikov.add(new Ninja());
                        break;

                    case 2:
                        this.zoznamBojovnikov.add(new Lukostrelec());
                        break;

                    case 3:
                        this.zoznamBojovnikov.add(new Necromancer(this));
                        break;

                    case 4:
                        this.zoznamBojovnikov.add(new Kuzelnik());
                        break;

                    case 5:
                        this.zoznamBojovnikov.add(new Pirat());
                        break;

                    case 6:
                        this.zoznamBojovnikov.add(new Boss());
                        break;
                }

            }

        }


    }


    /**
     * Vyliec cely team.
     *
     *
     *     vylieci kazdeho bojovnika v teame ktory je zadany do parametra
     *
     *
     * @param hrac hrac
     */
    public void vyliecCelyTeam(Hrac hrac) {
        hrac.setPeniaze(hrac.getPeniaze() - 10);
        for (Bojovnik bojovnik : this.zoznamBojovnikov) {
            bojovnik.setZivotyNaPlne();
        }
    }

    /**
     * Vypis bojovnikov v teame.
     *
     *
     * vypise bojovnikov v teame podla parametra, true je podrobnejsi vypis, false je skrateny vypis
     *
     *
     * @param podrobne the podrobne
     */
    public void vypisBojovnikovVTeame(boolean podrobne) {
        for (Bojovnik bojovnik : this.zoznamBojovnikov) {
            bojovnik.vypisInformacieOBojovnikovi(podrobne);
        }


    }

    /**
     * Obsahuje bojovnika boolean.
     *
     *
     *     zisti ci team obsahuje bojovnika v parametri ak ano vrati true ak nie vrati false
     *
     * @param bojovnik the bojovnik
     * @return the boolean
     */
    public boolean obsahujeBojovnika(Bojovnik bojovnik) {
        return this.zoznamBojovnikov.contains(bojovnik);
    }


    /**
     * Daj velkost teamu.
     *
     *
     *     vrati pocet bojovnikov v teame
     *
     * @return the int
     */
    public int dajVelkostTeamu() {
        return this.zoznamBojovnikov.size();
    }


    /**
     *
     * vrati hashset so statistikami teamu bojovnikov (aj tych co uz zomreli),
     *
     * @return hashset so statistikami teamu bojovnikov (aj tych co uz zomreli),
     */
    public HashMap<String, Integer> dajStatistikyTeamu() {
        HashMap<String, Integer> vysledok = new HashMap<String, Integer>();
        for (Bojovnik bojovnik : this.zoznamBojovnikov) {
            for (String s : bojovnik.dajStatistiky().keySet()) {
                if (vysledok.containsKey(s) && bojovnik.dajStatistiky().get(s) != null && vysledok.get(s) != null) {
                    Integer novaHodnota = bojovnik.dajStatistiky().get(s) + vysledok.get(s);
                    vysledok.put(s, novaHodnota);

                } else if (bojovnik.dajStatistiky().get(s) != null) {
                    vysledok.put(s, bojovnik.dajStatistiky().get(s));
                }

            }

        }
        for (Bojovnik bojovnik : this.zoznamVyradenychBojovnikovVsetkych) {
            for (String s : bojovnik.dajStatistiky().keySet()) {
                if (vysledok.containsKey(s) && bojovnik.dajStatistiky().get(s) != null && vysledok.get(s) != null) {
                    Integer novaHodnota = bojovnik.dajStatistiky().get(s) + vysledok.get(s);

                    vysledok.put(s, novaHodnota);

                } else if (bojovnik.dajStatistiky().get(s) != null) {
                    vysledok.put(s, bojovnik.dajStatistiky().get(s));
                }

            }

        }
        return vysledok;

    }


}
