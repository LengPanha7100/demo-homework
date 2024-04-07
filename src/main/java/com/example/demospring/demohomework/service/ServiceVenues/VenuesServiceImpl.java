package com.example.demospring.demohomework.service.ServiceVenues;

import com.example.demospring.demohomework.exception.NotFoundException;
import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.venues.Venues;
import com.example.demospring.demohomework.model.venues.VenuesRequest;
import com.example.demospring.demohomework.repository.VenuesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenuesServiceImpl implements VenuesService{
    public Integer id;

    public final VenuesRepository venuesRepository;

    public VenuesServiceImpl( VenuesRepository venuesRepository) {

        this.venuesRepository = venuesRepository;
    }


    @Override
    public List<Venues> getAllVenues(Integer offset,Integer limit) {
        offset = (offset-1)*limit;
        return venuesRepository.getAllVenues(offset,limit);
    }

    @Override
    public Venues getByIdVenues(Integer id) {
      Venues venues = venuesRepository.getAllByIdVenues(id);
        if(venues == null){
            throw  new NotFoundException("The venues id "+id+" has not been found");
        }
        return venues;
//        return venuesRepository.getAllByIdVenues(id);
    }

    @Override
    public Venues createVenues(VenuesRequest venuesRequest) {
//        getByIdVenues(id);
        return venuesRepository.createVenues(venuesRequest);
    }

    @Override
    public Venues updateVenues(Integer id, VenuesRequest venuesRequest) {
        getByIdVenues(id);
        return venuesRepository.updateVenues(id,venuesRequest);
    }

    @Override
    public Venues deleteVenues(Integer id) {
        getByIdVenues(id);
        return venuesRepository.deleteVenues(id);
    }
}
