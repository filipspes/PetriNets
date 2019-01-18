package sk.stuba.fei.oop.painting;


import sk.stuba.fei.oop.petriNet.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class DrawingField extends Canvas implements MouseListener {

    private List<Token> tokens = new ArrayList<Token>();
    private List<Square> squares = new ArrayList<Square>();
    private List<Arrow> arrows = new ArrayList<Arrow>();
    private PetrinetParser net = null;
    private int i = 0;
    private boolean addingTokens = false;
    private boolean removingTokens = false;

    private static final int MINIMUM_FIREABLE_LIMIT = 0;
    private static final int MAXIMUM_FIREABLE_LIMIT = 40;

    public DrawingField() {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    protected void resetNet() {
        this.tokens = new ArrayList<Token>();
        this.squares = new ArrayList<Square>();
        this.arrows = new ArrayList<Arrow>();
    }

    public void addPetrinet(PetrinetParser net) {
        this.resetNet();
        this.net = net;
        for(Place place :net.getPlaces()) {
            this.addCircle(new Token(place.getX(), place.getY(), place.getObjectID(), place.getTokens()));
        }

        for(Transition transition : net.getTransitions()) {
            this.addSquare(new Square(transition.getX(), transition.getY(), transition.getObjectID()));
        }

        for(Arc arc : net.getArcs()) {
            this.addArrow(new Arrow(arc.getInputX(), arc.getInputY(), arc.getOutputX(), arc.getOutputY()));
        }
    }

    private void addCircle(Token token){
        this.tokens.add(token);
    }
    private void addSquare(Square square){
        this.squares.add(square);
    }
    private void addArrow(Arrow arrow) {
        this.arrows.add(arrow);
    }

    @Override
    public void paint(Graphics g) {
       // Graphics2D g2d = (Graphics2D) g;
        //g.setStroke(new BasicStroke(2));
        super.paint(g);
        for(Token token : tokens) {
            token.draw(g);
        }
        for(Square square : squares) {
            Transition transition = net.getTransitions().get(i++);
                if(transition.isFireable()) {
                    square.setColor(Color.green);
                    square.draw(g);
                }
                else {
                    square.draw(g);
                }
            square.setColor(Color.black);
            }
            i = 0;

        for(Arrow arrow : arrows) {
            arrow.draw(g);
        }
    }
    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        int clickX;
        int clickY;

        for (Token token : tokens) {
            clickX = e.getX() - token.getX();
            clickY = e.getY() - token.getY();
            if (clickX >= MINIMUM_FIREABLE_LIMIT && clickX <= MAXIMUM_FIREABLE_LIMIT && clickY >= MINIMUM_FIREABLE_LIMIT && clickY <= MAXIMUM_FIREABLE_LIMIT) {
                for (Place place : net.getPlaces()) {
                    if (place.getObjectID() == token.getID()) {
                        if(this.addingTokens) {
                            place.addTokens(1);
                            token.addTokens(1);
                        }
                        if(this.removingTokens) {
                            try {
                                place.removeTokens(1);
                                token.removeTokens(1);
                            }
                            catch (NegativeTokensException err) {
                                System.out.println(err.getMessage());
                            }
                        }
                    }
                }
                repaint();
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int clickX;
        int clickY;

        for(GeometricObject square : squares) {
            clickX = e.getX()-square.getX();
            clickY = e.getY()-square.getY();
            if(clickX >= MINIMUM_FIREABLE_LIMIT && clickX <= MAXIMUM_FIREABLE_LIMIT && clickY >= MINIMUM_FIREABLE_LIMIT && clickY <= MAXIMUM_FIREABLE_LIMIT) {
                for(Transition transition : net.getTransitions()) {
                    if(transition.getObjectID() == square.getID()) {
                        try {
                            transition.fire();
                        }
                        catch (NonFireableTransitionException err) {
                            System.out.println("Prechod " + transition.getObjectID() + err.getMessage());
                        }
                        this.repaint();
                        for(Token token : tokens) {
                            for(Place place : net.getPlaces()) {
                                if(token.getID() == place.getObjectID()) {
                                    token.setTokens(place.getTokens());
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    protected void changingTokensStatus(boolean adding, boolean removing) {
        this.addingTokens = adding;
        this.removingTokens = removing;
    }
}
