package com.dam.accesodata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {
    private static final String ARCHIVO = "resources/notas_estudiantes.txt";

    // Añadir un estudiante al archivo
    public void añadirEstudiante(Estudiante estudiante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(estudiante.toString());
            writer.newLine(); // Añade una nueva línea después de cada estudiante
            System.out.println("Estudiante añadido con éxito.");
        } catch (IOException e) {
            System.out.println("Error al añadir el estudiante: " + e.getMessage());
        }
    }

    // Mostrar todos los estudiantes del archivo
    public void mostrarEstudiantes() {
        List<Estudiante> estudiantes = leerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\n--- Lista de Estudiantes ---");
            for (Estudiante est : estudiantes) {
                System.out.println(est.getNombre() + ": " + est.getNota());
            }
        }
    }

    // Buscar un estudiante por nombre
    public Estudiante buscarEstudiante(String nombre) {
        List<Estudiante> estudiantes = leerEstudiantes();

        Estudiante encontradoEstudiante = null;

        for (Estudiante est : estudiantes) {
            if (est.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Estudiante encontrado: " + est.getNombre() + " - Nota: " + est.getNota());
                encontradoEstudiante = est;
                break;
            }
        }

        if (encontradoEstudiante == null) {
            System.out.println("Estudiante no encontrado.");
        }
        return encontradoEstudiante;
    }

    // Calcular la nota media de todos los estudiantes
    public double calcularMedia() {
        List<Estudiante> estudiantes = leerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return 0;
        }

        double suma = 0;
        for (Estudiante est : estudiantes) {
            suma += est.getNota();
        }
        double media = suma / estudiantes.size();
        System.out.println("La nota media de los estudiantes es: " + media);
        return media;
    }

    // Leer los estudiantes del archivo
    public List<Estudiante> leerEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String nombre = datos[0];
                    double nota = Double.parseDouble(datos[1]);
                    estudiantes.add(new Estudiante(nombre, nota));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. No se ha encontrado ningún estudiante.");
        } catch (IOException e) {
            System.out.println("Error al leer los estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }
}
