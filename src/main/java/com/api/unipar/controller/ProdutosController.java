package com.api.unipar.controller;


import com.api.unipar.entidades.Cliente;
import com.api.unipar.entidades.Produto;
import com.api.unipar.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutosController {

    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @PostMapping("/salvar-produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/buscar-produto/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/deletar-produto/{id}")
    public void deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletarProdutoPorId(id);
    }

    @PutMapping("/atualizar-produto/{id}")
    public Produto atualizarProdutoPorId(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

}
