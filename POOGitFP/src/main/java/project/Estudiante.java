package project;

import java.util.Date;

public class Estudiante  extends Persona{

    private String estado;

    public Estudiante(int id, String nombre, String fechaDeNacimiento, String estado) {
        super(id, nombre, fechaDeNacimiento);
        this.estado = estado;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
