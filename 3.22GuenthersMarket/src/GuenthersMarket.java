import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GuenthersMarket {

	private static Scanner scan;
	private static Map<String, Double> menu = new TreeMap<>();
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();

	public static void main(String[] args) {
		scan = new Scanner(System.in);

	try {
		boolean cont = true;
		fillMenuMap();
		do {
			printMenu();
			System.out.println("What item would you like to add to your cart?");
			String itemName = scan.nextLine();
			Double itemPrice = menu.get(itemName);
			if (!menu.containsKey(itemName)) {
				System.out.println("Sorry we don't have that item.");
			}
			if (menu.containsKey(itemName)) {
				System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
			}
			addToShoppingCart(itemName, itemPrice);
			System.out.println("Would you like to add another item? (y/n)");
			String input = scan.nextLine();
			if (!input.equalsIgnoreCase("y")) {
				cont = false;
			}

		} while (cont == true);

		System.out.println("Here is what you ordered: ");
		printOrder(orderNames, orderPrices);
		averagePrice(orderPrices);
		maxPrice(orderPrices);
		minPrice(orderPrices);
		scan.close();
		
	} catch (NullPointerException e) {
		System.out.println("We didn't have one or more of the item's you asked for.");
	}
	
	}
	private static void fillMenuMap() {
		menu.put("apple", 1.99);
		menu.put("orange", 2.25);
		menu.put("grapes", 3.52);
		menu.put("lemon", 2.75);
		menu.put("watermelon", 5.99);
		menu.put("cantaloupe", 4.15);
		menu.put("pineapple", 7.15);
		menu.put("pear", .02);
	}

	private static void printMenu() {
		System.out.println("Item\tPrice");
		for (Map.Entry<String, Double> entry : menu.entrySet()) {
			System.out.println(entry.getKey() + "    " + entry.getValue());
		}
	}

	private static void addToShoppingCart(String itemName, Double itemPrice) {
		orderNames.add(itemName);
		orderPrices.add(itemPrice);
	}

	private static void printOrder(List<String> orderNames2, List<Double> orderPrices2) {
		for (int i = 0; i < orderNames2.size(); i++) {
			System.out.println(orderNames2.get(i) + "    " + orderPrices2.get(i));
		}
	}

	private static void averagePrice(List<Double> prices) {
		Double average = 0.00;
		double sum = 0.00;
		for (int i = 0; i < prices.size(); i++) {
			sum = sum + prices.get(i);
		}
		average = sum / prices.size();
		System.out.println("The average price for your items was: $" + average);
	}

	private static void maxPrice(List<Double> prices) {
		Double maximum = prices.get(0);
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) > maximum) {
				maximum = prices.get(i);
			}
		}
		System.out.println("The highest cost item you bought was: $" + maximum);
	}

	private static void minPrice(List<Double> prices) {
		Double minimum = prices.get(0);
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) < minimum) {
				minimum = prices.get(i);
			}
		}
		System.out.println("The lowest cost item you bought was: $" + minimum);
	}

}
