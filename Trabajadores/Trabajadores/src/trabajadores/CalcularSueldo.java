
package trabajadores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcularSueldo {
    public static double calcularSueldo(String dniTrabajador) throws FileNotFoundException, IOException {
        double sueldo = 0.0;
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
                    
                    if(trabajador.getPuesto().equals("Operario")){
                        sueldo=diasTrabajados*35;
                    }else if(trabajador.getPuesto().equals("Supervisor")){
                        sueldo=diasTrabajados*45;
                    }else if(trabajador.getPuesto().equals("Gerente")){
                        sueldo=diasTrabajados*55;
                    }else if(trabajador.getPuesto().equals("Director de departamento")){
                        sueldo=diasTrabajados*65;
                    }else if(trabajador.getPuesto().equals("Vicepresidente")){
                        sueldo=diasTrabajados*75;
                    }else if(trabajador.getPuesto().equals("Director ejecutivo")){
                        sueldo=diasTrabajados*85;
                    }
                }
            }
        }
        
        return sueldo;
    }
}







