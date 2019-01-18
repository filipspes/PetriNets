package sk.stuba.fei.oop.petriNet;

public abstract class PetrinetObject {

    private int objectID;
    private int x;
    private int y;

    public PetrinetObject (int ID, int x, int y) {
        this.objectID = ID;
        this.x = x;
        this.y = y;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int ID) {
        this.objectID = ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
