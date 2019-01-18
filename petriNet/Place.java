package sk.stuba.fei.oop.petriNet;


public class Place extends PetrinetObject {

    private int tokens;

    public Place(int ID, int x, int y, int initialTokens) {
        super(ID, x, y);
        this.tokens = initialTokens;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void addTokens(int weight) {
        this.tokens += weight;
    }

    public void removeTokens(int weight) throws NegativeTokensException {
        if(this.tokens == 0) {
            throw new NegativeTokensException();
        }
        else {
            this.tokens -= weight;
        }
    }




}
