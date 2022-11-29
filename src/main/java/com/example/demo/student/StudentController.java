package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v2/shipping")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @GetMapping(path = "{shippingId}")
    public Student getStudent(@PathVariable("shippingId") Long Id) {
        return studentService.getStudentbyId(Id);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{shippingId}")
    public void deleteStudent(@PathVariable("shippingId") Long studentId){
        studentService.deleteStudent(studentId);
    }

//    @PutMapping(path = "{studentId}")
//    public void updateStudent(@PathVariable("studentId") Long studentId,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email){
//        studentService.updateStudent(studentId, name, email);
//
//
//    }

}
