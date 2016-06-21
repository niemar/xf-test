package xf.test.fos.service;

import xf.test.fos.food.MenuItem;
import xf.test.fos.order.Order;

/**
 * @author niemar
 *
 */
public class PaymentService {

	public String printBill(Order order) {
		if(order == null || order.isEmpty())
			return "There is nothing to pay.";
		double cost = 0;
		for (MenuItem item : order.getItems()) {
			cost += item.getPrice();
		}
		return "You have to pay: " + cost + " euro.";
	}

}
