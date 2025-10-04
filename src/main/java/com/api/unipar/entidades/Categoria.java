package com.api.unipar.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria_produto")
public class Categoria {

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome) && Objects.equals(descricao, categoria.descricao) && Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, id);
    }
}
