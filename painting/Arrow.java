package sk.stuba.fei.oop.painting;

import java.awt.*;
import java.awt.geom.AffineTransform;



public class Arrow {

    private static final int HALF_GEOMETRIC_OBJECT_DIMENSION = 20;
    private static final int GEOMETRIC_OBJECT_DIMENSION = 40;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;


    private int sourceX;
    private int sourceY;
    private int destinationX;
    private int destinationY;

    public Arrow(int x1, int y1, int x2, int y2) {
        this.sourceX = x1;
        this.sourceY = y1;
        this.destinationX = x2;
        this.destinationY = y2;
    }

    public void draw(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        g.setColor(Color.BLACK);

        int x1 = this.sourceX;
        int y1 = this.sourceY;
        int x2 = this.destinationX;
        int y2 = this.destinationY;


       if(sourceX < destinationX && sourceY > destinationY || sourceX < destinationX && sourceY < destinationY) {
            x1+=GEOMETRIC_OBJECT_DIMENSION;
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if(sourceX > destinationX && sourceY < destinationY || sourceX > destinationX && sourceY > destinationY) {
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            x2+=GEOMETRIC_OBJECT_DIMENSION;
            y2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if((sourceX-destinationX > -GEOMETRIC_OBJECT_DIMENSION && sourceX-destinationX < 0)) {
            x1-=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            x2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2-=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }

        if((sourceX-destinationX > 0 && sourceX-destinationX < GEOMETRIC_OBJECT_DIMENSION)) {
            x1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            x2-=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2-=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if(sourceX == destinationX && sourceY < destinationY) {
            x1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y1+=GEOMETRIC_OBJECT_DIMENSION;
            x2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if(sourceX == destinationX && sourceY > destinationY) {
            x1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2+=GEOMETRIC_OBJECT_DIMENSION;
            x2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if(sourceY == destinationY && sourceX < destinationX) {
            x1+=GEOMETRIC_OBJECT_DIMENSION;
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
        }
        if(sourceY == destinationY && sourceX > destinationX) {
            y1+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            y2+=HALF_GEOMETRIC_OBJECT_DIMENSION;
            x2+=GEOMETRIC_OBJECT_DIMENSION;
        }

        double fi = Math.atan2(y2 - y1, x2 - x1);

        Polygon p = new Polygon();
        //top
        p.addPoint(x2, y2);
        //bot left
        p.addPoint(x2 - WIDTH/2, y2 - HEIGHT);
        //bot right
        p.addPoint(x2 + WIDTH/2, y2 - HEIGHT);

        AffineTransform tx = new AffineTransform();

        tx.rotate(fi - Math.PI/2, x2, y2);

        Shape shape = tx.createTransformedShape(p);
      //
        gr.fill(shape);
        g.drawLine(x1, y1, x2, y2);
       //g.drawLine(x1-3,y1-3, 3, 3);
        //g.fillOval(x2-5,y2-5,5,5);
    }

}
