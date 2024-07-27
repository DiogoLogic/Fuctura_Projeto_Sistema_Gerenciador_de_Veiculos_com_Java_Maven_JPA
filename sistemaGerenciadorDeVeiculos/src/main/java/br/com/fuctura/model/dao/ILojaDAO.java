package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidades.Loja;

public interface ILojaDAO {

	 void salvar(Loja loja);

	    void atualizar(Loja loja);

	    void deletar(Loja loja);

	    Loja buscarPorCNPJ(String cnpj);

		List<Loja> listarTodas();
}
