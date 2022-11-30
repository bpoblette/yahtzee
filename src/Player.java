
public class Player
{
    //String username;
    int playerNum;
    ScoreCard playerList[] = new ScoreCard[playerNum];
    Player()
    {
        this.playerNum = 0;
    }

    /* 
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return this.username;
    }
    */

    public void setPlayerNum(int playerNum)
    {
        this.playerNum = playerNum;
    }

    public int getPlayerNum()
    {
        return this.playerNum;
    }

    public void addNewPlayer()
    {
        playerList[playerNum] = new ScoreCard();
    }
}