package com.fruit;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.fruit.db.Fruit;

public class FruitBasket {
	private static String RUN_OPTIONS_TEST = "test";

	public static void main(String[] args) {
		String test = null;
		if (args != null && args.length > 0 && args[0] != null && args[0].length() > 0)
			test = args[0];
		if (RUN_OPTIONS_TEST.equals(test)) {
			System.out.println(
					"Running test cases\n" + "================================================================\n");
			ToolTester.runTestAndPrintResults();
			System.out.println("Execution of test cases completed\n"
					+ "================================================================\n");
			System.exit(0);
		}

		Scanner in = new Scanner(System.in);

		System.out.println("================================================================\n"
				+ "This is CLI TOOL which generates different reports based on the data provided in a CSV file.\n\n"
				+ "Please enter the CSV file path.\n"
				+ "File should contain the fruits data in the csv format with header \"fruit-type,age-in-days,characteristic1,characteristic2.\"\n"
				+ "================================================================\n");
		try{
		String path = in.nextLine();
		if (path == null || path.length() < 1) {
			System.out.println("Please enter the valid csv file path as input");
			System.exit(-1);
		}
		/*
		 * Initialize the data object with file content.
		 */
		FruitBasketReport.init(ReportHelper.getCSVFileContent(path));
		
		System.out.println("\n================================================================\n"
				+ "Please use the following options to generate the reports.\n" + "Press 1 for Total number of fruit\n"
				+ "Press 2 for Total types of fruit\n" + "Press 3 for Oldest fruit & age\n"
				+ "Press 4 for The number of each type of fruit in descending order\n"
				+ "Press 5 for The various characteristics (count, color, shape, etc.) of each fruit by type\n"
				+ "Press 0 to Exit\n"
				+ "================================================================\n");

		int input = 0;
		while ((input = in.nextInt()) != 0) {
			switch (input) {
			case 1:
				System.out.println("Total number of fruit:\n" + FruitBasketReport.getTotalCountOfAllFruits());
				break;
			case 2:
				System.out.println("Total types of fruit:\n" + FruitBasketReport.getDistinctFruitTypeCount());
				break;
			case 3:
				System.out.println("Oldest fruit & age:");
				int oldestAge = FruitBasketReport.getOldestAge();
				for (String fruit : FruitBasketReport.getOldestFruitList()) {
					System.out.println(fruit + ": " + oldestAge);
				}
				break;
			case 4:
				System.out.println("The number of each type of fruit in descending order:");
				List<String> keys = FruitBasketReport.getFruitKeysInDescendingOrder();
				for (String key : keys) {
					System.out.println(key + ": " + FruitBasketReport.getFruitListMap().get(key).size());
				}
				break;
			case 5:
				System.out.println("The various characteristics (count, color, shape, etc.) of each fruit by type:");
				Set<Fruit> groupedSet = FruitBasketReport.getGroupedFruitTypes();
				Map<Fruit, Integer> groupedMap = FruitBasketReport.getFruitTypeGroupMap();
				for (Fruit f : groupedSet) {
					System.out.println(groupedMap.get(f) + " " + f.getFruitType() + ": " + f.getCharacteristic1() + ", "
							+ f.getCharacteristic2());
				}
				break;
			}
		}
		}catch(Exception e){
			System.out.println("Tool closed due to error. Please retry with valid input.");
			System.exit(0);
		}
	}

}
