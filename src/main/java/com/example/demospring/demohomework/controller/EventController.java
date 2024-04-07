package com.example.demospring.demohomework.controller;

import com.example.demospring.demohomework.model.events.APIResponseEvent;
import com.example.demospring.demohomework.model.events.Event;
import com.example.demospring.demohomework.model.events.EventRequest;
import com.example.demospring.demohomework.repository.EventRepository;
import com.example.demospring.demohomework.service.ServiceEvent.EventService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    public final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public ResponseEntity<?> getAllEvent(@Positive @RequestParam (defaultValue = "1") Integer offset,
                                         @RequestParam (defaultValue = "3") Integer limit){
        List<Event> events = eventService.getAllEvent(offset,limit);
        APIResponseEvent<?> apiResponseEvent = new APIResponseEvent<>(
                "The event get all successfully",
                 events,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseEvent);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getByIdEvent(@Positive @PathVariable Integer id){
        Event event = eventService.getByIdEvent(id);
        APIResponseEvent<?> apiResponseEvent = new APIResponseEvent<>(
                "The event get by id successfully",
                event,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseEvent);
    }
    @PostMapping
    public ResponseEntity<?> createEvent(@Valid @RequestBody EventRequest eventRequest){
        Event event = eventService.createEvent(eventRequest);
        APIResponseEvent<?> apiResponseEvent = new APIResponseEvent<>(
                "The events create successfully",
                event,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseEvent);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateEvent(@Positive @PathVariable Integer id,@Valid @RequestBody EventRequest eventRequest){
        Event event = eventService.updateEvent(id,eventRequest);
        APIResponseEvent<?> apiResponseEvent = new APIResponseEvent<>(
                "The event has been update successfully",
                event,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseEvent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEvent(@Positive @PathVariable Integer id){
        Event event = eventService.deleteEvent(id);
        APIResponseEvent<?> apiResponseEvent = new APIResponseEvent<>(
                "The event has been delete successfully",
                event,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseEvent);
    }
}
