package com.varun.api.exceptions.handler;

import com.varun.api.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author varun.kumar
 */
@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ResponseDto> grepException(Exception e) {
    ResponseDto responseDto =
        ResponseDto.builder().errors("Invalid Data.. Please verify input... ").build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
  }
}
