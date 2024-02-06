package br.com.erudio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.BookDTO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.ModelMapperUtil;
import br.com.erudio.model.Book;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<BookDTO> getBooks() {
		return this.bookRepository.findAll().stream().map(book -> {
			BookDTO bookDTO = ModelMapperUtil.parseObject(book, BookDTO.class);
			return bookDTO;
		}).toList();
	}

	@Override
	public BookDTO getBookById(Long id) {
		return this.bookRepository.findById(id).map(book -> {
			BookDTO bookDTO = ModelMapperUtil.parseObject(book, BookDTO.class);
			return bookDTO;
		}).orElseThrow( () -> new ResourceNotFoundException("Livro não encontrado!"));
	}

	@Override
	public BookDTO save(BookDTO bookDTO) {
		
		Book book = ModelMapperUtil.parseObject(bookDTO, Book.class);
		book = this.bookRepository.save(book);
		bookDTO.setId(book.getId());
		return bookDTO;
	}

	@Override
	public BookDTO update(Long id, BookDTO bookDTO) {
		return this.bookRepository.findById(id).map(book -> {
			book.setAuthor(bookDTO.getAuthor());
			book.setLaunch_date(bookDTO.getLaunch_date());
			book.setPrice(bookDTO.getPrice());
			book.setTitle(bookDTO.getTitle());
			this.bookRepository.saveAndFlush(book);
			bookDTO.setId(id);
			return bookDTO;
		}).orElseThrow( () -> new ResourceNotFoundException("Livro não encontrado!"));
	}

	@Override
	public void delete(Long id) {
		if (this.getBookById(id) != null) {
			this.bookRepository.deleteById(id);
		}

	}

}
