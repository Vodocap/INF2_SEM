package sk.uniza.fri.hra;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trieda Hra.
 *
 * reprezentuje hru aj s levelmi, ponuka hracovi moznost hru ukoncit, nakupovat bojovnikov a bojovat, ak hrac zvitazi tak ho posunie do dalsieho levelu
 *
 * @author Matúš Uhlár
 */
public class Hra {

    private Hrac hrac;
    private ArrayList<Level> levely;
    private Obchod obchod;
    private int pocetLevelov;
    private final Simulacia simulacia;

    /**
     * Konstruktor triedy Hra.
     */
    public Hra() {

        this.simulacia = new Simulacia();

        this.levely = new ArrayList<Level>();

        this.pridajLevel(ObtiaznostiLevelov.LAHKY);
        this.pridajLevel(ObtiaznostiLevelov.STREDNY);
        this.pridajLevel(ObtiaznostiLevelov.TAZKY);
        this.pridajLevel(ObtiaznostiLevelov.MINUS_PENIAZE);
        this.pridajLevel(ObtiaznostiLevelov.BOSS);

        this.pocetLevelov = this.levely.size();

    }

    private void pridajLevel(ObtiaznostiLevelov obtiaznost) {
        this.levely.add(new Level(obtiaznost));
    }


    private void restartujHru() {
        while (!this.levely.isEmpty()) {
            this.levely.remove(0);
        }

        this.pridajLevel(ObtiaznostiLevelov.LAHKY);
        this.pridajLevel(ObtiaznostiLevelov.STREDNY);
        this.pridajLevel(ObtiaznostiLevelov.TAZKY);
        this.pridajLevel(ObtiaznostiLevelov.MINUS_PENIAZE);
        this.pridajLevel(ObtiaznostiLevelov.BOSS);
        this.pocetLevelov = this.levely.size();
        this.hraj();

    }


    /**
     * Hraj.
     *
     * hlavna metoda triedy Hra, zacne hru vie ju aj ukoncit, riadi dialogy s hracom a spusta boje medzi hracovimi bojovnikmi a predpripravenymi levelmi
     *
     */
    public void hraj() {

        int indexLevelu = 0;
        System.out.println("Vitaj v hre, napíš svoje meno a môžeš pokračovať");


        Scanner skener = new Scanner(System.in);

        this.hrac = new Hrac(skener.nextLine(), 150);
        this.obchod = new Obchod(this.hrac);
        this.hrac.setAktualnyLevel(this.levely.get(indexLevelu));
        boolean koniec = false;
        this.vypisStav(true);


        do {
            System.out.println("Ako chceš pokračovať? Stlač číslo podľa toho čo chceš urobiť");
            System.out.println("1 - chcem nakupovať");
            System.out.println("2 - chcem bojovať");
            System.out.println("3 - chcem skončiť");
            String hracovaVolbaString = skener.nextLine();
            try {
                int hracovaVolba = Integer.parseInt(hracovaVolbaString);

                switch (hracovaVolba) {

                    case 1:
                        this.obchod.nakupuj();
                        break;

                    case 2:
                        if (this.hrac.getHracovTeam().dajVelkostTeamu() < 1) {
                            System.out.println("Si si istý že chceš bojovať keď v tíme nemáš žiadnych bojovníkov? Choď si kúpiť aspoň jedného");
                            break;
                        } else {
                            boolean vyhra = this.simulacia.spustiBoj(this.hrac.getHracovTeam(), this.levely.get(indexLevelu).getBojovniciVLeveli(), this.hrac);


                            if (vyhra) {
                                this.hrac.setPeniaze(this.hrac.getPeniaze() + this.levely.get(indexLevelu).getOdmena());
                                indexLevelu++;
                                if (indexLevelu == this.pocetLevelov) {
                                    System.out.println("**********************VYHRAL SI CELU HRU**********************");
                                    koniec = true;
                                } else {
                                    this.vypisStav(false);
                                    this.hrac.setAktualnyLevel(this.levely.get(indexLevelu));
                                }


                            } else {
                                System.out.println("AK chceš, môžeš začať odznova");
                                System.out.println("Napíš číslo príkazu ktorý chceš vykonať");
                                System.out.println("1) - chcem reštartovať hru");
                                System.out.println("2) - chcem skončiť");

                                String hracovaVolbaStringDalsi = skener.nextLine();
                                int hracovaVolbaInt = Integer.parseInt(hracovaVolbaStringDalsi);

                                switch (hracovaVolbaInt) {

                                    case 1:
                                        koniec = true;
                                        this.restartujHru();
                                        break;

                                    case 2:
                                        System.out.println("Dúfam že si ešte niekedy zahráš.");
                                        koniec = true;
                                        break;

                                }

                            }
                            break;
                        }

                    case 3:
                        System.out.println("Dúfam že si ešte niekedy zahráš.");
                        koniec = true;
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Vstup musí byť len celé číslo");
            }

        } while (!koniec);

        this.obchod.zavriSkener();
        skener.close();
        this.obchod.zavriSkener();
        try {
            this.vypisStatistikyDoSuboru();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.simulacia.vratCelkoveStatistiky();




    }

    private void vypisStav(boolean predPo) {
        if (predPo) {
            System.out.printf("\nVitaj %s mas tolkoto penazi %d \n", this.hrac.getMenoHraca(), this.hrac.getPeniaze());
        } else {
            System.out.printf("Mas tolkoto penazi %d \n", this.hrac.getPeniaze());
        }

    }

    private void vypisStatistikyDoSuboru() throws IOException {
        File file = new File("statistiky.txt");
        PrintWriter pisac = new PrintWriter(file);
        for (String s : this.simulacia.vratCelkoveStatistiky().keySet()) {
            pisac.println(s + this.simulacia.vratCelkoveStatistiky().get(s));
        }
        pisac.close();


    }
}
