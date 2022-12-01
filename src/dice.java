import java.util.Random;

/*
* This program computes the dice class for our Yahtzee gui
* CPSC 224, Fall 2022
* Programming Assignment Final Prj
* 
* @author Louis Cerda
* @version v1.0 11/21/22
*/

// class returns random roll as a string
// turns and all of that
// total dice
// 

public class dice
{
    int dice;
    dice()
    {
    }


    public String rollDice()
    {
        Random randy = new Random();
        int roll = randy.nextInt(6 - 1 + 1) % 6 + 1;
        String name = String.valueOf(roll);
        return name; // sides number of one
    }

    // totals the dice from hand
    public int totalAllDice(int hand[])
    {
        int total = 0;
        for (int diePos = 0; diePos < 5; diePos++)
            total += hand[diePos];
        return total;
    } 




    // max of a kind function 
    public int maxOfAKindFound(int hand[])
    {
        int maxCount = 0;
        int currentCount;

        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for(int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }




    // max straight function
    public int maxStraightFound(int hand[])
    {
        int maxLen = 1;
        int curLen = 1;
        
        for (int counter = 0; counter < dice-1; counter++)
        {
            if (hand[counter] + 1 == hand[counter + 1])
                curLen++;
            else if (hand[counter] + 1 < hand[counter + 1])
                curLen = 1;
            if (curLen > maxLen)
                maxLen = curLen;
        }
        return maxLen;
    }




    // full house functuon
    public boolean fullHouseFound(int hand[])
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;


        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K == true && found3K == true)
            return true;
        return foundFH;
    }
}

