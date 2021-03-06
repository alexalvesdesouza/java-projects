package br.com.lufamador.service;

import org.springframework.data.domain.Page;

import br.com.lufamador.model.DepartamentoTecnico;

public interface DepartamentoTecnicoService {

    Page<DepartamentoTecnico> findAll(int page, int count);

    DepartamentoTecnico createOrUpdate(DepartamentoTecnico departamentoTecnico);

    DepartamentoTecnico findByCodigo(Long codigo);

    void delete(Long codigo);
}
