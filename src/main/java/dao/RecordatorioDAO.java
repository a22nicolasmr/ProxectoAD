package dao;

import JPAUtil.JPAUtil;
import entities.Recordatorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RecordatorioDAO implements InterfaceDao<Recordatorio>{
    private EntityManager em;

    public RecordatorioDAO() {
        this.em= JPAUtil.createEntity();
    }

    @Override
    public void save(Recordatorio recordatorio) {
        try {
            em.getTransaction().begin();
            em.persist(recordatorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Recordatorio recordatorio) {
        try {
            em.getTransaction().begin();
            em.merge(recordatorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Recordatorio recordatorio) {
        try {
            em.getTransaction().begin();
            em.remove(recordatorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Recordatorio find(int id) {
        return em.find(Recordatorio.class,id);
    }

    @Override
    public List<Recordatorio> findAll() {
        String query ="Select  r from Recordatorio r";
        TypedQuery<Recordatorio> tq=em.createQuery(query, Recordatorio.class);
        return tq.getResultList();
    }
}
