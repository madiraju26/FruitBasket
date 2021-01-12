package com.fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fruit.db.Fruit;
import com.fruit.db.FruitData;

public class FruitBasketReport {
	public static void init(List<String[]> csvContent) {
		FruitData.setTotalCount(csvContent.size() - 1);
		FruitData.setFruitList(csvContent);
		Map<Integer, List<String>> tempCountMap = new HashMap<>();
		Map<String, List<String>> fruitsMap = new HashMap<>();
		Set<Fruit> fruitTypes = new LinkedHashSet<>();
		Map<Fruit, Integer> fruitTypeGroupMap = new HashMap<>();

		int tempCount = 1;
		String[] header = csvContent.get(0);
		validateHeader(header);

		csvContent.remove(0);
		for (String[] fruit : csvContent) {
			// FruitData.getFruitMap().put(fruit[0], fruit);
			int count = Integer.parseInt(fruit[1]);
			if (count >= tempCount) {
				List<String> fruits = tempCountMap.getOrDefault(count, new ArrayList<String>());
				fruits.add(fruit[0]);
				tempCountMap.put(count, fruits);
				tempCount = count;
			}
			List<String> fruitList = fruitsMap.getOrDefault(fruit[0], new ArrayList<String>());
			fruitList.add(fruit[0]);
			fruitsMap.put(fruit[0], fruitList);

			// group by type and characteristics
			Fruit f = new Fruit(fruit);
			fruitTypes.add(f);
			Integer groupCount = fruitTypeGroupMap.getOrDefault(f, 0);
			fruitTypeGroupMap.put(f, groupCount + 1);
		}
		List<String> oldestFruitList = tempCountMap.get(tempCount);
		Collections.sort(oldestFruitList);
		FruitData.setOldestFruitList(oldestFruitList);
		FruitData.setOldestCount(tempCount);
		FruitData.setFruitMap(fruitsMap);
		FruitData.setFruitTypes(fruitTypes);
		FruitData.setFruitTypeGroupMap(fruitTypeGroupMap);

		List<String> keys = FruitData.getFruitMap().entrySet().stream()
				.sorted((left, right) -> Integer.compare(right.getValue().size(), left.getValue().size()))
				.map(entry -> entry.getKey()).collect(Collectors.toList());
		FruitData.setFruitOrderKeys(keys);
	}

	private static void validateHeader(String[] header) {
		if (header == null || header.length < 4) {
			System.out.println(
					"Invalid csv file. File should contain fruit-type, age-in-days, characteristic1,characteristic2.");
			System.exit(-1);
		}
		if (!"fruit-type".equals(header[0]) || !"age-in-days".equals(header[1]) || !"characteristic1".equals(header[2])
				|| !"characteristic2".equals(header[3])) {
			System.out.println(
					"Invalid csv file. File should contain fruit-type, age-in-days, characteristic1,charecteristic2.");
			System.exit(-1);
		}
	}

	public static int getTotalCountOfAllFruits() {
		return FruitData.getTotalCount();
	}

	public static int getDistinctFruitTypeCount() {
		return FruitData.getFruitMap().size();
	}

	public static List<String> getOldestFruitList() {
		return FruitData.getOldestFruitList();
	}

	public static int getOldestAge() {
		return FruitData.getOldestCount();
	}

	public static List<String> getFruitKeysInDescendingOrder() {
		return FruitData.getFruitOrderKeys();
	}

	public static Map<String, List<String>> getFruitListMap() {
		return FruitData.getFruitMap();
	}

	public static Map<Fruit, Integer> getFruitTypeGroupMap() {
		return FruitData.getFruitTypeGroupMap();
	}

	public static Set<Fruit> getGroupedFruitTypes() {
		return FruitData.getFruitTypes();
	}
}
