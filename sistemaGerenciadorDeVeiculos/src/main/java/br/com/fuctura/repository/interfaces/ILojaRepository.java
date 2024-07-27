package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Loja;
import java.util.List;

public interface ILojaRepository {

    void salvar(Loja loja);

    void atualizar(Loja loja);

    void deletar(Loja loja);

    Loja buscarPorCNPJ(String cnpj);

    List<Loja> listar();
}
