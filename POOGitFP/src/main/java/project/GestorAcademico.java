package project;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos, HashMap<Integer, ArrayList<Estudiante>> inscripciones) {
        this.estudiantes = estudiantes;
        this.cursos = cursos;
        this.inscripciones = inscripciones;
    }
}
