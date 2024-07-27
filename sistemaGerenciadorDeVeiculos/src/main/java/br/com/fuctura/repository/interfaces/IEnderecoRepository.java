package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Endereco;
import java.util.List;

public interface IEnderecoRepository {

    void salvar(Endereco endereco);

    void atualizar(Endereco endereco);

    void deletar(Endereco endereco);

    Endereco buscarPorCEP(String cep);

    List<Endereco> listar();
}
