package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void registrarOdontologoLucianaMurgaYRetornarElID() throws BadRequestException {
        OdontologoEntradaDto entradaDto = new OdontologoEntradaDto("123", "Luciana", "Murga");
        OdontologoSalidaDto salidaDto = odontologoService.registrarOdontologo(entradaDto);
        assertNotNull(salidaDto.getId());
        assertEquals("Luciana", salidaDto.getNombre());
    }

    @Test
    @Order(2)
    void deberiaRetornarElOdontologoConId1() {
        OdontologoSalidaDto odontologoSalida = null;
        try {
            odontologoSalida = odontologoService.buscarOdontologoPorId(1L);
            assertNotNull(String.valueOf(odontologoSalida), "El odontólogo no debería ser nulo");
            assertEquals(1, odontologoSalida.getId());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Test
    @Order(3)
    void deberiaEliminarOdontologoConId1(){
        try {
            odontologoService.eliminarOdontologo(1L);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }


}