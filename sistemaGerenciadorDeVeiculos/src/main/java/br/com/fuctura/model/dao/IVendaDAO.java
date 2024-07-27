package br.com.fuctura.model.dao;

import br.com.fuctura.model.entidades.Venda;

public interface IVendaDAO {
	
	void salvar(Venda venda);

	void atualizar(Venda venda);

	void deletar(Venda venda);

	Venda buscarPorId(Long id);

}
