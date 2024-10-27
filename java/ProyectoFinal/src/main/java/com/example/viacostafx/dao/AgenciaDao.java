package com.example.viacostafx.dao;

import com.example.viacostafx.Modelo.AgenciaModel;
import com.example.viacostafx.Repositorio.AgenciaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgenciaDao  {
    private final AgenciaRepo agenciaRepo;

    @Autowired
    public AgenciaDao(AgenciaRepo agenciaRepo) {
        this.agenciaRepo = agenciaRepo;
    }

    public List<AgenciaModel> findAll() {
        return agenciaRepo.findAll();
    }

    public Optional<AgenciaModel> findById(Integer id) {
        return agenciaRepo.findById(id);
    }

    public AgenciaModel save(AgenciaModel agencia) {
        return agenciaRepo.save(agencia);
    }

    public void deleteById(Integer id) {
        agenciaRepo.deleteById(id);
    }
}
