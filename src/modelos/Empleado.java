package modelos;

public class Empleado extends Persona{
    
    private String telefono;
    private String cargo;
    private double sueldo;

    public Empleado() {
    }
   
    public Empleado(int id, String dni, String ap_paterno, String ap_materno, String nombres, String correo, String telefono, String cargo, double sueldo) {
        super(id, dni, ap_paterno, ap_materno, nombres, correo);
        this.telefono = telefono;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
        
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
