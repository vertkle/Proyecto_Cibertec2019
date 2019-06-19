
package Controlador;

import Modelo.AreaPOJO;
import Util.MysqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDAO {
    
    public AreaPOJO RecuperarArea(int idArea){
        AreaPOJO area=null;
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
                    String sql="select * from areas where are_id=?";
                    con=MysqlConexion.getConexion();
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, idArea);
                    rs=pst.executeQuery();
                    
                    if(rs.next()){
                        area=new AreaPOJO(rs.getInt(1), rs.getString(2));
                    }
        }catch(SQLException e){
            System.out.println("Error en la sentencia "+e.getMessage());
        }
        
        return area;
    }
}
