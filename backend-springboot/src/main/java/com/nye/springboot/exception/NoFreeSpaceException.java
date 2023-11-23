package com.nye.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Registration failed: No free spaces available.")
public class NoFreeSpaceException extends RuntimeException {
    

}
