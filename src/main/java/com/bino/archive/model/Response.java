package com.bino.archive.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
    private Integer statusCode;
    private String reason;
    private String message;
    private String developpeurError;
    private Map<?,?> data;
}
