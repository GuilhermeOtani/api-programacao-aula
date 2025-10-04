package com.api.unipar.controller;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CLASSE RESPONSAVEL POR EXPOR ENDPOINTS DA APLICAÇÃO REFERENTE A CLIENTES

//MARCA A CLASSE COMO UMA CLASSE REST OU SEJA EXPOE OS ENDPOINTS PARA O USO DE CLIENTES
@RestController

//DEFINE A ROTA PARA ACESSO AOS ENDPOINTS AQUI DESENVOLVIDOS
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    //DEFINICAO DA CLASSE CLIENTE SERVICE PARA INJECAO DE DEPENDENCIAS
    private final ClienteService clienteService;

    //INJETO DE FATO AS DEPENDECIAS DEFINIDAS COMO FINAL ANTERIORMENTE
    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //EXPOE O ENDPOINT RESPONSAVEL POR RETORNAR A LISTA DE CLIENTES CADASTRADOS NO BANCO DE DADOS
    @GetMapping("/listar")
    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosCLientes();
    }

    @PostMapping("/salvar-cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("/buscar-cliente/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/deletar-cliente/{id}")
    public void deletarClientePorId(@PathVariable Long id) {
        clienteService.deletarClientePorId(id);
    }

    @PutMapping("/atualizar-cliente/{id}")
    public Cliente atualizarClientePorId(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }
}
