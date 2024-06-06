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
public class ProfesorDao {

    Conexion miConexion = new Conexion();

    Connection con;
    PreparedStatement pst;
    ResultSet rs;


//Función para Insertar o registrar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean insertarDatos(Profesor unProfe){
        String query= "INSERT INTO profesor (cedula, nombreApellido) VALUES (?, ?)";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión            
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL 
            
            
            pst.setInt(1, unProfe.getCedula()); 
            pst.setString(2, unProfe.getNombreApellido());
            pst.execute();//Se ejecuta la consulta
            System.out.println(pst);//se imprime el script de la consulta por consola
            
            
            
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: "+e.getMessage());
            return false;
        }
        
    }

//Función para Consultar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Profesor consultarProfe(int ced){
        String query = "SELECT * FROM profesor where cedula=?";
        
        
        Profesor unProfesor= new Profesor();
        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión
            pst = this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            pst.setInt(1, ced);
            
            
            System.out.println("contenido del query:\n"+pst);//se imprime el script de la consulta por consola
            
            rs= pst.executeQuery();//Se ejecuta la consulta
            
            if(rs.next()){
                
                unProfesor.setCedula(rs.getInt("cedula"));
                unProfesor.setNombreApellido(rs.getString("nombreApellido"));
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona: "+e);
        }
        
        return unProfesor;
    }
    
//Función para Eliminar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminarProfe(int ced){
        String query= "DELETE FROM profesor WHERE cedula ="+ced;
        
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
    
      //Función para Modificar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean actualizarDatos(Profesor unProfesor){
        String query= "UPDATE profesor SET nombreApellido =?  WHERE cedula = ?";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión        
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            
            pst.setString(1, unProfesor.getNombreApellido());
            pst.setInt(2, unProfesor.getCedula());
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            pst.execute();//Se ejecuta la consulta
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
    
     //Función para Listar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List listarProfes(){
        List<Profesor> listaDeObjetos = new ArrayList();
        String query = "SELECT * FROM profesor";
                
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión            
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            rs= pst.executeQuery();//Se ejecuta la consulta           
            
            while(rs.next()){
                
                Profesor unProfesor= new Profesor();
                
                unProfesor.setCedula(rs.getInt("cedula"));
                unProfesor.setNombreApellido(rs.getString("nombreApellido"));
                
                listaDeObjetos.add(unProfesor);
                
            }
            
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null, "Error al listar los datos: "+e);
        }
        
        return listaDeObjetos;
    }
    

}
