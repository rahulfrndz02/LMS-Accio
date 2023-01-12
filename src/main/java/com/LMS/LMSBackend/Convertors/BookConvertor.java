package com.LMS.LMSBackend.Convertors;

import com.LMS.LMSBackend.Models.Book;
import com.LMS.LMSBackend.RequestDto.BookRequestDto;

public class BookConvertor {


    public static Book convertDtoToEntity(BookRequestDto bookRequestDto){

        Book book = Book.builder().name(bookRequestDto.getName()).genre(bookRequestDto.getGenre()).build();

        return book;
    }


}
