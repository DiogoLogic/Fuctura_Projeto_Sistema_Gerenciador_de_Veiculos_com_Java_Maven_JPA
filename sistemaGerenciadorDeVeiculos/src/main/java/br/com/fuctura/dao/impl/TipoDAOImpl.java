package br.com.fuctura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.dao.ITipoDAO;
import br.com.fuctura.model.entidades.Tipo;

public class TipoDAOImpl implements ITipoDAO {

    private EntityManager em;

    public TipoDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Tipo tipo) {
        em.getTransaction().begin();
        em.persist(tipo);
        em.getTransaction().commit();
    }

    @Override
    public void atualizar(Tipo tipo) {
        em.getTransaction().begin();
        em.merge(tipo);
        em.getTransaction().commit();
    }

    @Override
    public void deletar(Tipo tipo) {
        em.getTransaction().begin();
        em.remove(tipo);
        em.getTransaction().commit();
    }

    @Override
    public Tipo buscarPorDescricao(String descricao) {
        try {
            TypedQuery<Tipo> query = em.createQuery("SELECT t FROM Tipo t WHERE t.descricao = :descricao", Tipo.class);
            query.setParameter("descricao", descricao);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public List<Tipo> listar() {
        TypedQuery<Tipo> query = em.createQuery("SELECT t FROM Tipo t", Tipo.class);
        return query.getResultList();
    }
}
