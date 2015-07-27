package tennis;

import java.util.Scanner;

/**
 * Created by test on 7/27/2015.
 */
public class TennisGame {
    
    static final String PLAYER_1 = "D";
    static final String PLAYER_2 = "F";

    public static  void main(String args[]) {
        Scoreboard board = new Scoreboard(PLAYER_1, PLAYER_2);
        
        Scanner scan = new Scanner(System.in);
        
        while(!board.gameHasEnded()) {
            String player = scan.nextInt() == 1 ? "D" : "F";
            board.updateScore(player);
        }

        
        System.out.println("Scoreboard");
        System.out.println("-------------");
        board.displayScoreboard();

    }

}

