package dao;

import JPAUtil.JPAUtil;
import entities.Tarea;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TareaDAO implements InterfaceDao<Tarea>{
    private EntityManager em;

    public TareaDAO() {
        this.em= JPAUtil.createEntity();
    }

    @Override
    public void save(Tarea tarea) {
        try {
            em.getTransaction().begin();
            em.persist(tarea);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tarea tarea) {
        try {
            em.getTransaction().begin();
            em.merge(tarea);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Tarea tarea) {
        try {
            em.getTransaction().begin();
            em.remove(tarea);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Tarea find(int id) {
        return em.find(Tarea.class,id);
    }

    @Override
    public List<Tarea> findAll() {
        String query="Select t from Tarea t";
        TypedQuery<Tarea> tq=em.createQuery(query, Tarea.class);
        return tq.getResultList();
    }
}
