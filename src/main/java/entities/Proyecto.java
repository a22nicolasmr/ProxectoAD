package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proyectos")

public class Proyecto {
    @Id
    @Column(name = "idProyecto",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private int idProyecto;
    @Column(name = "nombre",length = 100,nullable = false)
    private String nombre;
    @Column(name = "descripcion",length = 100,nullable = false)
    private String descripcion;
    @Column(name = "fecha_inicio",nullable = false)
    private Date fechaInicio;
    @Column(name = "fecha_limite",nullable = false)
    private Date fechaLimite;
    @Column(name = "categoria",nullable = false)
    private Categoria categoria;
    @Column(name = "completado",nullable = false)
    private boolean completado;

    //relacion ManyToMany con Usuario
    @ManyToMany(mappedBy = "proyectos")
    private List<Usuario> usuarios;

    //relacion @OneToMany con Tarea
    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;

    public Proyecto() {
    }

    public Proyecto( String nombre, String descripcion, Date fechaInicio, Date fechaLimite, Categoria categoria, boolean completado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.categoria = categoria;
        this.completado = completado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int id) {
        this.idProyecto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
