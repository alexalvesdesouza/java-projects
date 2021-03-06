package br.com.lufamador.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.lufamador.model.Atleta;
import br.com.lufamador.model.AtletaHistory;

public interface AtletaService {

    Page<Atleta> findAll(int page, int count);

    Atleta createOrUpdate(Atleta atleta);

    Atleta findByCodigo(Long id);

    void delete(Long id);

    List<AtletaHistory> history(Long id);
}
