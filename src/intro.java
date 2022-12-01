/*
* This program computes the gui for Yahtzee
* CPSC 224, Fall 2022
* Programming Assignment #5
* 
* @author Louis Cerda
* @version v1.0 11/13/22
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class intro implements ActionListener
{
    JButton startBut, next, nextPlayer, rollDice, scoreShow, scoreHide,  menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, 
    menuItem3K, menuItem4K, menuItemFH, menuItemSS, menuItemLS,menuItemYL, menuItemC, 
    dice1Button, dice2Button,dice3Button,dice4Button,dice5Button, nextPlayerUp;

    JLabel topLabel, midLabel, label3, label4, label5, label6, diceImage1, diceImage2, 
        diceImage3, diceImage4, diceImage5, displayScore; 

    JPanel topPanel, midPanel, lowPanel;

    JComboBox<String> drpDwnDice, drpDwnSides;
    JCheckBoxMenuItem cbMenuItemScore;
    String[] diceOpts = {"1", "2", "3", "4", "5", "6", "7", "8"};




    // ArrayList<String> upperLowerArr = new ArrayList<String>();
    ArrayList<String> rerolledDice = new ArrayList<>();
    ArrayList<String> currentScorecard;


    // flags for start of game

    int dice = 5;
    int sides = 6;
    int player = 1;
    int[] hand = new int[5];  
    int totalScore = 0;
    int curenetPlayer = 1;

    scorecard scoreClass = new scorecard();
    dice diceClass = new dice();

    


    intro(){
        // creating a jframe and setting it to visible and creating a close button
        JFrame frame = new JFrame();
        frame.setLayout(null); 
        frame.setTitle("YAHTZEE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600); //setting size
        frame.setLocationRelativeTo(null); // putting it in the middle 




        // creating a drop down menu for dice
        drpDwnDice = new JComboBox<String>(diceOpts);
        drpDwnDice.addActionListener(this);

        // creating a drop down menu



        // creating a panel
        topPanel = new JPanel();
        midPanel = new JPanel();
        // lowPanel = new JPanel();
        topPanel.setBackground(new Color(75, 75, 75)); // setting color of background panel
        topPanel.setBounds(0, 0, 600, 270);

        midPanel.setBackground(new Color(75, 75, 75)); 
        midPanel.setBounds(0, 270 , 600, 330);



        topPanel.setLayout(null);





        menuItem1 = new JButton();
        menuItem1.setText("");
        menuItem1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem1.setBounds(300,125,200,50);
        menuItem1.addActionListener(this);
        
        menuItem2 = new JButton();
        menuItem2.setText("");
        menuItem2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem2.setBounds(300,175,200,50);
        menuItem2.addActionListener(this);
        
        menuItem3 = new JButton();
        menuItem3.setText("");
        menuItem3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem3.setBounds(300,225,200,50);
        menuItem3.addActionListener(this);
        
        menuItem4 = new JButton();
        menuItem4.setText("");
        menuItem4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem4.setBounds(300,275,200,50);
        menuItem4.addActionListener(this);
         
        menuItem5 = new JButton();
        menuItem5.setText("");
        menuItem5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem5.setBounds(300,325,200,50);
        menuItem5.addActionListener(this);
        
        menuItem3K = new JButton();
        menuItem3K.setText("");
        menuItem3K.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem3K.setBounds(500,125,200,50);
        menuItem3K.addActionListener(this);
        
        menuItem4K = new JButton();
        menuItem4K.setText("");
        menuItem4K.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem4K.setBounds(500,175,200,50);
        menuItem4K.addActionListener(this);
        
        menuItemFH = new JButton();
        menuItemFH.setText("");
        menuItemFH.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemFH.setBounds(500,225,200,50);
        menuItemFH.addActionListener(this);
        
        menuItemSS = new JButton();
        menuItemSS.setText("");
        menuItemSS.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemSS.setBounds(500,275,200,50);
        menuItemSS.addActionListener(this);

        menuItemLS = new JButton();
        menuItemLS.setText("");
        menuItemLS.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemLS.setBounds(500,275,200,50);
        menuItemLS.addActionListener(this);

        menuItemYL = new JButton();
        menuItemYL.setText("");
        menuItemYL.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemYL.setBounds(500,325,200,50);
        menuItemYL.addActionListener(this);
        
        menuItemC = new JButton();
        menuItemC.setText("");
        menuItemC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemC.setBounds(500,325,200,50);
        menuItemC.addActionListener(this);
                
        
        topPanel.add(menuItem1);
        topPanel.add(menuItem2);
        topPanel.add(menuItem3);
        topPanel.add(menuItem4);
        topPanel.add(menuItem5);
        topPanel.add(menuItem3K);
        topPanel.add(menuItem4k);
        topPanel.add(menuItemFH);
        topPanel.add(menuItemSS);
        topPanel.add(menuItemLS);
        topPanel.add(menuItemYL);
        topPanel.add(menuItemC);
      





 
        menuItem1.setVisible(false);
        menuItem2.setVisible(false);
        menuItem3.setVisible(false);

        




        dice1Button = new JButton(); 
        dice1Button.setText("");
        dice1Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice1Button.setBounds(10,150,75,75);
        dice1Button.addActionListener(this);
        topPanel.add(dice1Button);
        dice1Button.setVisible(false);

        dice2Button = new JButton(); 
        dice2Button.setText("");
        dice2Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice2Button.setBounds(95,150,75,75);
        dice2Button.addActionListener(this);
        topPanel.add(dice2Button);
        dice2Button.setVisible(false);

        dice3Button = new JButton(); 
        dice3Button.setText("");
        dice3Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice3Button.setBounds(180,150,75,75);
        dice3Button.addActionListener(this);
        topPanel.add(dice3Button);
        dice3Button.setVisible(false);

        dice4Button = new JButton(); 
        dice4Button.setText("");
        dice4Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice4Button.setBounds(265,150,75,75);
        dice4Button.addActionListener(this);
        topPanel.add(dice4Button);
        dice4Button.setVisible(false);

        dice5Button = new JButton(); 
        dice5Button.setText("");
        dice5Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice5Button.setBounds(350,150,75,75);
        dice5Button.addActionListener(this);
        topPanel.add(dice5Button);
        dice5Button.setVisible(false);






    



        // label welcome 
        topLabel = new JLabel();
        topLabel.setText("Welcome to Yahtzee!");
        topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        topLabel.setBounds(65,50,457,100);



        // middle label blank intially 
        midLabel = new JLabel();
        midLabel.setText("");
        midLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 3 blank intially 
        label3 = new JLabel();
        label3.setText("");
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 4 blank intially 
        label4 = new JLabel();
        label4.setText("");
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 30));





        // creating start button
        startBut = new JButton();//creating instance of JButton 
        startBut.setText("Start"); 
        startBut.setPreferredSize(new Dimension(200,50));
        startBut.addActionListener(this);
        startBut.setBackground(Color.lightGray);
        startBut.setOpaque(true);


        // creating exit button
        next = new JButton();//creating instance of JButton  
        next.setText("Next");
        next.setPreferredSize(new Dimension(200,50));
        next.addActionListener(this);
        next.setBackground(Color.lightGray);
        next.setOpaque(true);

        // creating next player button
        nextPlayer = new JButton();//creating instance of JButton  
        nextPlayer.setText("Reroll Highlighted Dice");
        nextPlayer.setPreferredSize(new Dimension(200,50));
        nextPlayer.addActionListener(this);
        nextPlayer.setBackground(Color.lightGray);
        nextPlayer.setOpaque(true);

        // creating next player button
        rollDice = new JButton();//creating instance of JButton  
        rollDice.setText("Roll All Dice");
        rollDice.setPreferredSize(new Dimension(200,50));
        rollDice.addActionListener(this);
        rollDice.setBackground(Color.lightGray);
        rollDice.setOpaque(true);

        // creating next player button
        scoreShow = new JButton();//creating instance of JButton  
        scoreShow.setText("Show Scorecard");
        scoreShow.setPreferredSize(new Dimension(200,50));
        scoreShow.addActionListener(this);
        scoreShow.setBackground(Color.lightGray);
        scoreShow.setOpaque(true);

        // creating next player button
        scoreHide = new JButton();//creating instance of JButton  
        scoreHide.setText("Hide Scorecard");
        scoreHide.setPreferredSize(new Dimension(200,50));
        scoreHide.addActionListener(this);
        scoreHide.setBackground(Color.lightGray);
        scoreHide.setOpaque(true);


        // creating next player button
        nextPlayerUp = new JButton();//creating instance of JButton  
        nextPlayerUp.setText("Next Player");
        nextPlayerUp.setPreferredSize(new Dimension(200,50));
        nextPlayerUp.addActionListener(this);
        nextPlayerUp.setBackground(Color.lightGray);
        nextPlayerUp.setOpaque(true);




        topPanel.add(topLabel);
        topPanel.add(label3);
        topPanel.add(label4);

        midPanel.add(midLabel);
        midPanel.add(startBut);
        topPanel.add(scoreHide);
        scoreHide.setBounds(375,500,150,50);
        scoreHide.setVisible(false);
        frame.add(topPanel);
        frame.add(midPanel);

        frame.setVisible(true);     
    }    







    public static void main(String[] args)
    {
        new intro();
    }







    // changing buttons and label text
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {   
        // changing the settings of the game to fit their needs
        if (e.getSource() == startBut)
        {
            topLabel.setText("How many players would you like to play with?");
            topLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));


            // setting bounds for labels that say dice and sides
            label3.setText("Players: ");
            label3.setBounds(150,100,120,100);




            // setting bounds for drop down menus
            drpDwnDice.setBounds(150,150,100,100);
            drpDwnDice.setVisible(true);
            topPanel.add(drpDwnDice);

            // drpDwnSides.setBounds(300,150,100,100);

            // topPanel.add(drpDwnSides);
            

            startBut.setVisible(false);
            next.setVisible(true);
            midPanel.add(next);
        }




        if (e.getSource() == next)
        {
            drpDwnDice.setVisible(false);
            next.setVisible(false);


            // dice buttons being set visible
            dice1Button.setVisible(true);
            dice2Button.setVisible(true);
            dice3Button.setVisible(true);
            dice4Button.setVisible(true);
            dice5Button.setVisible(true);



            next.setVisible(false);
            nextPlayer.setVisible(true);
            nextPlayerUp.setVisible(true);
            midPanel.add(nextPlayer);
            midPanel.add(nextPlayerUp);
            midPanel.add(rollDice);
            midPanel.add(scoreShow);

            label3.setText("");

            topLabel.setText("");

            topLabel.setText("Player: " + curenetPlayer);
            topLabel.setFont(null);
            topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));

            // upperLowerArr = scorecard.changeInitialArr(upperLowerArr);
            

            

        }



        // rerolls hgihlighted options whne clicked
        if (e.getSource() == nextPlayer)
        {
            // temp = scoreClass.getSpecScorecard(curenetPlayer - 1);
            diceClass.rerollSelected(currentScorecard, dice1Button, hand, dice2Button, dice3Button, dice4Button, dice5Button);
            unhighlight();
        }


        if (e.getSource() == nextPlayerUp)
        {
            curenetPlayer = (((curenetPlayer) % player) + 1);

            topLabel.setText("Player: " + curenetPlayer);

            currentScorecard = scorecard.getSpecScorecard(curenetPlayer);
        }





        if (e.getSource() == scoreShow)
        {
            currentScorecard = scorecard.getSpecScorecard(curenetPlayer - 1);
            System.out.println(currentScorecard);

            nextPlayer.setVisible(false);
            scoreShow.setVisible(false);
            rollDice.setVisible(false);
            scoreHide.setVisible(true);
            dice1Button.setVisible(false);
            dice2Button.setVisible(false);
            dice3Button.setVisible(false);
            dice4Button.setVisible(false);
            dice5Button.setVisible(false);



            topLabel.setText("Player " + curenetPlayer + " Scorecard");
            label3.setText("Total Score: " + scorecard.getSpecScore(curenetPlayer - 1));
            label3.setBounds(10,0,250,100);




            // showing scores 
            if (currentScorecard.contains("1"))
            {
                menuItem1.setVisible(true);

                int currentCount = 0;
                for (int diePos = 0; diePos < dice; diePos++)
                {
                    if (hand[diePos] == 1)
                        currentCount++;
                }
                menuItem1.setText("1 Score: " + 1*currentCount);
            }

            if (currentScorecard.contains("2"))
            {
                menuItem2.setVisible(true);

                int currentCount = 0;
                for (int diePos = 0; diePos < dice; diePos++)
                {
                    if (hand[diePos] == 2)
                        currentCount++;
                }
                menuItem2.setText("2 Score: " + 2*currentCount);
            }

            if (currentScorecard.contains("3"))
            {
                menuItem3.setVisible(true);

                int currentCount = 0;
                for (int diePos = 0; diePos < dice; diePos++)
                {
                    if (hand[diePos] == 3)
                        currentCount++;
                }
                menuItem3.setText("3 Score: " + 3*currentCount);
            }
            topPanel.setBounds(0,0,600,600);
        }




        // taking in each score if clicked on scorecard  
        // still need to fix

        if (e.getSource() == menuItem1)
        {

            // calc the score for menu item 1
            int currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == 1)
                    currentCount++;
            }
            // score to be added
            int temp = 1*currentCount;



            if(temp > 0)
            {
                menuItem1.setVisible(false);
                currentScorecard.remove("1");
                int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
                label3.setText("Total score: " + finalScore);


            }
        }

        if (e.getSource() == menuItem2)
        {
            int currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == 2)
                    currentCount++;
            }
            int temp = 2*currentCount;
            if(temp > 0)
            {
                int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
                label3.setText("Total score: " + finalScore);
                menuItem2.setVisible(false);
                currentScorecard.remove("2");
            }
        }

        if (e.getSource() == menuItem3)
        {
            int currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == 3)
                    currentCount++;
            }
            int temp = 3*currentCount;
            if(temp > 0)
            {
                int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
                label3.setText("Total score: " + finalScore);
                menuItem3.setVisible(false);
                currentScorecard.remove("3");
            }
        }




        if (e.getSource() == scoreHide)
        {
            unhighlight();
            topPanel.setBounds(0,0,600,270);
            scoreShow.setVisible(true);
            rollDice.setVisible(true);
            scoreHide.setVisible(false);
            topLabel.setText("Player: " + curenetPlayer);

            menuItem1.setVisible(false);
            menuItem2.setVisible(false);
            menuItem3.setVisible(false);
           

            dice1Button.setVisible(true);
            dice2Button.setVisible(true);
            dice3Button.setVisible(true);
            dice4Button.setVisible(true);
            dice5Button.setVisible(true);
            nextPlayer.setVisible(true);


            label3.setText("");
        }



        // function that rolls dice and updates the text on the button
        if (e.getSource() == rollDice)
        {  
            unhighlight();

            
            String dice1Roll = diceClass.rollDice();
            dice1Button.setText(dice1Roll);
            hand[0] = Integer.parseInt(dice1Roll);
            
            String dice2Roll = diceClass.rollDice();
            dice2Button.setText(dice2Roll);
            hand[1] = Integer.parseInt(dice2Roll);


            String dice3Roll = diceClass.rollDice();
            dice3Button.setText(dice3Roll);
            hand[2] = Integer.parseInt(dice3Roll);

            
            String dice4Roll = diceClass.rollDice();
            dice4Button.setText(dice4Roll);
            hand[3] = Integer.parseInt(dice4Roll);

            
            String dice5Roll = diceClass.rollDice();
            dice5Button.setText(dice5Roll);
            hand[4] = Integer.parseInt(dice5Roll);
        }


    

       

        // drp dwn for dice
        if(e.getSource() == drpDwnDice)
        {
            label3.setText("Players: " + ((JComboBox<String>) e.getSource()).getSelectedItem());

            JComboBox<String> cb = (JComboBox<String>)e.getSource();
            String playerString = (String)cb.getSelectedItem();  
            player = Integer.parseInt(playerString);
        }


        






        // buttons clicked action listen 
        // if the button is clicked then the background is set to red and added to an aray list to keep easier tabs

        if (e.getSource() == dice1Button)
        {
            dice1Button.setBackground(Color.red);
            rerolledDice.add("1");
            dice1Button.setOpaque(true);
        }

        if (e.getSource() == dice2Button)
        {
            dice2Button.setBackground(Color.red);
            dice2Button.setOpaque(true);
            rerolledDice.add("2");
        }

        if (e.getSource() == dice3Button)
        {
            dice3Button.setBackground(Color.red);
            dice3Button.setOpaque(true);
            rerolledDice.add("3");
        }

        if (e.getSource() == dice4Button)
        {
            dice4Button.setBackground(Color.red);
            dice4Button.setOpaque(true);
            rerolledDice.add("4");
        }

        if (e.getSource() == dice5Button)
        {
            dice5Button.setBackground(Color.red);
            dice5Button.setOpaque(true);
            rerolledDice.add("5");
        }
    }











    // simple function to unhiglihgt selected dice
    public void unhighlight()
    {
        if (rerolledDice.contains("1"))
        {
            // dice1Button.setOpaque(false);
            dice1Button.setBackground(null);
            rerolledDice.remove("1");
        }

        if (rerolledDice.contains("2"))
        {
            // dice2Button.setOpaque(false);
            dice2Button.setBackground(null);
            rerolledDice.remove("2");
        }

        if (rerolledDice.contains("3"))
        {
            dice3Button.setOpaque(false);
            dice3Button.setBackground(null);

            rerolledDice.remove("3");
        }

        if (rerolledDice.contains("4"))
        {
            dice4Button.setBackground(null);
            dice4Button.setOpaque(false);
            rerolledDice.remove("4");
            
        }

        if (rerolledDice.contains("5"))
        {
            dice5Button.setBackground(null);
            dice5Button.setOpaque(false);
            rerolledDice.remove("5");

        }
    }

















}
