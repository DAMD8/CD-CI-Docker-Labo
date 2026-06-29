package org.example.DevOps.repository;

import org.example.DevOps.entity.ServiceStatus;
import org.example.DevOps.repositories.StatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatusRepositoryTest {

    @Mock
    private StatusRepository statusRepository;

    @Test
    void cuandoBuscarEstadoPorId_entoncesRetornaSimulacionExitosa() {
        ServiceStatus mockStatus = new ServiceStatus();
        mockStatus.setId(1L);
        mockStatus.setComponent("Gateway");
        mockStatus.setStatus("OK");

        when(statusRepository.findById(1L)).thenReturn(Optional.of(mockStatus));

        Optional<ServiceStatus> resultado = statusRepository.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Gateway", resultado.get().getComponent());
        verify(statusRepository, times(1)).findById(1L);
    }
}