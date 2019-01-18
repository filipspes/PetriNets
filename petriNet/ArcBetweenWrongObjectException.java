package sk.stuba.fei.oop.petriNet;


public class ArcBetweenWrongObjectException extends RuntimeException {
    public ArcBetweenWrongObjectException() {
        super(" - hrana nemoze byt vytvorena medzi objektami rovnakeho typu");
    }
}
