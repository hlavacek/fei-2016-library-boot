package sk.fei.books.client;


import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import sk.fei.books.boot.storinglibrary.Book;

public class RestClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		RestTemplate rt = new RestTemplate();
		List<Book> books = rt.getForObject("http://localhost:8080/books", List.class);
		System.out.println(books.size());
		
		AsyncRestTemplate art = new AsyncRestTemplate();
		
		ListenableFuture<ResponseEntity<List>> future = art.getForEntity("http://localhost:8080/books", List.class);
		
		System.out.println("I can do something");
		
		System.out.println(future.get().getBody().size());
	}
}
