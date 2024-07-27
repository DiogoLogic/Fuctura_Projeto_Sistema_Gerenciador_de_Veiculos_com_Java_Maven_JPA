package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Veiculo;
import java.util.List;

public interface IVeiculoRepository {

    void salvar(Veiculo veiculo);

    void atualizar(Veiculo veiculo);

    void deletar(Veiculo veiculo);

    Veiculo buscarPorPlaca(String placa);

    List<Veiculo> listar();
}
