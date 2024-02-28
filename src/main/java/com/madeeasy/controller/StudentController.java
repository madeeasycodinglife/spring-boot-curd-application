package com.madeeasy.controller;

import com.madeeasy.dto.StudentRequest;
import com.madeeasy.dto.StudentPartiallyUpdateRequest;
import com.madeeasy.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student-service")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(
            tags = "Get all students",
            summary = "Get all students",
            description = "Get all students"
    )

    @GetMapping(path = "/get-all-students")
    public ResponseEntity<?> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(
            tags = "Get student by id",
            summary = "Get student by id",
            description = "Get student by id"
    )
    @GetMapping(path = "/get-student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @Operation(
            tags = "Create student",
            summary = "Create student",
            description = "Create student"
    )
    @PostMapping(path = "/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @Operation(
            tags = "Update student",
            summary = "Update student",
            description = "Update student"
    )
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid StudentRequest studentRequest,
                                           @PathVariable("id") Long id) {
        return studentService.updateStudent(studentRequest, id);
    }

    @Operation(
            tags = "Partial update student",
            summary = "Partial update student",
            description = "Partial update student"
    )
    @PatchMapping(path = "/patch/{id}")
    public ResponseEntity<?> partialUpdate(StudentPartiallyUpdateRequest studentUpdateRequest,
                                           @PathVariable("id") Long id) {
        return studentService.partialUpdate(studentUpdateRequest, id);
    }

    @Operation(
            tags = "Delete student",
            summary = "Delete student",
            description = "Delete student"
    )
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }
}
