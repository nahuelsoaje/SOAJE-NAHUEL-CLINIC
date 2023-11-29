package com.backend.clinicaodontologica.dto.modificacion;

import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id del turno que se desea modificar")

    private Long id;
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaYHora;
    @NotNull(message = "el id odontologo no puede ser nulo")
    @Valid
    private long idodontologo;
    @NotNull(message = "el id paciente no puede ser nulo")
    @Valid
    private long idpaciente;

    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, LocalDateTime fechaYHora, long idodontologo, long idpaciente) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.idodontologo = idodontologo;
        this.idpaciente = idpaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
