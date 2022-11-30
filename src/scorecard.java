import java.util.ArrayList;

public class scorecard 
{
    int player;
    ArrayList<Integer> scores = new ArrayList<>();

    scorecard()
    {

    }









    public ArrayList<String> setupPlayerCard(int players)
    {
        return null;
    }

    public void setupPlayerScores(int players)
    {
        for (int i = 0; i < players; i++)
            scores.add(0);
    }

    // change intial array to be able to read for the scorecard
    public ArrayList<String> changeInitialArr(ArrayList<String> list)
    {
        for (int i = 1; i <= 5; i++) 
        {
            String x  = String.valueOf(i);
            list.add(x);
        }
        String[] upperArr = {"3K", "4K", "FH", "SS", "LS", "YL", "C"};
        for (String name : upperArr)
        list.add(name);
        return list;
    }


















    // max of a kind function 
    public int maxOfAKindFound(int hand[])
    {
        int maxCount = 0;
        int currentCount;

        for (int dieVal = 1; dieVal <= 5+1; dieVal++)
        {
            currentCount = 0;
            for(int diePos = 0; diePos < 5; diePos++)
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
        
        for (int counter = 0; counter < 5-1; counter++)
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


        for (int dieVal = 1; dieVal <= 5+1; dieVal++)
        {
            currentCount = 0;
            for (int diePos = 0; diePos < 5; diePos++)
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





/*
 * making a list of list
 * 
 * something like an array of arrays in python
 * 
 * the 0 idx would store the total and the arry would then be of the 
 * items still in play for that player 
 * 
 * you could access it through indexing and co;ntain method and remove method built in
 * 
 * or you could also use a temp array for the current player when playing
 * 
 */