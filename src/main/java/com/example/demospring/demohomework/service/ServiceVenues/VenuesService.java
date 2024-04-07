package com.example.demospring.demohomework.service.ServiceVenues;

import com.example.demospring.demohomework.model.venues.Venues;
import com.example.demospring.demohomework.model.venues.VenuesRequest;

import java.util.List;

public interface VenuesService {

    List<Venues> getAllVenues(Integer offset,Integer limit);

    Venues getByIdVenues(Integer id);

    Venues createVenues(VenuesRequest venuesRequest);

    Venues updateVenues(Integer id, VenuesRequest venuesRequest);

    Venues deleteVenues(Integer id);
}
