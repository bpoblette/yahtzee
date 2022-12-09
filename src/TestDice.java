import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.ArrayList;
import javax.swing.*;

public class TestDice 
{
    @Test
    public void testTotalAllDice()
    {
        // new dice object
        dice testDice = new dice();
        int hand[] = new int[5];
        int temp;

        // sets the total of a hand of die
        for(int i = 1; i <=5; i++)
        {
            hand[i-1] = i;
        }
        temp = testDice.totalAllDice(hand);

        // check that the total of all the die is 15
        assertTrue(temp == 15);
    }

    @Test
    public void testFullHouse()
    {
        // new dice object
        dice testDice = new dice();
        int hand[] = new int[5];

        hand[0] = 1;
        hand[1] = 1;
        hand[2] = 2;
        hand[3] = 2;
        hand[4] = 2;


        // sets hand to a full house
        boolean temp = testDice.fullHouseFound(hand);

        // checks that found full house was true
        assertTrue(temp == true);
    }

    @Test
    public void testMaxOfAKind()
    {
        // new dice object
        dice testDice = new dice();
        int hand[] = new int[5];

        hand[0] = 1;
        hand[1] = 1;
        hand[2] = 3;
        hand[3] = 2;
        hand[4] = 5;
        // sets hand
        int temp = testDice.maxOfAKindFound(hand);

        // checks that the max count is 2
        assertTrue(temp == 2);
    }

    @Test
    public void testMaxStraightFound()
    {
        // new dice object
        dice testDice = new dice();
        int hand[] = new int[5];

        hand[0] = 1;
        hand[1] = 2;
        hand[2] = 3;
        hand[3] = 4;
        hand[4] = 2;

        // sets hand equal to a small straight
        int temp = testDice.maxStraightFound(hand);

        // asserts that the max straight possible is 4
        assertTrue(temp == 4);
    }

    @Test
    public void testMaxStraightFoundWithUnsortedList()
    {
        // new dice object
        dice testDice = new dice();
        int hand[] = new int[5];

        hand[0] = 2;
        hand[1] = 1;
        hand[2] = 3;
        hand[3] = 4;
        hand[4] = 1;
        testDice.sortArray(hand, 5);
        // sets hand equal to a small straight
        int temp = testDice.maxStraightFound(hand);

        //asserts that the max straight possible is 4
        assertTrue(temp == 4);
    }

    // @Test
    // public void testRerollSelected()
    // {
    //     // new dice object
    //     dice testDice = new dice();
    //     ArrayList<String> temp = new ArrayList<String>();
    //     temp.add("1");
  

    //     JButton dice1Button;
        
    //     boolean flag = testDice.rerollSelected(temp, dice1Button);

    //     assertTrue(flag == true);
    // }
} 
