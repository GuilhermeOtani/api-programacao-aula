package com.api.unipar.service;

import com.api.unipar.entidades.Categoria;
import com.api.unipar.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Long id) {
       categoriaRepository.deleteById(id);
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de ID " + id + " não encontrada"));
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Categoria categoriaSalva = buscarCategoriaPorId(id);
        BeanUtils.copyProperties(categoria,categoriaSalva, "id");
        return categoriaRepository.save(categoriaSalva);
    }
}
