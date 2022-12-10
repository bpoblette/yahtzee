import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayList;
import javax.swing.*;

public class testScorecard 
{
   
    @Test
    public void testCheckGameOver()
    {
        
        //test value
        boolean y = true;
        int x = 0;
        //if statement to check checkGameOver is working correctly 
        //by finding the opposite result of checkGameOver,
        //since the game shoulnd't be over as its a new scorecard
        if(y != scorecard.checkGameOver())
            x = 1;
        else
            x = 0;

        assertTrue(x == 1);

    }

    @Test
    public void testUpdateScores()
    {
        
        //test function, set value to output
        int x = scorecard.updateScores(1, 5);

        //assert if true
        assertTrue(x == 5);
        
    }

    @Test
    public void testScoreRanking()
    {
        //create array list to put into max
        ArrayList<Integer> test = new ArrayList();

        //fill list with values to test
        test.add(30);
        test.add(20);
        test.add(5);

        //set max to created array list
        scorecard.scoreRanking();
        scorecard.Collections.max(test);

        //check if highest score is in first index
        assertTrue(scorecard.rankedScores.indexOf(30) == 0);
        
    }

    @Test
    public void testChangeInitialArr()
    {
        //create ArrayList to test
        ArrayList<String> testArr = new ArrayList<>();

        //run function on test ArrayList
        scorecard.changeInitialArr(testArr);

        //test if correct value is at correct index within test ArrayList
        assertTrue(testArr.indexOf(1) == 0);
    }


}