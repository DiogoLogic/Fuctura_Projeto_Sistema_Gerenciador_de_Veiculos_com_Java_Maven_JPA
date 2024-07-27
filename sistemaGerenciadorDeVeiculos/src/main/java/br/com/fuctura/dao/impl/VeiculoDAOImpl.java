package br.com.fuctura.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.dao.IVeiculoDAO;
import br.com.fuctura.model.entidades.Veiculo;

public class VeiculoDAOImpl implements IVeiculoDAO {

    private EntityManager em;

    public VeiculoDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void deletar(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        try {
            TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v WHERE v.placa = :placa", Veiculo.class);
            query.setParameter("placa", placa);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
