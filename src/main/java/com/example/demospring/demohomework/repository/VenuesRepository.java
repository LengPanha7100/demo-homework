package com.example.demospring.demohomework.repository;

import com.example.demospring.demohomework.model.venues.Venues;
import com.example.demospring.demohomework.model.venues.VenuesRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface VenuesRepository {
    @Select("""
    SELECT * FROM Venues OFFSET #{offset} LIMIT #{limit};
    """)
    List<Venues> getAllVenues(Integer offset,Integer limit);
    @Select("""
    SELECT * FROM Venues WHERE venues_id =#{venues_id};
    """)
    Venues getAllByIdVenues(Integer id);
    @Select("""
    INSERT INTO Venues (venues_name, location)
    VALUES (#{Venues.venues_name},#{Venues.location})
    RETURNING *;
    """)
    Venues createVenues(@Param("Venues") VenuesRequest venuesRequest);

    @Select("""
    
    UPDATE Venues
    SET venues_name = #{VenuesRequest.venues_name},location = #{VenuesRequest.location}
    WHERE venues_id = #{id}
    RETURNING *;
    """)
    Venues updateVenues( Integer id,@Param("VenuesRequest") VenuesRequest venuesRequest);

    @Select("""
    
    DELETE FROM Venues
    WHERE venues_id =#{venues_id};
    """)
    Venues deleteVenues(Integer id);
}
