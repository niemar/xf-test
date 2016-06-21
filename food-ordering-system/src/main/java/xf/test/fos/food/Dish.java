package xf.test.fos.food;

/**
 * @author niemar
 *
 */
public class Dish extends MenuItem {
	private Cuisine cuisine;
	
	public Dish(double price, String name) {
		this(price, name, Cuisine.None);
	}
	
	public Dish(double price, String name, Cuisine cuisine) {
		super(price, name);
		this.cuisine = cuisine;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

}
