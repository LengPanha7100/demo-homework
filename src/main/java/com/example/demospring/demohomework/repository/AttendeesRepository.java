package com.example.demospring.demohomework.repository;

import com.example.demospring.demohomework.model.attendees.Attendees;
import com.example.demospring.demohomework.model.attendees.AttendeesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeesRepository {

    @Select("""
        SELECT * FROM Attendees LIMIT #{limit} OFFSET #{offset};
    """)
    List<Attendees> getAllAttendees(Integer offset, Integer limit);

    @Select("""
    SELECT * FROM Attendees WHERE attendees_id=#{attedees_id};
    """)
    Attendees getById(Integer id);

    @Select("""
    SELECT at.attendees_id,at.attendees_name,at.email FROM Attendees at
    JOIN Event_attendees Ea on at.attendees_id = Ea.attendees_id
    WHERE Ea.event_id= #{attendees_id};
    """)
    List<Attendees> getAllAttendeesByAttendeesId(Integer id);

    @Select("""
    INSERT INTO Attendees (attendees_name, email)
    VALUES (#{Attendees.attendees_name},#{Attendees.email})
    RETURNING *;
    """)
    Attendees createAttendees(@Param("Attendees") AttendeesRequest attendeesRequest);

    @Select("""
    UPDATE attendees
    SET attendees_name = #{attendeesRequest.attendees_name} ,
    email = #{attendeesRequest.email}
    WHERE attendees_id = #{id}
    returning *;
    """)
    @Result(property = "email", column = "email")
    @Result(property = "attendees_name", column = "attendees_name")
    Attendees updateAttendees( Integer id, @Param("attendeesRequest") AttendeesRequest attendeesRequest);

    @Select("""
    
    DELETE FROM Attendees
    WHERE attendees_id =#{attendees_id}
    returning *;
    """)
    Attendees deleteAttendees(Integer id);
}
