package com.example.demospring.demohomework.service.ServiceAttendees;

import com.example.demospring.demohomework.exception.NotFoundException;
import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.attendees.AttendeesRequest;

import org.springframework.stereotype.Service;
import com.example.demospring.demohomework.repository.AttendeesRepository;


import java.util.List;

@Service
public class AttendeesServiceImpl implements AttendeesService {
    public Integer id;
    public final AttendeesRepository attendeesRepository;

//    private final ModelMapper modelMapper = new ModelMapper();

    public AttendeesServiceImpl(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;

    }

    @Override
    public List<Attendees> getAllAttendees(Integer offset, Integer limit) {
        offset = (offset-1)*limit;
        return attendeesRepository.getAllAttendees(offset,limit);

    }

    @Override
    public Attendees getById(Integer id) {
        Attendees attendees = attendeesRepository.getById(id);
        if(attendees == null){
            throw new NotFoundException("The attendees id "+id+" has not been found");
        }
        return attendees;
    }

    @Override
    public Attendees createAttendees(AttendeesRequest attendeesRequest) {
//         getById(id);
         return attendeesRepository.createAttendees(attendeesRequest);
    }

    @Override
    public Attendees updateAttendees( Integer id, AttendeesRequest attendeesRequest) {
        getById(id);
        return attendeesRepository.updateAttendees(id,attendeesRequest);
    }

    @Override
    public Attendees deleteAttendees(Integer id) {
        getById(id);
        return attendeesRepository.deleteAttendees(id);
    }
}
