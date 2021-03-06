package br.com.lufamador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lufamador.model.EscalaArbitros;
import br.com.lufamador.service.impl.EscalaArbitrosServiceImpl;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/escalas")
public class EscalaArbitrosController {

    @Autowired
    private EscalaArbitrosServiceImpl escalaArbitrosService;

    @GetMapping
    public ResponseEntity<List<EscalaArbitros>> getEscalas() {
        List<EscalaArbitros> list = this.escalaArbitrosService.getEscalaArbitrosList();
        return ResponseEntity.ok(list);
    }

}
