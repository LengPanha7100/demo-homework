package com.example.demospring.demohomework.service.ServiceAttendees;

import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.attendees.AttendeesRequest;

import java.util.List;


public interface AttendeesService {


    List<Attendees> getAllAttendees(Integer offset, Integer limit);

    Attendees getById(Integer id) ;

    Attendees createAttendees(AttendeesRequest attendeesRequest);

    Attendees updateAttendees(Integer id, AttendeesRequest attendeesRequest);

    Attendees deleteAttendees(Integer id);
}
