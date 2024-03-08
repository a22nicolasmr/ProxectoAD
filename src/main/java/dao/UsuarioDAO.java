package dao;

import DTO.UsuarioDTO;
import JPAUtil.JPAUtil;
import entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UsuarioDAO implements InterfaceDao<Usuario> {
    private EntityManager em;
    private UsuarioDTO usuarioDTO;
    public UsuarioDAO() {
        this.em= JPAUtil.createEntity();
    }

    @Override
    public void save(Usuario usuario) {
        try{
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void update(Usuario usuario) {
        try{
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Usuario find(int id) {
        return em.find(Usuario.class,id);
    }

    public UsuarioDTO showUsuario(int id){
        Usuario usuario=em.find(Usuario.class,id);
        usuarioDTO=new UsuarioDTO(usuario.getIdUsuario(),usuario.getNombreUsuario(),usuario.getCorreoElectronico());
        return usuarioDTO;
    }
    @Override
    public List<Usuario> findAll() {
        String query= "Select u from Usuario u";
        TypedQuery<Usuario> tq=em.createQuery(query, Usuario.class);
        return tq.getResultList();
    }
}
