package pl.edu.agh.kis;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.AfterClass;
import org.junit.Test;

public class WritingToFileTest {

	@Test
	public void testWritingToFile_Basic() {
		String[] toWrite = {"aye", "BackTo TheFuture", "2.0abc"};
		
		try {
			FileWriter.writeLines("JUNITtest.txt", toWrite);
		} catch (IOException e) {
			fail("error!");
		}
		
		String[] result = null;
		
		try {
			result = FileReader.readLines("JUNITtest.txt");
		} catch (IOException e) {
			fail("error!");
		}
		
		assertArrayEquals(toWrite, result);
	}
	
	@AfterClass
	public static void afterClass(){
		File f = new File("JUNITtest.txt");
		f.delete();
	}

}
