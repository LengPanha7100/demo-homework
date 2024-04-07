package com.example.demospring.demohomework.model.events;

import com.example.demospring.demohomework.model.venues.Venues;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @NotBlank(message = "must not be null")
    @NotNull
    private String event_name;

    @NotNull
    private LocalDateTime event_date;
    @NotNull
    private Integer venues_id;
    @NotNull
    @NotEmpty
    private List<Integer> attendees_id;
}
