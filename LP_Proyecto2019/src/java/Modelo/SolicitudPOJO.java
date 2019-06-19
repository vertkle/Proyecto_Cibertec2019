package Modelo;
public class SolicitudPOJO {
    private int idSolicitud;
    private String descripcion;
    private String fecha;
    private String fkUsuario;
    private int fk_areaDestino;
    private String estado;

    public SolicitudPOJO(int idSolicitud, String descripcion, String fecha, String fkUsuario, int fk_areaDestino, String estado) {
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fkUsuario = fkUsuario;
        this.fk_areaDestino = fk_areaDestino;
        this.estado = estado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFkUsuario() {
        return fkUsuario;
    }

    public int getFk_areaDestino() {
        return fk_areaDestino;
    }

    public String getEstado() {
        return estado;
    }

    
    
    
}
