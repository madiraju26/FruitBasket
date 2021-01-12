package com.fruit.db;

public class Fruit {
	private String fruitType;
	private String ageInDays;
	private String characteristic1;
	private String characteristic2;

	public Fruit(String[] fruit) {
		this.fruitType = fruit[0];
		this.ageInDays = fruit[1];
		this.characteristic1 = fruit[2];
		this.characteristic2 = fruit[3];
	}

	public String getFruitType() {
		return fruitType;
	}

	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}

	public String getAgeInDays() {
		return ageInDays;
	}

	public void setAgeInDays(String ageInDays) {
		this.ageInDays = ageInDays;
	}

	public String getCharacteristic1() {
		return characteristic1;
	}

	public void setCharacteristic1(String characteristic1) {
		this.characteristic1 = characteristic1;
	}

	public String getCharacteristic2() {
		return characteristic2;
	}

	public void setCharacteristic2(String characteristic2) {
		this.characteristic2 = characteristic2;
	}

	@Override
	public int hashCode() {
		return fruitType.hashCode();
	}

	@Override
	public boolean equals(Object f) {
		Fruit fruit = (Fruit) f;
		if (fruit.getFruitType().equals(this.fruitType) && fruit.getCharacteristic1().equals(this.characteristic1)
				&& fruit.getCharacteristic2().equals(characteristic2)) {
			return true;
		}
		return false;
	}
}