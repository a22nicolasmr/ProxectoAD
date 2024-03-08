package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "recordatorios")
public class Recordatorio {
    @Id
    @Column(name = "idRecordatorio",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private int idRecordatorio;
    @Column(name = "descripcion",length = 100,nullable = false)
    private String descripcion;
    @Column(name = "fecha",nullable = false)
    private Date fecha;
    @Column(name = "fecha_limite",nullable = false)
    private Date fechaLimite;
    @Column(name = "completado",nullable = false)
    private boolean completado;

    //relacion ManyToOne con Tarea
    @ManyToOne
    @JoinColumn(name="idTarea")
    private Tarea tarea;

    public Recordatorio() {
    }

    public Recordatorio( String descripcion, Date fecha, Date fechaLimite, boolean completado) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaLimite = fechaLimite;
        this.completado = completado;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int id) {
        this.idRecordatorio = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
