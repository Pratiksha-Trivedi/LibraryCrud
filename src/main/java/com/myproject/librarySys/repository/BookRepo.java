
package com.myproject.librarySys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.librarySys.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
