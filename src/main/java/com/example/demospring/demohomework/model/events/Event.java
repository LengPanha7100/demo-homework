package com.example.demospring.demohomework.model.events;

import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.venues.Venues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer event_id;
    private String event_name;
    private LocalDateTime event_date;
    private Venues venues;
    private List<Attendees> attendees;
}
