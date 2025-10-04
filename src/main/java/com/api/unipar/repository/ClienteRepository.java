package com.api.unipar.repository;

import com.api.unipar.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DEFINE O REPOSITORIO DA ENTIDADE CLIENTE, CLASSE ESSA RESPONSAVEL POR SE COMUNICAR COM O BANCO DE DADOS
//EXEMPLO: LISTAR, INSERIR, ATUALIZAR E EXCLUIR CLIENTES
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNome(String nome);
}
