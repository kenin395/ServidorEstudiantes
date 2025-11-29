package services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import modelo.Estudiantes;
import modelo.Notas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Clase: EstudianteServiceImplement
 * Autor: Kenin Cusme
 * Fecha: 28/11/2025
 *
 * Descripción:
 * Esta clase implementa los servicios web (SOAP) relacionados con la gestión de estudiantes
 * y el cálculo de sus notas. Maneja un listado en memoria de estudiantes y registros de
 * notas, permitiendo operaciones como listar estudiantes, registrar nuevos, calcular y
 * guardar notas, así como buscar estudiantes por su ID y obtener sus calificaciones.
 *
 * Este servicio utiliza Jakarta Web Services y funciona como el endpoint que expone
 * los métodos definidos en la interfaz EstudianteService.
 */
@WebService(endpointInterface = "services.EstudianteService")
public class EstudianteServiceImplement implements EstudianteService {

    // Lista estática que almacena los estudiantes registrados
    private static final List<Estudiantes> estudiantes = new ArrayList<>();

    // Lista estática que almacena las notas de los estudiantes
    private static final List<Notas> notasList = new ArrayList<>();

    // Generador de ID incremental automático
    private static final AtomicLong generatedId = new AtomicLong(0);

    /**
     * Método que devuelve la lista completa de estudiantes registrados.
     *
     * @return Lista de estudiantes
     */
    @WebMethod
    @Override
    public List<Estudiantes> listar() {
        return estudiantes;
    }

    /**
     * Método para registrar un nuevo estudiante en el sistema.
     * El ID es generado automáticamente.
     *
     * @param estudiantes Objeto estudiante recibido desde el cliente
     * @return Estudiante registrado con su ID asignado
     */
    @WebMethod
    @Override
    public Estudiantes estudiante(Estudiantes estudiantes) {
        estudiantes.setIdEstudiante(generatedId.incrementAndGet());
        EstudianteServiceImplement.estudiantes.add(estudiantes);
        return estudiantes;
    }

    /**
     * Método para calcular las notas de un estudiante, generar su promedio
     * y determinar su estado académico (Aprobado, Supletorio o Reprobado).
     *
     * @param idEstudiante ID del estudiante
     * @param n1 Nota 1
     * @param n2 Nota 2
     * @param n3 Nota 3
     * @param examen Nota del examen final
     * @return Objeto Notas con los resultados calculados o null si el estudiante no existe
     */
    @WebMethod
    @Override
    public Notas calcularNotas(Long idEstudiante, double n1, double n2, double n3, double examen) {

        // 1. Buscar al estudiante por ID
        Estudiantes estudiante = estudiantes.stream()
                .filter(e -> e.getIdEstudiante().equals(idEstudiante))
                .findFirst()
                .orElse(null);

        // Maneja el caso de estudiante no encontrado
        if (estudiante == null) {
            return null;
        }

        // 2. Cálculo del promedio ponderado
        double promedio = n1 * 0.22 + n2 * 0.22 + n3 * 0.22 + examen * 0.34;
        String estado;

        // 3. Determinar el estado según el promedio obtenido
        if (promedio >= 7.0) {
            estado = "APROBADO";
        } else if (promedio >= 3.0 && promedio < 7.0) {
            estado = "SUPLETORIO";
        } else {
            estado = "REPROBADO";
        }

        // 4. Crear el objeto Notas con los datos calculados
        Notas notas = new Notas();
        notas.setIdEstudiante(idEstudiante);
        notas.setNota1(n1);
        notas.setNota2(n2);
        notas.setNota3(n3);
        notas.setExamen(examen);
        notas.setPromedio(promedio);
        notas.setEstado(estado);

        // 5. Guardar las notas en la lista
        notasList.add(notas);

        return notas;
    }

    /**
     * Busca un estudiante por su ID.
     *
     * @param id Identificador del estudiante
     * @return Objeto Estudiantes o null si no existe
     */
    @WebMethod
    @Override
    public Estudiantes buscarPorId(Long id) {
        return estudiantes.stream()
                .filter(e -> e.getIdEstudiante().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene las notas registradas de un estudiante.
     *
     * @param idEstudiante ID del estudiante
     * @return Objeto Notas o null si no existen registros
     */
    @WebMethod
    @Override
    public Notas obtenerNotas(Long idEstudiante) {
        return notasList.stream()
                .filter(n -> n.getIdEstudiante().equals(idEstudiante))
                .findFirst()
                .orElse(null);
    }
}
