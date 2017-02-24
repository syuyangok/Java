/**
 * The PACFundraiser Class is used to simulate social Fundraiser.  
 * It is a sub class of Fundraiser.  
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */

import java.util.Random;
import java.util.ArrayList;
public class PACFundraiser extends Fundraiser
{
    private Random rand = new Random();        

    /**
     * Parameter Constructer to build a PAC Fundraiser.
     * @param inLocation is the String that will become the Fundraiser's location
     * @param inCandidate will become the candidate for fundraiser
     * @exception TooLowPollsException when candidate money less than 1% of total cadidates money
     */
    public PACFundraiser(String inLocation, Candidate inC, ArrayList<Candidate> inCC) throws TooLowPollsException
    {
        
        setCandidate(inC);        
        //If money less 1% of total candidates, throw TooLowPollsException
        int total = 0;
            for (Candidate x: inCC)
            {
                    total += x.getMoney();
            }
        if (inC.getMoney() < 0.01 * total)
        {
                throw new TooLowPollsException();                
        }
        setFundType("Political Action Committees");
        setLocation(inLocation);

        
        
    }    
    /**
     * toString method.
     * @return String will display fund raiser's information.
     */        
    public String toString()
    {
        return "Fund raised by the candidate " + getCandidate().getName() +": \n\tLocation: " + getLocation() + 
                ": \n\tFund Type: " + getFundType() + ". \n\tRaised money:" + raiseMoneyPAC() + 
                ". \n\tHis total money is :"+ getCandidate().getMoney()
                + ". \n\tHis money moidifer now is :"+ getCandidate().getMoneyMod() +  
                ". \n\tHis debate moidifer now is :"+ getCandidate().getDebateMod() + ".\n";                      
        
    }
         
    
    /**
     * raiseMoney
     * Add candidate's money modifier by 0.2
     * Add candidate's debate modifier by 0.1
     * @return raised money
     */
    public int raiseMoneyPAC()
    {
            int raisedMoney = raiseMoney();  
            getCandidate().setMoneyMod(0.2);
            getCandidate().setDebateMod(0.1);
            return raisedMoney;
    }


}
  
  
