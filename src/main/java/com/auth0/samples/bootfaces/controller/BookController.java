package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Book;
import com.auth0.samples.bootfaces.persistence.BookRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "request")
@Join(path = "/bookz", to="/index.jsf")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	private Book book = new Book();

	public Book getBook() {
		return book;
	}

	public String doCreateBook() {
		this.bookRepository.save(book);
		book = new Book();
		return "index.xhtml";
	}

	public void doFindBookById() {
		book = bookRepository.findOne(this.book.getId());
	}

	public List<Book> findAllBooks() {
		return this.bookRepository.findAll();
	}

}
