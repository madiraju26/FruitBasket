package com.fruit;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fruit.db.Fruit;

public class ToolTester {
	static void runTestAndPrintResults() {
		String path = "file.csv";
		FruitBasketReport.init(ReportHelper.getCSVFileContent(path));
		System.out.println("\nTest case 1 :");
		System.out.println("Total number of fruit:\n" + FruitBasketReport.getTotalCountOfAllFruits());
		System.out.println("####################################\nTest case 2 :");
		System.out.println("Total types of fruit:\n" + FruitBasketReport.getDistinctFruitTypeCount());
		System.out.println("####################################\nTest case 3 :");
		System.out.println("Oldest fruit & age:");
		int oldestAge= FruitBasketReport.getOldestAge();
		for(String fruit : FruitBasketReport.getOldestFruitList()){
			System.out.println(fruit + ": " + oldestAge);
		}
		System.out.println("####################################\nTest case 4 :");
		System.out.println("The number of each type of fruit in descending order:");
		List<String> keys = FruitBasketReport.getFruitKeysInDescendingOrder();
		for(String key : keys){
			System.out.println(key + ": " + FruitBasketReport.getFruitListMap().get(key).size());
		}
		System.out.println("####################################\nTest case 5 :");
		System.out.println("The various characteristics (count, color, shape, etc.) of each fruit by type:");
		Set<Fruit> groupedSet = FruitBasketReport.getGroupedFruitTypes();
		Map<Fruit, Integer> groupedMap = FruitBasketReport.getFruitTypeGroupMap();
		for(Fruit f: groupedSet){
			System.out.println(groupedMap.get(f) +" " + f.getFruitType()+": " + f.getCharacteristic1()+", " + f.getCharacteristic2());
		}
		System.out.println("####################################\n");
	}

}
