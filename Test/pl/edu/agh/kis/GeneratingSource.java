package pl.edu.agh.kis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class GeneratingSource {
	ClassGenerator cg = new ClassGenerator();
	
	@Test
	public void testGeneratingSource_Basic() {
		String[] result = cg.generateClass("KlasaTestowa1", "pl.edu.agh.kis").toArray(new String[0]);
		System.out.println(Arrays.toString(result));
		String[] expected = null;
		try {
			expected = FileReader.readLines("./files_essential_junit/expected.txt");
		} catch (IOException e) {
			fail("error!");
		}
		System.out.println(Arrays.toString(expected));
		assertArrayEquals(expected, result);
	}

}
