package modelo;

/**
 * Clase: Notas
 * Autor: Kenin Cusme
 * Fecha: 28/11/2025
 *
 * Descripción:
 * Esta clase representa el registro de notas de un estudiante dentro del sistema.
 * Contiene las calificaciones de tres actividades principales, el examen final,
 * el promedio total y el estado (Aprobado/Reprobado). Además incluye el id del
 * estudiante para relacionarlo con su información personal.
 */
public class Notas {

    // Identificador del estudiante al que pertenecen las notas
    private Long idEstudiante;

    // Nota de la primera actividad
    private double nota1;

    // Nota de la segunda actividad
    private double nota2;

    // Nota de la tercera actividad
    private double nota3;

    // Calificación del examen final
    private double examen;

    // Promedio final del estudiante
    private double promedio;

    // Estado del estudiante según su promedio (Ej: Aprobado/Reprobado)
    private String estado;

    /**
     * Constructor vacío
     * Permite crear un objeto Notas sin inicializar sus atributos.
     */
    public Notas() {
    }

    /**
     * Constructor con parámetros
     * Inicializa un registro completo de notas.
     *
     * @param idEstudiante Identificador del estudiante
     * @param nota1 Primera nota
     * @param nota2 Segunda nota
     * @param nota3 Tercera nota
     * @param examen Nota del examen final
     * @param promedio Promedio de todas las notas
     * @param estado Estado del estudiante (Aprobado/Reprobado)
     */
    public Notas(Long idEstudiante, double nota1, double nota2, double nota3, double examen, double promedio, String estado) {
        this.idEstudiante = idEstudiante;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.examen = examen;
        this.promedio = promedio;
        this.estado = estado;
    }

    // Getters y Setters

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getExamen() {
        return examen;
    }

    public void setExamen(double examen) {
        this.examen = examen;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
