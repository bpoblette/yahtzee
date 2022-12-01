import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestDice 
{
    @Test
    public void testTotalAllDice()
    {
        // new dice object
        dice testDice = new dice();

        // sets the total of a hand of die
        int temp = testDice.totalAllDice(5, 4, 3, 2, 1);

        // check that the total of all the die is 15
        assertTrue(temp == 15);
    }

    @Test
    public void testFullHouse()
    {
        // new dice object
        dice testDice = new dice();

        // sets hand to a full house
        int temp = testDice.fullHouseFound(1, 1, 2, 2, 2);

        // checks that found full house was true
        assertTrue(foundFH == true);
    }

    @Test
    public void testMaxOfAKind()
    {
        // new dice object
        dice testDice = new dice();

        // sets hand
        int temp = testDice.maxOfAKindFound(1, 1, 3, 2, 5);

        // checks that the max count is 2
        assertTrue(maxCount == 2);
    }

    @Test
    public void testMaxStraightFound()
    {
        // new dice object
        dice testDice = new dice();

        // sets hand equal to a small straight
        int temp = testDice.maxStraightFound(1, 2, 3, 4, 2);

        // asserts that the max straight possible is 4
        assertTrue(maxLen == 4);
    }

    @Test
    public void testRerollSelected()
    {
        // new dice object
        dice testDice = new dice();
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("1");
        Hand hand;

        JButton dice1Button;
        
        boolean flag = testDice.rerollSelected(temp, dice1Button);

        assertTrue(flag == true);
    }
} 
