/**
 * extra fee class for first class flight
 * 
 */
public class FirstClassSeat extends FlightSeat {
    
    
 /**
 * calculates extra for first class
 * 
 */
    public FirstClassSeat()
    {
        classType = "First Class";
        extraCharge = 220.78;
       
    }
/**
* print statement clarifying for user what class they chose
*/
    public void classGreeting()
    {
        System.out.println("Wow, you're fancy! Thanks for flying first class");
    }
}
