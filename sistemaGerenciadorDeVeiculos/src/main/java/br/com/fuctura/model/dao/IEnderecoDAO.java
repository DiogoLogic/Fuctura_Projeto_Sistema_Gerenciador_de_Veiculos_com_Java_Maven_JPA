package br.com.fuctura.model.dao;

import br.com.fuctura.model.entidades.Endereco;

public interface IEnderecoDAO {


    void salvar(Endereco endereco);

    void atualizar(Endereco endereco);

    void deletar(Endereco endereco);

    Endereco buscarPorCEP(String cep);
}
