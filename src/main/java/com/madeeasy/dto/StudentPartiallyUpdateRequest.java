package com.madeeasy.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentPartiallyUpdateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
