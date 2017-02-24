/**
 * The Advertisement Class is used to simulate advertisement.  
 * A Advertisement has a candidate and cost.  
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */


public class Advertisement
{
    /**
     * create message, candidate and cost. 
     */
    private String mes = "DEFAULT";
    private Candidate candidate1 = null;
    private int cost = 0;
    private String adType = "DEFAULT";

    
    /**
     * Set message.
     * @param inM is the string will become the advertisement's message
     */
    public void setMes(String inMes)
    {
        mes = inMes;
    }
    /**
     * Get messge.
     * @return the the advertisement current's message 
     */
    public String getMes()
    {
         return mes;
                  
    }
        
    /**
     * Set Candidates.
     *@param inC is Candidate that will become the candidate
     */
     public void setCandidate(Candidate inC)
     {
          candidate1 = inC;
     }
    /**
     * Get Candidate.
     * @return the candidate  
     */
     public Candidate getCandidate()
     {             
          return candidate1;
     }

    /**
     * set cost
     * @param inCost will be the value of the cost
     * @exception OutOfMoneyException when cost is greater than candidate's current money.
     */
    public void  setCost(int inCost) throws OutOfMoneyException
    {
            if (getCandidate().getMoney()-inCost <0)
            {
                    throw new OutOfMoneyException();
            }
            else
            {
                    cost = inCost;
            }
    }
    /**
     * Get Cost.
     * @return int is the advertisement's current's cost
     */
    public int getCost()
    {
        return cost;
    }

    /**
     * toString method.
     * @return String will display advertisement's information.
     */        
    public String toString()
    {
        return "The advertisment of "  + getCandidate().getName() + 
                ": \n\tIt cost " + getCost()+ ". \n\tMessage: " + getMes() +  ".\n";
    } 
    /**
     * Set advertisement type. 
     * @param inAd will be the value of the advertisement type.
     */
    public void setAdType(String inAd)
    {
            if (!(inAd.equals("")))
            {
                    adType = inAd;
            }
    }
    /**
     * Get advertisement type.
     * @return String is the  adverstisment type.
     */
    public String getAdType()
    {
        return adType;
    }        
    
}
  
  
