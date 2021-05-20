package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.model.BookModel;
import com.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public List<BookModel> getAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional
	public void addBook(BookModel book) {
		bookRepository.save(book);
	}

	@Transactional
	public List<BookModel> getBookByGenre(String genre) {
		List<BookModel> books = bookRepository.findByGenre(genre);
		return books;
	}

	@Transactional
	public void updateBook(int bookId, BookModel book) throws Exception{
		if (bookRepository.existsById(bookId)) {
			book.setBookId(bookId);
			bookRepository.save(book);
		}
		else {
			throw new Exception();
		}
	}	
	@Transactional
	public BookModel getBook(int bookId) {
		return bookRepository.findById(bookId).orElse(new BookModel());
	}

	@Transactional
	public List<BookModel> sortedBooks(String genre) {
		return bookRepository.findByGenreSorted(genre);
	}

	@Transactional
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}
}
