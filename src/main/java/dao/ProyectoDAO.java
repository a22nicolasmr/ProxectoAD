package dao;

import JPAUtil.JPAUtil;
import entities.Proyecto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProyectoDAO implements InterfaceDao<Proyecto>{
    private final EntityManager em;
    public ProyectoDAO() {
        this.em = JPAUtil.createEntity();
    }

    @Override
    public void save(Proyecto proyecto) {
        try {
            em.getTransaction().begin();
            em.persist(proyecto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Proyecto proyecto) {
        try {
            em.getTransaction().begin();
            em.merge(proyecto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
    }
}

    @Override
    public void delete(Proyecto proyecto) {
        try {
            em.getTransaction().begin();
            em.remove(proyecto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Proyecto find(int id) {
        return em.find(Proyecto.class, id);
    }

    @Override
    public List<Proyecto> findAll() {
        String query = "SELECT p FROM Proyecto p";
        TypedQuery<Proyecto> tq = em.createQuery(query, Proyecto.class);
        return tq.getResultList();
    }
}
