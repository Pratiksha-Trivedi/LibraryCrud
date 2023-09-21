
package com.myproject.librarySys.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Libraray1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	public Libraray1() { // TODO Auto-generated constructor stub
		System.out.println("Libraray.Libraray()");
	}

	private String library_name;
    
	@OneToMany(mappedBy = "libraray" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Book> book;


	/*
	 * public Libraray(Long id, String library_name, List<Book> book) { super();
	 * this.id = id; this.library_name = library_name; this.book = book; }
	 */


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLibrary_name() {
		return library_name;
	}



	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}





	public void setBook(List<Book> book) {
		this.book = book;
	}

	
	@Override
	public String toString() {
		return "Libraray1 [id=" + id + ", library_name=" + library_name + ", book=" + book + "]";
	}



	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return book;
	}
	
}
