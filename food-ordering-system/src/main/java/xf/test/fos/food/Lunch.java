package xf.test.fos.food;

/**
 * @author niemar
 *
 */
public class Lunch extends MenuItem {
	private Dish mainCourse;
	private Dish dessert;
	
	public Lunch(Dish mainCourse, Dish dessert) {
		super(mainCourse.getPrice() + dessert.getPrice(), null);
		this.mainCourse = mainCourse;
		this.dessert = dessert;
		this.name = toString();
	}

	public Dish getMainCourse() {
		return mainCourse;
	}

	public Dish getDessert() {
		return dessert;
	}

	@Override
	public String toString() {
		return "[Main course: " + mainCourse + ", Dessert: " + dessert + "]";
	}

}
