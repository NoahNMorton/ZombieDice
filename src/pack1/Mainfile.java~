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
        ZombieDiceBucket zdb = new ZombieDiceBucket(); //todo what name and colour?
        zdb.loadBucket();
        //todo play game

        while (true) {
            for (int i = 0; i < playersAmt; i++) { //turn incrementer
                int totalPoints = 0; //points to be added to the player at end of turn.
                boolean turnSuccess = false;
                while (!turnSuccess) {
                    String currentPlayer = playerNames[i]; //the player with the current turn
                    System.out.println("Total points accumulated: " + totalPoints);
                    System.out.println("Player " + currentPlayer + ", Would you like to roll(0), or stop(1)?");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0:
                            //todo roll die, and add points to player score.
                            zdb.draw().getDieColour();
                            //maybe write ifs to check colour of draw, then run roll method of respective die
                            break;
                        case 1: //exit and keep points.

                            break;
                        case 3: //secret cheat to view scores of current player
                            System.out.println("Player " + currentPlayer + " has a score of " + playerScores[i]);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a 0 or 1.");
                            break;
                    }
                }
                /*if (findWinner(playerNames, playerScores) != null) {
                    System.out.println("Player " + findWinner(playerNames, playerScores) + " has won. Congrats!");
                    System.out.println("Everyone's scores are as follows. ");
                    //finalResults(playerNames, playerScores);
                    System.exit(0);
                }*/
            }

        }
    }

    /**
     * Method to shuffle the provided array.
     * Note: Taken from previous lab, 100OrBust
     *
     * @param array array to shuffle.
     */
    public static void shuffleNames(String[] array) {

        for (int y = 0; y < 100; y++) {
            int random1 = (int) (Math.random() * array.length);
            int random2 = (int) (Math.random() * array.length);

            String t = array[random1];
            array[random1] = array[random2];
            array[random2] = t;
        }
    }

    /**
     * Method to find the winner of the game.
     */
    public static void findWinner() {
        //todo find winner
        //Returns a String containing the name of the winning player or null if there is no winner yet.
    }


}
