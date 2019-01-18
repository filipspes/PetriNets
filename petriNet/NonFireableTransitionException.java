package sk.stuba.fei.oop.petriNet;


public class NonFireableTransitionException extends RuntimeException {
    public NonFireableTransitionException() {
        super(" sa neda spustit - nie je pripojeny na miesto alebo niektore z miest na ktore je pripojeny obsahuje nedostatocny pocet tokenov");
    }
}
