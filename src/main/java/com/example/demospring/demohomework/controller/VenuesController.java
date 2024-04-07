package com.example.demospring.demohomework.controller;

import com.example.demospring.demohomework.model.venues.APIResponseVenues;
import com.example.demospring.demohomework.model.venues.Venues;
import com.example.demospring.demohomework.model.venues.VenuesRequest;
import com.example.demospring.demohomework.service.ServiceVenues.VenuesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenuesController {
    public final VenuesService venuesService;

    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }

    @GetMapping
    public ResponseEntity<?> getAllVenues(@Positive @RequestParam(defaultValue = "1") Integer offset,
                                          @RequestParam(defaultValue = "3") Integer limit){
        List<Venues> venues = venuesService.getAllVenues(offset,limit);
        APIResponseVenues<?> apiResponseVenues = new APIResponseVenues<>(
                "The venues get all successfully",
                venues,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseVenues);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getByIdVenues(@Positive @PathVariable Integer id){
        Venues venues = venuesService.getByIdVenues(id);
        APIResponseVenues<?> apiResponseVenues = new APIResponseVenues<>(
                "The Venues get by id successfully",
                venues,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseVenues);
    }
    @PostMapping
    public ResponseEntity<?> createVenues(@Valid @RequestBody VenuesRequest venuesRequest){
        Venues venues = venuesService.createVenues(venuesRequest);
        APIResponseVenues<?> apiResponseVenues = new APIResponseVenues<>(
                "The venues create successfully",
                venues,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseVenues);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateVenues(@Positive @PathVariable Integer id,@Valid @RequestBody VenuesRequest venuesRequest){
        Venues venues = venuesService.updateVenues(id,venuesRequest);
        APIResponseVenues<?> apiResponseVenues = new APIResponseVenues<>(
                "The venues has been successfully",
                venuesService.getByIdVenues(id),
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseVenues);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVenues(@Positive @PathVariable Integer id){
        Venues venues = venuesService.deleteVenues(id);
        APIResponseVenues<?> apiResponseVenues = new APIResponseVenues<>(
                "The venues has been delete successfully",
                null,
                HttpStatus.OK,
                LocalTime.now()
        );
        return ResponseEntity.ok(apiResponseVenues);
    }
}
