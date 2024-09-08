package project;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudiante(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (inscripciones.containsKey(idCurso) && inscripciones.get(idCurso).contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya esta inscrito en el curso.");
        } else {
            inscripciones.computeIfAbsent(idCurso, k -> new ArrayList<>()).add(estudiante);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (inscripciones.containsKey(idCurso) && inscripciones.get(idCurso).removeIf(est -> est.getId() == idEstudiante)) {
            System.out.println("Estudiante desinscrito correctamente.");
        } else {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no se ha encontrado inscrito en este curso.");
        }
    }


    public void verTodasLasInscripciones() {
        if (inscripciones.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            System.out.println("Lista de inscripciones de estudiantes en cursos:");

            for (Integer idCurso : inscripciones.keySet()) {
                // Buscar el curso por su ID
                Curso curso = buscarCursoPorId(idCurso);
                if (curso != null) {
                    System.out.println("\nCurso: " + curso.getNombre() + " (ID: " + curso.getId() + ")");
                    ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(idCurso);

                    if (estudiantesInscritos.isEmpty()) {
                        System.out.println("No hay estudiantes inscritos en este curso.");
                    } else {
                        for (Estudiante estudiante : estudiantesInscritos) {
                            System.out.println("ID: " + estudiante.getId() +
                                    ", Nombre: " + estudiante.getNombre() +
                                    ", Fecha de Nacimiento: " + estudiante.getFechaDeNacimiento() +
                                    ", Estado: " + estudiante.getEstado());
                        }
                    }
                } else {
                    System.out.println("Curso con ID " + idCurso + " no encontrado.");
                }
            }
        }
    }

    private Curso buscarCursoPorId(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getId() == idCurso) {
                return curso;
            }
        }
        return null;  // Retorna null si el curso no se encuentra
    }
}
