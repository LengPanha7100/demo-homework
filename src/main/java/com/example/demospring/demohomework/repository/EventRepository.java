package com.example.demospring.demohomework.repository;

import com.example.demospring.demohomework.model.events.Event;
import com.example.demospring.demohomework.model.events.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("""
    SELECT * FROM Event OFFSET #{offset} LIMIT #{limit};
    """)
    @Results(id="Event",value = {
            @Result(property = "venues",column = "venues_id",
            one = @One(select = "com.example.demospring.demohomework.repository.VenuesRepository.getAllByIdVenues")
            ),
            @Result(property = "event_id",column = "event_id"),
            @Result(property = "attendees",column = "event_id",
            many = @Many(select = "com.example.demospring.demohomework.repository.AttendeesRepository.getAllAttendeesByAttendeesId")
            )
    })
    List<Event> getAllEvent(Integer offset,Integer limit);

    @Select("""
    
    SELECT * FROM Event
    WHERE event_id = #{id};
    """)
    @ResultMap("Event")
    Event getByIdEvent(Integer id);

    @Select("""
 
    INSERT INTO Event (event_name, event_date, venues_id)
    VALUES (#{event.event_name},#{event.event_date},#{event.venues_id})
    RETURNING event_id;
    """)

    Integer createEvent(@Param("event") EventRequest eventRequest);


    @Update("""
    
    UPDATE Event
    SET event_name = #{event.event_name},event_date= #{event.event_date},venues_id= #{event.venues_id}
    WHERE event_id= #{id};
    """)
    @ResultMap("Event")
    void updateEvent(Integer id, @Param("event") EventRequest eventRequest);

    @Select("""
    
    DELETE FROM event
    WHERE event_id =#{id};
    """)
    Event deleteEvent(Integer id);

    @Select("""
    
    SELECT * FROM Event
    WHERE event_id = #{event_id};
    """)
    @ResultMap("Event")
    Event findIdEvent(Integer event_id);

    @Insert("""
    INSERT INTO Event_attendees (event_id, attendees_id)
    VALUES (#{event_id},#{attendees_id});
    """)
    @ResultMap("Event")
    void insertIntoEventAttendees(Integer event_id, Integer attendees_id);

    @Delete("""
    DELETE FROM event_attendees WHERE event_id= #{id}
    """)
    void deleteAttendeesFromEventAttendees(Integer id);
}
