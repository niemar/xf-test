package xf.test.fos.order;

import java.util.ArrayList;
import java.util.List;

import xf.test.fos.food.MenuItem;

/**
 * @author niemar
 *
 */
public class Order {
	private List<MenuItem> items = new ArrayList<MenuItem>();
	
	public void add(MenuItem item) {
		items.add(item);
	}
	
	public List<? extends MenuItem> getItems() {
		return items;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public String toString() {
		return "Your order: " + items;
	}
}
