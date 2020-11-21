import java.util.function.ToIntBiFunction;

public class SlopeOfALine{
    private static record 
    Point(int x, int y){
	public void print(){
	    System.out.println(this.toString());
	}
        @Override
	public String toString(){
	    return "X " + x + ", Y " + y;
	}
    }

    private final class SlopeClass implements ToIntBiFunction<Point, Point>{
        @Override
	public int applyAsInt(final Point firstPoint, final Point secondPoint){
	    return (secondPoint.y() - firstPoint.y()) / (secondPoint.x() - firstPoint.x());
	}
    }

    private final ToIntBiFunction<Point, Point> slopeAnonymous = 
    new ToIntBiFunction<Point, Point>(){
        @Override
	public int applyAsInt(final Point firstPoint, final Point secondPoint){
	    return (secondPoint.y() - firstPoint.y()) / (secondPoint.x() - firstPoint.x());
	}
    };


    private static int applyAsInt(final Point firstPoint, final Point secondPoint){
         return (secondPoint.y() - firstPoint.y()) / (secondPoint.x() - firstPoint.x());
    }

    private final ToIntBiFunction<Point, Point> slopeLambdaFullStyle = 
	(final Point firstPoint, final Point secondPoint) -> (secondPoint.y() - firstPoint.y()) / (secondPoint.x() - firstPoint.x());

    private final ToIntBiFunction<Point, Point> slopeLambdaShortStyle = (firstPoint, secondPoint) -> (secondPoint.y() - firstPoint.y()) / (secondPoint.x() - firstPoint.x());

    private final ToIntBiFunction<Point, Point> slopeMethodRefrence = SlopeOfALine::applyAsInt;

    public static void main(final String ... args){
        final Point firstPoint  = new Point(12, 11); firstPoint.print();
	final Point secondPoint = new Point(17, 22); secondPoint.print();

	final SlopeOfALine obj = new SlopeOfALine();
        int slopeOfLine = obj.new SlopeClass().applyAsInt(firstPoint, secondPoint); 
	System.out.format("%s -> Slope Of A Line with firstPoint -> %s and secondPoint -> %s is %d.%n", "Regular Class", firstPoint, secondPoint, slopeOfLine);

	slopeOfLine = obj.slopeAnonymous.applyAsInt(firstPoint, secondPoint); 
	System.out.format("%s -> Slope Of A Line with firstPoint -> %s and secondPoint -> %s is %d.%n", "Anonymous Class", firstPoint, secondPoint, slopeOfLine);

	slopeOfLine = obj.slopeLambdaFullStyle.applyAsInt(firstPoint, secondPoint); 
	System.out.format("%s -> Slope Of A Line with firstPoint -> %s and secondPoint -> %s is %d.%n", "Lambda Full Implementation", firstPoint, secondPoint, slopeOfLine);

	slopeOfLine = obj.slopeLambdaShortStyle.applyAsInt(firstPoint, secondPoint); 
	System.out.format("%s -> Slope Of A Line with firstPoint -> %s and secondPoint -> %s is %d.%n", "Lambda Short Implementation", firstPoint, secondPoint, slopeOfLine);

	slopeOfLine = obj.slopeMethodRefrence.applyAsInt(firstPoint, secondPoint); 
	System.out.format("%s -> Slope Of A Line with firstPoint -> %s and secondPoint -> %s is %d.%n", "Lambda Method Ref Implementation", firstPoint, secondPoint, slopeOfLine);

    }
}
