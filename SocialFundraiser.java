/**
 * The SocialFundraiser Class is used to simulate social Fundraiser.  
 * It is a sub class of Fundraiser.  
 * @version OOL2
 */

import java.util.Random;
public class SocialFundraiser extends Fundraiser
{
    private Random rand = new Random();        

    /**
     * Parameter Constructer to build a Social Fundraiser.
     * @param inLocation is the String that will become the Fundraiser's location
     * @param inCandidate will become the candidate for fundraiser
     */
    public SocialFundraiser(String inLocation, Candidate inCandidate)
    {
        setLocation(inLocation);
        setCandidate(inCandidate);
        setFundType("Social Events");
    }    
    /**
     * toString method.
     * @return String will display fund raiser's information.
     */        
    public String toString()
    {
        return "Fund raised by the candidate " + getCandidate().getName() +": \n\tLocation: " + getLocation() + 
                ": \n\tFund Type: " + getFundType() + ". \n\tRaised money:" + raiseMoneySocial() + 
                ". \n\tHis total money is :"+ getCandidate().getMoney()
                + ". \n\tHis money moidifer now is :"+ getCandidate().getMoneyMod() +  ".\n";                      
        
    }
         
    
    /**
     * raiseMoney
     * increase candidate's money modifier by 0.1
     * @return raised money
     */
    public int raiseMoneySocial()
    {
            int raisedMoney = raiseMoney();  
            getCandidate().setMoneyMod(0.1);
            return raisedMoney;
    }


}
  
  
