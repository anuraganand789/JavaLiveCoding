public class Inheritance{
    class GrandFather {
        protected int money = 1_00_00_000;

	protected void calculateAsset() {
	    money -= 1_00_00_000;
	}

	public void displayAsset(){
	    System.out.println("Total money is " + money);
	}
    }
    
    class Father extends GrandFather{
        @Override
	protected void calculateAsset(){
	    super.calculateAsset();
	    money += 1_00_000;
	}
    }

    class Son extends Father {
        @Override
	protected void calculateAsset(){
	    super.calculateAsset();
	    money += 1_00_00_000;
	}
    }

    public static void main(String... args){
        final Inheritance obj = new Inheritance();

        final GrandFather grandDad = obj.new GrandFather();
	grandDad.calculateAsset();
	grandDad.displayAsset();

        final Father father = obj.new Father();
	father.calculateAsset();
	father.displayAsset();

	final Son         son = obj.new Son();
	son.calculateAsset();
	son.displayAsset();
    }
}
