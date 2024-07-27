package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidades.Tipo;

public interface ITipoDAO {
	
    void salvar(Tipo tipo);

    void atualizar(Tipo tipo);

    void deletar(Tipo tipo);

    Tipo buscarPorDescricao(String descricao);
    
    public List<Tipo> listar();
}
