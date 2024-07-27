package br.com.fuctura.controller;

import br.com.fuctura.model.entidades.Tipo;
import br.com.fuctura.repository.impl.TipoRepository;

public class TipoController {

    private final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public void salvar(Tipo tipo) {
        tipoRepository.salvar(tipo);
    }

    public void atualizar(Tipo tipo) {
        tipoRepository.atualizar(tipo);
    }

    public void deletar(Tipo tipo) {
        tipoRepository.deletar(tipo);
    }

    public Tipo buscarPorDescricao(String descricao) {
        return tipoRepository.buscarPorDescricao(descricao);
    }

}
