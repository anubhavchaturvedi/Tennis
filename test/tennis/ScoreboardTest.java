package tennis;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreboardTest {
    final String PLAYER_1 = "D";
    final String PLAYER_2 = "F";
    
    public ScoreboardTest() {
    }
    
    /**
     * Test of isDuce method, of class Scoreboard.
     */
    @Test
    public void testIsDuce() {
        System.out.println("isDuce");
        Scoreboard instance = new Scoreboard();
        
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_1);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_2);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_1);
        instance.updateScore(PLAYER_1);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_2);
        instance.updateScore(PLAYER_2);
        assertEquals(true, instance.isDuce());
        instance.updateScore(PLAYER_2);
        assertEquals(false, instance.isDuce());
    }

    /**
     * Test of updateScore method, of class Scoreboard.
     */
    @Test
    public void testUpdateScore() {
        System.out.println("updateScore");
        Scoreboard scoreboard = new Scoreboard();
        
        assertEquals( "love - love", scoreboard.currentScore());
        scoreboard.updateScore(PLAYER_1);
        assertEquals( "15 - love", scoreboard.currentScore());
        
    }

    /**
     * Test of gameHasEnded method, of class Scoreboard.
     */
    @Test
    public void testGameHasEnded() {
        System.out.println("gameHasEnded");
        

    /**
     * Test of currentPlayerScore method, of class Scoreboard.
     */
    @Test
    public void testCurrentPlayerScore() {
        System.out.println("currentPlayerScore");
        
    }

    /**
     * Test of currentScore method, of class Scoreboard.
     */
    @Test
    public void testCurrentScore() {
        System.out.println("currentScore");
        
    }

    /**
     * Test of scoreBoardLength method, of class Scoreboard.
     */
    @Test
    public void testScoreBoardLength() {
        System.out.println("scoreBoardLength");
        
    }

    /**
     * Test of displayScoreboard method, of class Scoreboard.
     */
    @Test
    public void testDisplayScoreboard() {
        System.out.println("displayScoreboard");
        
    }

    /**
     * Test of displayScore method, of class Scoreboard.
     */
    @Test
    public void testDisplayScore() {
        System.out.println("displayScore");
        
    }
}
