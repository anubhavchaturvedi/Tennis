/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;

/**
 *
 * @author test
 */
public class Scoreboard {
    private ArrayList<Integer> player1;
    private ArrayList<Integer> player2;
    private String player1name;
    private String player2name;
    
    Scoreboard(){
        player1name = "D";
        player2name = "F";
    }
    
    boolean updateScore(String playerScored) {
        
    }
    
    
    boolean hasGameEnded() {
        
    }
    
    public String currentScore() {
        String score="";
        int length=scoreBoardLength();
        score+=player1.indexOf(length-1);
        score+=" - ";
        score+=player2.indexOf(length-1);
        return score;
    }

    int scoreBoardLength(){
        return player1.size();
    }

    public void displayScoreboard(){
        displayScore(player1);
        for(int i=0;i<scoreBoardLength();i++){
            System.out.print("--"+ " ");
        }
        displayScore(player2);
    }

    public void displayScore(ArrayList<Integer> player){
        for(int i=0;i<player.size();i++){
            System.out.print(player.get(i)+" | ");
        }
        System.out.println();
    }
    
}
