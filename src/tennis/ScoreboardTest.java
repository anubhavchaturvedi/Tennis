package tennis;

import junit.framework.TestCase;

/**
 * Created by test on 7/27/2015.
 */
public class ScoreboardTest extends TestCase {

        final String PLAYER_1 = "D";
        final String PLAYER_2 = "F";

    public void testIsDuce() throws Exception {
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

    public void testUpdateScore() throws Exception {

        System.out.println("updateScore");
        Scoreboard scoreboard = new Scoreboard();

        assertEquals( "love - love", scoreboard.currentScore());
        scoreboard.updateScore(PLAYER_1);
        assertEquals( "15 - love", scoreboard.currentScore());
    }

    public void testGameHasEnded() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        assertEquals(true, scoreboard.gameHasEnded());
    }

    public void testCurrentPlayerScore() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        assertEquals("15", scoreboard.currentPlayerScore(PLAYER_1));
    }

    public void testCurrentScore() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        assertEquals("15 - love", scoreboard.currentScore());
    }

    public void testScoreBoardLength() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        assertEquals(2, scoreboard.scoreBoardLength());
    }

}