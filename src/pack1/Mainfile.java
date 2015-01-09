package pack1;


import java.util.Scanner;

public class Mainfile {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount of players. 2-5");
        int playersAmt = input.nextInt();
        if (playersAmt < 2) playersAmt = 2; //set upwards if below threshold.
        if (playersAmt > 5) playersAmt = 5; //set downwards if above threshold.

        String[] playerNames = new String[playersAmt]; //create the arrays of names and scores.
        int[] playerScores = new int[playersAmt];

        for (int e = 0; e < playersAmt; e++) { //receive all players' names.
            System.out.println("Please enter the name for player " + e);
            playerNames[e] = input.next();
        }
        shuffleNames(playerNames); //call shuffle to shuffle names.

    }

    /**
     * Method to shuffle the provided array.
     * Note: Taken from previous lab, 100OrBust
     *
     * @param array array to shuffle.
     */
    public static void shuffleNames(String[] array) {
        String[] temp1 = new String[1]; //todo not actually changing the global array >help
        String[] temp2 = new String[1];
        for (int y = 0; y < 10; y++) {
            int random1 = (int) (Math.random() * array.length);
            int random2 = (int) (Math.random() * array.length);
            temp1[0] = array[random1];
            temp2[0] = array[random2];
            array[random1] = temp1[0];
            array[random2] = temp2[0];
        }
    }


    public void findWinner() {
        //todo find winner
        //Returns a String containing the name of the winning player or null if there is no winner yet.
    }


}
