package sk.stuba.fei.oop.petriNet;

import java.util.ArrayList;
import java.util.List;


public class Petrinet {

    private int temporaryID;
    private Place inputPlace = null;
    private Transition inputTransition = null;
    private Place outputPlace = null;
    private Transition outputTransition = null;
    private List<Place> places = new ArrayList<Place>();
    private List<Transition> transitions = new ArrayList<Transition>();
    private List<Arc> arcs = new ArrayList<Arc>();

    public Petrinet() {}

    public List<Place> getPlaces() {
        return places;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public List<Arc> getArcs() {
        return arcs;
    }

    public Place place(int ID, int x, int y, int initialTokens) {
        Place place = new Place(ID, x, y, initialTokens);
        places.add(place);

        return place;

    }

    public Transition transition(int ID, int x, int y) {
        Transition transition = new Transition(ID, x, y);
        transitions.add(transition);

        return transition;
    }

    public void addArcID(int ID) {
        this.temporaryID = ID;
        this.inputPlace = null;
        this.inputTransition = null;
    }

    public void addArcInput(Place input) {
        this.inputPlace = input;
    }

    public void addArcInput(Transition input) {
        this.inputTransition = input;

    }

    public void addArcOutput(Place output) {
        try {
            if (this.inputPlace != null) {
                throw new ArcBetweenWrongObjectException();
            }
            else {
                this.outputPlace = output;
            }
        }
        catch (ArcBetweenWrongObjectException e) {
            System.out.println("Hrana " + this.temporaryID + e.getMessage());
        }
    }

    public void addArcOutput(Transition output) {
        try {
            if (this.inputTransition != null) {
                throw new ArcBetweenWrongObjectException();
            }
            else {
                this.outputTransition = output;
            }
        }
        catch (ArcBetweenWrongObjectException e) {
            System.out.println("Hrana " + this.temporaryID + e.getMessage());
        }

    }


    public Arc arc(int ID, Place place, Transition transition) {
        Arc arc = new Arc(ID, place, transition);
        arcs.add(arc);

        return arc;
    }

    public Arc arc(int ID, Transition transition, Place place) {
        Arc arc = new Arc(ID, transition, place);
        arcs.add(arc);

        return arc;
    }

    public Arc addArc() {
        Arc arc = null;

        try {
            if(this.inputPlace == null && this.outputTransition == null) {
                if(this.inputTransition == null || this.outputPlace == null) {
                    throw new NoConnectedArcException();
                }
                else {
                    arc = this.arc(this.temporaryID, this.inputTransition, this.outputPlace);
                }
            }
            else {
                if(this.inputPlace == null || this.outputTransition == null) {
                    throw new NoConnectedArcException();
                }
                else {
                    arc = this.arc(this.temporaryID, this.inputPlace, this.outputTransition);
                }
            }
        }
        catch (NoConnectedArcException e) {
            System.out.println("Hrana " + this.temporaryID + e.getMessage());
        }

        this.inputPlace = null;
        this.inputTransition = null;
        this.outputPlace = null;
        this.outputTransition = null;

        return arc;
    }
    public void fireTransition(int ID) {

        for (Transition transition : transitions) {
            if (ID == transition.getObjectID()) {
                System.out.println("Spustam prechod "+transition.getObjectID());
                try {
                    transition.fire();
                }
                catch (NonFireableTransitionException e) {
                    System.out.println("Prechod " + transition.getObjectID() + e.getMessage());
                }
            }
        }
    }
}


