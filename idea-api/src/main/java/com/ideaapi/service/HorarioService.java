package com.ideaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaapi.model.Horario;
import com.ideaapi.repository.HorarioRepository;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> listaTodasHorarios() {
        return this.horarioRepository.findAll();
    }

    public Horario cadastraHorario(Horario entity) {
        return this.horarioRepository.save(entity);
    }

    public Horario buscaHorario(Long codigo) {
        Horario horario = this.horarioRepository.findOne(codigo);
        if (horario != null) {
            return horario;
        }

        return null;
    }

    public void deletaHorario(Long codigo) {
        this.horarioRepository.delete(codigo);
    }
}