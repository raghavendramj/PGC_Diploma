package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
