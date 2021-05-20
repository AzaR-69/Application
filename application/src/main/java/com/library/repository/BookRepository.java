package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.model.BookModel;

import java.util.*;

public interface BookRepository extends JpaRepository<BookModel,Integer>{
	 List<BookModel> findByGenre(String genre);
	 @Query("from BookModel where genre=?1 order by bookName")
	 List<BookModel> findByGenreSorted(String genre);
}
