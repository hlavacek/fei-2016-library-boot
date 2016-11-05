package sk.fei.books.boot.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void shouldReturnBook() {
		Library library = new Library();
		
		assertEquals("Hitchhiker's guide to the galaxy, Witcher", library.listBooks());
	}
}
