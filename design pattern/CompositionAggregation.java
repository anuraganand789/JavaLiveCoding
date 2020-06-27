public class CompositionAggregation {
    class Author{
        public final Set<Book> listOfBooks = new HashSet<>();
    }
    
    class Book{
        public Author author;
        public String name;
	public int cost;
	public String ISBN;
    }

    class ShoppingMall{
        String nameOfShoppingMall;
        Set<Person> customers;
	Set<Person> employedToShoppingMall;
	Set<Person> employedByShops;
	Set<Shop>   shopsOnRent;
	Set<Chairs> chairs;
    }

    class Shop {
        String name;
	int flooNumer;
	ShoppingMall;
    }

    public static void main(String ... args) {
        
    }
}
