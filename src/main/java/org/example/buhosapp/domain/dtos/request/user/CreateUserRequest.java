package org.example.buhosapp.domain.dtos.request.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.example.buhosapp.common.regexp.PasswordRegexp.REGEXP_PASSWORD;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "Name cannot be empty")
    private String username;

    @NotBlank(message = "Card cannot be empty")
    @Size(min = 8, max = 8)
    private String card;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = REGEXP_PASSWORD, message = "Password must be alphanumeric")
    @Size(min = 4, message = "Password must have 4 characters")
    private String password;
}
