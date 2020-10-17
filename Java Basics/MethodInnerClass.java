public class MethodInnerClass{
    //we can have the same class names in different functions
    private static void mathFunction_2(int x, int y){
	
        class Coordinates { 
	    int x, y; 
	    Coordinates(final int x, final int y) { this.x = x; this.y = y;} 
	}

        final Coordinates oldCoordinates = new Coordinates(x, y);

	final Coordinates newCoordinates = new Coordinates(oldCoordinates.x * 2, oldCoordinates.y * 2);

	System.out.printf("Math Function 2 => X : %d, Y : %d %n", newCoordinates.x, newCoordinates.y);
    }

    private static void mathFunction(int x, int y){
	
        class Coordinates { 
	    int x, y; 
	    Coordinates(final int x, final int y) { this.x = x; this.y = y;} 
	}

        final Coordinates oldCoordinates = new Coordinates(x, y);

	final Coordinates newCoordinates = new Coordinates(oldCoordinates.x * 2, oldCoordinates.y * 2);

	System.out.printf("Math Function => X : %d, Y : %d %n", newCoordinates.x, newCoordinates.y);
    }
    public static void main(final String[] args){
        mathFunction(10, 12);
        mathFunction_2(10, 12);
    }
}
