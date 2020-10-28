package modelos;

public class Persona {

    protected int id;
    protected String dni;
    protected String ap_paterno;
    protected String ap_materno;
    protected String nombres;
    protected String correo;

    public Persona() {
    }
        
    public Persona(int id, String dni, String ap_paterno, String ap_materno, String nombres, String correo) {
        this.id = id;
        this.dni = dni;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.nombres = nombres;
        this.correo = correo;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
}
