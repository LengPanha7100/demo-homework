package com.example.demospring.demohomework.model.attendees;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesRequest {
    @NotBlank(message = "must not be blank")
    @NotNull
    private String attendees_name;
    @NotBlank(message = "Email is blank or empty")
    @NotNull
    @Email
    private String email;


}
