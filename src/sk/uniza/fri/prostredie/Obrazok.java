package sk.uniza.fri.prostredie;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Trieda Obrazok.
 * reprezentuje bitmapovy obrazok, ktory moze byt vykresleny na platno.
 * 
 * @author Miroslav Kvassay
 * @author Michal Varga
 * 
 * @version 1.1
 * TRIEDU SOM SKOPIROVAL Z CVICENI MINULEHO SEMESTRA
 */
public class Obrazok {
    private boolean jeViditelny;
    
    private int lavyHornyX;
    private int lavyHornyY;
    private int povodnaVelkostX;
    private int povodnaVelkostY;
    private int velkostX;
    private int velkostY;
    private double uhol;
    private BufferedImage obrazok;

    /**
     * Parametricky konstruktor vytvori Obrazok na pozicii paX, paY s natocenim paUhol
     * 
     * @param suborSObrazkom cesta k suboru s obrazkom, ktory sa ma vykreslovat
     */
    public Obrazok(String suborSObrazkom) {      
        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);                                   
 
        this.jeViditelny = false;
        this.lavyHornyX = 100;
        this.lavyHornyY = 100;
        this.povodnaVelkostX = this.obrazok.getWidth();
        this.povodnaVelkostY = this.obrazok.getHeight();
        this.velkostX = this.povodnaVelkostX;
        this.velkostY = this.povodnaVelkostY;
        this.uhol = 0;    
        
    }


    /**
     * Metoda getObrazok
     *
     * vrati obrazok
     *
     * @return obrazok
     */
    public BufferedImage getObrazok() {
        return this.obrazok;
    }
    
    /**
     * (Obrázok) Zobraz sa.
     */
    public void zobraz() {      
        this.jeViditelny = true;
        this.nakresli();
    }
    
    /**
     * (Obrázok) Zobraz sa.
     */
    public void skry() {       
        this.zmaz();
        this.jeViditelny = false;
    }                     
    
    /**
     * (Obrázok) Posuň sa vpravo o pevnú dĺžku.
     *
     * @param velkostPosunu velkost posunu
     *
     */
    public void posunVpravo(int velkostPosunu) {
        this.posunVodorovne(velkostPosunu);
    }

    /**
     * (Obrázok) Posuň sa vľavo o pevnú dĺžku.
     *
     * @param velkostPosunu velkost posunu
     */
    public void posunVlavo(int velkostPosunu) {
        this.posunVodorovne(-velkostPosunu);
    }

    /**
     * (Obrázok) Posuň sa hore o pevnú dĺžku.
     *
     *
     */
    public void posunHore() {
        this.posunZvisle(-20);
    }

    /**
     * (Obrázok) Posuň sa dole o pevnú dĺžku.
     */
    public void posunDole() {
        this.posunZvisle(20);
    }

    /**
     * (Obrázok) Posuň sa vodorovne o dĺžku danú parametrom.
     *
     * @param vzdialenost vzdialenost
     */
    public void posunVodorovne(int vzdialenost) {
        this.zmaz();
        this.lavyHornyX += vzdialenost;
        this.nakresli();
    }

    /**
     * (Obrázok) Posuň sa zvisle o dĺžku danú parametrom.
     *
     * @param vzdialenost vzdialenost posunu
     */
    public void posunZvisle(int vzdialenost) {
        this.zmaz();
        this.lavyHornyY += vzdialenost;
        this.nakresli();
    }

    /**
     * (Obrázok) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
     *
     * @param vzdialenost vzdialenost posunu
     */
    public void pomalyPosunVodorovne(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else  {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.lavyHornyX += delta;
            this.nakresli();
        }
    }

    /**
     * (Obrázok) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
     * @param vzdialenost vzdialenost posunu
     */
    public void pomalyPosunZvisle(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.lavyHornyY += delta;
            this.nakresli();
        }
    }
           
    /**
     * (Obrázok) Zmení obrázok.
     * Súbor s obrázkom musí existovať.
     * 
     * @param suborSObrazkom cesta k súboru s obrázkom, ktorý sa má načítať
     */
    public void zmenObrazok(String suborSObrazkom) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();        
        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);
        
        
        
        if (nakresleny) {
            this.nakresli();
        }
    }    
    
    /**
     * (Obrázok) Zmeň polohu stredu obrázka na hodnoty dané parametrami.
     *
     * @param stredX suradnica x stredu obrazka
     * @param stredY suradnica y stredu obrazka
     */
    public void zmenPolohu(int stredX, int stredY) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();
        this.lavyHornyX = stredX - this.sirka() / 2;
        this.lavyHornyY = stredY - this.vyska() / 2;
        if (nakresleny) {
            this.nakresli();
        }
    }
    
    /**
     * (Obrázok) Zmeň uhol natočenia obrázku podľa parametra. Sever = 0.
     *
     * @param uhol novy uhloé
     */
    public void zmenUhol(double uhol) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();
        this.uhol = uhol;
        if (nakresleny) {
            this.nakresli();
        }
    }  
    
    /**
     * (Obrázok) Zmeň veľkosť obrázku podľa parametrov. .
     *
     * @param velkostX nova velkost x
     * @param velkostY nova velkos y
     */
    public void zmenVelkost(int velkostX, int velkostY) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();
        this.velkostX = velkostX;
        this.velkostY = velkostY;
        if (nakresleny) {
            this.nakresli();
        }
    }  
    
    /*
     * Načíta obrázok zo súboru.
     */
    private BufferedImage nacitajObrazokZoSuboru(String subor) {
        BufferedImage nacitanyOBrazok = null;
        
        try {
            nacitanyOBrazok = ImageIO.read(new File(subor));
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Subor " + subor + " sa nenasiel.");
        }        
        
        return nacitanyOBrazok;
    }     
    
    /*
     * (Obrázok) Vráti všírku obrázka.
     */
    private int sirka() {
        return this.velkostX;
    }
    
    /*
     * (Obrázok) Vráti výšku obrázka.
     */
    private int vyska() {
        return this.velkostY;
    }    
    
    /*
     * Draw the square with current specifications on screen.
     */
    private void nakresli() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
        
            AffineTransform at = new AffineTransform();
            at.translate(this.lavyHornyX + this.sirka() / 2, this.lavyHornyY + this.vyska() / 2);
            at.rotate(this.uhol / 180.0 * Math.PI);
            at.translate(-this.sirka() / 2, -this.vyska() / 2);
            at.scale(this.velkostX / (double)this.povodnaVelkostX, this.velkostY / (double)this.povodnaVelkostY);
            canvas.draw(this, this.obrazok, at);
            canvas.wait(4);
            
        }
    }


    /*
     * Erase the square on screen.
     */
    private void zmaz() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
    
}
