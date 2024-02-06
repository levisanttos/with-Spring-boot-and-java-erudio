package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.BookDTO;
import br.com.erudio.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getBooks() {
		return new ResponseEntity<List<BookDTO>>(this.bookService.getBooks(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<BookDTO>(this.bookService.getBookById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookDTO> save(@RequestBody BookDTO bookDTO) {
		return new ResponseEntity<BookDTO>(this.bookService.save(bookDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable(value = "id") Long id, @RequestBody BookDTO bookDTO) {
		return new ResponseEntity<BookDTO>(this.bookService.update(id, bookDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value ="id") Long id) {
		this.bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
