package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlRootElement
public class Curso {
    @XmlElement
    private String nombreCurso;

    @XmlElementWrapper(name = "estudiantes")
    @XmlElement(name = "estudiante")
    private List<Estudiante> estudiantes;

    // Constructor sin argumentos necesario para JAXB
    public Curso() {}

    public Curso(String nombreCurso, List<Estudiante> estudiantes) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = estudiantes;
    }

    // Getters y Setters sin anotaciones JAXB
    public String getNombreCurso() {
        return nombreCurso;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
