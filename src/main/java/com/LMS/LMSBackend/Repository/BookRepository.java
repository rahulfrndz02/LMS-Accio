package com.LMS.LMSBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
