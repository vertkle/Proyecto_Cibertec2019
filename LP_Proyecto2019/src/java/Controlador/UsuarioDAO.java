
package Controlador;

import Modelo.UsuarioPOJO;
import Util.MysqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public UsuarioPOJO ValidarUsuario(String dni,String password){
        UsuarioPOJO usuPojo=null;
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        
        try{
            
            String sql="select u.usu_dni,u.usu_nombre,u.usu_apellidos,u.usu_direccion,u.fk_area,a.are_nombre,d.dis_nombre FROM usuario u inner join areas a on u.fk_area=a.are_id inner join distrito d on d.dis_id=u.fk_distrito where u.usu_dni=? and u.usu_password=? and  usu_estado=0";
            con=MysqlConexion.getConexion();
            pst=con.prepareStatement(sql);
            pst.setString(1, dni);
            pst.setString(2, password);
            rs=pst.executeQuery();
            
            if(rs.next()){
                usuPojo=new UsuarioPOJO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return usuPojo;
    }
    
    public UsuarioPOJO RecuperarUsuario(String dni){
        UsuarioPOJO usuPojo=null;
        ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
        
        try{
            
            String sql="select u.usu_dni,u.usu_nombre,u.usu_apellidos,u.usu_direccion,u.fk_area,a.are_nombre,d.dis_nombre FROM usuario u inner join areas a on u.fk_area=a.are_id inner join distrito d on d.dis_id=u.fk_distrito where u.usu_dni=? and  usu_estado=0";
            con=MysqlConexion.getConexion();
            pst=con.prepareStatement(sql);
            pst.setString(1, dni);
            rs=pst.executeQuery();
            
            if(rs.next()){
                usuPojo=new UsuarioPOJO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return usuPojo;
    }
}
