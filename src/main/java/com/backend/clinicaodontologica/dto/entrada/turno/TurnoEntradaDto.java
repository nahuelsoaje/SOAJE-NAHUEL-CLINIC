package com.backend.clinicaodontologica.dto.entrada.turno;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto {
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha del turno")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaYHora;
    @NotNull(message = "El odontologo tiene que existir")
    @NotBlank(message = "no puede estar vacio")
    @Valid
    private long idodontologo;
    @NotNull(message = "El paciente tiene que existir")
    @NotBlank(message = "no puede estar vacio")
    @Valid
    private long idpaciente;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, long idodontologo, long idpaciente) {
        this.fechaYHora = fechaYHora;
        this.idodontologo = idodontologo;
        this.idpaciente = idpaciente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public long getIdodontologo() {
        return idodontologo;
    }

    public void setIdodontologo(long idodontologo) {
        this.idodontologo = idodontologo;
    }

    public long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(long idpaciente) {
        this.idpaciente = idpaciente;
    }
}






