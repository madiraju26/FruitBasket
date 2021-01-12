package com.fruit;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class ReportHelper {
	public static List<String[]> getCSVFileContent(String filePath) {
		if (!filePath.endsWith(".csv")) {
			System.out.println("1-Invalid file path provided. Please provide a valid csv filename.");
			System.exit(-1);
		}

		List<String[]> csvContent = null;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			csvContent = reader.readAll();
			// csvContent.forEach(x -> System.out.println(Arrays.toString(x)));
		} catch (Exception e) {
			System.out.println("2-Invalid file path provided. Please provide a valid csv file.");
		}

		return csvContent;
	}
}
