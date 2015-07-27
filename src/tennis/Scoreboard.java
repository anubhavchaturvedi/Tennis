package tennis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Scoreboard {
    private ArrayList<String> player1State;
    private ArrayList<String> player2State;
    private String player1name;
    private String player2name;
    private static HashMap<String, String> scores;
    
    private int scoreboardLastIndex;
    
    Scoreboard(){
        player1name = "D";
        player2name = "F";
        player1State = new ArrayList<String>();
        player2State = new ArrayList<String>();
        player1State.add("love");
        player2State.add("love");
        scoreboardLastIndex = player1State.size() - 1;
        
        scores = new HashMap<String, String>();
        scores.put("love", "15");
        scores.put("15", "30");
        scores.put("30", "40");
        scores.put("40", "A");
        scores.put("A", "game");
    }
    
    public boolean isDuce(){
        return currentPlayerScore(player1name) == "40" && currentPlayerScore(player2name) == "40";
    }
    
    boolean updateScore(String playerScored) {
        if ( gameHasEnded() ) {
            return false;
        }
        
        String player1_currentScore = currentPlayerScore(player1name);
        String player2_currentScore = currentPlayerScore(player2name);
        
        boolean duceCancelled = ( playerScored == player2name && player1_currentScore == "A" ) ||
                ( playerScored == player1name && player2_currentScore == "A" );
        
        if ( duceCancelled ) {
            player1State.add("40");
            player2State.add("40");
            scoreboardLastIndex++;
            return true;
        }
        
        if ( playerScored == player1name ) {
            player1State.add(scores.get(player1_currentScore));
            player2State.add(player2_currentScore);
            scoreboardLastIndex++;
        }
        else {
            player1State.add(player1_currentScore);
            player2State.add(scores.get(player2_currentScore));
            scoreboardLastIndex++;
        }
        return true;
    }
        
    boolean gameHasEnded() {
        return player1State.get(scoreboardLastIndex) == "game" ||
                player2State.get(scoreboardLastIndex) == "game";
    }
    
    String currentPlayerScore(String player) {
        if ( player == player1name ) {
            return player1State.get(scoreboardLastIndex);
        }
        else {
            return player2State.get(scoreboardLastIndex);
        }
    }
    
    public String currentScore() {
        return currentPlayerScore(player1name) + " - " + currentPlayerScore(player2name);
    }

    int scoreBoardLength(){
        return scoreboardLastIndex + 1 ;
    }

    public void displayScoreboard(){
        displayScore(player1State);
        displayScore(player2State);
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
            System.out.println(board.currentPlayerScore("D") + "," + board.currentPlayerScore("F"));
        }
    }
}
