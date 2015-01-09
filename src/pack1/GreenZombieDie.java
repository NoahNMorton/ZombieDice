package pack1;


public class GreenZombieDie extends ZombieDie {

    public GreenZombieDie(int dieColour) {
        super(dieColour); //todo Calls GreenZombieDie constructor with the text “Green” >help
    }
//test
    void roll() {
        int random = ((int) (Math.random() * 6));
        if (random <= 2) //2runner
        {
            //set value
        } else if (random <= 5) //3brain
        {
            //set value
        } else if (random == 6) //1shot
        {
            //set value
        }
    }


}

