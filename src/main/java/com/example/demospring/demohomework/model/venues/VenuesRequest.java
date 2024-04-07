package com.example.demospring.demohomework.model.venues;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesRequest {
    @NotBlank(message = "must not be blank")
    @NotNull
    private String venues_name;
    @NotNull
    @NotBlank(message = "must not be blank")
    private String location;
}
