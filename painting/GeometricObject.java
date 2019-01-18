package sk.stuba.fei.oop.painting;

import java.awt.*;

public abstract class GeometricObject {

    private int x;
    private int y;
    private int ID;
    public abstract void draw(Graphics g);

    public GeometricObject(int x, int y, int ID) {
        this.x = x;
        this.y = y;
        this.ID = ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getID() {
        return ID;
    }
}
