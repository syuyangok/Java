/**
 * The IssueBasedAdvertisement Class is used to simulate Issue Based advertisement.  
 * It is a sub class of Advertisement.  
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */

import java.util.Random;
public class IssueBasedAdvertisement extends Advertisement
{
    private Random rand = new Random();        

    
    /**
     * Constructer to build a IssueBasedAdvertisement with gengerate random cost.
     * @param inCan is the candidate in the advertisement.
     * @exception OutOfMoneyException when the ad's cost greater than the candidate's current money.
     */    
    public IssueBasedAdvertisement(Candidate inCan) throws OutOfMoneyException
    {
            try
            {
                    setAdType("IssueBased");
                    setCandidate(inCan);            
                    setCost( rand.nextInt(15001)+5000);
                    setMes(addMes());
            }
            catch(OutOfMoneyException e)
            {
                    throw new OutOfMoneyException();
            }
            
    }


    /**
     * toString method.
     * @return String will display advertisement's information.
     */        
    public String toString()
    {            
        return "The advertisment of "  + getCandidate().getName() + 
                ": \n\tIt cost " + getCost()+  ". \n\tIt's type: " + 
                getAdType() + ". \n\tMessage: " + getMes() +  
                 ".\n";
        
    } 
    
    /**
     * add message.
     * @return the String is about the advertisement what about. 
     */
    public String addMes()
    {       
        int cMoney = getCandidate().getMoney()-getCost();
        //if (getCandidate().getAdType()== "IssueBased" )
        if (getCandidate().endorse(this) )
        {
            getCandidate().setDebateMod(0.1);            
            getCandidate().changeMoney(cMoney);
            return "My name is " + getCandidate().getName() + " and I approve this message.";
        }
        else
        {
            getCandidate().setDebateMod(0.05);
            getCandidate().changeMoney(cMoney);
            return "This messeage has not been approved by " + getCandidate().getName();
        }        
    }    
    
}
  
  
