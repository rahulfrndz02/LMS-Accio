package com.LMS.LMSBackend.Service;
import com.LMS.LMSBackend.Convertors.BookConvertor;
import com.LMS.LMSBackend.Models.Author;
import com.LMS.LMSBackend.Models.Book;
import com.LMS.LMSBackend.Repository.AuthorRepository;
import com.LMS.LMSBackend.Repository.BookRepository;
import com.LMS.LMSBackend.RequestDto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String createBook(BookRequestDto bookRequestDto){

        Book book = BookConvertor.convertDtoToEntity(bookRequestDto);

        //I need to set the AuthorEntity :

        int authorId = bookRequestDto.getAuthorId();

        //Getting the author Entity
        Author author  = authorRepository.findById(authorId).get();

        book.setAuthor(author);

        //That book list also needs to be updated

        List<Book> currentListOfBooks = author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);

        //Save the author
        authorRepository.save(author);

        //Save the book
        //this func will be automatically call by parent save
//        bookRepository.save(book);

        return "successfully added book";

    }

}