package com.example.demospring.demohomework.controller;

import com.example.demospring.demohomework.model.attendees.APIResponseAttendees;
import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.attendees.AttendeesRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demospring.demohomework.service.ServiceAttendees.AttendeesService;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeesController {
    public final AttendeesService attendeesService;

    public AttendeesController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAttendees(@Positive @RequestParam(defaultValue = "1") Integer offset,
                                             @RequestParam(defaultValue = "3") Integer limit){
        List<Attendees> attendees = attendeesService.getAllAttendees(offset,limit);
        APIResponseAttendees<?> responseAttendees = new APIResponseAttendees<>(
                "The attendees get all successfully",
                attendees,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(responseAttendees);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getByID(@Positive @PathVariable Integer id) {
          Attendees attendees = attendeesService.getById(id);
          APIResponseAttendees<?> apiResponseAttendees = new APIResponseAttendees<>(
                  "The attendees get by id successfully",
                  attendees,
                  HttpStatus.OK,
                  LocalTime.now()
          );
          return  ResponseEntity.ok(apiResponseAttendees);

    }
    @PostMapping
    public ResponseEntity<?> createAttendees(@Valid @RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees = attendeesService.createAttendees(attendeesRequest);
        APIResponseAttendees<?> apiResponseAttendees = new APIResponseAttendees<>(
                "The attendees has been create successfully",
                attendees,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseAttendees);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateAttendees(@Positive @PathVariable Integer id,@Valid @RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees =attendeesService.updateAttendees(id,attendeesRequest);
        APIResponseAttendees<?> apiResponseAttendees = new APIResponseAttendees<>(
                "The attendees has been update successfully",
                attendees,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseAttendees);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAttendees(@Positive @PathVariable Integer id){
        Attendees attendees = attendeesService.deleteAttendees(id);
        APIResponseAttendees<?> apiResponseAttendees = new APIResponseAttendees<>(
                "The attendees has been delete successfully",
                null,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseAttendees);
    }
}
