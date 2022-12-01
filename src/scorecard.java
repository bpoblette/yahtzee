import java.util.ArrayList;

public class scorecard 
{
    // static int player;
    static ArrayList<Integer> scores = new ArrayList<>();
    static ArrayList<ArrayList<String>> scorecard = new ArrayList<ArrayList<String>>();



    scorecard()
    {
        setupPlayerScores(2);
        setupPlayerCard(2);
        System.out.println(scorecard);
        System.out.println(scores);
    }


    public static void main(String[] args) 
    {
    }



    public static ArrayList<String> getSpecScorecard(int cur)
    {
        return scorecard.get(cur);
    }



    public static int getSpecScore(int cur)
    {
        return scores.get(cur);
    }



    public static int updateScores (int curPlayer, int addedScore)
    {
        // int finalScore = Integer.parseInt(scores.get(curPlayer));
        // String finalScr = (finalScore + addedScore);
        // scores.set(addedScore, finalScr)

        // calcs the final score of prev score and new score being added
        int finalScore = scores.get(curPlayer) + addedScore;
        // sets the score
        scores.set(curPlayer, finalScore);
        System.out.println(scores);
        return finalScore;
    }


    // sets up the player card for the scoreboard
    public static void setupPlayerCard(int playersTotal)
    {
        // ArrayList<ArrayList<String> > scoreList = new ArrayList<ArrayList<String> >(playersTotal);

        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();
        ArrayList<String> a4 = new ArrayList<String>();
        ArrayList<String> a5 = new ArrayList<String>();
        ArrayList<String> a6 = new ArrayList<String>();
        ArrayList<String> a7 = new ArrayList<String>();
        ArrayList<String> a8 = new ArrayList<String>();


        a1 = changeInitialArr(a1);
        a2 = changeInitialArr(a2);
        a3 = changeInitialArr(a3);
        a4 = changeInitialArr(a4);
        a5 = changeInitialArr(a5);
        a5 = changeInitialArr(a6);
        a5 = changeInitialArr(a7);
        a5 = changeInitialArr(a8);


        scorecard.add(a1);
        scorecard.add(a2);
        scorecard.add(a3);
        scorecard.add(a4);
        scorecard.add(a5);
        scorecard.add(a6);
        scorecard.add(a7);
        scorecard.add(a8);





        // for (int i = 0; i < playersTotal; i++)
        //     scorecard.add(a1);
        // System.out.println(scoreList);
        // System.out.println(scoreList.get(currentplayer+1));//.get(currentplayer+1));

        // return scoreList;
    }



    // sets up the scores for all the players possible 
    public static void setupPlayerScores(int players)
    {
        for (int i = 0; i < players; i++)
            scores.add(0);
    }

    // change intial array to be able to read for the scorecard
    public static ArrayList<String> changeInitialArr(ArrayList<String> list)
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


    // public static void remove


















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
