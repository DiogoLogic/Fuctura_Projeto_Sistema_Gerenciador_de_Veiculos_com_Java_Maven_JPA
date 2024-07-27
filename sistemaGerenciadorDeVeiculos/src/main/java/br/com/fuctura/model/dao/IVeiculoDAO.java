package br.com.fuctura.model.dao;

import br.com.fuctura.model.entidades.Veiculo;

public interface IVeiculoDAO {

    void salvar(Veiculo veiculo);

    void atualizar(Veiculo veiculo);

    void deletar(Veiculo veiculo);

    Veiculo buscarPorPlaca(String placa);
}
