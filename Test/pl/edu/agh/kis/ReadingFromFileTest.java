package pl.edu.agh.kis;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ReadingFromFileTest {

	@Test
	public void testReadingFromFile_Basic() {
		String[] result = null;
		try {
			result = FileReader.readLines("test.txt");
		} catch (IOException e) {
			fail("error");
		}
		
		String[] expected = { "ez" ,"skins","2.0","2" ,"1234"};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testReadingFromFile_NullPath() {
		String[] result = null;
		try {
			result = FileReader.readLines("null");
		} catch (IOException e) {
		}
	}

}
