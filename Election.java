/**
 * The Election Class is used to simulate election.  
 * A election has a title, 10 candidates.  
 * The winning method denotes a winner by compare who gots most money. 
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */

import java.util.Random;
import java.util.ArrayList;
public class Election
{
    /**
     * create title, candidates and rand. 
     */
    private String title = "";
    private ArrayList<Candidate> candidates = null;
    //private ArrayList<Candidate> candidates = new ArrayList<Candidate>();  
    private Random rand = new Random();
    
    
    

    /**
     * Parameter Constructer to build a election with title and array of candidates.
     * @param inTitle is the String that will become the election's title
     * @param inCan is a array of Candidate that will become candidates
     */
    public Election(String inTitle, ArrayList<Candidate> inCan)
    {
        title = inTitle;
        candidates = inCan;
    }
    
    /**
     * Set Title.
     * @param inTitle is the String that will become the election's title
     */
    public void setTitle(String inTitle)
    {
        title = inTitle;
    }
    /**
     * getTitle.
     * @return the election's title.
     */
    public String getTitle()
    {
          if (title.equals(""))
          {
               return "No Title Set";
          }
          else
          {
               return title;
          }    
    }

    /**
     * Set candidates.
     * @param inCan is the candidates current values.
     */
    public void setCandidates(ArrayList<Candidate> inCan)
    {
        candidates = inCan;
    }    
    
    /**
     * getCandidates .
     * @return the election's canidates names.
     */
    public String getCandidates()
    {
            String output = "";
            for (Candidate inC: candidates)
            {
                    output = output + inC.getName()+", ";
            }

            return output;

    }

    /**
     * Method to determine who winn by most money .
     * @return a string which declase the winner and the title of election.
     */
     public String declareWinner()
     {
          Candidate winner = candidates.get(0);
          for (int x = 1; x < candidates.size(); x++)
          {
               if (winner.getMoney() < candidates.get(x).getMoney())
               {
                    winner = candidates.get(x);
               }
               else if (winner.getMoney() == candidates.get(x).getMoney())//if there is a tie, Random choose winner.
               {
                    if(rand.nextInt(2) == 1)
                    {
                         winner = candidates.get(x);
                    }
               }
          
          }
          
          return winner.getName() + " is the winner of the " + getTitle() + " election.";
     }
  
    /**
     * toString method.
     * @return String will display election's information.
     */
        
    public String toString()
    {
        return declareWinner();
        
    }
           
    
}  
