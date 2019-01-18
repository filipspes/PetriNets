package sk.stuba.fei.oop.painting;

import java.awt.*;


public class Square extends GeometricObject {

    private static final int SIZE = 40;
    public Color color = Color.black;

    public Square(int x, int y, int ID) {
        super(x, y, ID);
    }

    @Override
        public void draw(Graphics g) {
        if(color == Color.black) {
            g.setColor(this.color);
            g.drawRect(this.getX(), this.getY(), SIZE, SIZE);
        }
        if(color == Color.green) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), SIZE, SIZE);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
