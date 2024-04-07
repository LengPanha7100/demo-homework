package com.example.demospring.demohomework.model.venues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venues {
    private Integer venues_id;
    private String venues_name;
    private String location;
}
