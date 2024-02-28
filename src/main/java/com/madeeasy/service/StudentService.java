package com.madeeasy.service;

import com.madeeasy.dto.StudentRequest;
import com.madeeasy.dto.StudentPartiallyUpdateRequest;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<?> createStudent(StudentRequest studentRequest);

    ResponseEntity<?> getAllStudents();

    ResponseEntity<?> updateStudent(StudentRequest studentRequest, Long id);

    ResponseEntity<?> deleteStudent(Long id);

    ResponseEntity<?> partialUpdate(StudentPartiallyUpdateRequest studentUpdateRequest, Long id);

    ResponseEntity<?> getStudentById(Long id);
}
