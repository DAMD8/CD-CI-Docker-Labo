package org.example.buhosapp.domain.dtos.response.role;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoleResponse {
    private UUID id;
}
