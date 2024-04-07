package com.example.demospring.demohomework.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;


import java.time.LocalDateTime;
import java.util.HashMap;



@ControllerAdvice

public class GlobalException {
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );
        problemDetail.setTitle("Not found");
        problemDetail.setProperty("timestamp", LocalDateTime.now());

        return problemDetail;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        HashMap<String, String> errors = new HashMap<>();

        //it's catch error for building that it make
        //get field name and error message for MethodArgumentNotValidException
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        //focus on UI
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Invalid request"
        );
        problemDetail.setTitle("Bad Request");
//        problemDetail.setType(URI.create("http://localhost:8080/attendees/not found"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("error", errors);
        return problemDetail;
    }


//    @ExceptionHandler(HandlerMethodValidationException.class)
//    public ProblemDetail methodValidationException(HandlerMethodValidationException e) {
//        HashMap<String, String> errors = new HashMap<>();
//        //get parameter name and error message from exception
//
//        for (var parameterError : e.getAllValidationResults()) {
//            final String parameterName = parameterError.getMethodParameter().getParameterName();
//            for (var error : parameterError.getResolvableErrors()) {
//                errors.put(parameterName, error.getDefaultMessage());
//            }
//        }
//
//        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
//                HttpStatus.BAD_REQUEST,
//                "Validation failed"
//        );
//        problemDetail.setTitle("Bad Request");
//        problemDetail.setProperty("timestamp", LocalDateTime.now());
//        problemDetail.setProperty("errors", errors);
//        return problemDetail;
//    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    public ProblemDetail handleMethodValidationException(HandlerMethodValidationException e){
        HashMap<String, String> errors = new HashMap<>();

        for (var parameterError : e.getAllValidationResults()){
            String parameterName = parameterError.getMethodParameter().getParameterName();
            //get message error
            for(var error : parameterError.getResolvableErrors()){
                errors.put(parameterName,error.getDefaultMessage());
            }
        }
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Invalid request"
        );
        problemDetail.setTitle("Bad Request");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("error", errors);
        return problemDetail;
    }
}