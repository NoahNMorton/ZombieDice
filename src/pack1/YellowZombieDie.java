package pack1;


public class YellowZombieDie extends ZombieDie {

    public YellowZombieDie(int dieColour) {
        super(dieColour); //todo Calls YellowZombieDie constructor with the text “Yellow” >help
    }

    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            //set value
        } else if (random == 3 || random == 4) //2brain
        {
            //set value
        } else if (random >= 5) //2shot
        {
            //set value
        }
    }


}
