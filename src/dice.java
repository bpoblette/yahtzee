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
}

