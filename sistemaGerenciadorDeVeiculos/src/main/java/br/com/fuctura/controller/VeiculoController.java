package br.com.fuctura.controller;

import java.util.List;

import br.com.fuctura.model.entidades.Veiculo;

public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    public VeiculoController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public void salvar(Veiculo veiculo) {
        veiculoRepository.salvar(veiculo);
    }

    public void atualizar(Veiculo veiculo) {
        veiculoRepository.atualizar(veiculo);
    }

    public void deletar(Veiculo veiculo) {
        veiculoRepository.deletar(veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.buscarPorPlaca(placa);
    }

    public List<Veiculo> listar() {
        return veiculoRepository.listar();
    }

}
