package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private int idTarea;
    @Column(name = "descripcion",length = 100,nullable = false)
    private String descripcion;
    @Column(name = "completado",nullable = false)
    private boolean completado;
    @Column(name = "fecha_inicio",nullable = false)
    private Date fechaInicio;
    @Column(name = "fecha_limite",nullable = false)
    private Date fechaLimite;

    //relacion ManyToMany con Usuario
    @ManyToMany(mappedBy ="tareas" )
    private List<Usuario> usuarios;

    //relacion ManyToOne con Proyecto
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    //relacion OneToMany con Recordatorio
    @OneToMany(mappedBy = "tarea")
    private List<Recordatorio> recordatorios;

    public Tarea() {
    }

    public Tarea( String descripcion, boolean completado, Date fechaInicio, Date fechaLimite) {
        this.descripcion = descripcion;
        this.completado = completado;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(List<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int id) {
        this.idTarea = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
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
}
