package com.example.viacostafx.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Viaje")
public class ViajeModel {
    @Id
    @Column(name = "ID_Viaje_INT")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Agencia_Origen_INT")
    private AgenciaModel agenciaOrigen;

    @ManyToOne
    @JoinColumn(name = "ID_Agencia_Destino_INT")
    private AgenciaModel agenciaDestino;

    private LocalDateTime fechaHoraSalida;

    private Boolean isActive;

    @OneToMany(mappedBy = "viaje")
    private List<ViajeBusModel> viajeBuses;

    @OneToMany(mappedBy = "viaje")
    private List<BoletoModel> boletos;
}
