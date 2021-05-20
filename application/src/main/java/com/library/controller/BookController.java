package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.library.model.BookModel;
import com.library.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@PostMapping(value = "/saveBook")
	public String addBook(@RequestBody BookModel book) {
		bookService.addBook(book);
		return "Inserted Successfully";
	}

	@PostMapping(value = "/editBook")
	public String editBook(@RequestParam("bookId") int bookId, @RequestBody BookModel book) {
		try{bookService.updateBook(bookId,book);
		return "Updated Successfully";}
		catch(Exception e) {
			return "Book with book ID "+bookId+" does not exist";
		}
	}

	@PostMapping(value = "/deleteBook")
	public String deleteBook(@RequestParam("bookId") int bookId) {
		try {
			bookService.deleteBook(bookId);
			return "Deleted Successfully";
		} catch (Exception e) {
			return "Incorrect BookId";
		}

	}

	@GetMapping(value="/getBooks")
	public List<BookModel> getBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "/getByType")
	public List<BookModel> getByType(@RequestParam("genre") String genre) {
		return bookService.sortedBooks(genre);

	}
}
