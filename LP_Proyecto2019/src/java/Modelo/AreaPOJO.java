package Modelo;
public class AreaPOJO {
    private int idarea;
    private String nombreArea;

    public AreaPOJO(int idarea, String nombreArea) {
        this.idarea = idarea;
        this.nombreArea = nombreArea;
    }

    public int getIdarea() {
        return idarea;
    }

    public String getNombreArea() {
        return nombreArea;
    }
    
}
