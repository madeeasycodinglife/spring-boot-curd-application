package com.madeeasy.service.impl;

import com.madeeasy.dto.StudentRequest;
import com.madeeasy.dto.StudentResponse;
import com.madeeasy.dto.StudentPartiallyUpdateRequest;
import com.madeeasy.entity.Student;
import com.madeeasy.exception.StudentNotFoundException;
import com.madeeasy.repository.StudentRepository;
import com.madeeasy.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<?> createStudent(StudentRequest studentRequest) {
        Student student = Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .phone(studentRequest.getPhone())
                .build();
        Student savedStudent = this.studentRepository.save(student);
        StudentResponse studentResponse = StudentResponse.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .phone(savedStudent.getPhone())
                .build();
        return ResponseEntity.ok().body(studentResponse);
    }

    @Override
    public ResponseEntity<?> getAllStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        if (studentList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(studentList);
    }

    @Override
    public ResponseEntity<?> updateStudent(StudentRequest studentRequest, Long id) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for id " + id));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setPhone(studentRequest.getPhone());
        Student updatedStudent = this.studentRepository.save(student);
        StudentResponse studentResponse = StudentResponse.builder()
                .id(updatedStudent.getId())
                .firstName(updatedStudent.getFirstName())
                .lastName(updatedStudent.getLastName())
                .email(updatedStudent.getEmail())
                .phone(updatedStudent.getPhone())
                .build();
        return ResponseEntity.ok().body(studentResponse);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long id) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for id " + id));
        this.studentRepository.delete(student);
        return ResponseEntity.ok().body("Student deleted successfully whose id " + id);
    }

    @Override
    public ResponseEntity<?> partialUpdate(StudentPartiallyUpdateRequest studentUpdateRequest, Long id) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for id " + id));
        if (!ObjectUtils.isEmpty(studentUpdateRequest.getFirstName()))
            student.setFirstName(studentUpdateRequest.getFirstName());
        if (!ObjectUtils.isEmpty(studentUpdateRequest.getLastName()))
            student.setLastName(studentUpdateRequest.getLastName());
        if (!ObjectUtils.isEmpty(studentUpdateRequest.getEmail()))
            student.setEmail(studentUpdateRequest.getEmail());
        if (!ObjectUtils.isEmpty(studentUpdateRequest.getPhone()))
            student.setPhone(studentUpdateRequest.getPhone());
        Student updatedStudent = this.studentRepository.save(student);
        StudentResponse studentResponse = StudentResponse.builder()
                .id(updatedStudent.getId())
                .firstName(updatedStudent.getFirstName())
                .lastName(updatedStudent.getLastName())
                .email(updatedStudent.getEmail())
                .phone(updatedStudent.getPhone())
                .build();
        return ResponseEntity.ok().body(studentResponse);
    }

    @Override
    public ResponseEntity<?> getStudentById(Long id) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for id " + id));
        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .build();
        return ResponseEntity.ok().body(studentResponse);
    }

}
