package project;

public class Main {
    public static void main(String[] args) {

        GestorAcademico gestor = new GestorAcademico();

        Estudiante estudiante1 = new Estudiante(1, "Franco Paiz", "27 de Diciembre de 2005.", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Vagner Pineda", "31 de Diciembre de 1998. ", "matriculado");
        Curso curso1 = new Curso(1, "Programación", "Curso de programación funcional y POO.", 5, "1.0");
        Curso curso2 = new Curso(2, "Inglés", "Curso de Inglés nivel avanzado", 4, "2.0");

        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        //Inscribir a los estudiantes en cursos
        try {
            gestor.inscribirEstudiante(estudiante1, curso1.getId());
            gestor.inscribirEstudiante(estudiante2, curso2.getId());
        } catch (EstudianteYaInscritoException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // Verificamos la funcionalidad desinscribiendo al estudiante

        try {
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


        // Ver los resultados de estudiantes registrados en cursos
        gestor.verTodasLasInscripciones();


    }
}
