package sk.stuba.fei.oop.petriNet;


public class NoConnectedArcException extends RuntimeException {
    public NoConnectedArcException() {
        super(" - neda sa vytvorit hrana - nema nastaveny vstupny alebo vystupny vrchol");
    }
}
