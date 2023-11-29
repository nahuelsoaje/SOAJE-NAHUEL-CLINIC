package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteDeNombreJuanYRetornaElId(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("juan","pedro",1354688, LocalDate.of(2023,12,24),new DomicilioEntradaDto("calle",12,"localidad", "provinvia"));

        pacienteService.registrarPaciente(pacienteEntradaDto);

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Juan",pacienteSalidaDto.getNombre());
    }

}