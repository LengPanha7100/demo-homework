package com.example.demospring.demohomework.model.venues;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class APIResponseVenues<T>{
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalTime time;
}
