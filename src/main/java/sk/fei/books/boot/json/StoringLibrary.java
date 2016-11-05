package sk.fei.books.boot.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class StoringLibrary {
	
	private List<String> books = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(StoringLibrary.class, args);
	}

	@GetMapping
	public String listBooks() {
		return books.stream().reduce((b1, b2) -> b1 + ",\n" + b2).orElse("");
	}

	@PostMapping
	public Integer createBook(@RequestBody String bookName) {
		books.add(bookName);
		return books.size() - 1;
	}

	@PutMapping("/{id}")
	public Integer updateBook(@PathVariable("id") Integer id, @RequestBody String bookName) {
		books.set(id, bookName);
		return id;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable("id") Integer id) {
		books.remove(id);
	}

}
