package org.example.DevOps.repositories;

import org.example.DevOps.entity.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<ServiceStatus, Long> {
}