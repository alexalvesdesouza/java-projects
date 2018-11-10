package com.ideaapi.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    @GetMapping
    public List<String> listar() {
        return Arrays.asList("Compras", "Boletos");
    }
}
