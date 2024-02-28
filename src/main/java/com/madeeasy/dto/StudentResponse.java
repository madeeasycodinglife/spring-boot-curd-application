package com.madeeasy.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
