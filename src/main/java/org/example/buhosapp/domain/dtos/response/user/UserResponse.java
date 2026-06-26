package org.example.buhosapp.domain.dtos.response.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String username;
    private String card;
    private String email;
}
