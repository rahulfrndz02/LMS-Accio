package com.LMS.LMSBackend.Controllers;

import com.LMS.LMSBackend.Models.Student;
import com.LMS.LMSBackend.Models.UpdateCountry;
import com.LMS.LMSBackend.RequestDto.StudentRequestDto;
import com.LMS.LMSBackend.Service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody() StudentRequestDto studentRequestDto){

        String result = studentService.createStudent(studentRequestDto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}