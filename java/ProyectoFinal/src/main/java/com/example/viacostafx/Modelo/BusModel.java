package com.example.viacostafx.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "Buses")
public class BusModel {
    @Id
    @Column(name = "ID_Bus_INT")
    private Integer id;

    @Column(length = 7)
    private String placa;

    @Column(length = 50)
    private String modelo;

    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private CategoriaModel categoria;

    private Boolean isActive;

    @OneToMany(mappedBy = "bus")
    private List<ChoferModel> choferes;

    @OneToMany(mappedBy = "bus")
    private List<AsientoModel> asientos;

    @OneToMany(mappedBy = "bus")
    private List<ViajeBusModel> viajeBuses;
}
