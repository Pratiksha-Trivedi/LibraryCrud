
package com.myproject.librarySys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	public Book() { 
		// TODO Auto-generated constructor stub
		System.out.println("Book.Book()");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String isbn; // International Standard Book Number
	private String catalogNumber; // Library-specific catalog number
	private String title;
	private String author;

	@JsonIgnore
	@ManyToOne
	private Libraray1 libraray;
	
	

	public Libraray1 getLibraray() {
		return libraray;
	}

	public void setLibraray(Libraray1 libraray) {
		this.libraray = libraray;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Book(String isbn, String catalogNumber, String title, String author) {
		this.isbn = isbn;
		this.catalogNumber = catalogNumber;
		this.title = title;
		this.author = author;

		// TODO Auto-generated constructor stub
	}


}
