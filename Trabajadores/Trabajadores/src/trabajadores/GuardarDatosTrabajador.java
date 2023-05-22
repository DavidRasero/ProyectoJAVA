
package trabajadores;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarDatosTrabajador {
    public static void guardarDatos(Trabajador trabajador) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_trabajador.txt",true))) {
            
            writer.write("----------------------------------------------");
            writer.write("\n");
            writer.write("DNI: " + trabajador.getDni());
            writer.write("\n");
            writer.write("Nombre: " + trabajador.getNombre());
            writer.write("\n");
            writer.write("Teléfono: " + trabajador.getTelefono());
            writer.write("\n");
            writer.write("Puesto: " + trabajador.getPuesto());
            writer.write("\n");
            writer.write("Tipo de contrato: " + trabajador.getTipoContrato());
            writer.write("\n");
            writer.write("Días trabajados: " + trabajador.getDiasTrabajados());
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

