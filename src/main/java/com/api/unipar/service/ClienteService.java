package com.api.unipar.service;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


//CLASSE RESPONSAVEL POR CONTER NOSSA REGRA DE NEGOCIO, A LOGICA DA APLICAÇÃO
@Service
public class ClienteService {

    //INJETANDO AS DEPENENCIAS DO MEU SERVICE, NO CASO O REPOSITORIO
    private final ClienteRepository clienteRepository;

    //METODO CONSTRUTOR, RESPONSAVEL POR INJETAR DE FATO O REPOSITORIO E DEMAIS DEPENDENCIAS
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //METODO RESPONSAVEL POR LISTAR OS CLIENTES CADASTRADOS NO BANCO DE DADOS
    public List<Cliente> listarTodosCLientes() {
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Cliente de ID " + id + " não encontrado"));
    }

    public void deletarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteSalvo = buscarClientePorId(id);
        // Copia as propriedades do cliente recebido para o clienteSalvo, exceto o id
        BeanUtils.copyProperties(cliente, clienteSalvo, "id");
        return clienteRepository.save(clienteSalvo);
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
