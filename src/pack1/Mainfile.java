package pack1;


import java.util.ArrayList;
import java.util.Scanner;

public class Mainfile {

    public static void main(String[] args) {

        Scanner input = null;
        int playersAmt = 0;
        boolean argValid = false;

        while (true) {
            try {
                input = new Scanner(System.in);
                System.out.println("Please enter the amount of players. 2-5");
                playersAmt = input.nextInt();
                if (playersAmt < 2) playersAmt = 2; //set upwards if below threshold.
                if (playersAmt > 5) playersAmt = 5; //set downwards if above threshold.
                break;
            } catch (Exception e) {
                System.err.println("Error. Please only enter an integer.");
            }
        }

        String[] playerNames = new String[playersAmt]; //create the arrays of names and scores.
        int[] playerScores = new int[playersAmt];

        try {
            if (args[0] != null && args[1] != null) { //tries to receive names from args
                playerNames[0] = args[0];
                playerNames[1] = args[1];
                argValid = true;
                if (playersAmt > 2)
                    System.err.println("Warning: Playing with more than 2 players in test mode, \nThings may not work.");
            }
        } catch (Exception ignored) { //if args are not valid, simply skip them
        }


        if (!argValid) { //if args are not valid, will get names from user
            for (int e = 0; e < playersAmt; e++) { //receive all players' names.
                System.out.println("Please enter the name for player " + e);
                playerNames[e] = input.next();
            }
        }

        shuffleNames(playerNames); //call shuffle to shuffle names.
        ZombieDiceBucket zdb = new ZombieDiceBucket();
        zdb.loadBucket();
        ArrayList<ZombieDie> rolledDice = new ArrayList<ZombieDie>(); //the rolled dice array, holds all the dice that are on the figurative "table"
        ArrayList<ZombieDie> runners = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> shots = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> brains = new ArrayList<ZombieDie>();

        //noinspection InfiniteLoopStatement
        while (true) {

            for (int i = 0; i < playersAmt; i++) { //turn incrementer

                int tempBrains = 0; //points to be added to the player at end of turn.
                boolean turnSuccess = false;

                //clear all arrayLists after turn.
                runners.clear();
                shots.clear();
                rolledDice.clear();
                brains.clear();
                zdb.loadBucket();
                while (!turnSuccess) { //while loop will exit at the end of player's turn, if appropriate action was taken.
                    zdb.loadBucket();

                    System.out.println("Total brains accumulated: " + tempBrains);
                    System.out.println("Player " + playerNames[i] + ", Would you like to roll(0), or stop(1)?");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0: //roll die, and add points to player score.

                            //gather dice
                            if (runners.size() > 0) {
                                rerollDice(rolledDice, runners); //reroll dice in runners

                            } else {
                                if (zdb.draw() != null) //if dice bucket is not empty
                                    while (rolledDice.size() < 3) {
                                        rolledDice.add(zdb.draw());
                                    }
                            }
                            //check what the rolled values are.
                            for (ZombieDie aRolledDice : rolledDice) aRolledDice.roll(); //roll all dice

                            for (int p = 0; p < rolledDice.size(); p++) {
                                switch (rolledDice.get(p).getValue()) {
                                    case ZombieDie.BRAIN: //value 2
                                        brains.add(rolledDice.remove(p));
                                        p--;
                                        tempBrains = brains.size();
                                        break;
                                    case ZombieDie.SHOT: //value 3
                                        shots.add(rolledDice.remove(p)); //transfer die from rolledDice to shots
                                        p--;
                                        if (shots.size() >= 3) { //if 3 shots have accumulated
                                            tempBrains = 0;
                                            brains.clear();
                                            turnSuccess = true;
                                            System.out.println("\n\n\n\nIt seems you got shot 3 times, ending your turn. Sorry mate.");
                                        }
                                        break;
                                    case ZombieDie.RUNNER: //value 1
                                        runners.add(rolledDice.remove(p)); //add rolled runner to runner arrayList
                                        p--;
                                        break;
                                }
                            }
                            System.out.println("Turn Summary:");
                            System.out.println("Runners:");
                            System.out.println(runners);
                            System.out.println("Brains:");
                            System.out.println(brains);
                            System.out.println("Shots:");
                            System.out.println(shots);

                            break;
                        case 1: //exit and keep points.
                            playerScores[i] += tempBrains;
                            turnSuccess = true;
                            break;
                        case 3: //secret cheat to view scores of current player
                            System.out.println("Player " + playerNames[i] + " has a score of " + playerScores[i]);
                            break;
                        default:
                            System.err.println("Invalid choice. Please enter a 0 or 1.");
                            break;
                    }
                }
                findWinner(playerNames, playerScores); //call findWinner to find the winner and end the program.
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
     *
     * @param playerNames  arrayList of player names
     * @param playerScores arrayList of player scores
     */
    public static void findWinner(String[] playerNames, int[] playerScores) {
        for (int i = 0; i < playerNames.length; i++) {
            if (playerScores[i] >= 13) {
                System.out.println("Player " + playerNames[i] + " has won.");
                System.exit(0);
            }
        }

    }

    /**
     * Method to reroll the arrayList of runners.
     *
     * @param dice    the main arrayList of rolledDice.
     * @param runners the array of runners.
     */
    public static void rerollDice(ArrayList<ZombieDie> dice, ArrayList<ZombieDie> runners) {

        for (int i = 0; i < runners.size(); i++) { //go through runners, roll each, and transfer back to dice
            runners.get(i).roll();
            dice.add(runners.remove(i));
        }
    }


}
