package tennis;

import java.util.Scanner;

/**
 * Created by test on 7/27/2015.
 */
public class TennisGame {

    public static  void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Input \n");
        String gameString = input.nextLine();

        char [] gameState = gameString.toCharArray();
        Scoreboard scoreBoard = new Scoreboard();

        for (char currentPoint: gameState) {
            int player = Integer.parseInt(Character.toString(currentPoint).trim());
            String playerScored = player == 1 ? "D" : "F";
            scoreBoard.updateScore(playerScored);
            System.out.println(currentPoint + " " + scoreBoard.currentPlayerScore("D") + "," + scoreBoard.currentPlayerScore("F"));
        }

        System.out.println("Current score is ::"+scoreBoard.currentScore());
        
        System.out.println("Scoreboard");
        System.out.println("-------------");
        scoreBoard.displayScoreboard();

    }

}

