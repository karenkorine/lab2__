import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testLinkedList() {
		LinkedList<String> test = new LinkedList<>();// #1
		assertThrows(NoSuchElementException.class, () -> { 
			test.getFirst();
		});
		assertThrows(NoSuchElementException.class, () -> { 
			test.getLast();
		});
	}

	@Test
	void testGetLast() {
		LinkedList<String> L = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			L.getLast();
		}); // test 1
		L.addFirst("A");
		assertEquals("A", L.getLast()); // test 2
		L.addLast("B");
		assertTrue(L.getLast().equals("B")); // test 3
		// L.removeLast(); First I should create this method
		// assertNotEquals("B", L.getLast()); //test 4
	}

	@Test
	void testGetLength() {
		LinkedList<Double> test = new LinkedList<>();
		assertEquals(0, test.getLength());// #1
		test.addLast(3.5);
		assertEquals(1, test.getLength());// #2
	}

	@Test
	void testIsEmpty() {
		LinkedList<Integer> test = new LinkedList<>();
		assertTrue(test.isEmpty());// #1
		test.addFirst(6);
		assertFalse(test.isEmpty());// #2
	}

	@Test
	void testAddFirst() {
		LinkedList<Double> test = new LinkedList<>();
		test.addFirst(6.5);
		assertEquals("6.5 \n", test.toString()); // #1
		test.addFirst(4.5);
		assertEquals("4.5 6.5 \n", test.toString()); // #2
		// create getFirst() //#3

	}

	@Test
	void testAddLast() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addLast(6);
		assertEquals("6 \n", test.toString()); // #1
		test.addLast(4);
		assertEquals("6 4 \n", test.toString()); // #1
	}

	@Test
	void testToString() {
		LinkedList<Double> test = new LinkedList<>();
		assertEquals("\n", test.toString()); // #1
		// create get length use it and check with 1 node;
		// create get length use it and check with more than 1 node;
	}

	@Test
	void testLinkedListTArray() {
		fail("Not yet implemented");
	}

	@Test
	void testLinkedListLinkedListOfT() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFirst() {
		LinkedList<String> L = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			L.getFirst();
		}); // test 1
		L.addLast("A");
		assertEquals("A", L.getFirst()); // test 2
		L.addFirst("B");
		assertTrue(L.getFirst().equals("B")); // test 3
		// L.removeFirst(); First I should create this method
		// assertNotEquals("B", L.getLast()); //test 4

	}

	@Test
	void testGetIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testOffEnd() {
		fail("Not yet implemented");
	}

	@Test
	void testAddIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveFirst() {
		LinkedList<String> L = new LinkedList<>();
		// testing precondition:
		assertThrows(NoSuchElementException.class, () -> {
			L.removeFirst();
		});
		// add 3 more tests below
		L.addFirst("A"); //test 2: length = 1
		L.removeFirst();
		assertTrue(L.offEnd());
		
		L.addFirst("A"); //test 3: iterator = first
		L.addLast("B");
		L.positionIterator();
		L.removeFirst();
		assertTrue(L.offEnd());
		
		L.addLast("C"); //test 4: general case
		L.positionIterator(); 
		L.advanceIterator();
		L.removeFirst();
		assertEquals("C \n", L.toString());
	}

	@Test
	void testRemoveLast() {
		LinkedList<String> L = new LinkedList<>();
		// testing precondition:
		assertThrows(NoSuchElementException.class, () -> {
			L.removeLast();
		});
		// add 3 more tests below
		L.addLast("A"); //test 2: length = 1
		L.removeLast();
		assertTrue(L.offEnd());
		
		L.addFirst("A"); //test 3: iterator = last 
		L.addLast("B");
		L.positionIterator();
		L.advanceIterator();
		L.removeLast();
		assertTrue(L.offEnd());
		
		L.addLast("C"); //test 4: general case
		L.addLast("D");
		L.positionIterator(); 
		L.advanceIterator();
		L.removeLast();
		assertEquals("A C \n", L.toString());
	}

	@Test
	void testRemoveIterator() {
		LinkedList<String> L = new LinkedList<>(); //test 1
		// testing precondition:
		assertThrows(NullPointerException.class, () -> {
			L.removeIterator();
		});
		
		L.addFirst("A");   // test 2: iterator = first
		L.positionIterator();
		L.removeIterator();
		assertTrue(L.offEnd());
		
		L.addFirst("B"); // test 3: iterator = last
		L.addLast("C");
		L.positionIterator();
		L.advanceIterator();
		L.removeIterator();
		assertEquals("B \n", L.toString());
		
		L.addFirst("A"); // test 4: general case
		L.addLast("C");
		L.positionIterator();
		L.advanceIterator();
		L.removeIterator();
		assertEquals("A C \n", L.toString());
	}

	@Test
	void testPositionIterator() {
		LinkedList<String> L = new LinkedList<>();
		L.positionIterator();
		assertTrue(L.offEnd()); // test 1 when list is empty
		
		L.addFirst("K"); //test 2 - when length = 1 
		L.positionIterator();
		assertEquals("K", L.getIterator());
		
		L.addFirst("A"); //test 3 - when length more than 1
		L.addLast("C");
		L.advanceIterator();
		L.positionIterator();
		assertEquals("A", L.getIterator());
		
	}

	@Test
	void testAdvanceIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testReverseIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testZipperLists() {
		LinkedList<String> L = new LinkedList<>();
		L.addFirst("1");
		L.addLast("2");
		
		LinkedList<String> M = new LinkedList<>();
		M.addFirst("4");
		M.addLast("5");
		
		LinkedList<String> K = new LinkedList<>();
		
		K.addFirst("5");
		K.addFirst("2");
		K.addFirst("4");
		K.addFirst("1");
		
		K.toString();
		assertEquals(K.toString(),  L.zipperLists(M));
	}

	@Test
	void testContainsBrokenLinks() {
		fail("Not yet implemented");
	}

}
