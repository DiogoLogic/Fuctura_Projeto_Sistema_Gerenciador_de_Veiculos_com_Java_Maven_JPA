package br.com.fuctura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.dao.ILojaDAO;
import br.com.fuctura.model.entidades.Loja;

public class LojaDAOImpl implements ILojaDAO {

    private EntityManager em;

    public LojaDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Loja loja) {
        em.getTransaction().begin();
        em.persist(loja);
        em.getTransaction().commit();
    }

    @Override
    public void atualizar(Loja loja) {
        em.getTransaction().begin();
        em.merge(loja);
        em.getTransaction().commit();
    }

    @Override
    public void deletar(Loja loja) {
        em.getTransaction().begin();
        em.remove(loja);
        em.getTransaction().commit();
    }

    @Override
    public Loja buscarPorCNPJ(String cnpj) {
        try {
            TypedQuery<Loja> query = em.createQuery("SELECT l FROM Loja l WHERE l.cnpj = :cnpj", Loja.class);
            query.setParameter("cnpj", cnpj);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

	@Override
	public List<Loja> listarTodas() {
		TypedQuery<Loja> query = em.createQuery("SELECT l FROM Loja l", Loja.class);
		return query.getResultList();
	}
}
