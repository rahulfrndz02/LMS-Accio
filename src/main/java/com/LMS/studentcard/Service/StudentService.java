package com.LMS.studentcard.Service;

import com.LMS.studentcard.Enums.CardStatus;
import com.LMS.studentcard.Models.Card;
import com.LMS.studentcard.Models.Student;
import com.LMS.studentcard.Models.UpdateCountry;
import com.LMS.studentcard.Repository.StudentRepository;
import com.LMS.studentcard.RequestDto.StudentRequestDto;
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
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setCountry(studentRequestDto.getCountry());
        student.setEmail(studentRequestDto.getEmail());
        student.setName(studentRequestDto.getName());

        //cresting object of card class
        Card newCard = new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student); //For that new foreign key column

        //For that bidirectional relation
        student.setCard(newCard);

        studentRepository.save(student); //cardRepository.save() will automatically be taken care of
        return "Successfully added student and card";
    }
    public Student findStudentById(Integer id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public void updateStudentCountry(UpdateCountry updateCountry){
        int id = updateCountry.getId();
        Student countryToBeUpdated = studentRepository.findById(id).get();
        countryToBeUpdated.setName(updateCountry.getName());
        studentRepository.save(countryToBeUpdated);
    }

    public void deleteStudentById(Integer id) throws Exception{
        studentRepository.deleteAllById(Collections.singleton(id));
    }
}