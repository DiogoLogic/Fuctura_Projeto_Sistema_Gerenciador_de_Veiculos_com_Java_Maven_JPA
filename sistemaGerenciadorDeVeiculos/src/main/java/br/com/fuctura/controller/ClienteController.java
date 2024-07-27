package br.com.fuctura.controller;



import java.util.List;

import br.com.fuctura.dao.impl.ClienteDAOImpl;
import br.com.fuctura.model.entidades.Cliente;
import br.com.fuctura.repository.impl.ClienteRepository;

public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController() {
        this.clienteRepository = new ClienteRepository(new ClienteDAOImpl(null)); // Inicializa o repositório com o DAO
    }

    public void inserirCliente(Cliente cliente) {
        if (validarCliente(cliente)) {
            clienteRepository.salvar(cliente); // Utiliza o método do repositório para inserir cliente
        } else {
            System.out.println("Cliente inválido. Não foi possível inserir.");
        }
    }

    public void atualizarCliente(Cliente cliente) {
        if (validarCliente(cliente)) {
            clienteRepository.atualizar(cliente); // Utiliza o método do repositório para atualizar cliente
        } else {
            System.out.println("Cliente inválido. Não foi possível atualizar.");
        }
    }

    public void deletarClientePorCPF(String cpf) {
        Cliente cliente = clienteRepository.buscarPorCPF(cpf); // Busca o cliente pelo CPF
        if (cliente != null) {
            clienteRepository.deletar(cliente); // Utiliza o método do repositório para deletar cliente encontrado
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    public Cliente buscarClientePorCPF(String cpf) {
        return clienteRepository.buscarPorCPF(cpf); // Utiliza o método do repositório para buscar cliente pelo CPF
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listar(); // Retorna a lista de todos os clientes utilizando o método do repositório
    }

    private boolean validarCliente(Cliente cliente) {
        // Implemente suas validações de negócio aqui
        return cliente.getCpf() != null && cliente.getNome() != null; // Exemplo simples de validação
    }
}
