import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class AnalizadorDatosAbiertos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo a analizar:");
        String rutaArchivo = scanner.nextLine();
        if (rutaArchivo.endsWith(".csv")) {
            List<String[]> datosCSV = parsearCSV(rutaArchivo);
            mostrarResumenCSV(datosCSV);
        } else if (rutaArchivo.endsWith(".json")) {
            JsonObject datosJSON = parsearJSON(rutaArchivo);
            mostrarResumenJSON(datosJSON);
        } else if (rutaArchivo.endsWith(".xml")) {
            Document datosXML = parsearXML(rutaArchivo);
            mostrarResumenXML(datosXML);
        } else {
            System.out.println("Formato de archivo no soportado.");
        }
    }
    public static List<String[]> parsearCSV(String rutaArchivo) {
        List<String[]> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new
                FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                registros.add(valores);
            }} catch (Exception e) {
            System.out.println("Error al leer el archivo CSV: " +
                    e.getMessage());
        }
        return registros;
    }
    public static JsonObject parsearJSON(String rutaArchivo) {
        JsonObject jsonObject = null;
        try (FileReader reader = new FileReader(rutaArchivo)) {
            jsonObject = new Gson().fromJson(reader, JsonObject.class);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON: " +
                    e.getMessage());
        }
        return jsonObject;
    }
    public static Document parsearXML(String rutaArchivo) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(rutaArchivo);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo XML: " +
                    e.getMessage());
        }
        return doc;
    }
    public static void mostrarResumenCSV(List<String[]> datos) {
        if (datos.isEmpty()) {
            System.out.println("No se encontraron datos.");
            return;
        }
        System.out.println("Resumen del archivo CSV:");
        System.out.println("Número total de filas: " + datos.size());
        System.out.println("Número de columnas: " + datos.get(0).length);
        System.out.println("\nPrimeros 5 registros:");
        for (int i = 0; i < Math.min(5, datos.size()); i++) {
            System.out.println(String.join(" | ", datos.get(i)));}
    }

    public static void mostrarResumenJSON(JsonObject datos) {
        int[] recuento = checkearElemento(datos);

        int numClaves = recuento[0];
        int numArrays = recuento[1];

        // Mostrar el resultado
        System.out.println("Número de claves: " + numClaves);
        System.out.println("Número de arrays: " + numArrays);
    }

    public static int[] checkearElemento(JsonElement elemento) {
        int[] recuento = {0,0}; // Contador de claves y arrays

        // Comprobar si el elemento es un objeto JSON
        if (elemento.isJsonObject()) {
            JsonObject objeto = elemento.getAsJsonObject();
            recuento[0]++; // Incrementar el contador de claves

            // Recorrer el objeto JSON
            for (Map.Entry<String, JsonElement> entry : objeto.entrySet()) {
                int[] added = checkearElemento(entry.getValue());
                recuento[0] += added[0];
                recuento[1] += added[1];
            }
        }

        // Comprobar si el elemento es un array JSON
        if (elemento.isJsonArray()) {
            recuento[1]++; // Incrementar el contador de arrays

            // Recorrer el array JSON
            for (JsonElement arrayElement : elemento.getAsJsonArray()) {
                int[] added = checkearElemento(arrayElement);
                recuento[0] += added[0];
                recuento[1] += added[1];
            }
        }

        return recuento;
    }


    public static void mostrarResumenXML(Document datos) {
        // Contar el número total de nodos
        NodeList todosLosNodos = datos.getElementsByTagName("*"); // Asterisco (*) selecciona todos los nodos
        System.out.println("Número total de nodos: " + todosLosNodos.getLength());

        // Mostrar el árbol de nodos
        System.out.println("Estructura del árbol de nodos:");
        Element raiz = datos.getDocumentElement(); // Obtener el nodo raíz
        mostrarNodosRecursivamente(raiz, 0); // Llamar a la función recursiva para imprimir el árbol
    }


    public static void mostrarNodosRecursivamente(Element nodo, int nivel) {
        // Imprimir el nodo con indentación según su nivel en el árbol
        for (int i = 0; i < nivel; i++) {
            System.out.print("  "); // Añadir espacios para la indentación
        }
        System.out.println("- " + nodo.getNodeName()); // Imprimir el nombre del nodo

        // Obtener los hijos del nodo
        NodeList hijos = nodo.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            if (hijos.item(i) instanceof Element) {
                // Si el hijo es un elemento, llamamos a la función recursiva
                mostrarNodosRecursivamente((Element) hijos.item(i), nivel + 1);
            }
        }
    }

}
