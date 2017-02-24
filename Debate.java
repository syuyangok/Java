/**
 * The Debate Class is used to simulate debate.  
 * A debate has a location, two candidates.  
 * The winner method denotes a winner by compare 2 randomly polls number.   
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */

import java.util.ArrayList;
import java.util.Random;
public class Debate
{
    /**
     * create location, two candidates and rand. 
     */
    private String location = "DEFAULT";
    private ArrayList<Candidate> candidates; 
    private Random rand = new Random();   
    

    /**
     * Parameter Constructer to build a debate.
     * @param inLoc is the String that will become the debate's location
     * @param inC is a array of Candidate that will take part in debate.
     */
     public Debate(String inLoc, ArrayList<Candidate> inC ) throws TooLowPollsException
     {
          setLocation(inLoc);

          //calcute total money
          double totalMoney =0;
             for (Candidate c: inC)
             {
                     totalMoney += c.getMoney();
             }
             // calculate if candidate which money <3%;
             for (Candidate c: inC)
             {
                     if ((c.getMoney()/totalMoney)<0.03)
                     {
                             System.out.println("Your money < 3% of total Money. Now test if same party!!!");
                             for (Candidate cc: inC)
                             {
                                     if (!(cc.getParty().equals(inC.get(0).getParty())))
                                     {
                                             throw new TooLowPollsException();
                                     }
                             }
          
                             
                     }
             }                                        

          
          candidates = inC;
  
     }
    
    /**
     * Set Location.
     * @param inLocation is the debate current's location
     */
    public void setLocation(String inLocation)
    {
        location = inLocation;
    }
    /**
     * Get Location.
     * @return the debate current's location 
     */
    public String getLocation()
    {
          return location;
              
    }
    
        
    
    /**
     * Add Candidates.
     *@param inC is a candidates that will be in debate 
     */
     public void addCandidates(Candidate inC)
     {
             candidates.add(inC);
          
     }

    /**
     * Get Candidate.
     * @return the candidates name 
     */
     public String getCandidates()
     {
             String output = "";
             for (int x =0; x < candidates.size(); x++)
             {
                     output = output + candidates.get(x).getName() + "; ";
             }
          return output;
     }
    


    /**
     * Method to determine the winner of bebate by compare the debate scores.
     * tell the winner and transfer the loser's money to winner
     * @return a string which declare the winner and how many points he wins.  
     */
    public String declareWinner()
    {
            Candidate winC = candidates.get(0);
            double mScore =candidates.get(0).getScore(), dScore=0, tScore =0;
            int lMoney=0, wMoney=0 ; 
            //Set each candidates' score and compare them. 
            for (int n=0; n< candidates.size(); n++)
            {
                   dScore = (rand.nextInt(101))*(candidates.get(n).getDebateMod());
                   candidates.get(n).setScore(dScore);
                   if (dScore > mScore)
                   {                                                    
                           winC = candidates.get(n);
                           mScore = dScore;                          
                    }
                   else if(dScore == mScore)// if there is a tie, random choose winner.
                   {
                           int choose = rand.nextInt(2);
                           if (choose == 1)
                           {
                                   winC = candidates.get(n);
                                   mScore = dScore; 
                           }   
                   }
                   tScore += dScore;
            }
            // from loser candidates Array List calculte losing money and get output string.
            String output="";
            for (int x=0; x< candidates.size(); x++)
            {
                    if (!(candidates.get(x).equals(winC)))
                    {
                    lMoney = (int)(candidates.get(x).getMoney()*(tScore - candidates.get(x).getScore())/tScore);
                    wMoney += lMoney;
                    //set loser candidates current money;
                    candidates.get(x).changeMoney(candidates.get(x).getMoney()-lMoney);
                    //get output for each losing candidate.  
                    output = output + "\n\t" + candidates.get(x).getName() + " losing money: " + lMoney  + ". Current Money: " + candidates.get(x).getMoney();         
                    
                    }
            }
            //Add winning money to winner.
            wMoney += winC.getMoney();
            winC.changeMoney(wMoney);
            return "Winner is: " + winC.getName() + ". And he winnning the debate: " + "his current money: " +winC.getMoney()+ output ;
        
    }
    
    /**
     * toString method.
     * @return String will display debate's information.
     */        
    public String toString()
    {
        return "The debate in "  + location + ": \n\t" + declareWinner() + "\n";
        
    }
       

  
}
