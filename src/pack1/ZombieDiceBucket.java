package pack1;


import java.util.ArrayList;

public class ZombieDiceBucket {
    ArrayList<ZombieDie> dice;

    public ZombieDiceBucket() {
        this.dice = new ArrayList<ZombieDie>();
    }

    void loadBucket() {
        //Clears dice and then loads 6 green dice, 4 yellow dice and 3 red dice.
        dice.clear();

        dice.add(new RedZombieDie(ZombieDie.RED));
        dice.add(new RedZombieDie(ZombieDie.RED));
        dice.add(new RedZombieDie(ZombieDie.RED));

        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));

        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));

    }

    ZombieDie draw() {
        if (dice.size() != 0)
            return dice.remove((int) (Math.random() * dice.size()));
        else
            return null;
        //Removes and returns 1 random die or null when the bucket is empty.
    }


}
