/**
 * The AttackAdvertisement Class is used to simulate Attack advertisement.  
 * It is a sub class of Advertisement.  
 * @Lab time Tue 6:30
 * @version OOL2
 */


import java.util.Random;
public class AttackAdvertisement extends Advertisement
{
        
    
    private Candidate target = null;
    private Random rand = new Random();  
    
    /**
     * Constructer to build a Attack Advertisement with gengerate random cost.
     * @param inCan is the candidate in the advertisement.
     * @param inT is the candidate will become target in the advertisement.
     * @exception OutOfMoneyException when the ad's cost greater than the candidate's current money.
     */   
    public AttackAdvertisement(Candidate inCan, Candidate inT) throws OutOfMoneyException
    {
            try
            {
                    setAdType("Attack");
                    setCandidate(inCan);
                    setTarget(inT);            
                    setCost( rand.nextInt(25001)+50000);
                    setMes(addMes());
            }
            catch(OutOfMoneyException e)            
            {
                    throw new OutOfMoneyException();
            }
    }
    
    /**
     * Set Target.
     *@param inC is Candidate that will become Target
     */
     public void setTarget(Candidate inC)
     {
          target = inC;
     }
    /**
     * Get target.
     * @return the candidate of target.  
     */
     public Candidate getTarget()
     {             
          return target;
     }

    /**
     * toString method.
     * @return String will display advertisement's information.
     */ 
    public String toString()
    {
        return "The advertisment of "  + getCandidate().getName() + 
                ": \n\tIt cost: " + getCost()+ ". \n\tIt's type: " + getAdType() 
                + ". \n\tTarget: " + getTarget().getName()+ ". \n\tMessage: " + getMes() +  ".\n";
        
    } 
    
    /**
     * set message.
     * @return the String is about the advertisement what about.
     */
    public String addMes()
    {       
        int cMoney = getCandidate().getMoney()-getCost();  
        if (getCandidate().endorse(this) )
        {
            getCandidate().setDebateMod(0.2);
            getCandidate().setMoneyMod(-0.2);
            getTarget().setDebateMod(-0.15); 
            getTarget().setMoneyMod(-0.25); 
            getCandidate().changeMoney(cMoney);
            return "My name is " + getCandidate().getName() + " and I approve this message.";
        }
        else
        {
            getCandidate().setDebateMod(0.1);
            getCandidate().setMoneyMod(-0.05);
            getTarget().setDebateMod(-0.05); 
            getTarget().setMoneyMod(-0.1);
            getCandidate().changeMoney(cMoney);
            return "This messeage has not been approved by " + getCandidate().getName();
        }        
    }    
    
}
  
  
