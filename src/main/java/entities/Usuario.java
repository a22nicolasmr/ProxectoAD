package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private int idUsuario;
    @Column(name = "nombre_usuario",length = 50,nullable = false,unique = true)
    private String nombreUsuario;
    @Column(name = "nombre_completo_real",length = 100,nullable = false)
    private String nombreCompletoReal;
    @Column(name = "correo_electronico",length = 100,nullable = false,unique = true)
    private String correoElectronico;
    @Column(name = "contrasena",length = 100,nullable = false)
    private String contrasena;
    @Column(name = "fecha_alta",nullable = false)
    private Date fechaAlta;

    //relacion many to many con proyectos
    @ManyToMany
    @JoinTable(name = "UsuarioProyecto",
            joinColumns=@JoinColumn(name = "idUsuario"),
            inverseJoinColumns=@JoinColumn(name = "idProyecto"))
    private List<Proyecto> proyectos;

    //relacion many to many con tareas
    @ManyToMany
    @JoinTable(name = "UsuarioTarea",
            joinColumns=@JoinColumn(name = "idUsuario"),
            inverseJoinColumns=@JoinColumn(name = "idTarea"))
    private List<Tarea> tareas;

    public Usuario() {
    }

    public Usuario( String nombreUsuario, String nombreCompletoReal, String correoElectronico, String contrasena, Date fechaAlta) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompletoReal = nombreCompletoReal;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.fechaAlta = fechaAlta;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompletoReal() {
        return nombreCompletoReal;
    }

    public void setNombreCompletoReal(String nombreCompletoReal) {
        this.nombreCompletoReal = nombreCompletoReal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
