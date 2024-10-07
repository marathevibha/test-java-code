package com.test;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
	public void writeFile(StringBuilder fileContent, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
			writer.write(fileContent.toString());
			System.out.println("Data written to file successfully.");
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
			throw e;
		}
	}
}
