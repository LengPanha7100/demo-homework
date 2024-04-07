package com.example.demospring.demohomework.service.ServiceEvent;

import com.example.demospring.demohomework.exception.NotFoundException;
import com.example.demospring.demohomework.model.events.Event;
import com.example.demospring.demohomework.model.events.EventRequest;
import com.example.demospring.demohomework.repository.EventRepository;
import com.example.demospring.demohomework.service.ServiceAttendees.AttendeesService;
import com.example.demospring.demohomework.service.ServiceVenues.VenuesService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventServiceImpl implements EventService {

//    public Integer id;
    public final VenuesService venuesService;
    public final AttendeesService attendeesService;

    public final EventRepository eventRepository;

    public EventServiceImpl(VenuesService venuesService, AttendeesService attendeesService, EventRepository eventRepository) {
        this.venuesService = venuesService;
        this.attendeesService = attendeesService;

        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvent(Integer offset, Integer limit) {
        offset = (offset-1)*limit;
        return eventRepository.getAllEvent(offset,limit);
    }

    @Override
    public Event getByIdEvent(Integer id) {
        Event event = eventRepository.getByIdEvent(id);
        if(event == null){
            throw  new NotFoundException("The event id "+id+" has not been found");
        }
        return event;
//        return eventRepository.getByIdEvent(id);
    }

    @Override
    public Event createEvent(EventRequest eventRequest) {
//        venuesService.getByIdVenues(eventRequest.getVenues_id());
//        Integer event_id = eventRepository.createEvent(eventRequest);
        Integer venues_id = venuesService.getByIdVenues(eventRequest.getVenues_id()).getVenues_id();
//        List<Integer> attendeesId = attendeesService.getById(eventRequest.getAttendees_id());
        if (venues_id == null) {
            throw new NotFoundException("This venues id " + venues_id + " not found");
//        } else if (attendeesId ==null) {
//            throw new NotFoundException("This attendees id "+ attendeesId+ " not found");
        } else {
            Integer event_id = eventRepository.createEvent(eventRequest);
            for (Integer attendees_id : eventRequest.getAttendees_id()) {
                System.out.println(attendees_id);
                attendeesService.getById(attendees_id);
                eventRepository.insertIntoEventAttendees(event_id, attendees_id);
            }
            return eventRepository.findIdEvent(event_id);
        }

    }

//        Integer event_id = eventRepository.createEvent(eventRequest);
//        for(Integer attendees_id : eventRequest.getAttendees_id()){
//            System.out.println(attendees_id);
//            eventRepository.insertIntoEventAttendees(event_id,attendees_id);
//        }
//        return eventRepository.findIdEvent(event_id);


    @Override
    public Event updateEvent(Integer id, EventRequest eventRequest) {
        Integer venues_id = venuesService.getByIdVenues(eventRequest.getVenues_id()).getVenues_id();
        if (venues_id == null) {
            throw new NotFoundException("This venues id " + venues_id + " not found");
        }else {
            eventRepository.updateEvent(id, eventRequest);
            eventRepository.deleteAttendeesFromEventAttendees(id);
            for (Integer attendees_id : eventRequest.getAttendees_id()) {
                attendeesService.getById(attendees_id);
                eventRepository.insertIntoEventAttendees(id, attendees_id);
            }
            return getByIdEvent(id);
        }
    }

    @Override
    public Event deleteEvent(Integer id) {
        getByIdEvent(id);
        return eventRepository.deleteEvent(id);
    }
}
