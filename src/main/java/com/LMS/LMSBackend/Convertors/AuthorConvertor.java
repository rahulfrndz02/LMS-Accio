package com.LMS.LMSBackend.Convertors;


import com.LMS.LMSBackend.Models.Author;
import com.LMS.LMSBackend.RequestDto.AuthorRequestDto;

public class AuthorConvertor {


    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto){

        Author author = Author.builder().
                name(authorRequestDto.getName())
                .age(authorRequestDto.getAge()).country(authorRequestDto.getCountry())
                .email(authorRequestDto.getEmail()).build();


        return author;
    }
}