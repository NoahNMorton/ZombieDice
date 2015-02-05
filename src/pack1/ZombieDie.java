package pack1;


public abstract class ZombieDie {

    public static final int NOT_ROLLED = 0, RUNNER = 1, BRAIN = 2, SHOT = 3;
    public static final int RED = 1, GREEN = 2, YELLOW = 3;
    int dieColour, value;

    public ZombieDie(int dieColour) {
        this.dieColour = dieColour;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDieColour() {
        return dieColour;
    }

    public void setDieColour(int dieColour) {
        this.dieColour = dieColour;
    }

    abstract void roll(); //randomly set value based on dieColour

    @Override
    public String toString() {
        return "Dice colour: " + dieColour + " Die Value: " + value;
    }
}
