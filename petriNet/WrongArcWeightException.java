package sk.stuba.fei.oop.petriNet;


public class WrongArcWeightException extends RuntimeException {
    public WrongArcWeightException() {
        super(" neda sa nastavit nasobnost - nasobnost hrany nemoze byt mensia ako 1");
    }
}
