package sk.stuba.fei.oop.petriNet;


public class NegativeTokensException extends RuntimeException {
    public NegativeTokensException() {
        super("Minimalny pocet tokenov v mieste je 0");
    }
}
