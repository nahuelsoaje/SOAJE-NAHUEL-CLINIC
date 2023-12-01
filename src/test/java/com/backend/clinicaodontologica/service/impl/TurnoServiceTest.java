package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @Test
    @Order(1)
    void deberiaRegistrarUnTurnoConIdDePacienteYOdontologo() throws BadRequestException {

    // Registrar un odontólogo para las pruebas
    OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("124548d", "nahuel", "perex");
    OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);
    // Registrar un paciente para las pruebas
    PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("lu", "murga", 123456, LocalDate.of(2023, 12, 24), new DomicilioEntradaDto("Av. Cabildo", 124, "Núñez", "Buenos Aires"));
    PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);
    assertNotNull(odontologoSalidaDto.getId());
    assertEquals(1, odontologoSalidaDto.getId());
}

    @Test
    @Order(2)
    void DeberiaDevolverUnaListaVaciaDeTurnos() {
        List<TurnoSalidaDto> turnoSalida = turnoService.listarTurnos();

        assertTrue(turnoSalida.isEmpty());
    }
    @Test
    @Order(3)
    void deberiaEliminarOdontologoConId1(){
        try {
            turnoService.eliminarTurno(1L);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(1L));
    }




}

