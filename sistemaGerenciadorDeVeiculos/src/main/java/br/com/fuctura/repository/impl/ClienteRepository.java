package br.com.fuctura.repository.impl;

import br.com.fuctura.model.dao.IClienteDAO;
import br.com.fuctura.model.entidades.Cliente;
import br.com.fuctura.repository.interfaces.IClienteRepository;

import java.util.List;

public class ClienteRepository implements IClienteRepository{

    private final IClienteDAO clienteDAO;

    public ClienteRepository(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void salvar(Cliente cliente) {
        if (cliente != null) {
            clienteDAO.inserir(cliente);
        }
    }

    public void atualizar(Cliente cliente) {
        if (cliente != null && cliente.getCodigo() != null) {
            clienteDAO.atualizar(cliente);
        }
    }

    public void deletar(Cliente cliente) {
        if (cliente != null && cliente.getCodigo() != null) {
            clienteDAO.deletarPorCPF(cliente);
        }
    }

    public Cliente buscarPorCPF(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            return clienteDAO.buscarPorCPF(cpf);
        }
        return null;
    }

    public List<Cliente> listar() {
        return clienteDAO.listarTodos();
    }
}
