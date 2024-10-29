package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {
    @XmlElement
    private String nombre;
    @XmlElement
    private int edad;

    // Constructor sin argumentos necesario para JAXB
    public Estudiante() {}

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
