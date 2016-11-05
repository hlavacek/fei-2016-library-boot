package sk.fei.books.client;


import java.util.List;

import org.springframework.web.client.RestTemplate;

import sk.fei.books.boot.storinglibrary.Book;

public class RestClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		List<Book> books = rt.getForObject("http://localhost:8080/books", List.class);
		System.out.println(books.size());
	}
}
