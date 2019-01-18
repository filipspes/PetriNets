package sk.stuba.fei.oop.petriNet;

import sk.stuba.fei.oop.generated.Arc;
import sk.stuba.fei.oop.generated.Document;


public class PetrinetParser extends Petrinet {

    public PetrinetParser(Document net) {

        for(sk.stuba.fei.oop.generated.Place p : net.getPlace()) {
            place(p.getId(), p.getX(), p.getY(), p.getTokens());
        }

        for (sk.stuba.fei.oop.generated.Transition t : net.getTransition()) {
            transition(t.getId(), t.getX(), t.getY());
        }

        for (Arc a : net.getArc()) {
            try {
                addArcID(a.getId());
                for (sk.stuba.fei.oop.generated.Place p : net.getPlace()) {
                    if (a.getSourceId() == p.getId()) {
                        addArcInput(getArcSourcePlace(a));
                        addArcOutput(getArcDestinationTransition(a));
                    }
                }
                for (sk.stuba.fei.oop.generated.Transition t : net.getTransition()) {
                    if (a.getSourceId() == t.getId()) {
                        addArcInput(getArcSourceTransition(a));
                        addArcOutput(getArcDestinationPlace(a));
                    }
                }
                addArc();
            }
            catch (ArcBetweenWrongObjectException e) {
                System.out.println("Hrana " + a.getId() + e.getMessage());
            }
        }
    }

    private Place getArcSourcePlace(Arc arc) {

        Place source = null;

        for (Place p : getPlaces()) {
            if (arc.getSourceId() == p.getObjectID()) {
                source = p;
            }
        }
        return source;
    }

    private Transition getArcSourceTransition(Arc arc) {

        Transition source = null;

        for (Transition t : getTransitions()) {
            if (arc.getSourceId() == t.getObjectID()) {
                source = t;
            }
        }
        return source;
    }

    private Transition getArcDestinationTransition(Arc arc) throws ArcBetweenWrongObjectException {

        Transition destination = null;

        for (Transition t : getTransitions()) {
            if (arc.getDestinationId() == t.getObjectID()) {
                destination = t;
            }
        }
        if (destination == null) {
            for (Place p : getPlaces()) {
                if (arc.getDestinationId() == p.getObjectID()) {
                    throw new ArcBetweenWrongObjectException();
                }
            }
        }
        return destination;
    }

    private Place getArcDestinationPlace(Arc arc) throws ArcBetweenWrongObjectException {

        Place destination = null;

        for (Place p : getPlaces()) {
            if (arc.getDestinationId() == p.getObjectID()) {
                destination = p;
            }
        }
        if (destination == null) {
            for (Transition t : getTransitions()) {
                if (arc.getDestinationId() == t.getObjectID()) {
                    throw new ArcBetweenWrongObjectException();
                }
            }
        }
        return destination;
    }



    public void resetNet() {

    }
}
