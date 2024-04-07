package com.example.demospring.demohomework.model.attendees;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class APIResponseAttendees<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalTime time;

}
