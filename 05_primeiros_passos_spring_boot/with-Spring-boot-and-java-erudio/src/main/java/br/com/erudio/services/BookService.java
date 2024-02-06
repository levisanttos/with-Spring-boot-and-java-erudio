package br.com.erudio.services;

import java.util.List;

import br.com.erudio.data.vo.BookDTO;

public interface BookService {
	
	List<BookDTO> getBooks();
	
	BookDTO getBookById(Long id);
	
	BookDTO save(BookDTO bookDTO);
	
	BookDTO update(Long id, BookDTO bookDTO);
	
	void delete(Long id);

}
