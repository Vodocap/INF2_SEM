package sk.uniza.fri.hra;

import sk.uniza.fri.bojovnici.Bojovnik;
import sk.uniza.fri.bojovnici.Boss;
import sk.uniza.fri.bojovnici.Kuzelnik;
import sk.uniza.fri.bojovnici.Lukostrelec;
import sk.uniza.fri.bojovnici.Necromancer;
import sk.uniza.fri.bojovnici.Ninja;
import sk.uniza.fri.bojovnici.Pirat;
import sk.uniza.fri.bojovnici.Rytier;

import java.util.ArrayList;

/**
 * Trieda Vyklad.
 * dedi od triedy team, inicializuje team s jednym z kazdeho bojovnika a dokaze vypisat kazdeho z nich
 *
 *
 * @author Matúš Uhlár
 *
 *
 */

public class Vyklad extends Team {

    private ArrayList<Bojovnik> zoznamBojovnikov;

    /**
     * Konstruktor triedy vyklad.
     */
    public Vyklad() {
        this.zoznamBojovnikov = new ArrayList<Bojovnik>();
        this.zoznamBojovnikov.add(new Rytier());
        this.zoznamBojovnikov.add(new Ninja());
        this.zoznamBojovnikov.add(new Lukostrelec());
        this.zoznamBojovnikov.add(new Necromancer(this));
        this.zoznamBojovnikov.add(new Kuzelnik());
        this.zoznamBojovnikov.add(new Pirat());
        this.zoznamBojovnikov.add(new Boss());

    }





    public void vypisBojovnikovVTeame(boolean podrobne) {
        if (podrobne) {
            for (Bojovnik bojovnik : this.zoznamBojovnikov) {
                bojovnik.vypisInformacieOBojovnikovi(true);
            }
        } else {
            int i = 0;
            for (Bojovnik bojovnik : this.zoznamBojovnikov) {
                System.out.print(i + ") ");
                bojovnik.vypisInformacieOBojovnikovi(false);
                System.out.print("cena: " + bojovnik.getCena() + "\n");
                i++;
            }
        }

    }


}

