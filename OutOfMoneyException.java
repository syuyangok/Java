/**
 * The OutOfMoneyException Class is used to build a OutOfMoney exception.  
 * It is a sub class of Exception.  
 * @version OOL2
 */

import java.util.Random;
public class OutOfMoneyException  extends Exception
{
        public String getMessage()
        {
                return "You are out of Money!!!";
        }
    
}
