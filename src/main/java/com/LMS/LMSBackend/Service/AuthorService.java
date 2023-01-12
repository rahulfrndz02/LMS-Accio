package com.LMS.LMSBackend.Service;

import com.LMS.LMSBackend.Convertors.AuthorConvertor;
import com.LMS.LMSBackend.Models.Author;
import com.LMS.LMSBackend.Repository.AuthorRepository;
import com.LMS.LMSBackend.RequestDto.AuthorRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorRequestDto authorRequestDto){

        try {
            Author author = AuthorConvertor.convertDtoToEntity(authorRequestDto);
            authorRepository.save(author);
        }catch (Exception e){
            log.info("createAuthor has caused an error");
            return "Create author didn't work";
        }
        return "Author created successfully";
    }

}
