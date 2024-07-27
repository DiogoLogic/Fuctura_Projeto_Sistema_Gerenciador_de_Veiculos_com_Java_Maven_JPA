package br.com.fuctura.repository.impl;

import java.util.List;


import br.com.fuctura.model.dao.ITipoDAO;
import br.com.fuctura.model.entidades.Tipo;
import br.com.fuctura.repository.interfaces.ITipoRepository;

public class TipoRepository implements ITipoRepository {

    private final ITipoDAO tipoDAO;

    public TipoRepository(ITipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    @Override
    public void salvar(Tipo tipo) {
        if (tipo != null) {
            tipoDAO.salvar(tipo);
        }
    }

    @Override
    public void atualizar(Tipo tipo) {
        if (tipo != null && tipo.getCodigo() != null) {
            tipoDAO.atualizar(tipo);
        }
    }

    @Override
    public void deletar(Tipo tipo) {
        if (tipo != null && tipo.getCodigo() != null) {
            tipoDAO.deletar(tipo);
        }
    }

    @Override
    public Tipo buscarPorDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            return tipoDAO.buscarPorDescricao(descricao);
        }
        return null;
    }

    @Override
    public List<Tipo> listar() {
        return tipoDAO.listar();
    }
}
