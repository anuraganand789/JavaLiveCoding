public class TeslaTest{
    
    public static void main(String[] args){
        final var modelOfTheCar = "MODEL_X";
	final var teslaCar  =  TeslaFactory.car(modelOfTheCar);

	teslaCar.tirePressure();
	teslaCar.batteryStatus();
	teslaCar.start();
	teslaCar.stop();
    }
}
