package sk.fei.books.boot.storinglibrary;

import org.springframework.hateoas.ResourceSupport;

public class Book extends ResourceSupport {

	private String name;
	private String author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
