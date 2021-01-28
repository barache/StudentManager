package com.javalearn.studentmanager.controller;

import com.javalearn.studentmanager.entity.Student;
import com.javalearn.studentmanager.exception.ResourceNotFoundException;
import com.javalearn.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/")
    public List<Student> getAllStudents(){
        List<Student> list = studentRepository.findAll();
        return list;
    }

    @GetMapping("/students/lastname/{lastname}")
    public List<Student> getAllStudentsByLastname(@PathVariable(value="lastname") String lastname){
        List<Student> list = studentRepository.findByLastname(lastname);
        return list;
    }

    @GetMapping("/students/groupe/{groupeId}")
    public List<Student> getAllStudentsByGroupe(@PathVariable(value="groupeId") long groupe){
        List<Student> list = studentRepository.findByGroupe(groupe);
        return list;
    }

    @GetMapping("/students")
    public List<Student> getStudentsByGroup(@RequestParam(value="groupe") long groupeId){
        List<Student> list = studentRepository.findByGroupe(groupeId);
        return list;
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
            throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id : " + studentId));
        return ResponseEntity.ok().body(student);
    }

    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId)
            throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

        studentRepository.delete(student);

        return ResponseEntity.ok().body("Student was deleted");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable (value = "id") Long studentId, @RequestBody Student studenTemp)
            throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id : " + studentId));
        student.setLastname(studenTemp.getLastname());
        student.setFirstname(studenTemp.getFirstname());
        student.setPhone(studenTemp.getPhone());
        student.setEmail(studenTemp.getEmail());
        student.setAddress(studenTemp.getAddress());
        Student updateStudent = studentRepository.save(student);
        return ResponseEntity.ok(updateStudent);
    }



}

