package com.LMS.LMSBackend.Repository;

import com.LMS.LMSBackend.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
