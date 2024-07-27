package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.dao.IVendedorDAO;
import br.com.fuctura.model.entidades.Vendedor;

public class VendedorRepository implements IVendedorDAO {

    private final IVendedorDAO vendedorDAO;

    public VendedorRepository(IVendedorDAO vendedorDAO) {
        this.vendedorDAO = vendedorDAO;
    }

    public void salvar(Vendedor vendedor) {
        if (vendedor != null) {
            vendedorDAO.salvar(vendedor);
        }
    }

    public void atualizar(Vendedor vendedor) {
        if (vendedor != null && vendedor.getCodigo() != null) {
            vendedorDAO.atualizar(vendedor);
        }
    }

    public void deletar(Vendedor vendedor) {
        if (vendedor != null && vendedor.getCodigo() != null) {
            vendedorDAO.deletar(vendedor);
        }
    }

    public Vendedor buscarPorCPF(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            return vendedorDAO.buscarPorCPF(cpf);
        }
        return null;
    }

	@Override
	public List<Vendedor> listar() {
		return vendedorDAO.listar();
	}

  
}
