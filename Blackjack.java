
/*
 * Author: Sami Alrustom
 * Date: 04/05/2019
 * Purpose: This program is a game of Blackjack. The game is played between a dealer and a player. 
 * The player can have up to 4 hands. The player can hit or stand. The dealer must hit if the total of his cards is less than 17. 
 * The player wins if the total of his cards is greater than the total of the dealer's cards. 
 * The player loses if the total of his cards is less than the total of the dealer's cards. 
 * The player pushes if the total of his cards is equal to the total of the dealer's cards. 
 * The player loses if the total of his cards is greater than 21. The player wins if the total of the dealer's cards is greater than 21. 
 * The player loses if the total of the dealer's cards is equal to 21. The player loses if the total of his cards is equal to 21. 
 * The player loses if the total of his cards is less than 21. The player loses if the total of his cards is greater than 21. 
 * The player loses if the total of his cards is equal to 21.
 * CopyRight Protected
 * Version: 1.0
 */
import java.io.FileInputStream; //Java FileInputStream class obtains input bytes from a file. 
import java.io.FileNotFoundException; //Signals that an attempt to open the file denoted by a specified pathname has failed. This exception will be thrown by the FileInputStream , FileOutputStream , and RandomAccessFile constructors.
import java.io.FileOutputStream; // Java FileOutputStream class is an output stream for writing data to a File or to a FileDescriptor.
import java.io.IOException; //Java IOExceptions are Input/Output exceptions (I/O), and they occur whenever an input or output operation has failed.
import java.io.ObjectInputStream; //The Java ObjectInputStream class enables you to read Java objects from an InputStream instead of just raw bytes. 
import java.io.ObjectOutputStream; //An ObjectOutputStream class writes primitive data types and graphs of Java objects to an OutputStream.
import java.util.Scanner;

/**
 * Main program of the game of Blackjack
 */

public class Blackjack { // start class

    public static void main(String[] args) throws Exception { // Main

        BlackjackGame mygame = new BlackjackGame();

        mygame.initializeGame(); // declare game variables
        do {
            mygame.shuffle(); // shuffle the deck
            mygame.getBets(); // get the bets from players
            mygame.dealCards(); // dealer cards
            mygame.printStatus(); // print player status
            mygame.checkBlackjack(); // check for a winner
            mygame.hitOrStand(); // hit or stand
            mygame.dealerPlays(); // dealer plays
            mygame.settleBets(); // save the bets
            mygame.printMoney(); // print the money that the player have
            mygame.clearHands(); // clear the players and dealer's had
        } while (mygame.playAgain()); // play the game again
        // mygame.endGame();

        // The try statement allows you to define a block of code to be tested for
        // errors while it is being executed.
        // The catch statement allows you to define a block of code to be executed, if
        // an error occurs in the try block.

        // Test this block of code while runing the program
        try {
            FileOutputStream outObjectFile = new FileOutputStream("objOut", false);

            ObjectOutputStream outObjectStream = new ObjectOutputStream(outObjectFile);

            outObjectStream.writeObject(mygame);

            outObjectStream.flush();
            outObjectStream.close();
        } catch (FileNotFoundException fnfException) {
            System.out.println("No file"); // did not file in
        } catch (IOException ioException) {
            System.out.println("Thank you for playing!");
        }

        // Test this block of code while runing the program
        try {
            FileInputStream inObjectFile = new FileInputStream("objOut");

            ObjectInputStream inObjectStream = new ObjectInputStream(inObjectFile);

            Card myNewCard = (Card) inObjectStream.readObject();

            System.out.println(myNewCard);

        } catch (FileNotFoundException fnfException) {
            System.out.println("No File"); // did not file in
        } catch (IOException ioException) {
            System.out.println("See you in the next game!");
        }

        catch (ClassNotFoundException cnfException) {
            System.out.println("This is not a Card."); // The card is not in the game
        }

    }

} // End class