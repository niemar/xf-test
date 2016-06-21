package xf.test.fos.menu;

import java.util.ArrayList;
import java.util.List;

import xf.test.fos.food.Cuisine;
import xf.test.fos.food.Dish;
import xf.test.fos.food.Drink;
import xf.test.fos.food.Lunch;
import xf.test.fos.food.MenuItem;

/**
 * @author niemar
 *
 */
public class MenuDao implements IMenuDao {
	public List<Lunch> getLunches() {
		List<Lunch> lunchMenuItems = new ArrayList<Lunch>();
		Lunch polishLunch1 = new Lunch(new Dish(10.0, "Pork with potatoes.",
				Cuisine.Polish), new Dish(4.0, "Apple pie"));
		Lunch polishLunch2 = new Lunch(new Dish(7.0, "Dumpings",
				Cuisine.Polish), new Dish(4.0, "Apple"));
		Lunch mexicanLunch1 = new Lunch(new Dish(12.0, "Burrito",
				Cuisine.Mexican), new Dish(4.0, "Banana"));
		Lunch italianLunch1 = new Lunch(new Dish(9.0, "Spaghetti carbonara",
				Cuisine.Italian), new Dish(4.0, "Yogurt"));
		Lunch italianLunch2 = new Lunch(new Dish(10.0, "Spaghetti bolognese",
				Cuisine.Italian), new Dish(4.0, "Croissant"));
		lunchMenuItems.add(polishLunch1);
		lunchMenuItems.add(polishLunch2);
		lunchMenuItems.add(mexicanLunch1);
		lunchMenuItems.add(italianLunch1);
		lunchMenuItems.add(italianLunch2);
		return lunchMenuItems;
	}
	
	public List<Drink> getDrinks() {
		List<Drink> drinks = new ArrayList<Drink>();
		drinks.add(new Drink(3.0, "Water"));
		drinks.add(new Drink(5.0, "Orange juice"));
		drinks.add(new Drink(5.0, "Cola"));
		return drinks;
	}
}
