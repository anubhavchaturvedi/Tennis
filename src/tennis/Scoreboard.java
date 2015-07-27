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
        return currentPlayerScore(player1name) == "40" && currentPlayerScore(player2name) == "40";
    }
    
    boolean updateScore(String playerScored) {
        if ( gameHasEnded() ) {
            return false;
        }
        
        String player1_currentScore = currentPlayerScore(player1name);
        String player2_currentScore = currentPlayerScore(player2name);
        
        boolean player1_reached40 = reached40(player1name);
        boolean player2_reached40 = reached40(player2name);
        
        if ( playerScored == player1name ) {
            if ( !player2_reached40 ) {
                if( player1_reached40 ) {
                    player1.add("game");
                    player2.add(player2_currentScore);
                }
                else {
                    player1.add(scores.get(player1_currentScore));
                    player2.add(player2_currentScore);
                }
            }
            else {
                if( player1_reached40 ) {
                    if ( player2_currentScore == "A" ) {
                        player1.add("40");
                        player2.add("40");
                    }
                    else {
                        player1.add(scores.get(player1_currentScore));
                        player2.add(player2_currentScore);
                    }
                }
                else {
                    if ( player2_currentScore == "A" ) {
                        player1.add(scores.get(player1_currentScore));
                        player2.add("40");
                    }
                    else {
                        player1.add(scores.get(player1_currentScore));
                        player2.add(player2_currentScore);
                    }
                }
            }
        }
        else {
            if ( !player1_reached40 ) {
                if( player2_reached40 ) {
                    player2.add("game");
                    player1.add(player1_currentScore);
                }
                else {
                    player2.add(scores.get(player2_currentScore));
                    player1.add(player1_currentScore);
                }
            }
            else {
                if( player2_reached40 ) {
                    if ( player1_currentScore == "A" ) {
                        player2.add("40");
                        player1.add("40");
                    }
                    else {
                        player2.add(scores.get(player2_currentScore));
                        player1.add(player1_currentScore);
                    }
                }
                else {
                    if ( player1_currentScore == "A" ) {
                        player2.add(scores.get(player2_currentScore));
                        player1.add("40");
                    }
                    else {
                        player2.add(scores.get(player2_currentScore));
                        player1.add(player1_currentScore);
                    }
                }
            }
        }
        
        scoreboardLastIndex++;
        return true;
    }
        
    private boolean reached40(String player) {
        String currentScore = currentPlayerScore(player);
        return currentScore == "40" || currentScore == "A" || currentScore == "game";
    }
    
    boolean gameHasEnded() {
        return player1.get(scoreboardLastIndex) == "game" ||
                player2.get(scoreboardLastIndex) == "game";
    }
    
    String currentPlayerScore(String player) {
        if ( player == player1name ) {
            return player1.get(scoreboardLastIndex);
        }
        else {
            return player2.get(scoreboardLastIndex);
        }
    }
    
    public String currentScore() {
        return currentPlayerScore(player1name) + " - " + currentPlayerScore(player2name);
    }

    int scoreBoardLength(){
        return scoreboardLastIndex + 1 ;
    }

    public void displayScoreboard(){
        displayScore(player1);
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
            System.out.println(board.currentScore());
        }
    }
}
