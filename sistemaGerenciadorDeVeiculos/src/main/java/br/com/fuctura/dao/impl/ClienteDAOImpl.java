package br.com.fuctura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.dao.IClienteDAO;
import br.com.fuctura.model.entidades.Cliente;

public class ClienteDAOImpl implements IClienteDAO {

    private EntityManager em;

    public ClienteDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean inserir(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletarPorCPF(String cpf) {
        try {
            Cliente cliente = buscarPorCPF(cpf);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente buscarPorCPF(String cpf) {
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

	@Override
	public List<Cliente> listarTodos() {
		
		return null;
	}

	@Override
	public boolean deletarPorCPF(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}
}
