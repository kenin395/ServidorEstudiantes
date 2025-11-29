package modelo;

/**
 * Clase: Estudiantes
 * Autor: Kenin Cusme
 * Fecha: 28/11/2025
 *
 * Descripción:
 * Esta clase representa el modelo de un Estudiante dentro del sistema.
 * Contiene atributos básicos como nombre, apellido, correo, dirección,
 * teléfono y notas, además de su identificador único. Incluye un
 * constructor vacío, otro con parámetros y los métodos getters y
 * setters necesarios para manipular sus datos.
 */
public class Estudiantes {

    // Identificador único del estudiante
    private Long idEstudiante;

    // Nombre del estudiante
    private String nombre;

    // Apellido del estudiante
    private String apellido;

    // Correo electrónico del estudiante
    private String correo;

    // Dirección del estudiante
    private String direccion;

    // Teléfono del estudiante
    private String telefono;

    // Campo para registrar notas u observaciones del estudiante
    private String notas;

    /**
     * Constructor vacío
     * Permite crear un objeto Estudiantes sin inicializar sus atributos.
     */
    public Estudiantes() {
    }

    /**
     * Constructor con parámetros
     * Inicializa un objeto Estudiantes con los datos principales.
     *
     * @param idEstudiante Identificador del estudiante
     * @param nombre Nombre del estudiante
     * @param apellido Apellido del estudiante
     * @param correo Correo electrónico
     * @param direccion Dirección
     * @param telefono Teléfono
     */
    public Estudiantes(Long idEstudiante, String nombre, String apellido, String correo, String direccion, String telefono) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Métodos Getters y Setters

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
