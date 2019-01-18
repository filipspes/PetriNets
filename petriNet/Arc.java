package sk.stuba.fei.oop.petriNet;

public class Arc {

    private Place place;
    private Transition transition;
    private Direction direction;
    private int ID;

    private int weight = 1;

    enum Direction {
        PLACE_TO_TRANSITION {
            public void fire(Place p, int weight) {
                p.removeTokens(weight);
            }
        },
        TRANSITION_TO_PLACE {public void fire(Place p, int weight) {
            p.addTokens(weight);
            }
        };

        public abstract void fire(Place p, int weight);
    }

    private Arc(int ID, Direction d, Place p, Transition t) {
        this.ID = ID;
        this.place = p;
        this.transition = t;
        this.direction = d;
    }

    protected Arc(int ID, Place p, Transition t) throws ArcBetweenWrongObjectException {
        this(ID, Direction.PLACE_TO_TRANSITION, p, t);
        t.addInput(this);
    }

    protected Arc(int ID, Transition t, Place p) throws ArcBetweenWrongObjectException {
        this(ID, Direction.TRANSITION_TO_PLACE, p, t);
        t.addOutput(this);
    }


    public void fire() {
        this.direction.fire(place, this.weight);
    }

    public int getWeight() { return weight; }

    public void setWeight(int weight) {
        try {
            if(weight < 1) {
                throw new WrongArcWeightException();
            }
            else {
                this.weight = weight;
            }
            }
            catch (WrongArcWeightException e) {
                System.out.println("Hrana " + this.getID() +e.getMessage());
            }
    }

    public int getID() {
        return ID;
    }

    public int getInputPlaceTokens() {
        return place.getTokens();
    }

    public int getInputX() {


        if(this.direction == Direction.PLACE_TO_TRANSITION) {
            return place.getX();
        }
        else return transition.getX();
    }

    public int getInputY() {


        if(this.direction == Direction.PLACE_TO_TRANSITION) {
            return place.getY();
        }
        else return transition.getY();
    }

    public int getOutputX() {

        if(this.direction == Direction.PLACE_TO_TRANSITION) {
            return transition.getX();
        }
        else return place.getX();
    }

    public int getOutputY() {
        int y;

        if(this.direction == Direction.PLACE_TO_TRANSITION) {
            return transition.getY();
        }
        else return place.getY();
    }
}
