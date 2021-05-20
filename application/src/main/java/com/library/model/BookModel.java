package com.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "librarymanagement")
public class BookModel {
	@Id
	private int bookId;
	private int quantity;
	private String bookName;
	private String genre;

	public BookModel() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "BookModel [bookId=" + bookId + ", quantity=" + quantity + ", bookName=" + bookName + ", genre=" + genre
				+ "]";
	}


}
