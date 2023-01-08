package com.LMS.studentcard.Controllers;

import com.LMS.studentcard.Models.Student;
import com.LMS.studentcard.Models.UpdateCountry;
import com.LMS.studentcard.RequestDto.StudentRequestDto;
import com.LMS.studentcard.Service.StudentService;
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

    @GetMapping("/find_student/{id}")
    public Student findStudent(@PathParam("id") Integer id){
        try {
            Student student = studentService.findStudentById(id);
            return student;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update_country")
    public void updateCountry(@RequestBody UpdateCountry updateCountry) {
        studentService.updateStudentCountry(updateCountry);
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        try {
            studentService.deleteStudentById(id);
            return "Deleted successfully";
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}