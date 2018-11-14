package com.ideaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ideaapi.model.Empresa;
import com.ideaapi.repository.EmpresaRepository;
import com.ideaapi.repository.filter.EmpresaFilter;
import com.ideaapi.repository.projection.ResumoEmpresa;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listaTodasEmpresas() {
        return this.empresaRepository.findAll();
    }

    public Page<ResumoEmpresa> resumo(EmpresaFilter filter, Pageable pageable) {
        return this.empresaRepository.resumir(filter, pageable);
    }

    public Empresa cadastraEmpresa(Empresa entity) {
        return this.empresaRepository.save(entity);
    }

    public Empresa buscaEmpresa(Long codigo) {
        Empresa empresa = this.empresaRepository.findOne(codigo);
        if (empresa != null) {
            return empresa;
        }

        return null;
    }

    public void deletaEmpresa(Long codigo) {
        this.empresaRepository.delete(codigo);
    }
}