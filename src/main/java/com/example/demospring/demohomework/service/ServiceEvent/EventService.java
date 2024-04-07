package com.example.demospring.demohomework.service.ServiceEvent;

import com.example.demospring.demohomework.model.events.Event;
import com.example.demospring.demohomework.model.events.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvent(Integer offset,Integer limit);

    Event getByIdEvent(Integer id);

    Event createEvent(EventRequest eventRequest);

    Event updateEvent(Integer id, EventRequest eventRequest);

    Event deleteEvent(Integer id);
}
