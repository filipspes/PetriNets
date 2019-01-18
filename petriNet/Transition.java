package sk.stuba.fei.oop.petriNet;

import java.util.ArrayList;
import java.util.List;


public class Transition extends PetrinetObject {

    public Transition(int ID, int x, int y) {
        super(ID, x, y);
    }

    private List<Arc> input = new ArrayList<Arc>();
    private List<Arc> output = new ArrayList<Arc>();

    public boolean isFireable() {
        boolean status = true;

        if(input.isEmpty()) {
            status = false;
        }

        for (Arc arc : input) {
            if(arc.getInputPlaceTokens() < arc.getWeight()) {
                status = false;
                }
        }

        return status;
    }

    public void fire() {
        if(isFireable()) {
            for (Arc arc : input) {
                arc.fire();
            }
            for (Arc arc : output) {
                arc.fire();
            }
        }
        else {
            throw new NonFireableTransitionException();
        }
    }

    public void addInput(Arc arc) {
        this.input.add(arc);
    }

    public void addOutput(Arc arc) {
        this.output.add(arc);
    }
}
