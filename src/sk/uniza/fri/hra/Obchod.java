package sk.uniza.fri.hra;


import sk.uniza.fri.bojovnici.Boss;
import sk.uniza.fri.bojovnici.Kuzelnik;
import sk.uniza.fri.bojovnici.Lukostrelec;
import sk.uniza.fri.bojovnici.Necromancer;
import sk.uniza.fri.bojovnici.Ninja;
import sk.uniza.fri.bojovnici.Pirat;
import sk.uniza.fri.bojovnici.Rytier;

import java.util.Scanner;




/**
 * Trieda Obchod.
 *
 * Sluzi na vypisovanie dialogu nakupovania bojovnikov a samotne nakupovanie bojovnikov
 *
 *@author Matúš Uhlár
 */
public class Obchod {

    private boolean koniec;
    private Hrac hrac;
    private Team nakupnyKosik;
    private Vyklad vyklad;
    private Scanner skener;


    /**
     * Konstruktor triedy Obchod
     *
     * @param hrac hrac
     */
    public Obchod(Hrac hrac) {
        this.vyklad = new Vyklad();
        this.nakupnyKosik = new Team();
        this.hrac = hrac;
        this.skener = new Scanner(System.in);

        this.vyklad.vytvorSiBojovnikov(1, 0);


    }

    /**
     * Nakupuj.
     *
     *
     * robi dialog s hracom a umoznuje mu nakupovat bojovnikov do svojo teamu
     *
     *
     * @return team
     */
    public Team nakupuj() {

        this.koniec = false;

        System.out.printf("\nVitaj v obchode %s, čo si želáš?", this.hrac.getMenoHraca());
        do {

            System.out.println("\ntvoji bojovníci:  \n");
            this.hrac.getHracovTeam().vypisBojovnikovVTeame(false);
            System.out.printf("\nMáš toľkoto peňazí: %d \n", this.hrac.getPeniaze());

            System.out.println("Stlač číslo podľa bojovníka ktorého chceš ");
            this.vyklad.vypisBojovnikovVTeame(false);
            System.out.println("7) daj všetký bojovníkom plné životy (10)");
            System.out.println("8) ukáž mi štatistiky a schopnosti bojovníkov");
            System.out.println("9) odíď z obchodu");
            String hracovaVolbaString = this.skener.next();

            int hracovaVolba = Integer.parseInt(hracovaVolbaString);
            try {
                switch (hracovaVolba) {
                    case 0:
                        this.hrac.kupSiBojovnika(new Rytier());
                        break;

                    case 1:
                        this.hrac.kupSiBojovnika(new Ninja());
                        break;

                    case 2:
                        this.hrac.kupSiBojovnika(new Lukostrelec());
                        break;

                    case 3:
                        this.hrac.kupSiBojovnika(new Necromancer(this.hrac.getHracovTeam()));
                        break;

                    case 4:
                        this.hrac.kupSiBojovnika(new Kuzelnik());
                        break;

                    case 5:
                        this.hrac.kupSiBojovnika(new Pirat());
                        break;

                    case 6:
                        this.hrac.kupSiBojovnika(new Boss());
                        break;

                    case 7:
                        this.hrac.getHracovTeam().vyliecCelyTeam(this.hrac);
                        break;

                    case 8:
                        this.vyklad.vypisBojovnikovVTeame(true);
                        break;

                    case 9:
                        this.koniec = true;
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Vstup musí byť len celé číslo!");

            }



        } while (!this.koniec);


        return this.nakupnyKosik;
    }


    /**
     * Zavri skener.
     *
     *
     *     zavrie skener
     *
     *
     */
    public void zavriSkener() {
        this.skener.close();
    }

}
