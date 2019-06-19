package Controlador;

import Modelo.DetalleSolicitudPOJO;
import Modelo.SolicitudPOJO;
import Util.MysqlConexion;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SolicitudDAO {

    public void insertarSolicitud(SolicitudPOJO soli,ArrayList<DetalleSolicitudPOJO>listaDetalle){
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        int id=0;
       
        
        try{
                    String sql="insert into solicitud_personal(soli_descripcion,soli_fecha,fk_usu,fk_areadestino) values(?,?,?,?)";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    
                    pst.setString(1, soli.getDescripcion());
                    pst.setString(2, soli.getFecha());
                    pst.setString(3, soli.getFkUsuario());
                    pst.setInt(4, soli.getFk_areaDestino());
                    pst.executeUpdate();
                    
                    rs=pst.getGeneratedKeys();
                    if(rs.next()){
			id=rs.getInt(1);
		    }
                    
                    if(listaDetalle.size()>0){
                        for(DetalleSolicitudPOJO det:listaDetalle){
                            insertarDetalleSolicitud(det, id);
                        }
                    }
                    
                   
                   
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
    }
    
    public void insertarDetalleSolicitud(DetalleSolicitudPOJO det,int fk_solicitud){
        Connection con=null;
	PreparedStatement pst=null;
        
            try{
                String sql="insert into detalle_solicitud(fk_solicitud,fk_profesion,detsoli_salario,detsoli_cantidad)values(?,?,?,?)";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    
                    pst.setInt(1, fk_solicitud);
                    pst.setInt(2, det.getCodProfesion());
                    pst.setDouble(3, det.getSalario());
                    pst.setInt(4, det.getCantidadPersonal());
                    
                    pst.executeUpdate();
                    
                    
            }catch(SQLException e){
                System.out.println("Error en la sentencia "+e.getMessage());
            }
    }
    
    
    public ArrayList<SolicitudPOJO>RecuperarSolicitudxArea(int fk_area){
        ArrayList<SolicitudPOJO>lista=new ArrayList<SolicitudPOJO>();
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
                    String sql="select * from solicitud_personal where fk_areadestino=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, fk_area);
                    rs=pst.executeQuery();
                    
                    while(rs.next()){
                        lista.add(new SolicitudPOJO(
                                rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getString(4), 
                                rs.getInt(5), 
                                rs.getString(6)));
                    }
                    
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
        
        return lista;
    }
    
    public ArrayList<SolicitudPOJO>RecuperarSolicitudEstado(String estado){
        ArrayList<SolicitudPOJO>lista=new ArrayList<SolicitudPOJO>();
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
                    String sql="select * from solicitud_personal where soli_estado=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    pst.setString(1, estado);
                    rs=pst.executeQuery();
                    
                    while(rs.next()){
                        lista.add(new SolicitudPOJO(
                                rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getString(4), 
                                rs.getInt(5), 
                                rs.getString(6)));
                    }
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
        
        return lista;
    }
    
    
    public SolicitudPOJO RecuperarSolicitud(int idSoli){
        SolicitudPOJO soliPOJO=null;
         ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
                    String sql="select * from solicitud_personal where soli_id=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, idSoli);
                    rs=pst.executeQuery();
                    
                    if(rs.next()){
                        soliPOJO=new SolicitudPOJO(rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getString(4), 
                                rs.getInt(5), 
                                rs.getString(6));
                    }
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
        return soliPOJO;
    }
    
    
    public ArrayList<DetalleSolicitudPOJO>RecuperarDetalleSolicitud(int idSoli){
        ArrayList<DetalleSolicitudPOJO>lista=new ArrayList<DetalleSolicitudPOJO>();
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
            String sql="select fk_profesion,detsoli_salario,detsoli_cantidad from detalle_solicitud where fk_solicitud=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, idSoli);
                    rs=pst.executeQuery();
                    
                    while(rs.next()){
                        lista.add(new DetalleSolicitudPOJO(
                                rs.getInt(1), 
                                rs.getDouble(2), 
                                rs.getInt(3)));
                    }
        }catch(SQLException e){
            
        }
                
        return lista;
    }
    
    public void ModificarEstadoSolicitud(String estado,int idsoli){
        Connection con=null;
	PreparedStatement pst=null;
        
        try{
                    String sql="update solicitud_personal set soli_estado=? where soli_id=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    
                    pst.setString(1, estado);
                    pst.setInt(2, idsoli);
                    pst.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
    }
}
