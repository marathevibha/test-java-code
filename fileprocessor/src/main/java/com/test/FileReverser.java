package com.test;

import java.io.IOException;

public class FileReverser {
	
	private FileReader reader;
	private FileWriter writer;

	public FileReverser(FileReader reader, FileWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void reverseFileContent(String inputFilePath, String outputFilePath) throws IOException {
	
		// read file contents
		StringBuilder fileContent = reader.readFile(inputFilePath);

		// reverse the file contents
		fileContent.reverse();

		// write to file
		writer.writeFile(fileContent, outputFilePath);
	}

	public static void main(String[] args) {
		try {
			String inputFilePath = "src/main/resources/Input.txt";
			String outputFilePath = "src/main/resources/Output.txt";
			FileReverser fileReverser = new FileReverser(new  FileReader(), new FileWriter());
			fileReverser.reverseFileContent(inputFilePath, outputFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}