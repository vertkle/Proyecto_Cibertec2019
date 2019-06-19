package Controlador;

import Modelo.ProfesionPOJO;
import Util.MysqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesionDAO {
    
    public ArrayList<ProfesionPOJO>ListarProfesion(){
        ArrayList<ProfesionPOJO>lista=new ArrayList<ProfesionPOJO>();
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
           String sql="select * from profesion";
           con=MysqlConexion.getConexion();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                lista.add(new ProfesionPOJO(rs.getInt(1), rs.getString(2)));
            }

        }catch(SQLException e){
            System.err.println(""+e.getMessage());
        }
        
        
        return lista;
    }
    
    
    public ProfesionPOJO RecuperarProfesion(int idProfesion){
        ProfesionPOJO proPOJO=null;
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
           String sql="SELECT * FROM profesion where prof_id=?";
           con=MysqlConexion.getConexion();
            pst=con.prepareStatement(sql);
            pst.setInt(1, idProfesion);
            rs=pst.executeQuery();
            
            if(rs.next()){
                proPOJO=new ProfesionPOJO(rs.getInt(1), rs.getString(2));
            }

        }catch(SQLException e){
            System.err.println(""+e.getMessage());
        }
        
        return proPOJO;
    }
}
