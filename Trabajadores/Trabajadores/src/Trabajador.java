


public class Trabajador {
    private double sueldo;
    private int clase;

    public Trabajador(String nombre, double sueldo, int clase) {
        this.sueldo = sueldo;
        this.clase = clase;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

   
}
