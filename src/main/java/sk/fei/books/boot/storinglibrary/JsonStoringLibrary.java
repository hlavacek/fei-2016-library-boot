package sk.fei.books.boot.storinglibrary;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class JsonStoringLibrary {
	
	private List<Book> books = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(JsonStoringLibrary.class, args);
	}

	@GetMapping
	public List<Book> listBooks() {
		return books;
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable("id") Integer id) {
		return books.get(id);
	}

	@PostMapping
	public Integer createBook(@RequestBody Book book) throws NoSuchMethodException, SecurityException {
		
		int bookId = books.size();
		books.add(book);
		book.add(linkTo(methodOn(JsonStoringLibrary.class).getBook(bookId)).slash(bookId).withSelfRel());
		book.add(linkTo(methodOn(JsonStoringLibrary.class).listBooks()).withRel("list"));
		return bookId;
	}

	@PutMapping("/{id}")
	public Integer updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		books.set(id, book);
		return id;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable("id") Integer id) {
		books.remove(id);
	}

}
