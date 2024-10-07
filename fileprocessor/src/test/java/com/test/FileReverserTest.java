package com.test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileReverserTest {

	@Mock
	FileReader mockReader;
	
	@Mock
	FileWriter mockWriter;
	
	@Test
	public void testInputFileNotFound() {
		FileReverser reverser = new FileReverser(new FileReader(), new FileWriter());
		try {
			reverser.reverseFileContent("test.txt", "output.txt");
			fail();
		} catch (IOException e) {
			assertTrue(e instanceof NoSuchFileException);
		}
	}

	@Test
	public void testReverseFunction() {
		StringBuilder content = new StringBuilder("Hello World!");
		
		try {
			when(mockReader.readFile(anyString())).thenReturn(content);
	        FileReverser fileReverser = new FileReverser(mockReader, mockWriter);
	        
	        // Execute the method
	        fileReverser.reverseFileContent("input.txt", "output.txt");
	        
	        // Verify the interactions and the output
	        verify(mockReader).readFile("input.txt");
	        verify(mockWriter).writeFile(eq(content.reverse()), eq("output.txt"));
		} catch (IOException e) {
			fail();
		}
		
	}
}
