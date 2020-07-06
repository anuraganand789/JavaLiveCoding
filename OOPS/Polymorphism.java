public class Polymorphism {
    class Shape{
        public void display(){
	    System.out.println("I am inside " + Shape.class);
	}
    }

    class Rectangle extends Shape {
        @Override
	public void display(){
	    System.out.println("I am inside " + Rectangle.class);
	}
    }

    class Square extends Shape {
        @Override
	public void display(){
	    System.out.println("I am insided " + Square.class);
	}
    }

    public static void showPolyAction(final Shape shape) {
	System.out.print("Inside show -> ");
        shape.display();
    }
    public static void main(String... args){
       final Polymorphism obj        = new Polymorphism(); 
             Shape shape             = obj.new Shape();
       final Rectangle    rectangle  = obj.new Rectangle();
       final Square       square     = obj.new Square(); 
       
       //This is one way to do polymorphis
       showPolyAction(shape);
       showPolyAction(rectangle);
       showPolyAction(square);

       shape.display();
       //This is one way to do polymorphism
       shape = rectangle;
       shape.display();

       shape = square;
       shape.display();

    }
}
