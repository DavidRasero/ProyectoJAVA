
package trabajadores;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarDatosTrabajador {
    public static Trabajador cargarDatos(String dniTrabajador) {
        Trabajador trabajador = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("datos_trabajador.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("DNI:") && line.substring(5).equals(dniTrabajador)) {
                    String dni = line.substring(5);
                    String nombre = reader.readLine().substring(8);
                    String telefono = reader.readLine().substring(10);
                    String puesto = reader.readLine().substring(8);
                    String tipoContrato = reader.readLine().substring(18);
                    int diasTrabajados = Integer.parseInt(reader.readLine().substring(17));

                    trabajador = new Trabajador(dni, nombre, telefono, puesto, tipoContrato);
                    trabajador.setDiasTrabajados(diasTrabajados);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trabajador;
    }
}


