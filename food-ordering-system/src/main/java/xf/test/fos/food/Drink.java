package xf.test.fos.food;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niemar
 *
 */
public class Drink extends MenuItem {
	private List<Addition> additions;

	public Drink(double price, String name) {
		super(price, name);
		this.additions = new ArrayList<Addition>();
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	@Override
	public String toString() {
		return super.toString() + " Additions: " + additions;
	}

	public void addAddition(Addition addition) {
		additions.add(addition);
	}
}
