package Modelo;
public class UsuarioPOJO {
   private String dni;
   private String nombres;
   private String apellidos;
   private String direccion;
   private int fk_area;
   private String nombrearea;
   private String disnombre;

    public UsuarioPOJO(String dni, String nombres, String apellidos, String direccion, int fk_area, String nombrearea, String disnombre) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fk_area = fk_area;
        this.nombrearea = nombrearea;
        this.disnombre = disnombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getFk_area() {
        return fk_area;
    }

    public String getNombrearea() {
        return nombrearea;
    }

    public String getDisnombre() {
        return disnombre;
    }
   
   


   
}
