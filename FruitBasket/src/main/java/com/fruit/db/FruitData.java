package com.fruit.db;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitData {
	private static List<String[]> fruitList;
	private static Map<String, List<String>> fruitMap = new HashMap<>();
	private static int totalCount;
	private static List<String> oldestFruitList;
	private static int oldestCount;
	private static List<String> fruitOrderKeys;
	private static Map<Fruit, Integer> fruitTypeGroupMap = new HashMap<>();
	private static Set<Fruit> fruitTypes = new LinkedHashSet<>();

	public static List<String[]> getFruitList() {
		return fruitList;
	}

	public static void setFruitList(List<String[]> fL) {
		fruitList = fL;
	}

	public static Map<String, List<String>> getFruitMap() {
		return fruitMap;
	}

	public static void setFruitMap(Map<String, List<String>> fruitsMap) {
		fruitMap = fruitsMap;
	}

	public static int getTotalCount() {
		return totalCount;
	}

	public static void setTotalCount(int totalCount) {
		FruitData.totalCount = totalCount;
	}

	public static List<String> getOldestFruitList() {
		return oldestFruitList;
	}

	public static void setOldestFruitList(List<String> oldestFruitList) {
		FruitData.oldestFruitList = oldestFruitList;
	}

	public static int getOldestCount() {
		return oldestCount;
	}

	public static void setOldestCount(int oldestCount) {
		FruitData.oldestCount = oldestCount;
	}

	public static List<String> getFruitOrderKeys() {
		return fruitOrderKeys;
	}

	public static void setFruitOrderKeys(List<String> fruitOrderKeys) {
		FruitData.fruitOrderKeys = fruitOrderKeys;
	}

	public static Map<Fruit, Integer> getFruitTypeGroupMap() {
		return fruitTypeGroupMap;
	}

	public static void setFruitTypeGroupMap(Map<Fruit, Integer> fgm) {
		fruitTypeGroupMap = fgm;
	}

	public static Set<Fruit> getFruitTypes() {
		return fruitTypes;
	}

	public static void setFruitTypes(Set<Fruit> fruitTypes) {
		FruitData.fruitTypes = fruitTypes;
	}

}