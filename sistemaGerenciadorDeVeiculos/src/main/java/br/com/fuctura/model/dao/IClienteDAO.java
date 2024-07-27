package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidades.Cliente;

public interface IClienteDAO {
	
	   Cliente buscarPorCPF(String cpf);

	    boolean inserir(Cliente cliente);

	    boolean atualizar(Cliente cliente);

		List<Cliente> listarTodos();

		boolean deletarPorCPF(Cliente cliente);

		boolean deletarPorCPF(String cpf);
	

}
