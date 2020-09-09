public class TeslaFactory{
    public static Tesla car(final String modelOfTheCar){
	return switch(modelOfTheCar){
	    case "MODEL_3" -> new Model_3();
	    case "MODEL_X" -> new Model_X();
	    case "MODEL_Y" -> new Model_Y();
	    case "MODEL_S" -> new Model_S();
	    default -> throw new IllegalArgumentException("Invalid Car Model");
	};
    }
}

