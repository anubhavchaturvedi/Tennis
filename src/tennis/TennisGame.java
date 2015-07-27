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
            scoreBoard.updateScore(Character.toString(currentPoint));
        }

        System.out.println(scoreBoard.currentScore());

    }

}

