package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidades.Vendedor;

public interface IVendedorDAO {

    void salvar(Vendedor vendedor);

    void atualizar(Vendedor vendedor);

    void deletar(Vendedor vendedor);

    Vendedor buscarPorCPF(String cpf);
    
    public List<Vendedor> listar();
}
