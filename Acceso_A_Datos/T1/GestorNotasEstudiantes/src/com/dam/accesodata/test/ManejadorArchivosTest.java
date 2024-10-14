package com.dam.accesodata.test;

import com.dam.accesodata.Estudiante;
import com.dam.accesodata.ManejadorArchivos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ManejadorArchivosTest {
    
    private ManejadorArchivos manejador;
    private static final String ARCHIVO_TEST = "resources/notas_estudiantes_test.txt";

    @Before
    public void setUp() throws IOException {
        manejador = new ManejadorArchivos();

        // Crear un archivo de prueba temporal con algunos dato

        manejador.añadirEstudiante(new Estudiante("Juan", 8.5));
        manejador.añadirEstudiante(new Estudiante("Ana", 9.0));
        manejador.añadirEstudiante(new Estudiante("Pedro", 7.0));
    }

    @After
    public void tearDown() {
        // Eliminar el archivo de prueba después de cada test
        File archivo = new File(ARCHIVO_TEST);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

    @Test
    public void testAñadirEstudiante() {
        Estudiante nuevoEstudiante = new Estudiante("María", 6.5);
        manejador.añadirEstudiante(nuevoEstudiante);

        List<Estudiante> estudiantes = manejador.leerEstudiantes();
        assertEquals(4, estudiantes.size());
        assertEquals("María", estudiantes.get(3).getNombre());
        assertEquals(6.5, estudiantes.get(3).getNota(), 0.01);
    }

    @Test
    public void testMostrarEstudiantes() {
        List<Estudiante> estudiantes = manejador.leerEstudiantes();
        assertEquals(3, estudiantes.size());
    }

    @Test
    public void testBuscarEstudianteEncontrado() {
        Estudiante estudianteBuscado = manejador.buscarEstudiante("Ana");
        assertNotNull(estudianteBuscado);
        assertEquals("Ana", estudianteBuscado.getNombre());
        assertEquals(9.0, estudianteBuscado.getNota(), 0.01);
    }

    @Test
    public void testBuscarEstudianteNoEncontrado() {
        Estudiante estudianteBuscado = manejador.buscarEstudiante("Lucía");
        assertNull(estudianteBuscado);
    }

    @Test
    public void testCalcularMedia() {
        double media = manejador.calcularMedia();
        assertEquals(8.17, media, 0.01);
    }

    @Test
    public void testLeerEstudiantes() {
        List<Estudiante> estudiantes = manejador.leerEstudiantes();
        assertEquals(3, estudiantes.size());

        assertEquals("Juan", estudiantes.get(0).getNombre());
        assertEquals(8.5, estudiantes.get(0).getNota(), 0.01);

        assertEquals("Ana", estudiantes.get(1).getNombre());
        assertEquals(9.0, estudiantes.get(1).getNota(), 0.01);

        assertEquals("Pedro", estudiantes.get(2).getNombre());
        assertEquals(7.0, estudiantes.get(2).getNota(), 0.01);
    }
}
