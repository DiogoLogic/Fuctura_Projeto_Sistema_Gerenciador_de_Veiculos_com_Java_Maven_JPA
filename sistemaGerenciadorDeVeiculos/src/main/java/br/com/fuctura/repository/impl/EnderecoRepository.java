package br.com.fuctura.repository.impl;


import br.com.fuctura.model.dao.IEnderecoDAO;
import br.com.fuctura.model.entidades.Endereco;

public class EnderecoRepository implements IEnderecoDAO{

    private final IEnderecoDAO enderecoDAO;

    public EnderecoRepository(IEnderecoDAO enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    public void salvar(Endereco endereco) {
        if (endereco != null) {
            enderecoDAO.salvar(endereco);
        }
    }

    public void atualizar(Endereco endereco) {
        if (endereco != null && endereco.getCodigo() != null) {
            enderecoDAO.atualizar(endereco);
        }
    }

    public void deletar(Endereco endereco) {
        if (endereco != null && endereco.getCodigo() != null) {
            enderecoDAO.deletar(endereco);
        }
    }

    public Endereco buscarPorCEP(String cep) {
        if (cep != null && !cep.isEmpty()) {
            return enderecoDAO.buscarPorCEP(cep);
        }
        return null;
    }
}
