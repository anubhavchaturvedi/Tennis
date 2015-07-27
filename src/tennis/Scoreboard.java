package tennis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Scoreboard {
    private ArrayList<String> player1;
    private ArrayList<String> player2;
    private String player1name;
    private String player2name;
    private static HashMap<String, String> scores;
    
    private int scoreboardLastIndex;
    
    Scoreboard(){
        player1name = "D";
        player2name = "F";
        player1 = new ArrayList<String>();
        player2 = new ArrayList<String>();
        player1.add("love");
        player2.add("love");
        scoreboardLastIndex = player1.size() - 1;
        
        scores = new HashMap<String, String>();
        scores.put("love", "15");
        scores.put("15", "30");
        scores.put("30", "40");
        scores.put("40", "A");
        scores.put("A", "game");
    }
    
    public boolean isDuce(){
        return currentScore(player1name) == "40" && currentScore(player2name) == "40";
    }
    
    boolean updateScore(String playerScored) {
        if ( gameHasEnded() ) {
            return false;
        }
        
        String player1_currentScore = currentScore(player1name);
        String player2_currentScore = currentScore(player2name);
        
        boolean duceCancelled = ( playerScored == player2name && player1_currentScore == "A" ) ||
                ( playerScored == player1name && player2_currentScore == "A" );
        
        if ( duceCancelled ) {
            player1.add("40");
            player2.add("40");
            scoreboardLastIndex++;
            return true;
        }
        
        if ( playerScored == player1name ) {
            player1.add(scores.get(player1_currentScore));
            player2.add(player2_currentScore);
            scoreboardLastIndex++;
        }
        else {
            player1.add(player1_currentScore);
            player2.add(scores.get(player2_currentScore));
            scoreboardLastIndex++;
        }
        return true;
    }
        
    boolean gameHasEnded() {
        return player1.get(scoreboardLastIndex) == "game" || 
                player2.get(scoreboardLastIndex) == "game";
    }
    
    String currentScore(String player) {
        return player == player1name ? player1.get(scoreboardLastIndex) : 
                player2.get(scoreboardLastIndex);
    }
    
    public String currentScore() {
        return currentScore(player1name) + " - " + currentScore(player2name);
    }

    int scoreBoardLength(){
        return scoreboardLastIndex + 1 ;
    }

    public void displayScoreboard(){
        displayScore(player1);
        for(int i=0;i<scoreBoardLength();i++){
            System.out.print("--"+ " ");
        }
        displayScore(player2);
    }

    public void displayScore(ArrayList<String> player){
        for(int i=0;i<player.size();i++){
            System.out.print(player.get(i)+" | ");
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Scoreboard board = new Scoreboard();
        while ( !board.gameHasEnded() ) {
            String playerScored = scan.nextInt() == 1 ? "D" : "F";
            board.updateScore(playerScored);
            System.out.println( board.currentScore("D") + "," + board.currentScore("F"));
        }
    }
}
