package com.example.viacostafx.Repositorio;

import com.example.viacostafx.Modelo.AgenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepo  extends JpaRepository<AgenciaModel, Integer> {
}
