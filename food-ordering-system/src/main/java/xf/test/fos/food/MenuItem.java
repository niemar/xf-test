package xf.test.fos.food;

/**
 * @author niemar
 *
 */
public abstract class MenuItem {
	protected double price;
	protected String name;

	public MenuItem(double price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " - " + price + " euro";
	}

}
