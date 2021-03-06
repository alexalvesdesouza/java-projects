package br.com.lufamador.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lufamador.model.DepartamentoTecnico;
import br.com.lufamador.repository.DepartamentoTecnicoRepository;

@Service
public class DepartamentoTecnicoServiceImpl {

    private static final String PORTARIAS = "PORTARIAS";
    private static final String COMUNICADOS = "COMUNICADOS";
    private static final String NOTAS_OFICIAIS = "NOTAS_OFICIAIS";
    @Autowired
    private DepartamentoTecnicoRepository repository;

    public List<DepartamentoTecnico> getDepartamentoTecnicoList(String categoria, String subCategoria) {
        return this.repository.findByCategoriaAndSubCategoriaOrderByNumeroAsc(categoria, subCategoria);
    }

    public List<DepartamentoTecnico> getDocsList() {
        List<DepartamentoTecnico> docs = this.repository.findAll()
                .stream()
                .filter(doc -> (null != doc.getExibirPaginaPrincipal() && doc.getExibirPaginaPrincipal()))
                .collect(Collectors.toList());

        docs.forEach(doc ->
                doc.setCategoria(doc.getCategoria()
                        .replace(PORTARIAS, "PORTARIA")
                        .replace(COMUNICADOS, "COMUNICADO")
                        .replace(NOTAS_OFICIAIS, "NOTA OFICIAL")));
        return docs;
    }

}
