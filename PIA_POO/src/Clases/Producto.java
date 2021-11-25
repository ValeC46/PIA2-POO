
package Clases;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Producto {
    
    public void Editar(int clave, int cantidad, String nombre, float precio, String estado){
        boolean est;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement update = cn.prepareStatement("update productos set cantidad = ?, nombre = ?, precio = ?, estado = ? where clave = " + clave);
            
            update.setInt(1,cantidad);
            update.setString(2, nombre);
            update.setFloat(3, precio);
 
            if(estado.equalsIgnoreCase("No esta a la venta"))
                est = false;
            else
                est = true;
            
            update.setBoolean(4, est);
            
            update.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Los datos han sido editados","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
            
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }   
    }
    
    public void Registrar(int clave, int cantidad, String nombre, float precio, boolean estado) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement insert = cn.prepareStatement("insert into productos values(?,?,?,?,?)");
            
            if(cn != null)
                System.out.println("Conexion con la base de datos exitosa");
                
            insert.setInt(1, clave);
            insert.setInt(2,cantidad);
            insert.setString(3,nombre);
            insert.setFloat(4, precio);
            insert.setBoolean(5,estado);
            
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El producto ha sido agregado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error: " + e);
        }
    }
    
    public void Eliminar(int clave){
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement delete = cn.prepareStatement("delete from productos where clave = ?");
            
            delete.setInt(1, clave);
            delete.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El producto ha sido eliminado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }  
    }
    
    public boolean ValidarClave(int clave){
        
        boolean validacion = true;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Esta clave ya existe");
                validacion = false;
            }
            else{
                int digitos = String.valueOf(clave).length(); //se guarda en un entero la cantidad de digitos
                
                if(digitos < 5){
                    JOptionPane.showMessageDialog(null, "Esta clave es demasiada corta");
                    validacion = false;
                }else{
                    if(clave < 0 ){
                        JOptionPane.showMessageDialog(null, "No se pueden ingresar claves negativas");
                        validacion = false;
                    }
                    else{
                        validacion = true;
                    }
                }
 
            }
            
            rs.close();
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }
        
        return validacion;
    }
    
    public boolean ValidarCantidad(int cantidad){
        
        boolean validacion;
        
        if(cantidad < 0){
            validacion = false;
            JOptionPane.showMessageDialog(null, "No se pueden ingresar cantidades negativas");
        }
        else
            validacion = true;
        
        
        return validacion;
    }
    
    
    public DefaultComboBoxModel modeloproductos(){
        
        DefaultComboBoxModel Lista = new DefaultComboBoxModel();
        
        Lista.addElement("Lista de claves");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos");
            
            ResultSet rs = select.executeQuery();
            
            try{
                while(rs.next()){
                    Lista.addElement(rs.getString("clave") + "         " + rs.getString("nombre"));
                }
                
                rs.close();
                
            }catch(SQLException n){
                 System.err.print(n.getMessage());
            }
               
        }catch(Exception e){
            System.err.print("Error: " + e);
        }
        
        return Lista;
    }
    
}
