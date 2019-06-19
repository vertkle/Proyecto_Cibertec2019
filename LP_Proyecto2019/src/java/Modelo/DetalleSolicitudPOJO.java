
package Modelo;
public class DetalleSolicitudPOJO {
    
    private int codProfesion;
    private double salario;
    private int cantidadPersonal;

    public DetalleSolicitudPOJO(int codProfesion, double salario, int cantidadPersonal) {
        this.codProfesion = codProfesion;
        this.salario = salario;
        this.cantidadPersonal = cantidadPersonal;
    }

    public int getCodProfesion() {
        return codProfesion;
    }

    public double getSalario() {
        return salario;
    }

    public int getCantidadPersonal() {
        return cantidadPersonal;
    }
    
    
    
}
