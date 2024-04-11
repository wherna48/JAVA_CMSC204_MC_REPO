import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
		
		String converter2 = MorseCodeConverter.convertToEnglish("... ..- .-. - .-. / .. ... / -... .- .");
		assertEquals("surtr is bae", converter2);
		
		String converter3 = MorseCodeConverter.convertToEnglish(".- -.-. .... . .-. --- -. / .. ... / --- .--.");
		assertEquals("acheron is op", converter3);
	}

	@Test
	void testConvertToEnglishFile() {
		File file = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		
		File file2 = new File("src/Daisy.txt"); 
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file2));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
