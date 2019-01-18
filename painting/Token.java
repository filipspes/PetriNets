package sk.stuba.fei.oop.painting;

import java.awt.*;

public class Token extends GeometricObject {

    private static final int RADIUS = 40;
    private static final int DOT_RADIUS = 7;
    private static final int DOT_MOVEMENT = 8;
    private int tokens;

    public Token(int x, int y, int ID, int tokens) {
        super(x, y, ID);
        this.tokens = tokens;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(this.getX(), this.getY(), RADIUS, RADIUS);
        if(tokens > 0 && tokens < 10) {
            this.drawDots(g);
        }
        else g.drawString(Integer.toString(tokens), setXToCenter(), setYToCenterIfNumber());
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void addTokens(int weight) {
        this.tokens += weight;
    }

    public void removeTokens(int weight) {
        this.tokens -= weight;
    }

    private int setXToCenter() { return this.getX()+17; }
    private int setYToCenterIfNumber() { return this.getY()+25; }
    private int setYToCenterIfDots() { return this.getY()+17; }

    private void drawDots(Graphics g) {
        switch(tokens) {
            case 1: g.fillOval(setXToCenter(), setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    break;
            case 2: g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 3: g.fillOval(setXToCenter(), setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 4: g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 5: g.fillOval(setXToCenter(), setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 6: g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 7: g.fillOval(setXToCenter(), setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 8: g.fillOval(setXToCenter(), setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter(), setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
            case 9: g.fillOval(setXToCenter(), setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter(), setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter(), setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots(), DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()+DOT_MOVEMENT, setYToCenterIfDots()-DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    g.fillOval(setXToCenter()-DOT_MOVEMENT, setYToCenterIfDots()+DOT_MOVEMENT, DOT_RADIUS,DOT_RADIUS);
                    break;
        }
    }
}
