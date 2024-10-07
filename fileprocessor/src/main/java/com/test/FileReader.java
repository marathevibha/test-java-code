package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
	public StringBuilder readFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		StringBuilder fileContents = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				fileContents.append(line).append("\n");
			}
		}

		fileContents.deleteCharAt(fileContents.lastIndexOf("\n"));
		return fileContents;
	}

}
