
package Clases;

import java.sql.*;
import javax.swing.JOptionPane;



public class Cliente {
   
    //----------------------METODOS GET Y SET----------------------
    
   public void NuevoCliente(String nombre, String contacto){
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement insert = cn.prepareStatement("insert into clientes values(?,?,?)"); //INSTRUCCIONES
            
            if(cn != null)
                System.out.println("Conexion con la base de datos exitosa");
                
            insert.setString(1, "0");
            insert.setString(2,nombre);
            insert.setString(3,contacto);
            
                        
            insert.executeUpdate(); //EXECUTAR
            
            JOptionPane.showMessageDialog(null, "El registro ha sido agregado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();

        } catch (Exception e) {
            System.err.print("Error: " + e);
        } 
    }
   
   
   public boolean ValidarID(int id){
        
      boolean validacion = false;
      
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from clientes where id = ?");

            select.setInt(1, id);

            ResultSet rs = select.executeQuery();

            if(rs.next()){
               validacion = true;
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el ID");
            }

            cn.close();
          
          
      }catch(Exception e){
          System.err.print("Error: " + e);  
      }
      return validacion;  
    }
   
   
   
   public void Editar(int id, String nombre, String telefono){
       
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement update = cn.prepareStatement("update clientes set nombre = ?, telefono = ? where id = " + id);
            
            update.setString(1, nombre);
            update.setString(2, telefono);
            
            update.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Los datos han sido editados","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
            
        }catch(Exception e){
            System.err.print("Error: " + e);
        } 
   }
   
   public void Eliminar (int id){
       
       try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement delete = cn.prepareStatement("delete from clientes where id = ?");
            
            delete.setInt(1, id);
            delete.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
        }catch(Exception e){
            System.err.print("Error: " + e);
        }  
   }
    
    
    
}
