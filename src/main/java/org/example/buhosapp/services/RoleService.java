package org.example.buhosapp.services;

import org.example.buhosapp.domain.dtos.request.role.CreateRoleRequest;
import org.example.buhosapp.domain.dtos.response.role.RoleResponse;

public interface RoleService {
    void createRole(CreateRoleRequest roleRequest);
    RoleResponse getRoleByName(String name);
}
