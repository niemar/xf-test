package xf.test.fos.menu;

import java.util.List;

import xf.test.fos.food.Drink;
import xf.test.fos.food.Lunch;

/**
 * @author niemar
 *
 */
public interface IMenuDao {
	List<Drink> getDrinks();	
	List<Lunch> getLunches();
}
