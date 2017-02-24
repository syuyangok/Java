/**
 * The Fundraiser Class is used to simulate fundraiser.  
 * A fundraiser has a location, 1 candidates and donors.  
 * The raiseMoney method denotes generate money random by donors. 
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL2
 */

import java.util.Random;
public class Fundraiser
{
    /**
     * create location, 1 candidate, donors and rand. 
     */
    private String location = "";
    private Candidate candidate1 = null;
    private int donors = 0;
    private String fundType = "DEFAULT";
    private Random rand = new Random();
    
    /**
     * Default Constructer to build a Fundraiser.
     */
    public Fundraiser()
    {
        location = "";
        candidate1 = null;
        donors = rand.nextInt(201);      
    }
    
    /**
     * Parameter Constructer to build a Fundraiser.
     * @param inLocation is the String that will become the Fundraiser's location
     * @param inCandidate will become the candidate for fundraiser
     */
    public Fundraiser(String inLocation, Candidate inCandidate)
    {
        location = inLocation;
        candidate1 = inCandidate;        
        donors = rand.nextInt(201);      
    }
    
    /**
     * Set Location.
     * @param inLocation will become the fundraiser's current location.
     */
    public void setLocation(String inLocation)
    {
        location = inLocation;
    }
    /**
     * Get Location.
     * @return the fundraiser's current location
     */
    public String getLocation()
    {
          if (location.equals(""))
          {
               return "No Location Set";
          }
          else
          {
               return location;
          }          
    }   
    
    
    
    /**
     * Set Candidates.
     * @inCandidate is the candidate for the fundraiser.
     */
    public void setCandidate(Candidate inCandidate)
    {
        candidate1 = inCandidate;
    }
    /**
     * Get Candidate.
     * @return the fundraiser's current candidate
     */
    public Candidate getCandidate()
    {
        return candidate1;  
    }    
    
    /**
     * Set donors with randomly number.
     */
    public void setDonors()
    {
        donors = rand.nextInt(201);
    }
    /**
     * Get donors.
     * @return the fundraiser's current donors
     */
    public int getDonors()
    {
        return donors; 
    }
    
    /**
     * raiseMoney
     * Get raised money from donors with random.
     * Add raised money to candidate's money
     * @return raised money
     */
    public int raiseMoney()
    {
        int total =0, t=0, totalR = 0;
      for (int n = 1; n<= donors; n++)
      {          
          t = t + rand.nextInt(151);
      }
      totalR = (int)(t*candidate1.getMoneyMod());
      total =  totalR + candidate1.getMoney();
      candidate1.changeMoney(total);
      return totalR ;
    }
    
    /**
     * toString method.
     * @return String will display fund raiser's information.
     */        
    public String toString()
    {
        return "Fund raised by the candidate " + candidate1.getName() +": \n\tLocation: " + location + ". \n\tRaised money:" + raiseMoney() + ". \n\tHis total money is :"+ candidate1.getMoney();                      
        
    }
    
    /**
     * Set fund type.     
     */
    public void setFundType(String inF)
    {
            if (!(inF.equals("")))
            {
                    fundType = inF;
            }
    }
    /**
     * Get fund type.
     * return is the current fund type.
     */
    public String getFundType()
    {
        return fundType;
    }        
               
}
