package com.api.unipar.service;

import com.api.unipar.entidades.Produto;
import com.api.unipar.repository.ClienteRepository;
import com.api.unipar.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente de ID: " +
                id + "não encontrado"));
    }

    public void deletarProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoSalvo = buscarProdutoPorId(id);
        BeanUtils.copyProperties(produto, produtoSalvo, "id");
        return produtoRepository.save(produtoSalvo);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtoRepository.findbyNome(nome);
    }
}
