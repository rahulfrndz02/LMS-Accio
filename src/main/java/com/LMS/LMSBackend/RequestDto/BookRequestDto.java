package com.LMS.LMSBackend.RequestDto;


import com.LMS.LMSBackend.Enums.Genre;
import lombok.Data;

@Data
public class BookRequestDto {


    private String name;

    private Genre genre;

    private int authorId;

}