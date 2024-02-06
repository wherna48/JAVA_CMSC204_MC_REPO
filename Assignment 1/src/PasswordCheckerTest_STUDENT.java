
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author William Hernandez
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;
	@Before
	public void setUp() throws Exception {
		String[] p = {"SURTR143#", "aaaMiya1#", "ines4#", "KaltsitRI#", "c3ob#", "WarfarinR1", 
				"DoctorRI", "aa11Bb", "pilotProject", "SSSurtr132@3"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("SURTRrrr1413!"));	// should throw invalid sequence
			assertTrue("Did not throw lengthException",false);	
		}
		catch(LengthException e) {
			assertTrue("Successfully threw a lengthException", true);			
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides lengthException", true);
			System.out.println(e.getMessage());
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("c3obe"));			// should throw Length exception
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e) {
			assertTrue("Successfully threw a lengthException", true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
			System.out.println(e.getMessage());
		}				
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("nes4#"));					// should throw length exception
			assertTrue("Did not throw NoUpperAlphaException", false);						
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", true); 
			System.out.println(e.getMessage());
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("aaamiya1"));					// should throw no upper exception
			assertTrue("Did not throw NoUpperAlphaException", false);
		}catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false); 
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("ines4#"));					// should throw some other exception
			assertTrue("Did not throw NoLowerAlphaException", false);						
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", true); 
			System.out.println(e.getMessage());
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("INES4#"));					// should throw lower exception
			assertTrue("Did not throw NoLowerAlphaException", false);
		}catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false); 
			System.out.println(e.getMessage());
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Kaltsit1#"));					// No exceptions thrown
			assertTrue("Did not throw NoLowerAlphaException", true);
		}catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false); 
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword​("Surt@1");	// throw weak password exception
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);

		}
		
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword​("Surtr1413!");	//  a strong password, throws no exceptions
			assertTrue("Did not throw WeakPassword Exception",true);
		}
		catch(WeakPasswordException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);

		}
		
		
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Ka1tsit111#"));					// should throw some other exception
			assertTrue("Did not throw InvalidSequenceException", false);						
		}
		catch(InvalidSequenceException e) {
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a InvalidSequenceException", true);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides InvalidSequenceException", false); 
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Surtr2413#@AAaa"));					// should not throw any exception
			assertTrue("Did not throw InvalidSequenceException", true);						
		}
		catch(InvalidSequenceException e) {
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a InvalidSequenceException", true);

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides InvalidSequenceException", false); 

		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Kaltsit*#^@"));		// throws exception
			assertTrue("Did not throw NoDigitException", false);
		}
		catch(NoDigitException e) {
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a NoDigitException", true);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides NoDigitException", false);
			
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Kaltsit*#^@1"));		// Throws no exception
			assertTrue("Did not throw NoDigitException", true);
		}
		catch(NoDigitException e) {
			
			assertTrue("Successfully threw a NoDigitException", true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides NoDigitException", false);
			
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
				assertTrue(PasswordCheckerUtility.isValidPassword​("Kaltsit*#^@1"));		// Throws no exception, 
				assertTrue("Did not throw any Exception", true);
				System.out.println("Threw no Exception");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some exception and was not a valid password", false);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Kaltsit*#^@"));		// Throws exception
			assertTrue("Did not throw any Exception", false);
			System.out.println("Threw no Exception");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		assertTrue("Threw some exception and was not a valid password", true);
	}
	
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords​(passwords);
		
		Scanner scan = new Scanner (results.get(3));
		assertEquals(scan.next(), "KaltsitRI#");
		String nextResults = scan.nextLine().toLowerCase();	// read the exception message
		System.out.println(nextResults);
		assertTrue(nextResults.contains("digit") );			// find word
		
		scan = new Scanner (results.get(9));
		assertEquals(scan.next(), "SSSurtr132@3");
		nextResults = scan.nextLine().toLowerCase();	// read the exception message
		System.out.println(nextResults);
		assertTrue(nextResults.contains("sequence"));
	}
	
}
