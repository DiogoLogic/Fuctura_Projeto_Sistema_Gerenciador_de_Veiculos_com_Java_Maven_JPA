package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Cliente;
import java.util.List;

public interface IClienteRepository {

    void salvar(Cliente cliente);

    void atualizar(Cliente cliente);

    void deletar(Cliente cliente);

    Cliente buscarPorCPF(String cpf);

    List<Cliente> listar();
}
