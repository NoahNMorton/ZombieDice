package pack1;


public class YellowZombieDie extends ZombieDie {

    public YellowZombieDie(int dieColour) {
        super(dieColour);
    }

    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            value = ZombieDie.RUNNER;//set value
        } else if (random == 3 || random == 4) //2brain
        {
            value = ZombieDie.BRAIN;//set value
        } else if (random >= 5) //2shot
        {
            value = ZombieDie.BRAIN;//set value
        }
    }


}
