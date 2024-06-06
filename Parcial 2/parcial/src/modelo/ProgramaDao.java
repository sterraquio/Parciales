/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author UNIVALLE
 */
public class ProgramaDao {
     Conexion miConexion = new Conexion();

    Connection con;
    PreparedStatement pst;
    ResultSet rs;


//Función para Insertar o registrar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean insertarDatos(Programa unPrograma){
        String query= "INSERT INTO programa (codigo, nombre) VALUES (?, ?)";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión            
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL 
            
            
            pst.setInt(1, unPrograma.getCodigo()); 
            pst.setString(2, unPrograma.getNombre());
            pst.execute();//Se ejecuta la consulta
            System.out.println(pst);//se imprime el script de la consulta por consola
            
            
            
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: "+e.getMessage());
            return false;
        }
        
    }

    //Función para Consultar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Programa consultarPrograma(int ced){
        String query = "SELECT * FROM programa where codigo=?";
        
        
        Programa unPrograma= new Programa();
        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión
            pst = this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            pst.setInt(1, ced);
            
            
            System.out.println("contenido del query:\n"+pst);//se imprime el script de la consulta por consola
            
            rs= pst.executeQuery();//Se ejecuta la consulta
            
            if(rs.next()){
                
                unPrograma.setCodigo(rs.getInt("codigo"));
                unPrograma.setNombre(rs.getString("nombre"));
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona: "+e);
        }
        
        return unPrograma;
    }
    
        //Función para Modificar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean actualizarPrograma(Programa unPrograma){
        String query= "UPDATE programa SET nombre =?  WHERE codigo = ?";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión        
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            pst.setString(1, unPrograma.getNombre());
            pst.setInt(2, unPrograma.getCodigo());
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            pst.execute();//Se ejecuta la consulta
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
    
    //Función para Eliminar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminarPrograma(int codigo){
        String query= "DELETE FROM programa WHERE codigo ="+codigo;
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión
            pst = this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            pst.execute();//Se ejecuta la consulta
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos: "+e);
            return false;
        }
        
    }
    
    
}
