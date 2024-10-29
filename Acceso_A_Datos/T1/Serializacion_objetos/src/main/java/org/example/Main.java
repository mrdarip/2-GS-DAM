package org.example;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear estudiantes y un curso
            Estudiante estudiante1 = new Estudiante("Juan", 20);
            Estudiante estudiante2 = new Estudiante("Ana", 22);
            Curso curso = new Curso("Programación Java", Arrays.asList(estudiante1, estudiante2));

            // Serializar
            File file = new File("curso.xml");
            JAXBUtil.marshalCurso(curso, file);

            // Deserializar
            Curso cursoDeserializado = JAXBUtil.unmarshalCurso(file);
            System.out.println("Curso: " + cursoDeserializado.getNombreCurso());
            cursoDeserializado.getEstudiantes().forEach(est ->
                    System.out.println("Estudiante: " + est.getNombre() + ", Edad: " + est.getEdad())
            );
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
