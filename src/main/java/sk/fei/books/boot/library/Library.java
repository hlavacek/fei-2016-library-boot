package sk.fei.books.boot.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class Library {

	public static void main(String[] args) {
		SpringApplication.run(Library.class, args);
	}

	@GetMapping
	public String listBooks() {
		return "Hitchhiker's guide to the galaxy, Witcher";
	}

	@PostMapping
	public String createBook(@RequestBody String bookName) {
		return "Created book: " + bookName;
	}

	@PutMapping("/{id}")
	public String updateBook(@PathVariable("id") String id, @RequestBody String bookName) {
		return "Updated book " + id + " to " + bookName;
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id") String id) {
		return "Deleted book: " + id;
	}

}
