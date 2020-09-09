public class Model_Y  implements Tesla{
    private final String MODEL_NAME = "MODEL_Y";
    private int noOfSeats;
    private int cost;
    private int height;
    private int width;

    private int percentOfBattery;
    private int tirePressure;

    public void start(){
        System.out.println(MODEL_NAME + " has started ");
    }

    public void stop(){
        System.out.println(MODEL_NAME + " has stopped.");
    }

    public void batteryStatus(){
        System.out.println("Battery :- 80%");
    }

    public void tirePressure(){
        System.out.println("Tire Pressure :- 96%");
    }

}
