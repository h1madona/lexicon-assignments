import static org.junit.Assert.*;

import org.junit.Test;

public class AmazingListTest {
	
	AmazingList<String> list = new AmazingList<>();
	String firstElement = "firstElement";
	String secondElement = "secondElement";
	String thirdElement = "thirdElement";

	@Test
	public void addElementTest() {
		
		AmazingList<String> list = new AmazingList<>();
		
		list.add(firstElement);
		assertTrue(list.getElements().length == 1);
		
		list.add(secondElement);
		assertTrue(list.getElements().length == 2);
		
		assertFalse(list.getElements().length == 1);
		
		
		String actual = (String) list.getElements()[0];
		String expected = firstElement;
		String unexpected = secondElement;
		assertEquals(expected, actual);
		assertNotEquals(unexpected, actual);
		
	}
	
	@Test
	public void addIntegerElementTest() {
		AmazingList<Integer> list = new AmazingList<>();
		int firstElement = 1;
		int secondElement = 2;
		
		list.add(firstElement);
		assertTrue(list.getElements().length == 1);
		
		list.add(secondElement);
		assertTrue(list.getElements().length == 2);
		
		assertFalse(list.getElements().length == 1);
		
		
		Integer actual = (Integer) list.getElements()[0];
		Integer expected = firstElement;
		Integer unexpected = secondElement;
		assertEquals(expected, actual);
		assertNotEquals(unexpected, actual);
	}
	
	@Test
	public void getTest() {
		list.add(firstElement);
		list.add(secondElement);
		list.add(thirdElement);
		
		String actual = list.get(1);
		String expected = secondElement;
		assertEquals(expected, actual);
		assertEquals(null, list.get(3));
	}
	
	@Test
	public void removeElementTest() {
		
		list.add(firstElement);
		list.add(secondElement);
		list.add(thirdElement);
		assertTrue(list.getElements().length == 3);
		list.remove(1);
		assertTrue(list.getElements().length == 2);
		
	}
	
	@Test
	public void containsTest() {
		list.add(firstElement);
		list.add(secondElement);
		boolean actual = list.contains(firstElement);
		boolean expected = true;
		boolean unexpected = false;
		assertEquals(expected, actual);
		assertNotEquals(unexpected, actual);
	}
	
	@Test
	public void indexOfTest() {
		list.add(firstElement);
		list.add(secondElement);
		list.add(thirdElement);
		
		int expected = 2;
		int unexpected = 1;
		int actual = list.indexOf(thirdElement);
		
		assertEquals(expected, actual);
		assertNotEquals(unexpected, actual);
	}

}
