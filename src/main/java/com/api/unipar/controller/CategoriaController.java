package com.api.unipar.controller;

import com.api.unipar.entidades.Categoria;
import com.api.unipar.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar-categorias")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @PostMapping("/cadastrar-categoria")
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @DeleteMapping("/deletar-categoria/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }

    @PutMapping("/atualizar-categoria/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.atualizarCategoria(id, categoria);
    }
}
