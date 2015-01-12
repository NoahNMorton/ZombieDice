package pack1;


public class RedZombieDie extends ZombieDie {

    public RedZombieDie(int dieColour) {
        super(dieColour);
    }

    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            value = ZombieDie.RUNNER;//set value
        } else if (random == 3) //1brain
        {
            value = ZombieDie.BRAIN; //set value
        } else if (random >= 4) //3shot
        {
            value = ZombieDie.SHOT; //set value
        }

    }


}
