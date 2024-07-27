package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Vendedor;
import java.util.List;

public interface IVendedorRepository {

    void salvar(Vendedor vendedor);

    void atualizar(Vendedor vendedor);

    void deletar(Vendedor vendedor);

    Vendedor buscarPorCPF(String cpf);

    List<Vendedor> listar();
}
