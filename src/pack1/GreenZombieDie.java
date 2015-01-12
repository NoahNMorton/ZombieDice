package pack1;


public class GreenZombieDie extends ZombieDie {

    public GreenZombieDie(int dieColour) {
        super(dieColour);
    }

    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            value = ZombieDie.RUNNER;//set value
        } else if (random <= 5) //3brain
        {
            value = ZombieDie.BRAIN;//set value
        } else if (random == 6) //1shot
        {
            value = ZombieDie.SHOT;//set value
        }
    }


}

