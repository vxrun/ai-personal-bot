package com.varun.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author varun.kumar
 */
@Data
@Builder
public class ResponseDto implements Serializable {
  private String data;
  private String errors;
  private String comments;
}
