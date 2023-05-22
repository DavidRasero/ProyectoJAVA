
package trabajadores;


public class Trabajador {
    private String dni;
    private String nombre;
    private String telefono;
    private String puesto;
    private String tipoContrato;
    private int diasTrabajados;

    public Trabajador(String dni,String nombre, String telefono,  String puesto, String tipoContrato) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.puesto = puesto;
        this.tipoContrato = tipoContrato;
        this.diasTrabajados = 0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }


  
}

