package com.example.demospring.demohomework.model.attendees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendees {
    private Integer attendees_id;
    private String attendees_name;
    private String email;
}
