package br.com.lufamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lufamador.model.MembroTjdu;
import br.com.lufamador.model.Tjdu;
import br.com.lufamador.repository.MembroTjduRepository;
import br.com.lufamador.repository.TjduRepository;

@Service
public class TjduServiceImpl {

    @Autowired
    private TjduRepository repository;

    @Autowired
    private MembroTjduRepository repositoryMembrosTjdu;

    public List<Tjdu> getTjduList(final String categoria) {
        return this.repository.findByCategoria(categoria);
    }

    public List<MembroTjdu> getMembros() {
        return this.repositoryMembrosTjdu.findAll();
    }

}
