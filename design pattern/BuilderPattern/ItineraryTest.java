import java.util.Date;

public class ItineraryTest{
    public static void main(String[] args){
        final Itinerary travelPlan = (new Itinerary.ItineraryBuilder())
	                             .checkIn(new Date())
				     .checkOut(new Date())
				     .destination("Maldives")
				     .noOfGuests(1)
				     .noOfBeds(1)
				     .travelPlan();
       System.out.println("Current Travel Plan");
       System.out.println(travelPlan);
    }
}
