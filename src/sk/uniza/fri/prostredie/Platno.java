package sk.uniza.fri.prostredie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. 
 * 
 * 
 * 
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 * TRIEDU SOM SKOPIROVAL Z CVICENI MINULEHO SEMESTRA.
 * 
 * @version 1.6.1 (shapes)
 * 
 * 
 */
public class Platno {
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Platno platnoSingleton;

    /**
     * Factory method to get the canvas singleton object.
     * @return platno
     */
    public static Platno dajPlatno() {
        if (Platno.platnoSingleton == null) {
            Platno.platnoSingleton = new Platno("Bojove pole", 800, 600, 
                                         Color.white);
        } 
        Platno.platnoSingleton.setVisible(true);
        return Platno.platnoSingleton;
    }
    

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color pozadie;
    private Image canvasImage;
    private Timer timer;
    private List<Object> objekty;
    private HashMap<Object, IDraw> tvary;

    
    /**
     * Create a Canvas.
     * @param titulok  title to appear in Canvas Frame
     * @param sirka  the desired width for the canvas
     * @param vyska  the desired height for the canvas
     * @param pozadie  the desired background colour of the canvas
     */
    private Platno(String titulok, int sirka, int vyska, Color pozadie) {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.canvas = new CanvasPane();
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(titulok);
        this.frame.setAutoRequestFocus(true);
        this.canvas.setPreferredSize(new Dimension(sirka, vyska));
        this.timer = new Timer(25, null);
        this.timer.start();
        this.pozadie = pozadie;
        this.frame.pack();
        this.objekty = new ArrayList<Object>();
        this.tvary = new HashMap<Object, IDraw>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible) {
        if (this.graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setColor(this.pozadie);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }
        this.frame.setVisible(visible);
    }



    /**
     * Draw a given shape onto the canvas.
     * @param  objekt  an object to define identity for this shape
     * @param  farba            the color of the shape
     * @param  tvar            the shape object to be drawn on the canvas
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object objekt, String farba, Shape tvar) {
        this.objekty.remove(objekt);   // just in case it was already there
        this.objekty.add(objekt);      // add at the end
        this.tvary.put(objekt, new PopisTvaru(tvar, farba));
        this.redraw();

    }
    
    /**
     * Draw a given image onto the canvas.
     * @param  objekt  an object to define identity for this image
     * @param  image            the image object to be drawn on the canvas
     * @param  transform        the transformation applied to the image
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object objekt, BufferedImage image, AffineTransform transform) {
        this.objekty.remove(objekt);   // just in case it was already there
        this.objekty.add(objekt);      // add at the end
        this.tvary.put(objekt, new PopisObrazku(image, transform));
        this.redraw();

    }
 
    /**
     * Erase a given shape's from the screen.
     * @param  objekt  the shape object to be erased
     */
    public void erase(Object objekt) {
        this.objekty.remove(objekt); // just in case it was already there
        this.tvary.remove(objekt);
        this.redraw();

    }

    /**
     * Set the foreground colour of the Canvas.
     * @param  farba   the new colour for the foreground of the Canvas
     */
    public void setForegroundColor(String farba) {
        if (farba.equals("red")) {
            this.graphic.setColor(Color.red);
        } else if (farba.equals("black")) {
            this.graphic.setColor(Color.black);
        } else if (farba.equals("blue")) {
            this.graphic.setColor(Color.blue);
        } else if (farba.equals("yellow")) {
            this.graphic.setColor(Color.yellow);
        } else if (farba.equals("green")) {
            this.graphic.setColor(Color.green);
        } else if (farba.equals("magenta")) {
            this.graphic.setColor(Color.magenta);
        } else if (farba.equals("white")) {
            this.graphic.setColor(Color.white);
        } else {
            this.graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milisekundy  the number
     */
    public void wait(int milisekundy) {
        try {
            Thread.sleep(milisekundy);
        } catch (Exception e) {
            System.out.println("Cakanie sa nepodarilo");
        }
    }
    
    private void redrawOneShape(Object objekt) {
        
    }

    /**
     * * Redraw all shapes currently on the Canvas.
     */
    private void redraw() {
        try {
            this.erase();
            for (Object tvar : this.objekty) {
                this.tvary.get(tvar).draw(this.graphic);
            }
            this.canvas.repaint();
        } catch (Exception ignored) {

        }
    }
       
    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.pozadie);
        Dimension size = this.canvas.getSize();
        this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
        this.graphic.setColor(original);
    }


    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     *
     */
    private class CanvasPane extends JPanel {
        public void paint(Graphics graphic) {
            graphic.drawImage(Platno.this.canvasImage, 0, 0, null);
        }
    }
    
    /***********************************************************************
     * Inner interface IDraw - defines functions that need to be supported by
     * shapes descriptors
     */
    private interface IDraw {
        void draw(Graphics2D graphic);
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class PopisTvaru implements IDraw {
        private Shape tvar;
        private String farba;

        PopisTvaru(Shape tvar, String farba) {
            this.tvar = tvar;
            this.farba = farba;
        }

        public void draw(Graphics2D graphic) {
            Platno.this.setForegroundColor(this.farba);
            graphic.fill(this.tvar);
        }
    }
    
    private class PopisObrazku implements IDraw {
        private BufferedImage obrazok;
        private AffineTransform transformacia;
        
        PopisObrazku(BufferedImage obrazok, AffineTransform transformacia) {
            this.obrazok = obrazok;
            this.transformacia = transformacia;
        }
        
        public void draw(Graphics2D graphic) {
            graphic.drawImage(this.obrazok, this.transformacia, null); 
        }
    }
}
