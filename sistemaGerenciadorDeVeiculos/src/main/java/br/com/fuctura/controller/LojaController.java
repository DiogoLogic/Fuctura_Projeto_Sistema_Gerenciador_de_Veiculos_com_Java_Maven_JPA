package br.com.fuctura.controller;

import java.util.List;

import br.com.fuctura.model.entidades.Loja;
import br.com.fuctura.repository.impl.LojaRepository;

public class LojaController {

    private final LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public void salvar(Loja loja) {
        lojaRepository.salvar(loja);
    }

    public void atualizar(Loja loja) {
        lojaRepository.atualizar(loja);
    }

    public void deletar(Loja loja) {
        lojaRepository.deletar(loja);
    }

    public List<Loja> listar() {
        return lojaRepository.listar();
    }
}
