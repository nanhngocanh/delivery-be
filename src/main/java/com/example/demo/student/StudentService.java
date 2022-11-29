package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentbyId(Long Id) {
        Student student = studentRepository.findById(Id).orElseThrow(() -> new IllegalStateException("shipment with id " + Id + " does not exists"));
        return student;
    }
    public void addNewStudent(Student student){
//        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        studentRepository.save(student);
        System.out.println(student);
    }
    public void deleteStudent(Long Id){
        boolean exists = studentRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("shipment with id " + Id + " does not exists");
        }
        studentRepository.deleteById(Id);
    }

//    @Transactional
//    public void updateStudent(Long Id,String name,String email){
//        Student student = studentRepository.findById(Id).orElseThrow(() -> new IllegalStateException("student with id " + Id + " does not exists"));
//    if(name != null && name.length() > 0 && !Objects.equals(student.getType(), name)){
//        student.setType(name);
//    }
//
//    if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
//        student.setEmail(email);
//        }
//    }
}
