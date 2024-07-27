package br.com.fuctura.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.dao.IEnderecoDAO;
import br.com.fuctura.model.entidades.Endereco;

public class EnderecoDAOImpl implements IEnderecoDAO {

    private EntityManager em;

    public EnderecoDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Endereco endereco) {
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
    }

    @Override
    public void atualizar(Endereco endereco) {
        em.getTransaction().begin();
        em.merge(endereco);
        em.getTransaction().commit();
    }

    @Override
    public void deletar(Endereco endereco) {
        em.getTransaction().begin();
        em.remove(endereco);
        em.getTransaction().commit();
    }

    @Override
    public Endereco buscarPorCEP(String cep) {
        try {
            TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e WHERE e.cep = :cep", Endereco.class);
            query.setParameter("cep", cep);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
