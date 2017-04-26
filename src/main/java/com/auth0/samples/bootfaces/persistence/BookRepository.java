package com.auth0.samples.bootfaces.persistence;

import com.auth0.samples.bootfaces.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
