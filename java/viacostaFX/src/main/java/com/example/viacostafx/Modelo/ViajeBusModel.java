package com.example.viacostafx.Modelo;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name = "Viaje_Bus")
public class ViajeBusModel {
    @Id
    @Column(name = "ID_Viaje_Bus_INT")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Viaje")
    private ViajeModel viaje;

    @ManyToOne
    @JoinColumn(name = "ID_Bus")
    private BusModel bus;
}
