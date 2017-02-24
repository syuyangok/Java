/**
 * The Candidate Class is used to simulate candidate.  
 * A Candiatdate has a name, slogan and money.  
 * The endorse denotes a string message.
 * 
 * @author Yuyang Sun
 * @Lab time Tue 6:30
 * @version OOL3
 */

import java.util.Random;
public class Candidate implements Comparable<Candidate>
{
    /**
     * create name, slogan , money, modifier, socre,
     * adType fundType and rand. 
     */
    private String name = "DEFAULT";
    private String party = "DEFAULT";
    private String slogan = "DEFAULT";
    private int money;
    private double moneyMod = 0;
    private double debateMod = 0;
    private Random rand = new Random();
    private double score = 0;
    private String adType ="DEFAULT";
    private String fundType ="DEFAULT";    
    /**
     * Default Constructer to build a Candidate.
     */
    public Candidate()
    {
        name = "";
        party = "";
        slogan = "";
        money = rand.nextInt(101);
        moneyMod = 1.0;
        debateMod = 1.0;  
        score=0;
        adType ="DEFAULT";
        fundType ="DEFAULT"; 
    }
    
    /**
     * Parameter Constructer to build a Candidate with 3 parameters.
     * @param inName is the String that will become the Candidate's new name
     * @param inParty is the String that will become the Candidate's party
     * @param inSlogan is the String that will become the Candidate's slogan
     * @param inAd is the String that will become the Candidate's ad type
     * @param inFund is the String that will become the Candidate's fund type
     */
    public Candidate(String inName, String inParty, String inSlogan, String inAd, String inFund)
    {
        setName(inName);
        setParty(inParty);
        setSlogan(inSlogan);
        money = rand.nextInt(101);
        moneyMod = 1.0;
        debateMod = 1.0;
        score =0;
        setAdType(inAd);
        setFundType(inFund);
    }
    
    /**
     * Set name. 
     * @param inName is the String that will become the Candidate's new name
     */
    public void setName(String inName)
    {
        name = inName;
    }
    /**
     * Get name.
     * @return the cancadidate current's name
     */
    public String getName()
    {
          if (name.equals(""))
          {
               return "No Name Set";
          }
          else
          {
               return name;
          }
    }

    /**
     * Set party.
     * @param inParty is the String that will become the Candidate's party
     */
    public void setParty(String inParty)
    {
        party = inParty;
    }
    /**
     * Get party.
     * @return the cancadidate current's party
     */
    public String getParty()
    {
          if (party.equals(""))
          {
               return "No Party Set";
          }
          else
          {
               return party;
          }
    }
    
    /**
     * Set slogan.
     * @param inSlogan is the String that will become the Candidate's slogan
     */
    public void setSlogan(String inSlogan)
    {
        slogan = inSlogan;
    }
    /**
     * Get slogan.
     * @return the cancadidate current's sologan or "No Slogan set"
     */
    public String getSlogan()
    {
          if (slogan.equals(""))
          {
               return "No Slogan Set";
          }
          else
          {
               return slogan;
          }
    }    
    
    /**
     * Set money with random.
     */
    public void setMoney()
    {
        money = rand.nextInt(101);
    }
    /**
     * Get money.
     * @return is the candidate's current's money
     */
    public int getMoney()
    {
        return money;
    }
    
    /**
     * Change money.
     * @param inMoney is the value will become the candidate's money.
     */
    public void changeMoney(int inMoney)
    {
        money = inMoney;
    }
    

    /**
     * Set endorse.
     * @param inAd is the input advertisement.
     * @return boolean will indicate if get the Candidate endorse.
     */
        
    public boolean endorse(Advertisement inAd)
    {        
        
        if (getAdType().equals(inAd.getAdType()))
        {
                return true;
        }
        else
        {
                return false;
        }
    }
    /**
     * toString method.
     * @return String will display Candidate's information.
     */
        
    public String toString()
    {
        return "The candidate " + name + ": \n\tSloagan: " + slogan + ". \n\tMoney: " + 
                money + ".\n\tParty: " + party + ". \n\tMoney Modifier: "+ getMoneyMod() + 
                ". \n\tDebate Modifier: "+ getDebateMod() + ". \n\tAd type: " + getAdType() + 
                ". \n\tFund type: " + getFundType() +"\n";
        
    }
     
    /**
     * equals method.
     * @param othercandidate is the candidate will compare to the current candidate.
     * @return true if two candidates are same else return false..
     */        
    public boolean equals(Candidate otherCandidate)
    {
            
        return getName().equals(otherCandidate.getName());
        
    }

    /**
     * compareTo method.
     * @param othercandidate is the candidate will compare to the current candidate.
     * @return positive current candidate has more money. return 0 if they are equal. Else, retrun negative number.
     */           
     public int compareTo(Candidate otherCandidate)
     {       
             if  ((getMoney() - otherCandidate.getMoney()) == 0) //if the candidates have no money difference, then we will have to rely on their names
             {
                  return (getName().compareTo(otherCandidate.getName())); //then, we will go by reverse alphabetical order (whoever has a name closer to z is greater in comparsion) 
             }
              
             else //otherwise, we just decide based on money value
             {             
                  return (getMoney() - otherCandidate.getMoney());
             }

     }
     
    /**
     * Set money modifier.
     * @param inMod is the value will add to the candidates money modifier.
     */
    public void setMoneyMod(double inMod)
    {            
        moneyMod += inMod;
        
    }
    /**
     * Get money modifier.
     * @return is the candidate's current's money moidifier. If below 0, retrun 0.
     */
    public double getMoneyMod()
    {
        if (moneyMod < 0)
        {
                return 0;
        }
        else
        {
                return moneyMod;
        }
    }
    
    /**
     * Set debate modifier.
     * @param inMod is the value will add to the candidates debate modifier.
     */
    public void setDebateMod(double inMod)
    {            
        debateMod += inMod;
        
    }
    /**
     * Get debate modifier.
     * @return is the candidate's current's debate moidifier. If below 0, retrun 0.
     */
    public double getDebateMod()
    {
        if (debateMod < 0)
        {
                return 0;
        }
        else
        {
                return debateMod;
        }
    }
    
    /**
     * Set debate score.
     * @param inScore is the value of candidate's current debate score.
     */
    public void setScore(double inScore)
    {
        score = inScore;
    }
    /**
     * Get debate score.
     * return is the candidate's current's debate score.
     */
    public double getScore()
    {
        return score;
    }

    /**
     * Set advetisement type randomly.     
     */
    public void setAdType()
    {
        int type = rand.nextInt(3);
        if (type == 0)
        {
                adType = "IssueBased";
        }
        else if (type == 1)
        {
                adType = "Attack";
        }
        else
        {
                adType = "TownHall";
        }

    }
  
  
    /**
     * Set advetisement type with parameter.
     * @param inAd is the String will be the new value of the adtype.     
     */
    public void setAdType(String inAd )
    {

                adType = inAd;
 
    }
  
    /**
     * Get advertisement type.
     * return is the candidate's current's adverstisment.
     */
    public String getAdType()
    {
        return adType;
    }  
    
    /**
     * Set Fund type randomly.     
     */
    public void setFundType()
    {

        int type = rand.nextInt(3);
        if (type == 0)
        {
                fundType = "Social Events";
        }
        else if (type == 1)
        {
                fundType = "Automated Phone Calls";
        }
        else
        {
                fundType = "Political Action Committees";
        }
     
    }
  
    /**
     * Set fund type with parameter.
     * @param inFund is the String will be the new value of the fund type.     
     */
    public void setFundType(String inFund )
    {

                fundType = inFund;
 
    }
  
  
    /**
     * Get Fund type.
     * @return is the candidate's current's fund type.
     */
    public String getFundType()
    {
        return fundType;
    }         
}
  
  

