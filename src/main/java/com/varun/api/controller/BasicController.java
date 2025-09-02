package com.varun.api.controller;

import com.varun.api.dto.RequestDto;
import com.varun.api.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author varun.kumar
 */
@RestController
public class BasicController {

  public ResponseEntity<ResponseDto> basic(RequestDto requestDto) {
    return new ResponseEntity<ResponseDto>(HttpStatus.OK);
  }
}
