package xf.test.fos.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xf.test.fos.food.Addition;
import xf.test.fos.food.Cuisine;
import xf.test.fos.food.Drink;
import xf.test.fos.food.Lunch;
import xf.test.fos.food.MenuItem;
import xf.test.fos.menu.IMenuDao;
import xf.test.fos.menu.MenuDao;
import xf.test.fos.order.Order;
import xf.test.fos.service.PaymentService;

/**
 * @author niemar
 *
 */
public class Main {
	private static final String EXIT = "4";
	private static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		Order order = new Order();
		PaymentService paymentService = new PaymentService();
		IMenuDao menuDao = new MenuDao();
		List<Lunch> lunches = menuDao.getLunches();
		List<Drink> drinks = menuDao.getDrinks();

		String choice = "1";
		while (!choice.equals(EXIT)) {
			printMainMenu();
			choice = SCANNER.nextLine();
			switch (choice) {
				case "1": {
					
					List<Lunch> filteredLunches = filterByCuisine(lunches);					
					MenuItem lunch = chooseItem("Choose lunch: ", filteredLunches);
					if(lunch != null) {
						order.add(lunch);
						System.out.println("Added " + lunch + " to bill.");
					}
					break;
				}
				case "2": {
					MenuItem drink = chooseItem(" Choose drink: ", drinks);
					if(drink != null) {
						order.add(drink);
						addAdditions((Drink) drink);
						System.out.println("Added " + drink + " to bill.");
					}
					break;
				}
				case "3": {
					String bill = paymentService.printBill(order);
					System.out.println(order);
					System.out.println(bill);
					order = new Order();
					break;
				}
				case EXIT: {
					SCANNER.close();
					System.out.println("Goodbye");
					break;
				}
				default:
					;
			}
		}
		
	}

	private static List<Lunch> filterByCuisine(List<Lunch> lunches) {
		printHorizontalSeparator();
		System.out.println("Choose cuisine: ");
		System.out.println("	0. All" );
		int i = 1;
		for (Cuisine cuisine : Cuisine.values()) {
			System.out.println("	" + i++ + ". " + cuisine.toString());
		}
		printHorizontalSeparator();
		Integer index = readIndex();
		if(index == null || index == 0 || !isInCuisinesRange(index - 1))
			return lunches;
		List<Lunch> filteredLunches = lunches.stream()
				.filter((Lunch lunch) -> { return lunch.getMainCourse().getCuisine() == Cuisine.values()[index - 1]; })
				.collect(Collectors.toList());
		return filteredLunches;
	}

	private static boolean isInCuisinesRange(int index) {
		return index >=0 && index < Cuisine.values().length;
	}

	private static void addAdditions(Drink drink) {
		printHorizontalSeparator();
		System.out.println("Do you want to add addtitions to your drink ?");
		System.out.println("	0. None");
		System.out.println("	1. Ice cubes");
		System.out.println("	2. Lemon");
		System.out.println("	3. Ice cubes and lemon");
		printHorizontalSeparator();
		Integer index = readIndex();
		if(index == null) {
			return;
		}
		else if(index == 1) {
			drink.addAddition(Addition.IceCubes);
		}
		else if(index == 2) {
			drink.addAddition(Addition.Lemon);
		}
		else if(index == 3) {
			drink.addAddition(Addition.IceCubes);
			drink.addAddition(Addition.Lemon);
		}

	}

	private static MenuItem chooseItem(String itemsTitle, List<? extends MenuItem > items) {
		printHorizontalSeparator();
		System.out.println(itemsTitle);
		System.out.println("	0. Back");
		printItems(items);
		printHorizontalSeparator();
		
		Integer i = readIndex();
		if(i == null)
			return null;
		if(!isInRange(i - 1, items))
			return null;
		else 
			return items.get(i - 1);
	}

	private static Integer readIndex() {
		String index = SCANNER.nextLine();
		int i = -1;
		try {
			i = Integer.parseInt(index);
		} catch (NumberFormatException e) {
			return null;
		}
		return i;
	}
	
	private static boolean isInRange(int i, List<? extends MenuItem> items) {
		return i >= 0 && i < items.size();
	}

	private static void printItems(List<? extends MenuItem> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println("	" + (i + 1) + ". " + items.get(i));
		}
	}

	private static void printMainMenu() {
		printHorizontalSeparator();
		System.out.println("Restaurant");
		System.out.println("Write number to continue:");
		System.out.println("	1. Lunch");
		System.out.println("	2. Drinks");
		System.out.println("	3. Payment");
		System.out.println("	4. Exit");
		printHorizontalSeparator();
	}

	private static void printHorizontalSeparator() {
		System.out.println("============================");
	}

}
