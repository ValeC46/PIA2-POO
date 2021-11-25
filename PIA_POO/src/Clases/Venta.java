
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Venta {
    

    //Util para agregar las fechas
    public String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    
    
    //METODO QUE DICE SI ES POSIBLE VENDER CIERTA CANTIDAD DE PRODUCTO CON UNA CLAVE DETERMINADA
    public boolean ValidarCantidad(int clave,int cantidad){
        
        boolean validacion = false;
        
        if(cantidad < 1){
            validacion = false;
        }else{
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                int cant = rs.getInt("cantidad");
                
                if(cant>cantidad){
                    validacion = true;
                }
                else{
                    validacion = false;
                }
            }

            }catch(SQLException e){
                System.err.print("Error: " + e);

            }             
        }

        return validacion;
    }
    
    //DEVUELVE SI UNA CLAVE INGRESADA EXISTE
    public boolean ValidadProducto(int clave){
        
        boolean validacion = false;
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next())
                validacion = true;       
            else
                validacion = false;
            
            
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }
        
        return validacion;
    }
    
    
    //METODO QUE DEVUELVE EL PRECIO DE UN PRODUCTO CON DETERMINADA CLAVE
    public float Precio(int clave){
        
        float precio = 0;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                precio = rs.getFloat("precio");
            }
            
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }

        return precio;
    }
    
    
    //METODO QUE DEVUELVE EL NOMBRE DE UN PRODUCTO CON DETERMINADA CLAVE
    public String Producto(int clave){
        
        String nombre = null;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                nombre = rs.getString("nombre");
            }
            
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }

        return nombre;
    }
    
    
    //METODO QUE DEVUELVE SI UN PRODUCTO ESTA A LA VENTA O NO
    public boolean ValidarEstado(int clave){
         
        boolean estado = false;
        
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
               estado = rs.getBoolean("estado");
            }
            
            cn.close();
            
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }

        return estado;
    }
    
    //METODO QUE ACTUALIZA EL INVENTARIO CON CLAVE DETERMINADA REDUCIENDO A CANT EL VALOR DE CANTIDAD
    public void ActualizarInventario(int clave, int cantnueva){
                    
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");            
            PreparedStatement update = cn.prepareStatement("update productos set cantidad = ? where clave = " + clave);
            update.setInt(1, cantnueva);
            
            update.executeUpdate();
                        
            cn.close();

        }catch(SQLException n){
           System.err.print("Error: " + n);
        }
    }
    
    
    //METODO DE QUE OBTIENE LA CANTIDAD DE DETERMINADO PRODUCTO CON CLAVE
    public int ObtenerCant(int clave){
        int cant = 0;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");            
            PreparedStatement select = cn.prepareStatement("select * from productos where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
               cant = rs.getInt("cantidad");
            }

        }catch(SQLException n){
           System.err.print("Error: " + n);
        }
        
        return cant;
    }
    
    //SE GUARDAN DATOS DEL NUEVO CLIENTE
    public void NuevoCliente(String nombre, String contacto){
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement insert = cn.prepareStatement("insert into clientes values(?,?,?)");
            
            if(cn != null)
                System.out.println("Conexion con la base de datos exitosa");
                
            insert.setString(1, "0");
            insert.setString(2,nombre);
            insert.setString(3,contacto);
                        
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El registro ha sido agregado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);
            
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error: " + e);
        } 
    }
   
    //VALIDA QUE EL ID DE CLIENTE EXISTA
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
          
          
      }catch(SQLException e){
          System.err.print("Error: " + e);  
      }
      return validacion;  
    }
    
    //VALIDA QUE LA CLAVE DE VENTA NO SE REPITA
    public boolean ValidarClave(int clave){
        boolean validacion = false;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from venta where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
                validacion = false;
            }else{
                validacion = true;
                    try {
                        Connection cn2 = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
                        PreparedStatement insert = cn2.prepareStatement("insert into venta values(?)");

                        insert.setInt(1, clave);

                        insert.executeUpdate();
                        
                        cn2.close();

                    } catch (SQLException n) {
                        System.err.print("Error: " + n);
                    }
                cn.close();
            }

        }catch(SQLException e){
            System.err.print("Error: " + e);
        }         
        return validacion;
    }
    
    //MODELO QUE MUESTRA LA LISTA DE VENTAS EN UN COMBO BOX
    public DefaultComboBoxModel modeloventas(){
        
        DefaultComboBoxModel Lista = new DefaultComboBoxModel();
        
        Lista.addElement("Lista de ventas");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from venta");
            
            ResultSet rs = select.executeQuery();
            
            try{
                while(rs.next()){
                    Lista.addElement(rs.getString("clave"));
                }
                
                rs.close();
                
            }catch(SQLException n){
                 System.err.print(n.getMessage());
            }
               
        }catch(SQLException e){
            System.err.print("Error: " + e);
        }
        
        return Lista;
    }
    
    //METODO QUE AGREGA EL TEXTO INDICADO EN UN ARCHIVO DE TEXTO
    public void RegistrarVenta(String texto){
        File ventas = new File("./Ventas.txt");
		
            if(!ventas.exists() ) {
                    try {
                            ventas.createNewFile();
                    }catch (IOException e) {
                            System.err.print("Error: " + e);
                    }
            }

            try {
                    FileWriter fw = new FileWriter(ventas,true);
                    PrintWriter pw = new PrintWriter (fw);

                    if(!pw.checkError()) {
                            pw.println(texto);
                    }

                    pw.close();

            }catch(IOException n){
                    System.err.print("Error: " + n);
            }
    } 
    
    //METODO QUE VALIDA QUE EXISTA LA CLAVE DE VENTA
    public boolean ValidarVenta(int clave){
        
        boolean validacion = false;
        
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria","root","");
            PreparedStatement select = cn.prepareStatement("select * from venta where clave = ?");
            
            select.setInt(1, clave);
            
            ResultSet rs = select.executeQuery();
            
                if(rs.next()){
                    validacion = true;
                }else{
                    validacion = false;
                    JOptionPane.showMessageDialog(null, "La clave de venta no existe");
                }
                
            cn.close();
        }catch(SQLException e){
            System.err.print("Error: " + e);
        } 
                
        return validacion;
    }
    
    //METODO QUE IMPRIME EL TICKET DE LA CLAVE DE VENTA INGRESADA
    public String BuscarVenta(int clave){
        
        String ticket = " ";
        
        try{
            File archivo = new File("./Ventas.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String Linea = "";
                      
            int aux = 0;
            boolean leer= false;
            
            while(Linea != null){
                Linea = br.readLine();
                if(aux ==1){
                    aux=2;
                }
                
                if(Linea.equals("CLAVE DE COMPRA: " + clave)){
                    
                    ticket = Linea;
                    leer = true;
                    aux++;
                }
                if(leer){
                    if(aux==2){
                        ticket = ticket + "\n" + Linea;   
                    }
                           
                }
                if(Linea.equals("***********" )){
                    leer = false;                    
                }
            }
            
            fr.close();
            br.close();
            
                        
        }catch(Exception e){
            System.err.print("Error en busqueda: " + e);
        }
        
        return ticket;
    }
}
