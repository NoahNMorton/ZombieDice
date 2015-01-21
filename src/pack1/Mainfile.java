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
        ZombieDiceBucket zdb = new ZombieDiceBucket();
        zdb.loadBucket();
        //todo play game >might need slight help

        while (true) {
            for (int i = 0; i < playersAmt; i++) { //turn incrementer
                int totalPoints = 0; //points to be added to the player at end of turn.
                boolean turnSuccess = false;

                while (!turnSuccess) { //while loop will exit at the end of player's turn, if appropriate action was taken.
                    String currentPlayer = playerNames[i]; //the player with the current turn
                    System.out.println("Total brains accumulated: " + totalPoints);
                    System.out.println("Player " + currentPlayer + ", Would you like to roll(0), or stop(1)?");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0: //roll die, and add points to player score. todo >help
                            ZombieDie tempDie1 = zdb.draw();
                            ZombieDie tempDie2 = zdb.draw();

                            switch (tempDie1.getDieColour()) { //roll of the first die
                                case ZombieDie.RED: //if the die is red
                                    tempDie1.roll();
                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }
                                    break;
                                case ZombieDie.GREEN: //if the die is green
                                    tempDie1.roll();
                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }
                                    break;
                                case ZombieDie.YELLOW: //if the die is yellow
                                    tempDie1.roll();
                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }
                                    break;
                            }
                            switch (tempDie2.getDieColour()) { //roll of the second die
                                case ZombieDie.RED:
                                    tempDie2.roll();
                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }

                                    break;
                                case ZombieDie.GREEN:
                                    tempDie2.roll();

                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }
                                    break;
                                case ZombieDie.YELLOW:
                                    tempDie2.roll();

                                    if (tempDie1.getValue() == ZombieDie.BRAIN) { //if the rolled value is a brain, add points.
                                        totalPoints++;
                                    } else if (tempDie1.getValue() == ZombieDie.RUNNER) {

                                    } else if (tempDie1.getValue() == ZombieDie.SHOT) {
                                        turnSuccess = true;
                                        totalPoints = 0;
                                    }
                                    break;
                            }

                            break;
                        case 1: //exit and keep points.
                            playerScores[i] += totalPoints;
                            turnSuccess = true;
                        case 3: //secret cheat to view scores of current player
                            System.out.println("Player " + currentPlayer + " has a score of " + playerScores[i]);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a 0 or 1.");
                            break;
                    }
                }
                findWinner(playerNames, playerScores);

            }
        }
    }

    /**
     * Method to shuffle the provided array.
     * Note: Taken from previous lab, 100OrBust, modified by Tully
     *
     * @param array array to shuffle.
     */
    private static void shuffleNames(String[] array) {

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
    public static void findWinner(String[] playerNames, int[] playerScores) {
        //todo find winner if brains>=13, player has won
        for (int i = 0; i < playerNames.length; i++) {
            if (playerScores[i] >= 13) {
                System.out.println("Player " + playerNames[i] + " has won.");
                System.exit(0);
            }
        }

    }


}
