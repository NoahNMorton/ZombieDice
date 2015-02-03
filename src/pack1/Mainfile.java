package pack1;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainfile {

    public static void main(String[] args) {

        Scanner input = null;
        int playersAmt = 0;
        try {
            input = new Scanner(System.in);
            System.out.println("Please enter the amount of players. 2-5");
            playersAmt = input.nextInt();
            if (playersAmt < 2) playersAmt = 2; //set upwards if below threshold.
            if (playersAmt > 5) playersAmt = 5; //set downwards if above threshold.
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error. Please only enter an integer.");
        }

        String[] playerNames = new String[playersAmt]; //create the arrays of names and scores.
        int[] playerScores = new int[playersAmt];

        for (int e = 0; e < playersAmt; e++) { //receive all players' names.
            System.out.println("Please enter the name for player " + e);
            playerNames[e] = input.next();
        }
        shuffleNames(playerNames); //call shuffle to shuffle names.
        ZombieDiceBucket zdb = new ZombieDiceBucket();
        zdb.loadBucket(); //todo should reload bucket after each turn?
        //todo play game >might need slight help
        ArrayList<ZombieDie> rolledDice = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> runners = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> shots = new ArrayList<ZombieDie>();

        while (true) {

            for (int i = 0; i < playersAmt; i++) { //turn incrementer

                int tempBrains = 0; //points to be added to the player at end of turn.
                boolean turnSuccess = false;

                //clear all arrayLists after turn. todo yes?
                runners.clear();
                shots.clear();
                rolledDice.clear();
                while (!turnSuccess) { //while loop will exit at the end of player's turn, if appropriate action was taken.
                    String currentPlayer = playerNames[i]; //the player with the current turn.
                    System.out.println("Total brains accumulated: " + tempBrains);
                    System.out.println("Player " + currentPlayer + ", Would you like to roll(0), or stop(1)?");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0: //roll die, and add points to player score. todo >help

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
                                        tempBrains++;
                                        break;
                                    case ZombieDie.SHOT: //value 3
                                        shots.add(rolledDice.remove(p));

                                        if (shots.size() >= 3) { //if 3 shots have accumulated
                                            tempBrains = 0;
                                            turnSuccess = true;
                                            JOptionPane.showMessageDialog(null, "Player has died. score reset");
                                            //after this, shots should clear itself, todo perhaps add back to rolledDice
                                        }
                                        break;
                                    case ZombieDie.RUNNER: //value 1
                                        runners.add(rolledDice.remove(p)); //add rolled runner to runner arrayList
                                        break;
                                }
                            }

                            break;
                        case 1: //exit and keep points.
                            playerScores[i] += tempBrains;
                            turnSuccess = true;
                            break;
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
