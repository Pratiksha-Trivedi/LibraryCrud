
package com.myproject.librarySys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.librarySys.Entity.Book;
import com.myproject.librarySys.Entity.Libraray1;
import com.myproject.librarySys.repository.BookRepo;
import com.myproject.librarySys.repository.librarayRepository;

@RestController
@RequestMapping("/lib")
public class userController {

//	 @GetMapping("/")
//	 public String get()
//	 {
//		 return "Hello";
//	 }
	@Autowired
	private librarayRepository repository;

	@Autowired
	private BookRepo bookRepo;

	@GetMapping("/")
	public List<Libraray1> get() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Libraray1 getLibraryById(@PathVariable Long id) {
		Optional<Libraray1> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	@PostMapping("/")
	public Libraray1 create(@RequestBody Libraray1 libraray1) {
		// return repository.save(user);
		if (libraray1.getBook().isEmpty()) {
			return repository.save(libraray1);
		} else {
			List<Book> books = libraray1.getBook();
			books.stream().forEach(e -> e.setLibraray(libraray1));
			libraray1.setBook(books);
			return repository.save(libraray1);
		}

	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {

		Optional<Libraray1> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.deleteById(id);
		}

	}
	@GetMapping("/{id}/books")
	public List<Book> getAllBooksByLibraryId(@PathVariable Long id) {
		Optional<Libraray1> findById = repository.findById(id);
		if (findById.isPresent()) {
			Libraray1 library = findById.get();
			return library.getBook();
		} else
			return null;
	}

	@PutMapping("/")
	public Libraray1 updateCompnyById(@RequestBody Libraray1 lib) {

		System.out.println(lib.getLibrary_name() + " " + lib.getId());
		return repository.save(lib);
	}

	// book
	@GetMapping("/getbook")
	public List<Book> getBook() {
		return bookRepo.findAll();
	}

	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book) {
		System.out.println(book);
		return bookRepo.save(book);
	}
}
