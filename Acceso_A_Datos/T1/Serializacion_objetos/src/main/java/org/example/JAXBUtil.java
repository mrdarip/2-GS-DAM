package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBUtil {
    public static void marshal(Estudiante estudiante, File file) throws
            JAXBException {
        JAXBContext context = JAXBContext.newInstance(Estudiante.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(estudiante, file);
    }
    public static Estudiante unmarshal(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Estudiante.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Estudiante) unmarshaller.unmarshal(file);
    }

    public static void marshalCurso(Curso curso, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Curso.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(curso, file);
    }

    public static Curso unmarshalCurso(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Curso.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Curso) unmarshaller.unmarshal(file);
    }
}
