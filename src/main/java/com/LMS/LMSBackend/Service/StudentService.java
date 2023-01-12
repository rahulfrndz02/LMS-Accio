package com.LMS.LMSBackend.Service;

import com.LMS.LMSBackend.Enums.CardStatus;
import com.LMS.LMSBackend.Models.Card;
import com.LMS.LMSBackend.Models.Student;
import com.LMS.LMSBackend.Models.UpdateCountry;
import com.LMS.LMSBackend.Repository.StudentRepository;
import com.LMS.LMSBackend.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    CardService cardService;

    public String createStudent(StudentRequestDto studentRequestDto){

        //Step pending here :
        //Convert Dto to Entity ??

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setCountry(studentRequestDto.getCountry());
        student.setEmail(studentRequestDto.getEmail());
        student.setName(studentRequestDto.getName());


        Card newCard = cardService.createCard(student);


        //For that bidirectional relation
        student.setCard(newCard);

        studentRepository.save(student);
        //cardRepository.save() will automatically be taken of.

        return "Successfully added student and card";
    }
}