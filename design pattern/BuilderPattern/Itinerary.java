import java.util.Date;

public class Itinerary {
    private    Date checkInDate;
    private    Date checkOutDate;
    private    int  noOfGuests;
    private    int  noOfBeds;
    private    String destination;

    public Date checkInDate(){
        return this.checkInDate;
    }

    public Date checkOutDate(){
        return this.checkOutDate();
    }

    public int noOfGuests(){
        return this.noOfGuests;
    }

    public int noOfBeds(){
        return this.noOfBeds;
    }

    public String destination(){
        return this.destination;
    }
   
    @Override
    public String toString(){
        final StringBuilder message = new StringBuilder();
	int count = 0;

	message.append(++count).append(". ").append("Check In Date :- ").append(this.checkInDate).append("\n");
	message.append(++count).append(". ").append("Check Out Date :- ").append(this.checkOutDate).append("\n");
	message.append(++count).append(". ").append("Number Of Guests :- ").append(this.noOfGuests).append("\n");
	message.append(++count).append(". ").append("Number Of Beds :- ").append(this.noOfBeds).append("\n");
	message.append(++count).append(". ").append("Destination :- ").append(this.destination).append("\n");

	return message.toString();
    }

    static class ItineraryBuilder {
        private Date checkInDate;
	public ItineraryBuilder checkIn(final Date checkInDate){
	    this.checkInDate = checkInDate;
	    return this;
	}

        private Date checkOutDate;
	public ItineraryBuilder checkOut(final Date checkOutDate){
	    this.checkOutDate = checkOutDate;
	    return this;
	}

        private int noOfGuests ;
	public ItineraryBuilder noOfGuests(final int noOfGuests){
	    this.noOfGuests = noOfGuests;
	    return this;
	}

        private int noOfBeds;
	public ItineraryBuilder noOfBeds(final int noOfBeds){
	    this.noOfBeds = noOfBeds;
	    return this;
	}

        private String destination;
	public ItineraryBuilder destination(final String destination){
	    this.destination = destination;
	    return this;
	}

	public Itinerary travelPlan(){
	    if(null == destination || destination.trim().isEmpty()) throw new IllegalArgumentException("Please provide destination.");
	    final Itinerary travelPlan = new Itinerary ();

	    travelPlan.checkInDate    = this.checkInDate;
	    travelPlan.checkOutDate   = this.checkOutDate;
	    travelPlan.noOfGuests     = this.noOfGuests;
	    travelPlan.noOfBeds       = this.noOfBeds;
	    travelPlan.destination    = this.destination;

	    return travelPlan;
	}


    }
}
