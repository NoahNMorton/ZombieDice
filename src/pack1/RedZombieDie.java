package pack1;


public class RedZombieDie extends ZombieDie {

    public RedZombieDie(int dieColour) {
        super(dieColour); //todo Calls RedZombieDie constructor with the text “Red” >help
    }

    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            //set value
        } else if (random == 3) //1brain
        {
            //set value
        } else if (random >= 4) //3shot
        {
            //set value
        }

    }


}
