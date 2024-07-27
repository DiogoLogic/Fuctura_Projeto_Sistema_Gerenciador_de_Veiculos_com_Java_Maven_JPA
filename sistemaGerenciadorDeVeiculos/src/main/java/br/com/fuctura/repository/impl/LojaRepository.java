package br.com.fuctura.repository.impl;
import java.util.List;

import br.com.fuctura.model.dao.ILojaDAO;
import br.com.fuctura.model.entidades.Loja;
import br.com.fuctura.repository.interfaces.ILojaRepository;

public class LojaRepository implements ILojaRepository{

    private final ILojaDAO lojaDAO;

    public LojaRepository(ILojaDAO lojaDAO) {
        this.lojaDAO = lojaDAO;
    }

    public void salvar(Loja loja) {
        if (loja != null) {
            lojaDAO.salvar(loja);
        }
    }

    public void atualizar(Loja loja) {
        if (loja != null && loja.getCodigoLoja() != null) {
            lojaDAO.atualizar(loja);
        }
    }

    public void deletar(Loja loja) {
        if (loja != null && loja.getCodigoLoja() != null) {
            lojaDAO.deletar(loja);
        }
    }

    public List<Loja> listar() {
        return lojaDAO.listarTodas();
    }

	@Override
	public Loja buscarPorCNPJ(String cnpj) {
		if(cnpj != null && !cnpj.isEmpty()) {
			return lojaDAO.buscarPorCNPJ(cnpj);
		}
		return null;
	}
}
