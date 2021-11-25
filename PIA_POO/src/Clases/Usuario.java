
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Usuario  {
   
    //-------------------------------------------------METODOS-------------------------------------------------
    
    public void RegistrarUsuario(String nombre,String contraseña, String puesto, String sueldo, String celular) {
         
        boolean estado = true;

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement insert = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
            
            if(cn != null)
                System.out.println("Conexion con la base de datos exitosa");
                
            insert.setString(1, "0");
            insert.setString(2,nombre);
            insert.setString(3,contraseña);
            insert.setString(4, puesto);
            insert.setString(5, sueldo);
            insert.setString(6, celular);
            insert.setBoolean(7,estado);
            
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El registro ha sido agregado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();

        } catch (Exception e) {
            System.err.print("Error: " + e);
        }
    }
     
    
    
    public void Eliminar(int id){
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement delete = cn.prepareStatement("delete from usuario where ID = ?");
            
            delete.setInt(1, id);
            delete.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
        }catch(Exception e){
            System.err.print("Error: " + e);
        }  
    }
    
    
    public void Editar(int ide, String nombre,String contraseña, String puesto, String sueldo, String celular, String estado){
        
        boolean est;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement update = cn.prepareStatement("update usuario set NOMBRE = ?, CONTRASEÑA = ?, PUESTO = ?, SUELDO = ?, CELULAR = ?, ESTADO = ? where ID = " + ide);
            
            update.setString(1, nombre);
            update.setString(2, contraseña);
            update.setString(3, puesto);
            update.setString(4, sueldo);
            update.setString(5, celular);
            
            if(estado.equalsIgnoreCase("Inactivo"))
                est = false;
            else
                est = true;
            
            update.setBoolean(6, est);
            
            update.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Los datos han sido editados","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
            
        }catch(Exception e){
            System.err.print("Error: " + e);
        }
        
        
    }
    
    public boolean ValidarUsuario(int ident,String contraseña){
        
        boolean validacion = false;
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from usuario where ID = ?");
            
            select.setInt(1, ident);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                
                if(rs.getBoolean("ESTADO")){
                    if(contraseña.equals(rs.getString("CONTRASEÑA"))){
                         validacion = true;
                    }else{
                        validacion = false;
                        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                    }    
                }
                else{
                    validacion = false;
                    JOptionPane.showMessageDialog(null, "El usuario actualmente no esta activo");
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos ingresados no son validos","Error",JOptionPane.WARNING_MESSAGE);
            }
         }catch(Exception e){
             System.err.print("Error: " + e);
             
         }    
        return validacion;
    }
      
}
