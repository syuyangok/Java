/**
 * The TownHallAdvertisement Class is used to simulate TownHall advertisement.  
 * It is a sub class of Advertisement.  
 * @Lab time Tue 6:30
 * @version OOL2
 */


import java.util.Random;
public class TownHallAdvertisement extends Advertisement
{
        
     private int attendee  = 0;
     private Random rand = new Random();  
    
    /**
     * Constructer to build a TownHall Advertisement with gengerate random cost.
     * @param inCan is the candidate in the advertisement.
     * @exception OutOfMoneyException when the ad's cost greater than the candidate's current money.
     */    
    public TownHallAdvertisement(Candidate inCan) throws OutOfMoneyException
    {
            try
            {
                    setCandidate(inCan);
                    setAdType("TownHall");
                    setAttendee(rand.nextInt(151));
                    setCost( rand.nextInt(195001)+5000);       
                    setMes(addMes());
            }
            catch(OutOfMoneyException e)            
            {
                    throw new OutOfMoneyException();
            }
    }
    
    /**
     * Set attendee.
     *@param inA is the value that will become attendee.
     */
     public void setAttendee(int inA)
     {
          attendee = inA;
     }
    /**
     * Get attendee.
     * @return the current number of attendee.  
     */
     public int getAttendee()
     {             
          return attendee;
     }

    /**
     * toString method.
     * @return String will display advertisement's information.
     */        
    public String toString()
    {
        return "The advertisment of "  + getCandidate().getName() + 
                ": \n\tIt cost: " + getCost()+ ". \n\tIt's type: " + getAdType() + 
                ". \n\tIt's attendees: " + getAttendee() + ". \n\tMessage: " + getMes() +  ".\n";
        
    } 
    
    /**
     * set message.
     * @return the String is about the advertisement what about.
     */
    public String addMes()
    {       
        int cMoney = getCandidate().getMoney()-getCost(); 
        double inMod = 0;
        if (getCandidate().endorse(this) )
        {
            inMod = (double)getAttendee()/500;
            getCandidate().setMoneyMod(inMod);
            getCandidate().changeMoney(cMoney);
            return  getCandidate().getName() + " holds a successful Town Hall.";
        }
        else
        {
            inMod = (double)getAttendee()/2000;                
            getCandidate().setMoneyMod(inMod);
            getCandidate().changeMoney(cMoney);
            return getCandidate().getName() + " holds a Town Hall.";
        }        
    }    
    
}
  
  
