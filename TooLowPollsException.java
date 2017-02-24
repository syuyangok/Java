/**
 * The TooLowPollsException Class is used to build a OutOfMoney exception.  
 * It is a sub class of Exception.  
 * @version OOL2
 */

import java.util.Random;
public class TooLowPollsException  extends Exception
{
        public String getMessage()
        {
                return "Your polls are too Low!!!";
        }
    
}
